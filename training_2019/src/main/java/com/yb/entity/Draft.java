package com.yb.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Jue-PC
 */
@Getter
@Setter
@ToString
public class Draft {
    private int    id;
    private String stu_id;
    private String name;
    private String department;
    private String classname;
    private String words;
    private String create_time;
    private String state;
}
