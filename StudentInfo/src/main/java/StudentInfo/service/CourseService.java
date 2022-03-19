package StudentInfo.service;

import StudentInfo.entity.Course;

import java.util.List;

public interface CourseService {
    //添加课程信息
    Integer addCourse(Course course);
    //查询所有课程信息
    List<Course> findAllCourse();
    //根据ID删除课程信息
    Integer deleteCourse(String tid);
    //根据id跳转到修改课程界面
    //根据id查询课程信息
    List<Course> findOneCourse(String cid);
    //修改课程内容
    Integer updateCourse(Course course);
    //根据课程名称查询课程信息
    List<Course> findCnameCourse(String Cname);
    //根据学院查询课程信息
    List<Course> findBelongcollCourse(String belongcoll);
    //根据类型查询课程信息
    List<Course> findTypeCourse(String type);
}
