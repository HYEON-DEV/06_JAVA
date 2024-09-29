package com.hyeon.gson_ex;

import com.google.gson.Gson;
import com.hyeon.helpers.FileHelper;
import com.hyeon.model.Data01;

public class App01 {
    public static void main(String[] args) {
        
        String json = null;

        try {
            json = FileHelper.getInstance().readString("res/01.json");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        //System.out.println(json);


        // JSON 데이터를 Java 객체로 변환한다
        Gson gson = new Gson();

        // 읽어온 JSON 문자열을 Data01 클래스의 객체로 변환한다
        // Data01 클래스는 JSON 데이터의 구조에 맞춰 정의되어 있어야 한다
        /*
         * Data01.class의 의미:
         * Data01: 이 클래스는 JSON 데이터를 매핑할 Java 객체를 정의한 클래스
         * .class: 이는 Java에서 클래스 타입을 나타내는 특별한 키워드
         */
        Data01 data = gson.fromJson(json, Data01.class);

        // 변환된 Data01 객체에서 getMessage() 메소드를 호출하여 메시지를 출력한다
        // 이 메소드는 Data01 클래스 내에 정의된 메소드로, JSON의 특정 필드를 가져오는 역할을 한다
        System.out.println(data.getMessage());

        // JSON의 필드에 대한 getter 메소드가 포함되어 있어야 한다
    }
}
