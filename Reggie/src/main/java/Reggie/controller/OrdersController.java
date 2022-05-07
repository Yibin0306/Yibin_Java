package Reggie.controller;

import Reggie.common.BaseContext;
import Reggie.common.R;
import Reggie.dto.OrdersDto;
import Reggie.entity.OrderDetail;
import Reggie.entity.Orders;
import Reggie.entity.ShoppingCart;
import Reggie.entity.User;
import Reggie.service.OrderDetailService;
import Reggie.service.OrdersService;
import Reggie.service.ShoppingCartService;
import Reggie.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单相关
 */
@Slf4j
@RestController
@RequestMapping(value = "/order")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private UserService userService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 用户下单
     * @param orders
     * @return
     */
    @PostMapping(value = "/submit")
    public R<String> submit(@RequestBody Orders orders){
        log.info("订单数据：{}",orders);
        ordersService.submit(orders);
        return R.success("下单成功呢~");
    }

    /**
     * 后台端订单明细分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/page")
    public R<Page> page(int page, int pageSize, Integer number, String beginTime,String endTime){
        //构造分页构造器
        Page<Orders> pageInfo = new Page<>(page,pageSize);
        Page<OrdersDto> ordersDtoPage = new Page<>();
        //条件构造器
        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();
        //添加过滤条件，通过number进行like模糊查询
        queryWrapper.like(number!=null,Orders::getNumber,number);
        //添加过滤条件，通过日期范围进行查询.ge.le
        queryWrapper.ge(beginTime!=null,Orders::getOrderTime,beginTime)
                .le(endTime!=null,Orders::getOrderTime,endTime);
        //添加一个排序条件
        queryWrapper.orderByDesc(Orders::getOrderTime);
        //执行分页查询
        ordersService.page(pageInfo,queryWrapper);
        //对象拷贝
        BeanUtils.copyProperties(pageInfo,ordersDtoPage,"records");
        List<Orders> records = pageInfo.getRecords();
        List<OrdersDto> dtoList = records.stream().map((item) ->{
            OrdersDto ordersDto = new OrdersDto();
            BeanUtils.copyProperties(item,ordersDto);
            //用户id
            Long userId = item.getUserId();
            //根据id查询用户信息
            User user = userService.getById(userId);
            if (user!=null){
                String name = user.getName();
                ordersDto.setUserName(name);
            }
            return ordersDto;
        }).collect(Collectors.toList());
        ordersDtoPage.setRecords(dtoList);
        return R.success(ordersDtoPage);
    }

    /**
     * 后端修改订单状态
     * @return
     */
    @PutMapping
    public R<String> update(@RequestBody Orders orders){
        log.info("当前订单编号状态{}{}",orders);
        ordersService.updateById(orders);
        return R.success("派送订单成功呢~");
    }

    //抽离的一个方法，通过订单id查询订单明细，得到一个订单明细的集合
    //这里之所以抽离出来，那是因为直接写在stream中会出现连续叠加.eq的SQL语句导致后面的数据查询不出来
    public List<OrderDetail> getOrderDetailListByOrderId(Long orderId){
        LambdaQueryWrapper<OrderDetail> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderDetail::getOrderId, orderId);
        List<OrderDetail> orderDetailList = orderDetailService.list(queryWrapper);
        return orderDetailList;
    }
    /**
     * 用户端展示自己的订单分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/userPage")
    public R<Page> page(int page, int pageSize){
        //分页构造器对象
        Page<Orders> pageInfo = new Page<>(page,pageSize);
        Page<OrdersDto> pageDto = new Page<>(page,pageSize);
        //构造条件查询对象
        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();
        //这里树直接把分页的全部结果查询出来，没有分页条件
        //添加排序条件，根据更新时间降序排列
        queryWrapper.orderByDesc(Orders::getOrderTime);
        ordersService.page(pageInfo,queryWrapper);
        //通过OrderId查询对应的OrderDetail
        LambdaQueryWrapper<OrderDetail> queryWrapper2 = new LambdaQueryWrapper<>();
        //对OrderDto进行需要的属性赋值
        List<Orders> records = pageInfo.getRecords();
        List<OrdersDto> orderDtoList = records.stream().map((item) ->{
            OrdersDto orderDto = new OrdersDto();
            //此时的orderDto对象里面orderDetails属性还是空 下面准备为它赋值
            Long orderId = item.getId();//获取订单id
            List<OrderDetail> orderDetailList = this.getOrderDetailListByOrderId(orderId);
            BeanUtils.copyProperties(item,orderDto);
            //对orderDto进行OrderDetails属性的赋值
            orderDto.setOrderDetails(orderDetailList);
            return orderDto;
        }).collect(Collectors.toList());
        //使用dto的分页有点难度.....需要重点掌握
        BeanUtils.copyProperties(pageInfo,pageDto,"records");
        pageDto.setRecords(orderDtoList);
        return R.success(pageDto);
    }

    /**
     * 用户订单完成后，用户点击再来一单
     * @return
     */
    @PostMapping(value = "/again")
    public R<String> again(@RequestBody Orders orders){
        log.info("当前菜品的id：{}",orders);
        Long id = orders.getId();
        //根据id查询到菜品信息
        LambdaQueryWrapper<OrderDetail> queryWrappers = new LambdaQueryWrapper<>();
        queryWrappers.eq(OrderDetail::getOrderId,id);
        List<OrderDetail> orderDetailList = orderDetailService.list(queryWrappers);
        //通过用户id把原来的购物车给清空
        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId,BaseContext.getCurrentId());
        shoppingCartService.remove(queryWrapper);
        //将菜品信息重新添加到购物车中
        //获取用户id
        Long userId = BaseContext.getCurrentId();
        List<ShoppingCart> shoppingCartList = orderDetailList.stream().map((item) -> {
            //把从order表中和order_details表中获取到的数据赋值给这个购物车对象
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.setUserId(userId);
            shoppingCart.setImage(item.getImage());
            Long dishId = item.getDishId();
            Long setmealId = item.getSetmealId();
            if (dishId != null) {
                //如果是菜品那就添加菜品的查询条件
                shoppingCart.setDishId(dishId);
            } else {
                //添加到购物车的是套餐
                shoppingCart.setSetmealId(setmealId);
            }
            shoppingCart.setName(item.getName());
            shoppingCart.setDishFlavor(item.getDishFlavor());
            shoppingCart.setNumber(item.getNumber());
            shoppingCart.setAmount(item.getAmount());
            shoppingCart.setCreateTime(LocalDateTime.now());
            return shoppingCart;
        }).collect(Collectors.toList());
        //把携带数据的购物车批量插入购物车表  这个批量保存的方法要使用熟练！！！
        shoppingCartService.saveBatch(shoppingCartList);
        return R.success("成功");
    }
}
