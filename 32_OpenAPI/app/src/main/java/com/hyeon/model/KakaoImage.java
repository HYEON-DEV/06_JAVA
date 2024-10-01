package com.hyeon.model;


import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class KakaoImage {
    @SerializedName("meta")     
    private Meta meta;
    
    @SerializedName("documents")
    private List<Documents> documents;

    @Data
    public class Meta {
        @SerializedName("total_count")        //  JSON 키 이름
        private int totalCount;               //  Java 필드 이름

        @SerializedName("pageable_count")
        private int pageableCount;

        @SerializedName("is_end")
        private boolean isEnd;
    }

    @Data
    public class Documents {
        @SerializedName("collection")
        private String collection;

        @SerializedName("thumbnail_url")
        private String thumbnailUrl;

        @SerializedName("display_sitename")
        private String displaySitename;
    }
}
