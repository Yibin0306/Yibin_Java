package StudentInfo.service.impl;

import StudentInfo.dao.StudentMapper;
import StudentInfo.dao.TeacherMapper;
import StudentInfo.entity.Admin;
import StudentInfo.entity.Teacher;
import StudentInfo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    public TeacherMapper teacherMapper;
    //教师登录
    @Override
    public Teacher loginTeacher(Teacher teacher) {
        return teacherMapper.loginTeacher(teacher);
    }
    //添加教师信息
    @Override
    public Integer addTeacher(Teacher teacher) {
        return teacherMapper.addTeacher(teacher);
    }
    //查询所有教师信息
    @Override
    public List<Teacher> findAllTeacher() {
        return teacherMapper.findAllTeacher();
    }
    //删除教师信息
    @Override
    public Integer deleteTeacher(String tid) {
        return teacherMapper.deleteTeacher(tid);
    }
    //根据id跳转到修改老师
    //根据id查询教师信息
    @Override
    public List<Teacher> findOneTeacher(String tid) {
        return teacherMapper.findOneTeacher(tid);
    }
    //修改教师信息
    @Override
    public Integer updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }
    //根据id查询教师信息跳转个人界面
    @Override
    public Teacher findTeacher(String tid) {
        return teacherMapper.findTeacher(tid);
    }

}
