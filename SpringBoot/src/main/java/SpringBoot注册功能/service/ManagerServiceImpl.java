package SpringBoot注册功能.service;

import SpringBoot注册功能.dao.ManagerDao;
import SpringBoot注册功能.entity.Manager;
import SpringBoot注册功能.uitl.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService{
    @Autowired
    public ManagerDao managerDao;
    //注册功能,密码加密
    @Override
    public Integer regist(Manager manager) {
        //密码加密
        try {
            String s = MD5Util.md5Encode(manager.getPwd());
            manager.setPwd(s);
            Integer i = managerDao.regist(manager);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //验证重复名
    @Override
    public Integer checkName(String name) {
        return managerDao.checkName(name);
    }
}
