package 第十三章论坛短消息.service;

import 第十三章论坛短消息.dao.MsgDaoImpl;
import 第十三章论坛短消息.entit.Msg;

import java.util.List;

public class MsgServiceImpl implements MsgService{
    @Override
    public List<Msg> findAll() {
        return new MsgDaoImpl().findAll();
    }

    @Override
    public Integer deleteMsg(Integer msgid) {
        return new MsgDaoImpl().deleteMsg(msgid);
    }

    @Override
    public boolean addMes(Msg msg) {
        Integer integer = new MsgDaoImpl().addMes(msg);
        if(integer>0){
            return true;
        }
        return false;
    }

    @Override
    public Msg findone(Integer id) {
        return new MsgDaoImpl().findone(id);
    }
}
