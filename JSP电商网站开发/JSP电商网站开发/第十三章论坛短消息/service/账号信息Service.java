package 第十三章论坛短消息.service;

import 第十三章论坛短消息.entit.账号信息;

import java.util.List;

public interface 账号信息Service {
    //注册，添加
    Integer regist(账号信息 账号信息);
    Integer checkName(String name);
    //登录业务
    boolean login(账号信息 账号信息);
    //查询单个名称
    List<账号信息> findAllUser();
}
