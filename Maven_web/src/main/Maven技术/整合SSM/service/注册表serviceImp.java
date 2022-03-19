package 整合SSM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import 工具.MD5Util;
import 整合SSM.entity.注册表;

@Service
@Transactional
public class 注册表serviceImp implements 注册表service{
    @Autowired
    public 整合SSM.dao.注册表Dao 注册表Dao;

    @Override
    public Integer add(注册表 注册表) {
        //密码加密
        try {
            String s = MD5Util.md5Encode(注册表.getUpwd());
            注册表.setUpwd(s);
            Integer i = 注册表Dao.regist(注册表);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer checkName(String uname) {
        return 注册表Dao.checkName(uname);
    }

    @Override
    public 注册表 login(注册表 注册表) {
        整合SSM.entity.注册表 login = 注册表Dao.login(注册表);
        try {
            String s = MD5Util.md5Encode(注册表.getUpwd());
            if(login.getUpwd().equals(s)){
                return login;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
