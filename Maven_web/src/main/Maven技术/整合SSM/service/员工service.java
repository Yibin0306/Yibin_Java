package 整合SSM.service;

import 整合SSM.entity.员工;

import java.util.List;

public interface 员工service {
    //添加
    Integer add(员工 员工);
    //所有
    List<员工> findAll();
    //删除
    Integer delete(Integer id);
    //修改
    Integer update(员工 员工);
}
