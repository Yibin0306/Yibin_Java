package StudentInfo.service.impl;

import StudentInfo.dao.AdminMapper;
import StudentInfo.entity.Admin;
import StudentInfo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    public AdminMapper adminMapper;
    //管理员登录
    @Override
    public Admin login(Admin Admin) {
        return adminMapper.login(Admin);
    }
}
