package StudentInfo.service.impl;

import StudentInfo.dao.AdminMapper;
import StudentInfo.dao.CourseMapper;
import StudentInfo.entity.Course;
import StudentInfo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    public CourseMapper courseMapper;

    //添加课程信息
    @Override
    public Integer addCourse(Course course) {
        return courseMapper.addCourse(course);
    }
    //查询所有课程信息
    @Override
    public List<Course> findAllCourse() {
        return courseMapper.findAllCourse();
    }
    //根据ID删除课程信息
    @Override
    public Integer deleteCourse(String tid) {
        return courseMapper.deleteCourse(tid);
    }
    //根据ID查询课程
    @Override
    public List<Course> findOneCourse(String cid) {
        return courseMapper.findOneCourse(cid);
    }
    //修改课程内容
    @Override
    public Integer updateCourse(Course course) {
        return courseMapper.updateCourse(course);
    }
    //根据课程名称查询课程信息
    @Override
    public List<Course> findCnameCourse(String Cname) {
        return courseMapper.findCnameCourse(Cname);
    }
    //根据学院查询课程信息
    @Override
    public List<Course> findBelongcollCourse(String belongcoll) {
        return courseMapper.findBelongcollCourse(belongcoll);
    }
    //根据类型查询课程信息
    @Override
    public List<Course> findTypeCourse(String type) {
        return courseMapper.findTypeCourse(type);
    }
}
