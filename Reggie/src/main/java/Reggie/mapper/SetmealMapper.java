package Reggie.mapper;

import Reggie.entity.Setmeal;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
//继承mybatis-plus提供的BaseMapper<加对应实体类>
public interface SetmealMapper extends BaseMapper<Setmeal> {
}
