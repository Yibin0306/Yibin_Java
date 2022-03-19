package 第十三章论坛短消息.dao;

import 第六章Servlet技术.entit.DLJM;
import 第十三章论坛短消息.entit.账号信息;
import 第十三章论坛短消息.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class 业务处理DaoImpl implements 业务处理Dao {
    @Override
    public Integer regist(账号信息 账号信息) {
        try {
            Statement statement = JDBCUtil.getStatement();
            String sql = "insert into 账号信息(uname,upwd,email) values('"
                    +账号信息.getUname()+"','"
                    +账号信息.getUpwd()+"','"
                    +账号信息.getEmail()+"')";
            int i = statement.executeUpdate(sql);
            return i;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String checkName(String name) {
        try {
            ResultSet resultSet = JDBCUtil.getStatement().executeQuery("select uname from 账号信息 where uname='" + name + "'");
            String res = null;
            while (resultSet.next()){
                res = resultSet.getString(1);
            }
            return res;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public 账号信息 login(账号信息 账号信息) {
        try {
            ResultSet resultSet = JDBCUtil.getStatement().executeQuery("select * from 账号信息 where uname ='" + 账号信息.getUname() + "'and upwd ='" + 账号信息.getUpwd() + "'");
            第十三章论坛短消息.entit.账号信息 账号信息2 = new 账号信息();
            if (resultSet.next()){
                账号信息2.setId(resultSet.getInt(1));
                账号信息2.setUname(resultSet.getString(2));
                账号信息2.setUpwd(resultSet.getString(3));
                账号信息2.setEmail(resultSet.getString(4));
                return 账号信息2;
            }else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<账号信息> findAllUser() {
        try {
            ResultSet username = JDBCUtil.getStatement().executeQuery("select uname from 账号信息");
            ArrayList<账号信息> 账号信息s = new ArrayList<>();
            while (username.next()){
                账号信息 账号信息 = new 账号信息();
                账号信息.setUname(username.getString(1));
                账号信息s.add(账号信息);
            }
            return 账号信息s;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String findone(String username) {
        try {
            JDBCUtil.getStatement().executeQuery("select uname from 账号信息 where "+username);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
//        Integer reqist = new 用户注册DaoImpl().regist(new 账号信息("tom", "123", "dsad"));
//        System.out.println(reqist);
//        String s = new 业务处理DaoImpl().checkName("to1m");
//        System.out.println(s);
//        账号信息 tom = new 业务处理DaoImpl().login(new 账号信息("Yibin", "ba7df060feb0b2ddaee4c4b760f187b3"));
//        System.out.println(tom);

        List<账号信息> allUser = new 业务处理DaoImpl().findAllUser();
        System.out.println(allUser);
    }
}
