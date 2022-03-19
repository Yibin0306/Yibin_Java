package 第四章新闻发布系统主题管理及首页新闻显示.dao;


import 第四章新闻发布系统主题管理及首页新闻显示.entit.User;

public interface UserDao{
    //查找是否登录成功
    public User findUser(String uname,String password);
}