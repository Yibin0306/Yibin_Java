package ClassSystem.mapper;

import ClassSystem.entity.ClassList;
import ClassSystem.entity.PersonNum;
import ClassSystem.entity.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface SystemMapper {
    //登录操作
    User login(User user);
    //获取平台数据
    PersonNum PersonNum(PersonNum personNum);
    //返回班级列表行数（page）
    int ClassTotalCount();
    //获取班级列表
    List<ClassList> ClassList(ClassList classList);
}
