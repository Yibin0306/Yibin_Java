package springboot之数据存储.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springboot之数据存储.Utils.POIUtils;
import springboot之数据存储.entity.Person;
import springboot之数据存储.service.PersonService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("Person")
public class PersonController {

    @Autowired
    PersonService personService;

    //查询所有
    @RequestMapping("/findAll")
    public String index(HttpServletRequest request) {
        List<Person> list = personService.getAll();
        request.setAttribute("list",list);
        return "Boot增删改查/查询所有";
    }

    //添加操作
    @RequestMapping("/newp")
    public String index(Person p){
        personService.newp(p);
        return "forward:/Person/findAll";
    }

    //根据id跳转修改页面
    @RequestMapping("/findOne")
    public String TZ(Integer id,HttpServletRequest request){
        List<Person> one = personService.findOne(id);
        request.setAttribute("listPerson",one);
        return "Boot增删改查/修改操作";
    }

    //修改操作
    @RequestMapping("/update")
    public String update(Person p){
        personService.update(p);
        return "forward:/Person/findAll";
    }

    // 删除操作
    @RequestMapping("/delete")
    public String index(Integer id){
        personService.delete(id);
        return "forward:/Person/findAll";
    }

    //下载客户信息
    @GetMapping("/export")
    public ResponseEntity<byte[]> excelExport(){
        List<Person> list=personService.getAll();
        return POIUtils.ExportExcel(list);
    }

}