package com.ui.service;

import com.ui.dao.AdminDao;
import com.ui.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public List<Admin> findAll(Integer beginIndex, Integer rows) {
        return adminDao.findAll(beginIndex,rows) ;
    }

    @Override
    public Integer getTotal() {
        return adminDao.getTotal();
    }
}
