package com.hyeon.model;

import lombok.Data;

@Data
public class Professor {
    private int id;
    private String name;
    private String userid;
    private String position;
    private int sal;
    private String hiredate;
    private Integer comm;
    private int deptno;
}
