package Reggie.controller;

import Reggie.common.R;
import Reggie.entity.User;
import Reggie.service.UserService;
import Reggie.utils.ValidateCodeUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 用户登录
 */
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 发送手机验证码
     * @param user
     * @param session
     * @return
     */
    @PostMapping(value = "/sendMsg")
    public R<String> sendMsg(@RequestBody User user,HttpSession session){
        //获取手机号
        String phone = user.getPhone();
        if (StringUtils.isNotEmpty(phone)){
            //生成随机的四位验证码
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            log.info("验证码为：{}",code);
            //调用阿里云提供的短信API完成短信发送

            //需要将生成的验证码保存到session
            session.setAttribute(phone,code);
            return R.success("手机验证码发送成功~");
        }
        return R.success("手机验证码发送失败~");
    }

    /**
     * 移动端登陆业务
     * @param map
     * @return
     */
    @PostMapping(value = "/login")
    public R<User> login(@RequestBody Map map,HttpSession session){
        log.info(map.toString());
        //获取手机号
        String phone = map.get("phone").toString();
        //判断当前手机号对应的用户是否为新用户，如果是新用户就自动完成注册
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getPhone,phone);
        User user = userService.getOne(queryWrapper);
        if (user == null){
            user = new User();
            user.setPhone(phone);
            //状态默认为正常
            user.setStatus(1);
            userService.save(user);
        }
        session.setAttribute("user",user.getId());
        return R.success(user);


        /**
         * 下方是验证码判断逻辑代码
         */

//        //获取验证码
//        String code = map.get("code").toString();
//        //从session获取验证码
//        Object codeInSession = session.getAttribute(phone);
//        //进行验证码的对比（页面提交的验证码，和session中验证码对比）
//        if (codeInSession!=null&&codeInSession.equals(code)){
//            //如果能够比对成功，说明登陆成功
//            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
//            queryWrapper.eq(User::getPhone,phone);
//            User user = userService.getOne(queryWrapper);
//            if (user == null){
//                //判断当前手机号对应的用户是否为新用户，如果是新用户就自动完成注册
//                user = new User();
//                user.setPhone(phone);
//                //状态默认为正常
//                user.setStatus(1);
//                userService.save(user);
//            }
//            return R.success(user);
//        }
//        return R.error("登录失败呢~");
    }
}
