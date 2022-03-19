package 第四章新闻发布系统主题管理及首页新闻显示.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import 第四章新闻发布系统主题管理及首页新闻显示.dao.BaseDao;
import 第四章新闻发布系统主题管理及首页新闻显示.dao.TopicsDao;
import 第四章新闻发布系统主题管理及首页新闻显示.entit.Topic;

public class TopicsDaoImpl extends BaseDao implements TopicsDao {

    public List<Topic> getAllTopics(){
        Connection con=getConnection();
        PreparedStatement ps=null;
        List <Topic>list = new ArrayList<Topic>();
        //获取所有主题
        String sql = "select * from topic";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Topic topic = new Topic();
                topic.setTid(String.valueOf(rs.getInt("tid")));
                topic.setTname(rs.getString("tname"));
                list.add(topic);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            closeAll(con, ps,  rs);
        }
        return list;
    }

    public int deleteTopic(String tid) {
        String sql = "delete from topic where tid = ?" ;
        return exceuteUpdate(sql,new Integer[]{Integer.valueOf(tid)});
    }
    public int updateTopic(Map topic) {
        String sql = "update topic set tname=? "
                + "where tid = ?" ;
        return exceuteUpdate(sql,new Object[]{topic.get("tname"),topic.get("tid")});
    }

    public Topic findTopicByName(String name) {
        Connection con=getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        Topic topic =null;
        String sql = "select * from topic where tname=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
            if(rs.next()){
                topic = new Topic();
                topic.setTid(String.valueOf(rs.getInt("tid")));
                topic.setTname(rs.getString("tname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            closeAll(con, ps,  rs);
        }
        return topic;
    }

    public int addTopic(String name) {
        String sql = "insert into topic(TNAME) values(?)";
        return exceuteUpdate(sql,new Object[]{name});
    }
}

