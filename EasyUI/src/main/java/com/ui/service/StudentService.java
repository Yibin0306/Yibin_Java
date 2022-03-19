package com.ui.service;

import com.ui.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    List<Student> findStudent(Integer beginIndex, Integer rows);
    Integer getTotal();
}
