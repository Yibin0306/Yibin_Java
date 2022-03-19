package springboot之web开发.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//RestController  Controller+ResponseBody

@RestController
@RequestMapping(value = "My")
public class Mycontroller {
    @GetMapping(value = "hello")
    public String hello(){
        //业务逻辑调用
        return "hello Springboot";
    }

    @GetMapping(value = "login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","Yibin0306");
        modelAndView.setViewName("Boot增删改查/login");
        return modelAndView;
    }
}
