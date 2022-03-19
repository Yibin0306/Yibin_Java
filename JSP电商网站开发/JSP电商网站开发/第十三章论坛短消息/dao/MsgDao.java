package 第十三章论坛短消息.dao;

import 第十三章论坛短消息.entit.Msg;

import java.util.List;

public interface MsgDao {
    //查询所有新闻
    List<Msg> findAll();
    //删除新闻
    Integer deleteMsg(Integer msgid);
    //发布短消息
    Integer addMes(Msg msg);
    //获取单一的id，获取内容
    Msg findone(Integer id);
    //查看是否阅读
    Integer updateMsg(Integer id);
}
