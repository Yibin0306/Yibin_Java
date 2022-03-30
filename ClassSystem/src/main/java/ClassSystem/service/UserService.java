package ClassSystem.service;

import ClassSystem.entity.PageHelp;
import ClassSystem.entity.ServicePost;
import ClassSystem.entity.User;

public interface UserService {
    //登录操作
    ServicePost login(User user);
    //获取学生列表,page值
    ServicePost StudentList(PageHelp pageHelp);
    //查询框查询学生
    ServicePost searchStudent(User user);
    //删除单个学生信息
    ServicePost DeleteStudent(String username);
    //获取老师列表,page值
    ServicePost TeacherList(PageHelp pageHelp);
    //查询框查询教师
    ServicePost searchTeacher(User user);
    //删除单个老师信息
    ServicePost DeleteTeacher(String username);
}
