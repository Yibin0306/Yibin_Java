package 课上练习;

import java.sql.*;

public class 课上练习 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获得链接对象 Connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc技术", "root", "202306");
        //System.out.println(connection);

        //获得Statement对象，执行sql语句
        Statement statement = connection.createStatement();
        //执行SQL   executeUpdate:添加，修改，删除  executeQuery : 查询
        //String sql = "insert into 客户信息表 values(5,'zhangsan','aaa','666','526','henan',500)";
        //String sql = "delete from 客户信息表 where 客户id = 4";
        //String sql = "update 客户信息表 set 客户名称='张三' where 客户id=1";
        //受影响的行数
        //int i = statement.executeUpdate(sql);
        //System.out.println(i);

        //查询
        //----ORM   对象关系映射
        String sql = "select * from 客户信息表";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            //System.out.println("客户id:"+resultSet.getInt(1)+","+"客户名称:"+resultSet.getString(2));
            客户信息表 sc = new 客户信息表();
            sc.set客户id(resultSet.getInt(1));
            sc.set客户名称(resultSet.getString(2));
            sc.set客户密码(resultSet.getString(3));
            sc.set客户电话(resultSet.getString(4));
            sc.set客户邮箱(resultSet.getString(5));
            sc.set客户地址(resultSet.getString(6));
            sc.set客户余额(resultSet.getInt(7));
            System.out.println(sc);
        }

    }
}
