package com.ui.service;

import com.ui.dao.StudentDao;
import com.ui.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{
    @Autowired
    public StudentDao studentDao;

    @Override
    public List<Student> findStudent(Integer beginIndex, Integer rows) {
        return studentDao.findStudent(beginIndex,rows);
    }

    @Override
    public Integer getTotal() {
        return studentDao.getTotal();
    }
}
