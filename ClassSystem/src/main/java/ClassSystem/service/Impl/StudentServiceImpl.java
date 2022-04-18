package ClassSystem.service.Impl;

import ClassSystem.entity.PageHelp;
import ClassSystem.entity.ServicePost;
import ClassSystem.entity.User;
import ClassSystem.mapper.StudentMapper;
import ClassSystem.service.StudentService;
import ClassSystem.utility.RedisTemplateUtil;
import ClassSystem.utility.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ServicePost servicePost;
    @Autowired
    private RedisTemplateUtil redisTemplateUtil;

    //返回前端页面数据（学生列表,page值）
    @Override
    public ServicePost StudentList(PageHelp pageHelp) {
        String currentToken = UserRequest.getCurrentToken("token");

        int total = studentMapper.StudentTotalCount();
        if (total>0){
            pageHelp.setStart((pageHelp.getPage()-1)* pageHelp.getPagenum());
            pageHelp.setEnd(pageHelp.getPagenum());
            List<User> StudentList = studentMapper.StudentList(pageHelp);
            return servicePost.CreateTrueList(StudentList,total);
        }else {
            return ServicePost.CreateErrorCodMsg("学生列表没有数据呢~");
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
        int Total = studentMapper.searchStudentTotal(user);
        List<User> searchStudent = studentMapper.searchStudent(user);
        return servicePost.CreateTrueList(searchStudent,Total);
    }

    //添加学生信息
    @Override
    public ServicePost addStudent(User user) {
        Integer addStudent = studentMapper.addStudent(user);
        if (addStudent!=0){
            return ServicePost.CreateTrueCodMsg("添加学生信息成功呢!");
        }else {
            return ServicePost.CreateErrorCodMsg("添加学生信息失败呢~");
        }
    }

    //修改学生信息
    @Override
    public ServicePost updateStudent(User user) {
        Integer updateStudent = studentMapper.updateStudent(user);
        if (updateStudent!=0){
            return ServicePost.CreateTrueCodMsg("修改学生信息成功呢!");
        }else {
            return ServicePost.CreateErrorCodMsg("修改学生信息失败呢~");
        }
    }

    //删除单个学生信息
    @Override
    public ServicePost DeleteStudent(String username) {
        Integer deleteStudent = studentMapper.DeleteStudent(username);
        if (deleteStudent!=0){
            return ServicePost.CreateTrueCodMsg("删除学生信息成功呢!");
        }else {
            return ServicePost.CreateErrorCodMsg("删除学生信息失败呢~");
        }
    }

}
