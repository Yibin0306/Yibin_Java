package StudentInfo.service;

import StudentInfo.entity.Admin;
import StudentInfo.entity.Teacher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TeacherService {
    //教师登录功能
    Teacher loginTeacher(Teacher teacher);
    //添加教师信息
    Integer addTeacher(Teacher teacher);
    //查询所有教师信息
    List<Teacher> findAllTeacher();
    //删除教师信息
    Integer deleteTeacher(String tid);
    //根据id跳转到修改老师
    //根据id查询教师信息
    List<Teacher> findOneTeacher(String tid);
    //修改教师信息
    Integer updateTeacher(Teacher teacher);
    //根据id查询教师信息跳转个人界面
    Teacher findTeacher(String tid);
}
