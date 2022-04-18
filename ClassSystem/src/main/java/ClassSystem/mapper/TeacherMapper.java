package ClassSystem.mapper;

import ClassSystem.entity.PageHelp;
import ClassSystem.entity.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface TeacherMapper {
    //教师业务
    //返回教师列表多少行（page）
    int TeacherTotalCount();
    //获取教师列表
    List<User> TeacherList(PageHelp pageHelp);
    //返回多少行（page）教师
    int searchTeacherTotal(User user);
    //查询框查询教师
    List<User> searchTeacher(User user);
    //删除单个老师信息
    Integer DeleteTeacher(String username);
}
