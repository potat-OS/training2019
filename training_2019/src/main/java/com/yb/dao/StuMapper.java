package com.yb.dao;

import com.yb.entity.Student;
import org.springframework.stereotype.Repository;

/**
 * @author Jue-PC
 */
@Repository
public interface StuMapper {

    /**
     * @param student
     */
    void insert(Student student);

    /**
     * @param stu_id
     */
    Student query(String stu_id);
}
