package com.ui.dao;

import com.ui.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    List<Student> findStudent(@Param("beginIndex") Integer beginIndex, @Param("rows") Integer rows);
    Integer getTotal();
}
