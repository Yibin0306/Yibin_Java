package Reggie.controller;

import Reggie.common.BaseContext;
import Reggie.common.R;
import Reggie.dto.OrdersDto;
import Reggie.entity.OrderDetail;
import Reggie.entity.Orders;
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

import java.util.ArrayList;
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

    /**
     * 客户端查询历史订单
     * @return
     */
    @GetMapping(value = "/userPage")
    public R<Page> userPage(int page, int pageSize){
        //分页构造器对象
        Page<Orders> pageInfo = new Page<>(page,pageSize);
        Page<OrdersDto> pageDto = new Page<>(page,pageSize);
        //构造条件查询对象
        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();
        //这里树直接把分页的全部结果查询出来，没有分页条件
        //添加排序条件，根据更新时间降序排列
        queryWrapper.orderByDesc(Orders::getOrderTime);
        ordersService.page(pageInfo,queryWrapper);
        //对象的拷贝  注意这里要把分页数据的全集合records给忽略掉  把pageInfo中的数据复制给pageDto
        BeanUtils.copyProperties(pageInfo,pageDto,"records");
        //前端传给我们的数据太少了，所以都需要自己从用户id来查询
        Long userId = BaseContext.getCurrentId();
        LambdaQueryWrapper<Orders> queryWrapper2 = new LambdaQueryWrapper<>();
        //封装查询Orders表的条件
        queryWrapper2.eq(Orders::getUserId, userId);
        //通过用户id查询订单集合
        List<Orders> list = ordersService.list(queryWrapper2);
        //创建一个集合用来存放orders 的Id,为后面查询OrderDetail做准备
        List<Long> ordersIdList = new ArrayList<>();
        //通过循环拿到所有的ordersId 存在集合中
        for (Orders orders : list) {
            Long ordersId = orders.getId();
            ordersIdList.add(ordersId);
        }
        //通过OrderId查询对应的OrderDetail
        LambdaQueryWrapper<OrderDetail> queryWrapper3 = new LambdaQueryWrapper<>();
        //封装对OrderDetail的查询条件
        queryWrapper3.in(OrderDetail::getOrderId, ordersIdList);
        //查询到OrderDetail集合,里面有我们想要的数据 number  name....
        List<OrderDetail> orderDetailList = orderDetailService.list(queryWrapper3);
        //对OrderDto进行需要的属性赋值
        List<Orders> records = pageInfo.getRecords();
        List<OrdersDto> orderDtoList = records.stream().map((item) ->{
            OrdersDto orderDto = new OrdersDto();
            //此时的orderDto对象里面orderDetails属性还是空 下面准备为它赋值
            BeanUtils.copyProperties(item,orderDto);
            //对orderDto进行OrderDetails属性的赋值
            orderDto.setOrderDetails(orderDetailList);
            return orderDto;
        }).collect(Collectors.toList());
        //使用dto的分页有点难度.....需要重点掌握
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

//        Long id = orders.getId();
        //根据id查询到菜品信息
//        LambdaQueryWrapper<OrderDetail> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(OrderDetail::getOrderId,id);
//        OrderDetail orderDetail = orderDetailService.getById(queryWrapper);

//        log.info("当前菜品：{}",orderDetail);
        //将菜品信息重新添加到购物车中


        return null;
    }
}
