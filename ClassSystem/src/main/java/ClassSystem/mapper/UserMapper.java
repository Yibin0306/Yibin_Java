package ClassSystem.mapper;

import ClassSystem.entity.ClassList;
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
    PersonNum PersonNum(PersonNum personNum);

    //学生业务
    //返回学生列表多少行（page）
    int StudentTotalCount();
    //获取学生列表
    List<User> StudentList(PageHelp pageHelp);
    //返回班级列表行数（page）
    int ClassTotalCount();
    //获取班级列表
    List<ClassList> ClassList(ClassList classList);
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
