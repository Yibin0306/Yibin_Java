package com.ui.dao;

import com.ui.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDao {
    List<Admin> findAll(@Param("beginIndex") Integer beginIndex, @Param("rows") Integer rows);

    Integer getTotal();
}
