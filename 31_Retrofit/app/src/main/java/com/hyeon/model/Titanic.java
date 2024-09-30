package com.hyeon.model;

import lombok.Data;

@Data
public class Titanic {
    private int id;
    private boolean survived;
    private int pclass;
    private String name;
    private String sex;
    // 기본 데이터 타입은 원래 null 못 담는다 그래서 객체 타입으로 선언
    private String age;
    private int sibsp;
    private int parch;
    private String ticket;
    private double fare;
    private String cabin;
    private String embarked;

    public String getAge() {
        if ( this.age==null || this.age.isEmpty() ) {
            return "unknown";
        }
        else if ( this.age.contains(".") ) {
            double result = Double.parseDouble(this.age);
            return String.valueOf(result);
        } else {
            int result = Integer.parseInt(this.age);
            return String.valueOf(result);
        }
    }

    public String getCabin() {
        if ( this.cabin == null ){
            return "unknown";
        }
        return this.cabin;
    }

}
