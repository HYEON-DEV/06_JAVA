package com.hyeon.model;

import java.util.List;

// json은 그 자체가 java beans에 대응된다
// 중괄호 단위로 class를 만든다
// json 계층구조는 클래스의 계층구조다
public class Data05 {
    // rss는 밑의 27라인의 inner class의 객체가 된다 
    private Rss rss;
    // 생성자는 안 만들어도 된다
    // 멤버변수, getter, setter

    public Rss getRss() {
        return rss;
    }

    public void setRss(Rss rss) {
        this.rss = rss;
    }

    @Override
    public String toString() {
        return "Data04 [rss=" + rss + "]";
    }

    // inner class
    public class Rss {
        // json(JavaScript)의 배열은 사이즈 제한X -> 대응되는 것은 Java에서 List !

        // json의 key와 멤벼변수 이름이 같아야 한다
        private List<Item> item;
        
        // class가 원소인 item 배열 
        // Item 클래스는  클래스를 담을 수 있는 List
        public List<Item> getItem() {
            return item;
        }
        
        public void setItem(List<Item> item) {
            this.item = item;
        }
        
        @Override
        public String toString() {
            return "Rss [item=" + item + "]";
        }

        public class Item {

            private String title;
            private String description;
            private String pubDate;
            
            public String getTitle() {
            return title;
            }
            
            public void setTitle(String title) {
            this.title = title;
            }
            
            public String getDescription() {
            return description;
            }
            
            public void setDescription(String description) {
            this.description = description;
            }
            
            public String getPubDate() {
            return pubDate;
            }
            
            public void setPubDate(String pubDate) {
            this.pubDate = pubDate;
            }

            @Override
            public String toString() {
                return "Item [title=" + title + ", description=" + description + ", pubDate=" + pubDate + "]";
            }
        }
    }
}
