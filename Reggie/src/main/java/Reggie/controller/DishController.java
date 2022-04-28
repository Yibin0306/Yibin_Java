package Reggie.controller;

import Reggie.common.R;
import Reggie.dto.DishDto;
import Reggie.entity.Category;
import Reggie.entity.Dish;
import Reggie.service.CategoryService;
import Reggie.service.DishFlavorService;
import Reggie.service.DishService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    /**
     * 新增菜品
     * @param dishDto
     * @return
     */
    @PostMapping
    public R<String> sava(@RequestBody DishDto dishDto){
        log.info(dishDto.toString());
        dishService.savaWithFlavor(dishDto);
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
        //添加过滤条件
        queryWrapper.like(StringUtils.isNotEmpty(name),Dish::getName,name);
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
     * 编辑菜品
     * @param dishDto
     * @return
     */
    @PutMapping
    public R<String> upDate(@RequestBody DishDto dishDto){
        log.info(dishDto.toString());
        dishService.upDateWithFlavor(dishDto);
        return R.success("修改菜品成功呢~");
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
}
