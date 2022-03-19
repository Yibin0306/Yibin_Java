package 第三章会话跟踪技术.session.dao;

import 第三章会话跟踪技术.session.entit.Entit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoImp implements Dao {

    @Override
    public List<Entit> selectAllEntit() {
        ArrayList<Entit> Entits = new ArrayList<>();
        return Entits;
    }

    @Override
    public Boolean selectEntitByNameAndPwd(Entit Entit) {
        第三章会话跟踪技术.session.entit.Entit user = new Entit();
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
            rs = stat.executeQuery("select * from 会话跟踪技术 where name='"+Entit.getName()+
                    "' and pwd = '"+Entit.getPwd()+"'");
            while (rs.next()){
                return true;
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
        return false;
    }
}
