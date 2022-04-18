package ClassSystem.service.Impl;

import ClassSystem.entity.ServicePost;
import ClassSystem.mapper.CourseMapper;
import ClassSystem.utility.RedisTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private ServicePost servicePost;
    @Autowired
    private RedisTemplateUtil redisTemplateUtil;

}
