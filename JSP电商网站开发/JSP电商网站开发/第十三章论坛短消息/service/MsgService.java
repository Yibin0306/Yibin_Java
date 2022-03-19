package 第十三章论坛短消息.service;

import 第十三章论坛短消息.entit.Msg;

import java.util.List;

public interface MsgService {
    List<Msg> findAll();
    //删除
    Integer deleteMsg(Integer msgid);
    //发布短消息
    boolean addMes(Msg msg);
    //获取单一的id，获取内容
    Msg findone(Integer id);
}
