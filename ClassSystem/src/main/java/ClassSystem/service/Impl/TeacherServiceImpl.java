package ClassSystem.service.Impl;

import ClassSystem.entity.PageHelp;
import ClassSystem.entity.ServicePost;
import ClassSystem.entity.User;
import ClassSystem.mapper.TeacherMapper;
import ClassSystem.service.TeacherService;
import ClassSystem.utility.RedisTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private ServicePost servicePost;
    @Autowired
    private RedisTemplateUtil redisTemplateUtil;

    //获取老师列表,page值
    @Override
    public ServicePost TeacherList(PageHelp pageHelp) {
        int total = teacherMapper.TeacherTotalCount();
        if (total>0){
            pageHelp.setStart((pageHelp.getPage()-1)* pageHelp.getPagenum());
            pageHelp.setEnd(pageHelp.getPagenum());
            List<User> TeacherList = teacherMapper.TeacherList(pageHelp);
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
        int Total = teacherMapper.searchTeacherTotal(user);
        List<User> searchTeacher = teacherMapper.searchTeacher(user);
        return servicePost.CreateTrueList(searchTeacher,Total);
    }

    //删除单个老师信息
    @Override
    public ServicePost DeleteTeacher(String username) {
        Integer DeleteTeacher = teacherMapper.DeleteTeacher(username);
        if (DeleteTeacher!=0){
            return ServicePost.CreateTrueCodMsg("删除老师信息成功呢!");
        }else {
            return ServicePost.CreateErrorCodMsg("删除老师信息失败呢~");
        }
    }

}
