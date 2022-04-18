package ClassSystem.mapper;

import ClassSystem.entity.PageHelp;
import ClassSystem.entity.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface StudentMapper {
    //学生业务
    //返回学生列表多少行（page）
    int StudentTotalCount();
    //获取学生列表
    List<User> StudentList(PageHelp pageHelp);
    //返回多少行（page）学生
    int searchStudentTotal(User user);
    //查询框查询学生
    List<User> searchStudent(User user);
    //添加学生信息
    Integer addStudent(User user);
    //修改学生信息
    Integer updateStudent(User user);
    //删除单个学生信息
    Integer DeleteStudent(String username);
}
