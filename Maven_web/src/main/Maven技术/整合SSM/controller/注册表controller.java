package 整合SSM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import 工具.RandomValidateCode;
import 整合SSM.entity.注册表;
import 整合SSM.service.注册表service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("controller")
public class 注册表controller {
    @Autowired
    public 注册表service 注册表service;
    @RequestMapping("regist")
    /**
     * 把返回值编程json(jackson)字符串
     * xxx.json
     * xxs.txt
     * xxx.mp3
     */
    @ResponseBody
    public String regist(注册表 注册表){
        Integer i = 注册表service.add(注册表);
        if(i>0){
            return "true";
        }else{
            return "false";
        }
    }
    @RequestMapping("checkName")
    @ResponseBody
    public String checkName(String uname){
        Integer integer = 注册表service.checkName(uname);
        if(integer>0){
            return "false";
        }else{
            return "true";
        }
    }
    @RequestMapping("login")
    @ResponseBody
    //?name=tom
    public String login(注册表 注册表){
        整合SSM.entity.注册表 login = 注册表service.login(注册表);
        if(login==null){
            return "false";
        }else{
            return "true";
        }
    }

    @RequestMapping("checkVerify")
    @ResponseBody
    public String YZ(String code , HttpSession session){
        String attribute =(String) session.getAttribute("randomcode_key");
        if (code.equals(attribute)){
            return "ture";
        }
        return "false";
    }

    /**
     * 获取生成验证码显示到 UI 界面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("checkCode")
    public void checkCode(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");
        //设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        RandomValidateCode randomValidateCode = new RandomValidateCode();
        try {
            randomValidateCode.getRandcode(request, response);//输出图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
