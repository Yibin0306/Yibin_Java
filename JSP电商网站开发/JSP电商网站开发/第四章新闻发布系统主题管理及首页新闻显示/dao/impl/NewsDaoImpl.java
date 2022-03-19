package 第四章新闻发布系统主题管理及首页新闻显示.dao.impl;


import 第四章新闻发布系统主题管理及首页新闻显示.dao.BaseDao;
import 第四章新闻发布系统主题管理及首页新闻显示.dao.NewsDao;
import 第四章新闻发布系统主题管理及首页新闻显示.entit.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class NewsDaoImpl extends BaseDao implements NewsDao {
    public List<News> getAllnews() {
        Connection con=getConnection();
        PreparedStatement ps=null;
        List <News>list = new ArrayList<News>();
        //获取所有新闻
        String sql = "select *"
                + " from news,topic"
                + " where news.ntid = topic.tid"
                + " order by ntid,ncreatedate desc";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                News news = new News();
                news.setNid(String.valueOf(rs.getObject("nid")));
                news.setNtid(String.valueOf(rs.getObject("ntid")));
                news.setNtitle((String)rs.getObject("ntitle"));
                news.setNauthor((String)rs.getObject("nauthor"));
                news.setNcontent((String)rs.getObject("ncontent"));
                news.setNtname(String.valueOf(rs.getObject("tname")));
                news.setNcreatedate(rs.getString("ncreatedate"));
                list.add(news);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            closeAll(con, ps,  rs);
        }
        return list;
    }

    public List<News> getAllnewsByTID(int Tid) {
        Connection con=getConnection();
        PreparedStatement ps=null;
        List <News>list = new ArrayList<News>();
        //获取某主题下的所有新闻
        String sql = "select * from news  where ntid = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, Tid);
            rs = ps.executeQuery();
            while(rs.next()){
                News news = new News();
                news.setNid(String.valueOf(rs.getObject("nid")));
                news.setNtid(String.valueOf(rs.getObject("ntid")));
                news.setNtitle((String)rs.getObject("ntitle"));
                news.setNauthor((String)rs.getObject("nauthor"));
                news.setNcontent((String)rs.getObject("ncontent"));
                news.setNtname(String.valueOf(rs.getObject("ntitle")));
                list.add(news);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            closeAll(con, ps,  rs);
        }
        return list;
    }
}

