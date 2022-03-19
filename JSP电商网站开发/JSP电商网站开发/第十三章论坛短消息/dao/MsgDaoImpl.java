package 第十三章论坛短消息.dao;

import 第十三章论坛短消息.entit.Msg;
import 第十三章论坛短消息.util.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MsgDaoImpl implements MsgDao{
    @Override
    public List<Msg> findAll() {
        try {
            ResultSet resultSet = JDBCUtil.getStatement().executeQuery("SELECT * FROM msg");
            ArrayList<Msg> msg = new ArrayList<>();
            while (resultSet.next()){
                Msg m = new Msg();
                m.setMsgid(resultSet.getInt(1));
                m.setTitle(resultSet.getString(2));
                m.setConter(resultSet.getString("conter"));
                m.setSlate(resultSet.getInt("slate"));
                m.setDatetime(resultSet.getString("datetime"));
                m.setUsername(resultSet.getString("username"));
                msg.add(m);
            }
            return msg;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer deleteMsg(Integer msgid) {
        try {
            int i = JDBCUtil.getStatement().executeUpdate("delete from msg where msgid =" + msgid);
            return i;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Integer addMes(Msg msg) {
        try {
            Statement statement = JDBCUtil.getStatement();
            String sql = "insert into msg(title,username,datetime," +
                    "slate,conter,sendto) " +
                    "values('"+
                    msg.getTitle()+"','"+
                    msg.getUsername()+"','"+
                    msg.getDatetime()+"',"+
                    msg.getSlate()+",'"+
                    msg.getConter()+"','"+
                    msg.getSendto()+"')";
            int i = statement.executeUpdate(sql);
            return i;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Msg findone(Integer id) {
        try {
            ResultSet resultSet = JDBCUtil.getStatement().executeQuery("select * from msg where msgid=" + id);
            if (resultSet.next()){
                Msg msg = new Msg();
                msg.setMsgid(resultSet.getInt("msgid"));
                msg.setSlate(resultSet.getInt("slate"));
                msg.setUsername(resultSet.getString("username"));
                msg.setTitle(resultSet.getString("title"));
                msg.setConter(resultSet.getString("conter"));
                msg.setSendto(resultSet.getString("sendto"));
                msg.setDatetime(resultSet.getString("datetime"));
                return msg;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer updateMsg(Integer id) {
        try {
            Statement statement = JDBCUtil.getStatement();
            statement.executeUpdate("update msg set slate=1 where msgid="+id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
//        List<Msg> all = new MsgDaoImpl().findAll();
//        System.out.println(all);
//        Integer integer = new MsgDaoImpl().deleteMsg(10);
//        System.out.println(integer);
//        Msg findone = new MsgDaoImpl().findone(1);
//        System.out.println(findone);
    }
}
