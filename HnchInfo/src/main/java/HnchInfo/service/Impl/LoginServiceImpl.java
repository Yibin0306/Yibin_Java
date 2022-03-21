package HnchInfo.service.Impl;

import HnchInfo.entity.Employee;
import HnchInfo.mapper.LoginMapper;
import HnchInfo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    public LoginMapper loginMapper;

    @Override
    public Employee login(Employee employee) {
        return loginMapper.login(employee);
    }
}
