package ClassSystem.service;

import ClassSystem.entity.PageHelp;
import ClassSystem.entity.ServicePost;
import ClassSystem.entity.User;

public interface UserService {
    //登录操作
    ServicePost login(User user);
    //获取学生列表,page值
    ServicePost StudentList(PageHelp pageHelp);
    //删除学生信息
    ServicePost DeleteStudent(String username);
}
