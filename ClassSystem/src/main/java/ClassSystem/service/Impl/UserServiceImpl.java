package ClassSystem.service.Impl;

import ClassSystem.entity.PageHelp;
import ClassSystem.entity.ServicePost;
import ClassSystem.entity.User;
import ClassSystem.mapper.UserMapper;
import ClassSystem.service.UserService;
import ClassSystem.utility.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ServicePost servicePost;

    //登录验证
    @Override
    public ServicePost login(User user) {
        User login = userMapper.login(user);
        if (login!=null){
            return ServicePost.CreateTrueCodMsg("欢迎您，娇贵的小公主~");
        }else{
            return ServicePost.CreateErrorCodMsg("账号或密码错误呢~");
        }
    }
    //返回前端页面数据（学生列表,page值）
    @Override
    public ServicePost StudentList(PageHelp pageHelp) {
        int total = userMapper.TotalCount();
        if (total>0){
            pageHelp.setStart((pageHelp.getPage()-1)* pageHelp.getPagenum());
            pageHelp.setEnd(pageHelp.getPagenum());
            List<User> StudentList = userMapper.StudentList(pageHelp);
            return servicePost.CreateTrueCodMsgList(StudentList,total,"获取学生列表成功呢!");
        }else {
            return ServicePost.CreateErrorCodMsg("获取学生列表没有数据呢~");
        }
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
        return servicePost.CreateTrueCodMsgList(searchStudent,Total,"获取成功呢!");
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
        int total = userMapper.TotalCount();
        if (total>0){
            pageHelp.setStart((pageHelp.getPage()-1)* pageHelp.getPagenum());
            pageHelp.setEnd(pageHelp.getPagenum());
            List<User> TeacherList = userMapper.TeacherList(pageHelp);
            return servicePost.CreateTrueCodMsgList(TeacherList,total,"获取老师列表成功呢!");
        }else {
            return ServicePost.CreateErrorCodMsg("获取老师列表没有数据呢~");
        }
    }
    //删除单个老师信息
    @Override
    public ServicePost DeleteTeacher(String username) {
        Integer DeleteTeacher = userMapper.DeleteTeacher(username);
        if (DeleteTeacher!=0){
            return ServicePost.CreateTrueCodMsg("删除老师信息成功呢!");
        }else {
            return ServicePost.CreateErrorCodMsg("删除老师信息失败呢~");
        }    }
}
