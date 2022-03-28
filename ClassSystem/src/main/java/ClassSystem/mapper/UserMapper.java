package ClassSystem.mapper;

import ClassSystem.entity.PageHelp;
import ClassSystem.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //登录操作
    User login(User user);
    //返回多少行（page）
    int TotalCount();
    //获取学生列表
    List<User> StudentList(PageHelp pageHelp);
}
