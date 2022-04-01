package ClassSystem.service.Impl;

import ClassSystem.entity.*;
import ClassSystem.mapper.UserMapper;
import ClassSystem.service.UserService;
import ClassSystem.utility.RedisTemplateUtil;
import ClassSystem.utility.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ServicePost servicePost;
    @Autowired
    private RedisTemplateUtil redisTemplateUtil;

    //登录验证
    @Override
    public ServicePost login(User user) {
        User login = userMapper.login(user);
        if (login!=null){
            long CurrentTime = System.currentTimeMillis();
            String token = login.getUsername()+CurrentTime;
            login.setToken(token);
            redisTemplateUtil.setValue("token",token);
            return servicePost.CreateTrueData(login);
        }else{
            return ServicePost.CreateErrorCodMsg("密码或账号错误呢~");
        }
    }

    //获取平台数据
    @Override
    public ServicePost PersonNum(PersonNum personNum) {
        PersonNum personNums = userMapper.PersonNum(personNum);
        personNum.setTeacherNum(personNums.getTeacherNum());
        personNum.setStudentNum(personNums.getStudentNum());
        personNum.setNotice("我是平台公告！");
        return servicePost.CreateTrueData(personNum);
    }

    //返回前端页面数据（学生列表,page值）
    @Override
    public ServicePost StudentList(PageHelp pageHelp) {
        String currentToken = UserRequest.getCurrentToken("token");

        int total = userMapper.StudentTotalCount();
        if (total>0){
            pageHelp.setStart((pageHelp.getPage()-1)* pageHelp.getPagenum());
            pageHelp.setEnd(pageHelp.getPagenum());
            List<User> StudentList = userMapper.StudentList(pageHelp);
            return servicePost.CreateTrueList(StudentList,total);
        }else {
            return ServicePost.CreateErrorCodMsg("学生列表没有数据呢~");
        }
    }

    //获取班级列表
    @Override
    public ServicePost ClassList(ClassList classList) {
        int total = userMapper.ClassTotalCount();
        List<ClassList> classLists = userMapper.ClassList(classList);
        return servicePost.CreateTrueList(classLists,total);
    }

    //查询框查询学生
    @Override
    public ServicePost searchStudent(User user) {
        if (user.getPage()==0){
            user.setPage(1);
        }
        if (user.getEnd()==0){
            user.setEnd(10);
        }
        int start = (user.getPage()-1)* user.getEnd();
        user.setStart(start);
        int Total = userMapper.searchStudentTotal(user);
        List<User> searchStudent = userMapper.searchStudent(user);
        return servicePost.CreateTrueList(searchStudent,Total);
    }

    //添加学生信息
    @Override
    public ServicePost addStudent(User user) {
        Integer addStudent = userMapper.addStudent(user);
        if (addStudent!=0){
            return ServicePost.CreateTrueCodMsg("添加学生信息成功呢!");
        }else {
            return ServicePost.CreateErrorCodMsg("添加学生信息失败呢~");
        }
    }

    //修改学生信息
    @Override
    public ServicePost updateStudent(User user) {
        Integer updateStudent = userMapper.updateStudent(user);
        if (updateStudent!=0){
            return ServicePost.CreateTrueCodMsg("修改学生信息成功呢!");
        }else {
            return ServicePost.CreateErrorCodMsg("修改学生信息失败呢~");
        }
    }

    //删除单个学生信息
    @Override
    public ServicePost DeleteStudent(String username) {
        Integer deleteStudent = userMapper.DeleteStudent(username);
        if (deleteStudent!=0){
            return ServicePost.CreateTrueCodMsg("删除学生信息成功呢!");
        }else {
            return ServicePost.CreateErrorCodMsg("删除学生信息失败呢~");
        }
    }

    //获取老师列表,page值
    @Override
    public ServicePost TeacherList(PageHelp pageHelp) {
        int total = userMapper.TeacherTotalCount();
        if (total>0){
            pageHelp.setStart((pageHelp.getPage()-1)* pageHelp.getPagenum());
            pageHelp.setEnd(pageHelp.getPagenum());
            List<User> TeacherList = userMapper.TeacherList(pageHelp);
            return servicePost.CreateTrueList(TeacherList,total);
        }else {
            return ServicePost.CreateErrorCodMsg("老师列表没有数据呢~");
        }
    }

    //查询框查询教师
    @Override
    public ServicePost searchTeacher(User user) {
        if (user.getPage()==0){
            user.setPage(1);
        }
        if (user.getEnd()==0){
            user.setEnd(10);
        }
        int start = (user.getPage()-1)* user.getEnd();
        user.setStart(start);
        int Total = userMapper.searchTeacherTotal(user);
        List<User> searchTeacher = userMapper.searchTeacher(user);
        return servicePost.CreateTrueList(searchTeacher,Total);
    }

    //删除单个老师信息
    @Override
    public ServicePost DeleteTeacher(String username) {
        Integer DeleteTeacher = userMapper.DeleteTeacher(username);
        if (DeleteTeacher!=0){
            return ServicePost.CreateTrueCodMsg("删除老师信息成功呢!");
        }else {
            return ServicePost.CreateErrorCodMsg("删除老师信息失败呢~");
        }
    }

}
