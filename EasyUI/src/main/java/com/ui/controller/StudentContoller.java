package com.ui.controller;

import com.ui.entity.Student;
import com.ui.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("StudentContoller")
public class StudentContoller {
    @Autowired
    public StudentService studentService;

    @RequestMapping("findAll")
    public Map<String, Object> findAll(Integer page,Integer rows){
        Integer total = studentService.getTotal();
        List<Student> student = studentService.findStudent((page - 1) * rows, rows);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("total",total);
        hashMap.put("rows",student);
        return hashMap;
    }

}
