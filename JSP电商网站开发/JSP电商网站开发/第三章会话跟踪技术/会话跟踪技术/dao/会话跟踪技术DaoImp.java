package 第三章会话跟踪技术.会话跟踪技术.dao;

import 第一章idea集成tomcat及信息列表展示.信息列表展示.entit.信息列表展示;
import 第三章会话跟踪技术.会话跟踪技术.entit.会话跟踪技术;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class 会话跟踪技术DaoImp implements 会话跟踪技术Dao {
    @Override
    public List<会话跟踪技术> selectAll会话跟踪技术() {
        ArrayList<会话跟踪技术> 会话跟踪技术s = new ArrayList<>();
        return 会话跟踪技术s;
    }

    @Override
    public 会话跟踪技术 select会话跟踪技术ByNameAndPwd(会话跟踪技术 会话跟踪技术) {
        第三章会话跟踪技术.会话跟踪技术.entit.会话跟踪技术 会话跟踪技术1 = new 会话跟踪技术();

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
            rs = stat.executeQuery("select * from 会话跟踪技术 where name='"+会话跟踪技术.getName()+
                    "' and pwd = '"+会话跟踪技术.getPwd()+"'");
            //5.处理结果集（把数据库表中的多行数据变成多个java对象）
            while (rs.next()){
                会话跟踪技术1.setName(rs.getString(1));
                会话跟踪技术1.setPwd(rs.getString(2));
                return 会话跟踪技术1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                stat.close();
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
