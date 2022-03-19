package 第十三章论坛短消息.util;

import java.sql.*;

public class JDBCUtil {

    private static String driverClassName = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/实训十三";
    private static String username = "root";
    private static String password = "202306";
    static {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Statement getStatement() throws SQLException {
        Statement statement = DriverManager.getConnection(url, username, password).createStatement();
        return statement;
    }
}
