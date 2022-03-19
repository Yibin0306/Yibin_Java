package SpringBoot整合Echarts.dao;

import SpringBoot整合Echarts.entity.BaseEntity;

import java.util.List;
/**
 * mapper接口
 * @author Administrator
 *
 */
public interface StatMapper {
    /**
     * 查询用户地区的数据
     * @return
     */
    List<BaseEntity> queryUserAreaStat();
}
