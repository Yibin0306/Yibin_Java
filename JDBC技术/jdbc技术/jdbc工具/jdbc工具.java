package jdbc工具;

import java.sql.*;
import java.util.Collection;

public class jdbc工具 {
    static Connection conn=null;
    static Statement stat=null;
    static ResultSet rs = null;
    static {//类加载执行，执行一次
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Statement getStatement(String sql库名, String sql用户名, String sql密码) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" + sql库名, sql用户名, sql密码);
            stat = conn.createStatement();
            PreparedStatement ps = conn.prepareStatement("insert into user values(?,?,?,?)");
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return stat;
    }
    public static void close(){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stat!=null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}