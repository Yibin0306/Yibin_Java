package SpringBoot整合Echarts.controller;

import java.util.List;

import SpringBoot整合Echarts.entity.BaseEntity;
import SpringBoot整合Echarts.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 统计分析
 * @author LJH
 *
 */
@RequestMapping("stat")
@Controller
public class StatController {
    @Autowired
    private StatService statService;
    /**
     * 跳转到用户地区统计页面
     */
    @RequestMapping("toUserAreaStat")
    public String toUserAreaStat() {
        return "SpringBoot整合Echarts/数据展示";
    }
    /**
     * 加载用户地区数据
     */
    @RequestMapping("loadUserAreaStatJosn")
    @ResponseBody
    public List<BaseEntity> loadUserAreaStatJosn(){
        return this.statService.loadUserAreaStatList();
    }
}

