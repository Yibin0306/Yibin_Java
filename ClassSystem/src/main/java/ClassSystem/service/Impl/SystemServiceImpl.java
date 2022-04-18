package ClassSystem.service.Impl;

import ClassSystem.entity.ClassList;
import ClassSystem.entity.PersonNum;
import ClassSystem.entity.ServicePost;
import ClassSystem.entity.User;
import ClassSystem.mapper.SystemMapper;
import ClassSystem.service.SystemService;
import ClassSystem.utility.RedisTemplateUtil;
import ClassSystem.utility.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SystemServiceImpl implements SystemService {
    @Autowired
    private SystemMapper systemMapper;
    @Autowired
    private ServicePost servicePost;
    @Autowired
    private RedisTemplateUtil redisTemplateUtil;

    //登录验证
    @Override
    public ServicePost login(User user) {
        User login = systemMapper.login(user);
        if (login!=null){
            long CurrentTime = System.currentTimeMillis();
            String token = login.getUsername()+CurrentTime;
            login.setToken(token);
            redisTemplateUtil.setValue("token",token);
            return servicePost.CreateTrueData(login);
        }else{
            return ServicePost.CreateErrorCodMsg("密码或账号错误呢~");
        }
    }

    //身份验证
    @Override
    public ServicePost isSign() {
        //session中获取token
        String token1 = UserRequest.getCurrentToken("token");
        //redis中获取token
        final String token2 = redisTemplateUtil.getValue("token");
        //判断token是否为空&&相同
        if (token1!=null&&token1.equals(token2)) {
            return ServicePost.CreateTrueCodMsg("身份验证成功");
        }
        return ServicePost.CreateErrorToken("身份验证失败");
    }

    //获取平台数据
    @Override
    public ServicePost PersonNum(PersonNum personNum) {
        PersonNum personNums = systemMapper.PersonNum(personNum);
        personNum.setTeacherNum(personNums.getTeacherNum());
        personNum.setStudentNum(personNums.getStudentNum());
        personNum.setNotice("我是平台公告！");
        return servicePost.CreateTrueData(personNum);
    }

    //获取班级列表
    @Override
    public ServicePost ClassList(ClassList classList) {
        int total = systemMapper.ClassTotalCount();
        List<ClassList> classLists = systemMapper.ClassList(classList);
        return servicePost.CreateTrueList(classLists,total);
    }

}
