package com.yb.service.impl;

import com.yb.dao.StuMapper;
import com.yb.entity.Student;
import com.yb.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jue-PC
 */
@Service
public class StuServiceImpl implements StuService {

    private final
    StuMapper stuMapper;

    @Autowired
    public StuServiceImpl(StuMapper stuMapper) {this.stuMapper = stuMapper;}

    @Override
    public void insert(Student student) {
        stuMapper.insert(student);
    }

    @Override
    public Student query(String stu_id) {
        return stuMapper.query(stu_id);
    }
}
