package StudentInfo.dao;

import StudentInfo.entity.Admin;
import StudentInfo.entity.Student;
import StudentInfo.entity.Teacher;
import StudentInfo.entity.TeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    //登录功能
    Teacher loginTeacher(Teacher teacher);
    //查询所有教师信息
    List<Teacher> findAllTeacher();
    //添加教师信息
    Integer addTeacher(Teacher teacher);
    //删除教师信息
    Integer deleteTeacher(String tid);
    //根据id跳转到修改老师界面
    List<Teacher> findOneTeacher(String tid);
    //修改教师信息
    Integer updateTeacher(Teacher teacher);
    //根据id查询教师信息跳转个人界面
    Teacher findTeacher(String tid);
}