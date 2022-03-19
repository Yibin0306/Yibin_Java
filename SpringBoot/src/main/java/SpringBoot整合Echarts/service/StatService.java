package SpringBoot整合Echarts.service;

import SpringBoot整合Echarts.entity.BaseEntity;

import java.util.List;
/**
 * 据服务接口
 * @author LJH
 *
 */
public interface StatService {
    /**
     * 查询用户地区的数据
     * @return
     */
    List<BaseEntity> loadUserAreaStatList();
}
