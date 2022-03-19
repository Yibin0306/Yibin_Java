package 第四章新闻发布系统主题管理及首页新闻显示.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import 第四章新闻发布系统主题管理及首页新闻显示.dao.BaseDao;
import 第四章新闻发布系统主题管理及首页新闻显示.dao.UserDao;
import 第四章新闻发布系统主题管理及首页新闻显示.entit.User;

public class UserDaoImpl extends BaseDao implements UserDao {

    public User findUser(String uname, String password) {
        Connection con=getConnection();
        PreparedStatement ps=null;
        User user=null;
        //获取所有主题
        String sql = "select * from USER where uname=? and upwd=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1,uname);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if(rs.next()){
                user= new User();
                user.setUid(rs.getString("uid"));
                user.setUname(uname);
                user.setUpwd(password);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            closeAll(con, ps,  rs);
        }
        return user;
    }
}

