package 第十三章论坛短消息.dao;

import 第六章Servlet技术.entit.DLJM;
import 第十三章论坛短消息.entit.账号信息;

import java.util.List;

public interface 业务处理Dao {
    //注册，添加
    Integer regist(账号信息 账号信息);
    //检查用户名重复
    String checkName(String name);
    //登录业务
    账号信息 login(账号信息 账号信息);
    //发送消息，取用户名
    List<账号信息> findAllUser();
    //回信，获取单个用户名
    String findone(String username);

}
