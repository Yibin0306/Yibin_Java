package 整合SSM.dao;

import 整合SSM.entity.员工;

import java.util.List;

public interface 员工Dao {
    //添加员工
    Integer add(员工 员工);
    //所有员工
    List<员工> findAll();
    //删除员工
    Integer delete(Integer id);
    //修改员工
    Integer update(员工 员工);
}
