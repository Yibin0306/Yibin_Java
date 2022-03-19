package 第十一章Ajax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ZdbqDaoImpl {
    public String findAll(String s){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/实训十一", "root", "202306");
            Statement statement = connection.createStatement();
            String sql = "select name from 自动补全 where name like '%"+s+"%'";
            ResultSet resultSet = statement.executeQuery(sql);
            String res = "";
            while (resultSet.next()){
                res+=resultSet.getString(1)+",";
            }
            return res;
        }catch (Exception e){

        }
        return null;
    }

    public static void main(String[] args) {
        String t = new ZdbqDaoImpl().findAll("t");
        System.out.println(t);
    }
}
