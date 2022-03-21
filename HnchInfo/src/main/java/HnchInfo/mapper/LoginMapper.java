package HnchInfo.mapper;

import HnchInfo.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    //管理员登录功能
    Employee login(Employee employee);

}
