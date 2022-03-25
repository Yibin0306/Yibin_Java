package ClassSystem.mapper;

import ClassSystem.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    //登录操作
    User login(User user);
}
