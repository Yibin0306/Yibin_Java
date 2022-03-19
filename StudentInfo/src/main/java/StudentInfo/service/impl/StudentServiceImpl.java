package StudentInfo.service.impl;

import StudentInfo.dao.AdminMapper;
import StudentInfo.dao.StudentMapper;
import StudentInfo.entity.Student;
import StudentInfo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    public StudentMapper studentMapper;
    //学生登录
    @Override
    public Student loginStudent(Student Student) {
        return studentMapper.loginStudent(Student);
    }
    //查询所有学生信息
    @Override
    public List<Student> findAllstudent() {
        return studentMapper.findAllstudent();
    }
    //添加学生信息
    @Override
    public Integer addStudent(Student student) {
        return studentMapper.addStudent(student);
    }
    //删除学生信息
    @Override
    public Integer deleteStudent(String sid) {
        return studentMapper.deleteStudent(sid);
    }
    //根据ID跳转到修改学生
    //根据ID查询学生信息
    @Override
    public List<Student> findOneStudent(String sid) {
        return studentMapper.findOneStudent(sid);
    }
    //修改学生信息
    @Override
    public Integer updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }
    //根据学院查询学生信息
    @Override
    public List<Student> findCollegeStudent(String College) {
        return studentMapper.findCollegeStudent(College);
    }
    //根据专业查询学生信息
    @Override
    public List<Student> findProfessionStudent(String Profession) {
        return studentMapper.findProfessionStudent(Profession);
    }
    //根据班级查询学生信息
    @Override
    public List<Student> findClassrStudent(String Classr) {
        return studentMapper.findClassrStudent(Classr);
    }
    //根据id查询学生信息跳转个人界面
    @Override
    public Student findStudent(String sid) {
        return studentMapper.findStudent(sid);
    }
    //修改学生密码
    @Override
    public Integer updateStudentPwd(Student spassword) {
        return studentMapper.updateStudentPwd(spassword);
    }
}
