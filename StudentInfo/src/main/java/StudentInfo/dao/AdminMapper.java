package StudentInfo.dao;

import StudentInfo.entity.Admin;
import StudentInfo.entity.AdminExample;
import java.util.List;

import StudentInfo.entity.Student;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    //管理员登录功能
    Admin login(Admin Admin);

}