package 整合SSM.service;
import 整合SSM.entity.注册表;

public interface 注册表service {
    //注册
    Integer add(注册表 注册表);
    //验证重复名
    Integer checkName(String uname);
    //登录
    注册表 login(注册表 注册表);
}
