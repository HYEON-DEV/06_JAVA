package com.hyeon.service;

import com.hyeon.model.KakaoImage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface KakaoSearchService {
    String apiKey = "91480ede95433d75873494d4be45e74e";

    /**
     * @Headers({
     *      "Accept: application/json",
     *      "User-agent: Your-App-Name",
     *      "Cache-Control: max-age=640000"
     * }) 
     */

    /**
     * 카카오 이미지 검색 API 호출
     * @param query - 검색어
     * @return - KakaoImage 객체
     * //@see - KakaoSearchService
     */
    @Headers({"Authorization: KakaoAK "+apiKey})
    @GET("/v2/search/image")
    Call<KakaoImage> searchImage(@Query("query") String query);
}
