package com.chen.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class Course implements Serializable{
    private int c_id;
    private String courseName;
    private Teacher teacher;
}
