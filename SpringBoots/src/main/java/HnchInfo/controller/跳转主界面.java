package HnchInfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class 跳转主界面 {


    //主界面
    @RequestMapping("login")
    public String login(){
        return "河南测绘管理系统/login";
    }
}
