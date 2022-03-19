package 第一章idea集成tomcat及信息列表展示.信息列表展示.dao;

import 第一章idea集成tomcat及信息列表展示.信息列表展示.entit.信息列表展示;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class 信息列表展示DaoImpl implements 信息列表展示Dao{
    //使用jdbc技术查询所有用户信息，并且返回
    @Override
    public List<信息列表展示> selectAll信息列表展示() {
        List<信息列表展示> 信息列表展示s = new ArrayList<>();

        Connection conn =null;
        Statement stat =null;
        ResultSet rs = null;

        try {
            //1.加载驱动 com.mysql.jdbc.Driver
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得链接 DriverManager.getConnection(url,u,pwd);
            String url = "jdbc:mysql://127.0.0.1:3306/jsp测试";
            String uname = "root";
            String pwd = "202306";
            conn = DriverManager.getConnection(url,uname,pwd);
            //3.获得statment conn.creatStatment
            stat = conn.createStatement();
            //4.执行sql  ResultSet
            rs = stat.executeQuery("select * from 信息列表展示");
            //5.处理结果集（把数据库表中的多行数据变成多个java对象）
            while (rs.next()){
                信息列表展示 信息列表展示 = new 信息列表展示(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                信息列表展示s.add(信息列表展示);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
            try {
                rs.close();
                stat.close();
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return 信息列表展示s;
    }
}
