package Reggie.service;

import Reggie.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

//继承mybatis-plus提供的IService<加对应实体类>
public interface OrdersService extends IService<Orders> {
    //用户下单
    public void submit(Orders orders);
}
