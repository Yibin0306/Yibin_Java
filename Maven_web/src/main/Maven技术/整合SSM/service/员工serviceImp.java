package 整合SSM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import 整合SSM.dao.员工Dao;
import 整合SSM.entity.员工;

import java.util.List;

/*
    1.用在业务层的实现类上
    2.把类交给工厂管理;  默认Bean：接口名  用户service 小写
    @Autowired  自动依赖注入的
    @Transactional   业务层的组件 加上事物
*/
@Service
@Transactional
public class 员工serviceImp implements 员工service {
    //自动的依赖注入
    @Autowired
    private 员工Dao 员工Dao;

    @Override
    public Integer add(员工 员工) {
        return 员工Dao.add(员工);
    }

    @Override
    public List<员工> findAll() {
        return 员工Dao.findAll();
    }

    @Override
    public Integer delete(Integer id) {
        return 员工Dao.delete(id);
    }

    @Override
    public Integer update(员工 员工) {
        return 员工Dao.update(员工);
    }
}
