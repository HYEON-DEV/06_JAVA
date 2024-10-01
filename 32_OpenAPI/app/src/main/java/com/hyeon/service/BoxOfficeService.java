package com.hyeon.service;

import com.hyeon.model.BoxOffice;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BoxOfficeService {
    String apiKey = "0020fe39e18a044b567bf2ceb1b1af63";
    
    /**
     * 영화진흥위원회 일별 박스오피스 API 호출
     * @param targetDt - 조회하고자 하는 날짜
     * @return BoxOffice 객체
     * //@see BoxOfficeService
     */
    @GET("/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key="+apiKey)
    Call<BoxOffice> getBoxOffice(@Query("targetDt") String targetDt);
}
