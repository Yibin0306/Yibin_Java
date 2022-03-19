package StudentInfo.dao;

import StudentInfo.entity.CoursePlan;
import StudentInfo.entity.CourseplanExample;
import java.util.List;

import StudentInfo.entity.Student;
import org.apache.ibatis.annotations.Param;

public interface CourseplanMapper {
    //根据课程编号查询该课程，用于查询是否有有安排课程
    CoursePlan findOneCoursePlan(String cid);
    //添加课程信息
    Integer addCoursePlan(CoursePlan coursePlan);
    //多表查询根据tid查询到课程名称
    List<CoursePlan> findAllCoursePlan(String tid);
    //根据排课班级名跳转到修改课程信息信息界面
    List<CoursePlan> findOneTeaCoursePlan(String courseclass);
    //根据排课班级名修改课程信息信息
    Integer updateCoursePlan(CoursePlan coursePlan);
    //根据排课班级名删除课程信息信息
    Integer deleteCoursePlan(String courseclass);

}