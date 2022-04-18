package ClassSystem.mapper;

import ClassSystem.entity.Course;
import ClassSystem.entity.PageHelp;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CourseMapper {
    //返回未选课程列表多少行（page）
    int CourseNotTotalCount();
    //获取未选课程列表
    List<Course> CourseNotList(PageHelp pageHelp);

    //返回已选课程列表多少行（page）
    int CourseTotalCount();
    //获取未选课程列表
    List<Course> CourseList(PageHelp pageHelp);
}
