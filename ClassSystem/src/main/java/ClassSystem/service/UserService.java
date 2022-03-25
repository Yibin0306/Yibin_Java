package ClassSystem.service;

import ClassSystem.entity.ServicePost;
import ClassSystem.entity.User;

public interface UserService {
    //登录操作
    ServicePost login(User user);
}
