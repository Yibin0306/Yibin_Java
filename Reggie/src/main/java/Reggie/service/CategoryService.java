package Reggie.service;

import Reggie.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

//继承mybatis-plus提供的IService<加对应实体类>
public interface CategoryService extends IService<Category> {
    //根据id删除分类，删除之前需要进行判断
    public void remove(Long id);
}
