package 第六章Servlet技术.dao;

import 第六章Servlet技术.entit.DLJM;
import 第四章新闻发布系统主题管理及首页新闻显示.实训四练习.entit.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DLJMDaoImpl implements DLJMDao{
    @Override
    public DLJM login(DLJM dljm) {
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得链接
            String url="jdbc:mysql://localhost:3306/实训四练习";
            String uname = "root";
            String upwd = "202306";//自己的密码
            Connection connection = DriverManager.getConnection(url, uname, upwd);
            //3.获得Statement 执行sql
            Statement statement = connection.createStatement();
            String sql = "select * from dljm where name ='" + dljm.getName() + "'and pwd ='" + dljm.getPwd() + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            //4.处理结果 ORM 数据库-->java对象
            while (resultSet.next()){
                DLJM dljm1 = new DLJM(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
                return dljm1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
        }
        return null;
    }
}
