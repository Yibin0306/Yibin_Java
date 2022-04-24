package Reggie.controller;

import Reggie.common.R;
import Reggie.entity.Category;
import Reggie.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 分类管理
 */
@Slf4j
@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 新增分类
     * @param category
     * @return
     */
    @PostMapping
    public R<String> save(@RequestBody Category category){
        log.info("打印{}",category);
        categoryService.save(category);
        return R.success("添加分类成功呢~");
    }

    /**
     * 菜品分类的分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/page")
    public R<Page> page(int page,int pageSize){
        //分页构造器
        Page pageInfo = new Page(page, pageSize);
        //构造条件构造器
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        //添加排序条件，根据sort排序（菜品排序）
        queryWrapper.orderByAsc(Category::getSort);
        //调用service分页查询
        categoryService.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
    }

    /**
     * 根据id删除分类
     * @param ids
     * @return
     */
    @DeleteMapping
    public R<String> delete(Long ids){
        log.info("当前id为{}",ids);
        //service进行了菜品关联等逻辑判断
        categoryService.remove(ids);
        return R.success("删除分类成功呢~");
    }
}
