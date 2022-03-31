package ClassSystem.mapper;

import ClassSystem.entity.PageHelp;
import ClassSystem.entity.PersonNum;
import ClassSystem.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //登录操作
    User login(User user);
    //获取平台数据
    List<PersonNum> PersonNum(PersonNum personNum);
    //返回多少行（page）
    int TotalCount();
    //获取学生列表
    List<User> StudentList(PageHelp pageHelp);
    //查询框查询学生
    List<User> searchStudent(User user);
    //返回多少行（page）学生
    int searchStudentTotal(User user);
    //删除单个学生信息
    Integer DeleteStudent(String username);
    //获取老师列表
    List<User> TeacherList(PageHelp pageHelp);
    //查询框查询教师
    List<User> searchTeacher(User user);
    //返回多少行（page）教师
    int searchTeacherTotal(User user);
    //删除单个老师信息
    Integer DeleteTeacher(String username);
}
