package 整合SSM.dao;


import 整合SSM.entity.注册表;

public interface 注册表Dao {
    //注册
    Integer regist(注册表 注册表);
    //验证重复名
    Integer checkName(String uname);
    //登录
    注册表 login(注册表 注册表);
}
