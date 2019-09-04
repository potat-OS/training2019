package com.yb.service;

import com.yb.entity.Student;

/**
 * @author Jue-PC
 */
public interface StuService {
    /**
     * @param student
     */
    void insert(Student student);

    /**
     * @param stu_id
     */
    Student query(String stu_id);
}
