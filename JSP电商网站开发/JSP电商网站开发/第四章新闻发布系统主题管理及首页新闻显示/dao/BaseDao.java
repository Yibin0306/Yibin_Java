package 第四章新闻发布系统主题管理及首页新闻显示.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 数据库连接与关闭工具类。
 * @author 北大青鸟
 */
public class BaseDao {
    private static String driver =
            "com.mysql.jdbc.Driver";// 数据库驱动字符串
    private static String url =
            "jdbc:mysql://localhost:3306/实训四";// 连接URL字符串
    private static String user = "root"; // 数据库用户名
    private static String password = "202306"; // 用户密码

    protected Connection conn;
    protected PreparedStatement pstmt;
    protected ResultSet rs;
    /**
     * 获取数据库连接对象。
     */
    public Connection getConnection() {
        Connection conn = null;// 数据连接对象
        // 获取连接并捕获异常
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();// 异常处理
        }
        return conn;// 返回连接对象
    }
    /**
     * 关闭数据库连接。
     * @param conn 数据库连接
     * @param stmt Statement对象
     * @param rs 结果集
     */
    public void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        // 若结果集对象不为空，则关闭
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 若Statement对象不为空，则关闭
        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 若数据库连接对象不为空，则关闭
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 增、删、改操作
     * @param sql sql语句
     * @param prams 参数数组
     * @return 执行结果
     */
    public int exceuteUpdate(String sql,Object...prams){
        int result=0;
        conn=this.getConnection();
        try {
            pstmt=conn.prepareStatement(sql);
            for(int i=0;i<prams.length;i++){
                pstmt.setObject(i+1, prams[i]);
            }
            result=pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            closeAll(conn, pstmt, rs);
        }
        return result;
    }
}

