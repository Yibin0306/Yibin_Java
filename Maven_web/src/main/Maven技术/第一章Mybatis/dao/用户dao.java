package 第一章Mybatis.dao;

import 第一章Mybatis.entity.用户;

import java.util.List;

public interface 用户dao {
    //添加用户
    Integer addUser(用户 用户);
    //查询所有用户
    List<用户> findAll();
    //查询单个用户
    用户 selectOne(Integer id);
    //修改用户名
    Integer updateUser(用户 用户);
    //删除用户名
    Integer deleteUser(Integer id);
    //sql片段
    用户 selectOneName(String name);
    //多条件搜索
    用户 select(用户 用户);
    //foreach批量删除用户
    Integer deleteUserId(List<Integer> ids);
}
