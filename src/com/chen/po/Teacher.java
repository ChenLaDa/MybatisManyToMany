package com.chen.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class Teacher implements Serializable {
    private int t_id;
    private String teacherName;
}
