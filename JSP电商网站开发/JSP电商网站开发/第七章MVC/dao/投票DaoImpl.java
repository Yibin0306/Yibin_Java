package 第七章MVC.dao;

import 第一章idea集成tomcat及信息列表展示.信息列表展示.entit.信息列表展示;
import 第七章MVC.entit.投票;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class 投票DaoImpl implements 投票Dao{

    @Override
    public List<投票> selectAll投票() {
        //使用jdbc技术查询所有用户信息，并且返回
            List<投票> 投票s = new ArrayList<>();

            Connection conn =null;
            Statement stat =null;
            ResultSet rs = null;

            try {
                //1.加载驱动 com.mysql.jdbc.Driver
                Class.forName("com.mysql.jdbc.Driver");
                //2.获得链接 DriverManager.getConnection(url,u,pwd);
                String url = "jdbc:mysql://127.0.0.1:3306/实训七";
                String uname = "root";
                String pwd = "202306";
                conn = DriverManager.getConnection(url,uname,pwd);
                //3.获得statment conn.creatStatment
                stat = conn.createStatement();
                //4.执行sql  ResultSet
                rs = stat.executeQuery("select * from 投票");
                //5.处理结果集（把数据库表中的多行数据变成多个java对象）
                while (rs.next()){
                    投票 投票 = new 投票(rs.getInt(1), rs.getString(2), rs.getInt(3));
                    投票s.add(投票);
                }
                return 投票s;
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

            return null;
        }

    @Override
    public Integer add投票(Integer id) {
        Connection conn =null;
        Statement stat =null;
        ResultSet rs = null;

        try {
            //1.加载驱动 com.mysql.jdbc.Driver
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得链接 DriverManager.getConnection(url,u,pwd);
            String url = "jdbc:mysql://127.0.0.1:3306/实训七";
            String uname = "root";
            String pwd = "202306";
            conn = DriverManager.getConnection(url,uname,pwd);
            Statement statement = conn.createStatement();
            String sql = "update 投票 set times = times +1 where id="+id ;
            int i1 = statement.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
        }
        return null;
    }
}


