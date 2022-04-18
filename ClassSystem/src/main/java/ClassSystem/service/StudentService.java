package ClassSystem.service;

import ClassSystem.entity.PageHelp;
import ClassSystem.entity.ServicePost;
import ClassSystem.entity.User;

public interface StudentService {
    //学生业务
    //获取学生列表,page值
    ServicePost StudentList(PageHelp pageHelp);
    //查询框查询学生
    ServicePost searchStudent(User user);
    //添加学生信息
    ServicePost addStudent(User user);
    //修改学生信息
    ServicePost updateStudent(User user);
    //删除单个学生信息
    ServicePost DeleteStudent(String username);
}
