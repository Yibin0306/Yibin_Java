package ClassSystem.service.Impl;

import ClassSystem.entity.PageHelp;
import ClassSystem.entity.ServicePost;
import ClassSystem.entity.Student;
import ClassSystem.mapper.StudentMapper;
import ClassSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ServicePost servicePost;

    //返回前端页面数据（学生列表,page值）
    @Override
    public ServicePost StudentList(PageHelp pageHelp) {
        pageHelp.setStart((pageHelp.getPage()-1)* pageHelp.getPagenum());
        pageHelp.setEnd(pageHelp.getPagenum());
        List<Student> StudentList = studentMapper.StudentList(pageHelp);
        int total = studentMapper.TotalCount();
        return servicePost.CreateTrueCodMsgList(StudentList,total);
    }
}
