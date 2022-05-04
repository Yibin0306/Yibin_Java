package Reggie.controller;

import Reggie.common.R;
import Reggie.dto.OrdersDto;
import Reggie.dto.SetmealDto;
import Reggie.entity.OrderDetail;
import Reggie.entity.Orders;
import Reggie.entity.Setmeal;
import Reggie.entity.User;
import Reggie.service.OrderDetailService;
import Reggie.service.OrdersService;
import Reggie.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import javafx.scene.chart.PieChart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * 查询历史订单
     * @return
     */
    @GetMapping(value = "/userPage")
    public R<Page> userPage(int page, int pageSize){
        //构造分页构造器
        Page<Orders> pageInfo = new Page<>(page,pageSize);
        Page<OrdersDto> ordersDtoPage = new Page<>();
        //条件构造器
        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();
        //添加一个排序条件
        queryWrapper.orderByDesc(Orders::getOrderTime);
        //执行分页查询
        ordersService.page(pageInfo,queryWrapper);
        //对象拷贝
//        BeanUtils.copyProperties(pageInfo,ordersDtoPage,"records");
//        List<Orders> records = pageInfo.getRecords();
//        List<OrdersDto> dtoList = records.stream().map((item) ->{
//            OrdersDto ordersDto = new OrdersDto();
//            BeanUtils.copyProperties(item,ordersDto);
//            //订单号
//            String number = item.getNumber();
//            //根据id查询订单信息
//            OrderDetail orderDetail = orderDetailService.getById(number);
//            if (orderDetail!=null){
//                orderDetail.getName();
//                orderDetail.getNumber();
//            }
//            return ordersDto;
//        }).collect(Collectors.toList());
//        ordersDtoPage.setRecords(dtoList);

        return R.success(pageInfo);
    }
}
