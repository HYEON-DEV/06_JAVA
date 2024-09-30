package com.hyeon.helpers;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private static RetrofitHelper current;

    private OkHttpClient httpClient;

    public static RetrofitHelper getInstance() {
        if (current == null) {
            current = new RetrofitHelper();
        }

        return current;
    }

    public static void freeInstance() {
        current = null;
    }

    private RetrofitHelper() {
        super();
    }

    /**
     * Retrofit 객체를 생성하고 기본 설정들을 적용한 후 리턴한다
     * @param baseUrl - 접근하고자 하는 API 기본주소 (ex: http://도메인)
     * @return Retrofit 객체
     */
    public Retrofit getRetrofit(String baseUrl) {
        // 통신 객체를 생성하기 위한 Builder 객체 정의  =>  import okhttp3.OkHttpClient;
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

        // Builder를 통해 통신객체 생성  =>  import okhttp3.OkHttpClient;
        httpClient = httpClientBuilder.build();

        // retrofit : 백엔드에서 json 을 받아오는 기능
        // retrofit을 생성하는 기능을 수행하는 객체 정의
        Retrofit.Builder builder = new Retrofit.Builder();

        // 기본 주소 지정  ex) http://localhost:3001/ 을 baseUrl 이라 한다
        // Retrofit builder에 기본주소 연결
        builder.baseUrl(baseUrl);

        // 통신 결과를 Gson 객체를 통해 처리하도록 Gson 연결 => JSON 파싱 자동화
        builder.addConverterFactory(GsonConverterFactory.create());

        // Retrofit builder에 통신객체 연결
        builder.client(httpClient);

        // 모든 설정이 반영된 retrofit 객체 생성  =>  import retrofit2.Retrofit;
        Retrofit retrofit = builder.build();
        return retrofit;
    }

    /**
     * 통신 객체를 종료한다
     */
    public void shutdown() {
        if (httpClient != null) {
            httpClient.dispatcher().executorService().shutdown();
        }
    }

}