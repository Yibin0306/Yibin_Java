package ClassSystem.service;

import ClassSystem.entity.PageHelp;
import ClassSystem.entity.ServicePost;
import ClassSystem.entity.User;

public interface TeacherService {
    //教师业务
    //获取教师列表,page值
    ServicePost TeacherList(PageHelp pageHelp);
    //查询框查询教师
    ServicePost searchTeacher(User user);
    //删除单个教师信息
    ServicePost DeleteTeacher(String username);
}
