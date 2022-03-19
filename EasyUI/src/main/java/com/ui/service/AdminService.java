package com.ui.service;

import com.ui.entity.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> findAll(Integer beginIndex, Integer rows);

    Integer getTotal();

}
