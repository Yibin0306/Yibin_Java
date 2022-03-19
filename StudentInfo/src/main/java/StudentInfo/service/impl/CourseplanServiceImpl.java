package StudentInfo.service.impl;

import StudentInfo.dao.CourseplanMapper;
import StudentInfo.entity.CoursePlan;
import StudentInfo.entity.Student;
import StudentInfo.service.CourseplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseplanServiceImpl implements CourseplanService {
    @Autowired
    public CourseplanMapper courseplanMapper;

    //根据课程编号查询该课程，用于查询是否有有安排课程
    @Override
    public CoursePlan findOneCoursePlan(String cid) {
        return courseplanMapper.findOneCoursePlan(cid);
    }
    //添加课程信息
    @Override
    public Integer addCoursePlan(CoursePlan coursePlan) {
        return courseplanMapper.addCoursePlan(coursePlan);
    }
    //多表查询根据tid查询到课程名称
    @Override
    public List<CoursePlan> findAllCoursePlan(String tid) {
        return courseplanMapper.findAllCoursePlan(tid);
    }
    //根据排课班级名跳转到修改课程信息信息界面
    @Override
    public List<CoursePlan> findOneTeaCoursePlan(String courseclass) {
        return courseplanMapper.findOneTeaCoursePlan(courseclass);
    }
    //根据排课班级名修改课程信息信息
    @Override
    public Integer updateCoursePlan(CoursePlan coursePlan) {
        return courseplanMapper.updateCoursePlan(coursePlan);
    }
    //根据排课班级名删除课程信息信息
    @Override
    public Integer deleteCoursePlan(String courseclass) {
        return courseplanMapper.deleteCoursePlan(courseclass);
    }
}
