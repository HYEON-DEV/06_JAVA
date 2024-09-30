package com.hyeon.model;

import java.util.List;

import lombok.Data;

// json은 그 자체가 java beans에 대응된다
// 중괄호 단위로 class를 만든다
// json 계층구조는 클래스의 계층구조다
@Data
public class Data05 {
    // rss는 밑의 27라인의 inner class의 객체가 된다 
    private Rss rss;
    // 생성자는 안 만들어도 된다
    // 멤버변수, getter, setter

    // inner class
    @Data
    public class Rss {
        // json(JavaScript)의 배열은 사이즈 제한X -> 대응되는 것은 Java에서 List !

        // json의 key와 멤벼변수 이름이 같아야 한다
        private List<Item> item;
        
        // class가 원소인 item 배열 
        // Item 클래스는  클래스를 담을 수 있는 List
       
        @Data
        public class Item {

            private String title;
            private String description;
            private String pubDate;
            
        }
    }
}
