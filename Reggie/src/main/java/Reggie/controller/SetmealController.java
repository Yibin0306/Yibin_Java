package Reggie.controller;

import Reggie.common.R;
import Reggie.dto.SetmealDto;
import Reggie.entity.Category;
import Reggie.entity.Setmeal;
import Reggie.service.CategoryService;
import Reggie.service.SetmealDishService;
import Reggie.service.SetmealService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 套餐管理
 */
@Slf4j
@RestController
@RequestMapping(value = "/setmeal")
public class SetmealController {
    @Autowired
    private SetmealService setmealService;
    @Autowired
    private SetmealDishService setmealDishService;
    @Autowired
    private CategoryService categoryService;

    /**
     * 新增套餐
     * @param setmealDto
     * @return
     */
    @PostMapping
    public R<String> sava(@RequestBody SetmealDto setmealDto){
        log.info("打印{}",setmealDto);
        setmealService.savaWithDish(setmealDto);
        return R.success("套餐新增成功呢~");
    }

    /**
     * 套餐信息分页信息查询
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping(value = "/page")
    public R<Page> page(int page, int pageSize, String name){
        //构造分页构造器
        Page<Setmeal> pageInfo = new Page<>(page,pageSize);
        Page<SetmealDto> setmealDtoPage = new Page<>();
        //条件构造器
        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        //添加过滤条件，通过name进行like模糊查询
        queryWrapper.like(name!=null,Setmeal::getName,name);
        //添加一个排序条件
        queryWrapper.orderByDesc(Setmeal::getUpdateTime);
        //执行分页查询
        setmealService.page(pageInfo,queryWrapper);
        //对象拷贝
        BeanUtils.copyProperties(pageInfo,setmealDtoPage,"records");
        List<Setmeal> records = pageInfo.getRecords();
        List<SetmealDto> dtoList = records.stream().map((item) ->{
            SetmealDto setmealDto = new SetmealDto();
            BeanUtils.copyProperties(item,setmealDto);
            //分类ID
            Long categoryId = item.getCategoryId();
            //根据id查询分类对象
            Category category = categoryService.getById(categoryId);
            if (category!=null){
                //分类名称
                String categoryName = category.getName();
                setmealDto.setCategoryName(categoryName);
            }
            return setmealDto;
        }).collect(Collectors.toList());
        setmealDtoPage.setRecords(dtoList);
        return R.success(setmealDtoPage);
    }

    /**
     * 根据id查询套餐信息和对应的口味信息
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public R<SetmealDto> getById(@PathVariable Long id){
        SetmealDto byIdWithDish = setmealService.getByIdWithDish(id);
        return R.success(byIdWithDish);
    }

    /**
     * 修改套餐信息
     * @param setmealDto
     * @return
     */
    @PutMapping
    public R<String> upDate(@RequestBody SetmealDto setmealDto){
        log.info(setmealDto.toString());
        setmealService.upDateWithDish(setmealDto);
        return R.success("修改套餐信息成功呢~");
    }

    /**
     * 根据id 停售/起售 套餐
     * @param ids
     * @return
     */
    @PostMapping(value = "/status/{status}")
    public R<String> upDateStatus(@PathVariable Integer status,@RequestParam List<Long> ids){
        log.info("更改状态为{}",status);
        log.info("当前id为{}",ids);
        //LambdaUpdateWrapper作为修改的方法
        LambdaUpdateWrapper<Setmeal> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(Setmeal::getStatus,status);
        updateWrapper.in(Setmeal::getId,ids);
        setmealService.update(updateWrapper);
        return R.success("菜品销售状态更新成功呢~");
    }

    /**
     * 根据id删除套餐信息
     * @param ids
     * @return
     */
    @DeleteMapping
    public R<String> delete(@RequestParam List<Long> ids){
        log.info("当前id为{}",ids);
        //service进行了套餐关联等逻辑判断
        setmealService.removeWithDish(ids);
        return R.success("删除套餐信息成功呢~");
    }

    /**
     * 根据条件查询套餐数据
     * @param setmeal
     * @return
     */
    @GetMapping(value = "/list")
    public R<List<Setmeal>> list(Setmeal setmeal){
        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(setmeal.getCategoryId()!= null,Setmeal::getCategoryId,setmeal.getCategoryId());
        queryWrapper.eq(setmeal.getStatus()!= null,Setmeal::getStatus,setmeal.getStatus());
        queryWrapper.orderByDesc(Setmeal::getUpdateTime);
        List<Setmeal> list = setmealService.list(queryWrapper);
        return R.success(list);
    }
}
