package ClassSystem.service.Impl;

import ClassSystem.entity.PageHelp;
import ClassSystem.entity.ServicePost;
import ClassSystem.entity.User;
import ClassSystem.mapper.CourseMapper;
import ClassSystem.service.CourseService;
import ClassSystem.utility.RedisTemplateUtil;
import ClassSystem.utility.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private ServicePost servicePost;
    @Autowired
    private RedisTemplateUtil redisTemplateUtil;

    //返回前端页面数据（未选课列表,page值）
    @Override
    public ServicePost CourseNotList(PageHelp pageHelp) {
        String currentToken = UserRequest.getCurrentToken("token");
        int total = courseMapper.CourseNotTotalCount();
        if (total>0){
            pageHelp.setStart((pageHelp.getPage()-1)* pageHelp.getPagenum());
            pageHelp.setEnd(pageHelp.getPagenum());
            List<User> CourseList = courseMapper.CourseNotList(pageHelp);
            return servicePost.CreateTrueList(CourseList,total);
        }else {
            return ServicePost.CreateErrorCodMsg("未选课程列表没有数据呢~");
        }
    }

    //返回前端页面数据（已选课程列表,page值）
    @Override
    public ServicePost CourseList(PageHelp pageHelp) {
        String currentToken = UserRequest.getCurrentToken("token");
        int total = courseMapper.CourseTotalCount();
        if (total>0){
            pageHelp.setStart((pageHelp.getPage()-1)* pageHelp.getPagenum());
            pageHelp.setEnd(pageHelp.getPagenum());
            List<User> CourseList = courseMapper.CourseList(pageHelp);
            return servicePost.CreateTrueList(CourseList,total);
        }else {
            return ServicePost.CreateErrorCodMsg("未选课程列表没有数据呢~");
        }
    }

}
