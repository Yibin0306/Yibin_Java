package SpringBoot注册功能.dao;

import SpringBoot注册功能.entity.Manager;

public interface ManagerDao {
    //注册
    Integer regist(Manager manager);
    //验证重复名
    Integer checkName(String name);
}
