package com.chen.po;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class User implements Serializable {

    private int u_id;
    private String userName;
    private String corp;
    private List<Course> courses;
}
