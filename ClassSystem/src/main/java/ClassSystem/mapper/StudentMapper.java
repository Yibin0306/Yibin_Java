package ClassSystem.mapper;

import ClassSystem.entity.PageHelp;
import ClassSystem.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    //返回多少行（page）
    int TotalCount();
    //获取学生列表
    List<Student> StudentList(PageHelp pageHelp);

}
