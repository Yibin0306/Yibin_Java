package SpringBoot整合Echarts.service;

import java.util.List;
import SpringBoot整合Echarts.dao.StatMapper;
import SpringBoot整合Echarts.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service //注入业务接口
public class StatServiceImpl implements StatService {
    //注入mapper接口
    @Autowired
    private StatMapper statMapper;

    @Override
    public List<BaseEntity> loadUserAreaStatList() {
        return statMapper.queryUserAreaStat();
    }
}