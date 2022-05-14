package Reggie.controller;

import Reggie.common.R;
import Reggie.dto.DishDto;
import Reggie.entity.Category;
import Reggie.entity.Dish;
import Reggie.entity.DishFlavor;
import Reggie.service.CategoryService;
import Reggie.service.DishFlavorService;
import Reggie.service.DishService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 菜品管理
 */
@Slf4j
@RestController
@RequestMapping(value = "/dish")
public class DishController {
    @Autowired
    private DishService dishService;
    @Autowired
    private DishFlavorService dishFlavorService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 新增菜品
     * @param dishDto
     * @return
     */
    @PostMapping
    public R<String> sava(@RequestBody DishDto dishDto){
        log.info(dishDto.toString());
        //service层进行了逻辑处理
        dishService.savaWithFlavor(dishDto);
        //清理某个分类菜品缓存
        String key = "dish_" + dishDto.getCategoryId();
        redisTemplate.delete(key);
        return R.success("新增菜品成功呢~");
    }

    /**
     * 菜品信息分页信息查询
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping(value = "/page")
    public R<Page> page(int page,int pageSize,String name){
        //构造分页构造器
        Page<Dish> pageInfo = new Page<>(page,pageSize);
        Page<DishDto> dishDtoPage = new Page<>();
        //条件构造器
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        //添加过滤条件，通过name进行like模糊查询
        queryWrapper.like(name!=null,Dish::getName,name);
        //添加一个排序条件
        queryWrapper.orderByDesc(Dish::getUpdateTime);
        //执行分页查询
        dishService.page(pageInfo,queryWrapper);
        //对象拷贝
        BeanUtils.copyProperties(pageInfo,dishDtoPage,"records");
        List<Dish> records = pageInfo.getRecords();
        List<DishDto> dtoList = records.stream().map((item) ->{
            DishDto dishDto = new DishDto();
            BeanUtils.copyProperties(item,dishDto);
            //分类ID
            Long categoryId = item.getCategoryId();
            //根据id查询分类对象
            Category category = categoryService.getById(categoryId);
            if (category!=null){
                String categoryName = category.getName();
                dishDto.setCategoryName(categoryName);
            }
            return dishDto;
        }).collect(Collectors.toList());
        dishDtoPage.setRecords(dtoList);
        return R.success(dishDtoPage);
    }

    /**
     * 根据id查询菜品信息和对应的口味信息
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public R<DishDto> getById(@PathVariable Long id){
        DishDto dishDto = dishService.getByIdWithFlavor(id);
        return R.success(dishDto);
    }

    /**
     * 修改菜品信息
     * @param dishDto
     * @return
     */
    @PutMapping
    public R<String> upDate(@RequestBody DishDto dishDto){
        log.info(dishDto.toString());
        dishService.upDateWithFlavor(dishDto);
        //清理某个分类菜品缓存
        String key = "dish_" + dishDto.getCategoryId();
        redisTemplate.delete(key);
        return R.success("修改菜品信息成功呢~");
    }

    /**
     * 根据id 停售/起售 菜品
     * @param ids
     * @return
     */
    @PostMapping(value = "/status/{status}")
    public R<String> upDateStatus(@PathVariable Integer status,@RequestParam List<Long> ids){
        log.info("更改状态为{}",status);
        log.info("当前id为{}",ids);
        //LambdaUpdateWrapper作为修改的方法
        LambdaUpdateWrapper<Dish> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(Dish::getStatus,status);
        updateWrapper.in(Dish::getId,ids);
        dishService.update(updateWrapper);
        //清理菜品缓存
        Set keys = redisTemplate.keys("dish_*");
        redisTemplate.delete(keys);
        return R.success("菜品销售状态更新成功呢~");
    }

    /**
     * 根据id删除菜品信息
     * @param ids
     * @return
     */
    @DeleteMapping
    public R<String> delete(@RequestParam List<Long> ids){
        log.info("当前id为{}",ids);
        //service进行了菜品关联等逻辑判断
        dishService.removeWithFlavor(ids);
        return R.success("删除菜品信息成功呢~");
    }

    /**
     * 根据条件查询菜品分类信息
     * @param dish
     * @return
     */
    @GetMapping("/list")
    public R<List<DishDto>> list(Dish dish){
        //自定义一个动态的key
        List<DishDto> dishDtoList = null;
        String key = "dish_" + dish.getCategoryId();
        //先从redis中获取缓存数据
        dishDtoList = (List<DishDto>) redisTemplate.opsForValue().get(key);
        if (dishDtoList!=null){
            //如果存在，直接返回，无需查询数据库
            return R.success(dishDtoList);
        }
        //条件构造器
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        //添加条件
        queryWrapper.eq(dish.getCategoryId()!=null,Dish::getCategoryId,dish.getCategoryId());
        //查询状态为起售状态菜品
        queryWrapper.eq(Dish::getStatus,1);
        //添加排序条件
        queryWrapper.orderByAsc(Dish::getSort).orderByDesc(Dish::getUpdateTime);
        List<Dish> list = dishService.list(queryWrapper);
        dishDtoList = list.stream().map((item) ->{
            DishDto dishDto = new DishDto();
            BeanUtils.copyProperties(item,dishDto);
            //分类ID
            Long categoryId = item.getCategoryId();
            //根据id查询分类对象
            Category category = categoryService.getById(categoryId);
            if (category!=null){
                String categoryName = category.getName();
                dishDto.setCategoryName(categoryName);
            }
            //当前菜品的id
            Long dishId = item.getId();
            LambdaQueryWrapper<DishFlavor> dishFlavorLambdaQueryWrapper = new LambdaQueryWrapper<>();
            dishFlavorLambdaQueryWrapper.eq(DishFlavor::getDishId,dishId);
            List<DishFlavor> dishFlavorList = dishFlavorService.list(dishFlavorLambdaQueryWrapper);
            dishDto.setFlavors(dishFlavorList);
            return dishDto;
        }).collect(Collectors.toList());
        //如果不存在，需要查询数据库，将查询到的菜品数据缓存到redis
        redisTemplate.opsForValue().set(key,dishDtoList,30,TimeUnit.MINUTES);
        return R.success(dishDtoList);
    }
}
