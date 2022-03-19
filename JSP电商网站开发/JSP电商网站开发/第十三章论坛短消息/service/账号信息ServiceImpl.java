package 第十三章论坛短消息.service;

import 第十三章论坛短消息.dao.业务处理DaoImpl;
import 第十三章论坛短消息.entit.账号信息;
import 第十三章论坛短消息.util.MD5Util;

import java.util.List;

public class 账号信息ServiceImpl implements 账号信息Service{
    @Override
    public Integer regist(账号信息 账号信息) {
        try {
            String s = MD5Util.md5Encode(账号信息.getUpwd());
            账号信息.setUpwd(s);
            Integer regist = new 业务处理DaoImpl().regist(账号信息);
            return regist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer checkName(String name) {

        String s1 = new 业务处理DaoImpl().checkName(name);
        if(s1==null){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public boolean login(账号信息 账号信息) {

        try {
            String s = MD5Util.md5Encode(账号信息.getUpwd());
            账号信息.setUpwd(s);
            账号信息 userdb = new 业务处理DaoImpl().login(账号信息);
            if(userdb!=null){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<账号信息> findAllUser() {
        return new 业务处理DaoImpl().findAllUser();
    }

    public static void main(String[] args) {
        Integer tom = new 账号信息ServiceImpl().regist(new 账号信息("tom", "123", "@123"));
        System.out.println(tom);
    }
}
