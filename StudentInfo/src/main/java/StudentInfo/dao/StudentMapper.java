package StudentInfo.dao;

import StudentInfo.entity.Admin;
import StudentInfo.entity.Course;
import StudentInfo.entity.Student;
import StudentInfo.entity.StudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    //学生登录功能
    Student loginStudent(Student student);
    //查询所有学生信息
    List<Student> findAllstudent();
    //添加学生信息
    Integer addStudent(Student student);
    //删除学生信息
    Integer deleteStudent(String sid);
    //根据id跳转到修改学生界面
    //根据id查询学生信息
    List<Student> findOneStudent(String sid);
    //修改学生信息
    Integer updateStudent(Student student);
    //根据学院查询学生信息
    List<Student> findCollegeStudent(String College);
    //根据专业查询学生信息
    List<Student> findProfessionStudent(String Profession);
    //根据班级查询学生信息
    List<Student> findClassrStudent(String Classr);
    //根据id查询学生信息跳转个人界面
    Student findStudent(String sid);
    //修改学生密码
    Integer updateStudentPwd(Student spassword);
}