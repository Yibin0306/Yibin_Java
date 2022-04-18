package ClassSystem.service;

import ClassSystem.entity.ClassList;
import ClassSystem.entity.PersonNum;
import ClassSystem.entity.ServicePost;
import ClassSystem.entity.User;

public interface SystemService {
    //登录操作
    ServicePost login(User user);
    //身份验证
    ServicePost isSign();
    //获取平台数据
    ServicePost PersonNum(PersonNum personNum);
    //获取班级列表
    ServicePost ClassList(ClassList classList);
}
