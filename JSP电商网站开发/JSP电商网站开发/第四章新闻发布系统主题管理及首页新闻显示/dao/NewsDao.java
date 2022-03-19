package 第四章新闻发布系统主题管理及首页新闻显示.dao;


import java.util.List;
import 第四章新闻发布系统主题管理及首页新闻显示.entit.News;

public interface NewsDao{
    //获取所有新闻
    public List<News> getAllnews();
    //获取某主题下的所有新闻
    public List<News> getAllnewsByTID(int Tid);
}