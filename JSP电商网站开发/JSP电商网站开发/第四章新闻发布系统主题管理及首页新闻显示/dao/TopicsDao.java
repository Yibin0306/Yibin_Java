package 第四章新闻发布系统主题管理及首页新闻显示.dao;

import java.util.List;
import java.util.Map;

import 第四章新闻发布系统主题管理及首页新闻显示.entit.Topic;

public interface TopicsDao{
    //获取所有主题
    public List<Topic> getAllTopics();
    //更新主题
    public int updateTopic(Map<String, String> topic);
    //根据名字查找主题
    public Topic findTopicByName(String name);
    //添加主题
    public int addTopic(String name);
    //通过tid删除主题
    public int deleteTopic(String tid);
}