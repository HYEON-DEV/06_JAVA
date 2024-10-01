package com.hyeon.openapi_ex;

import java.util.List;
import java.util.Scanner;

import com.hyeon.helpers.RetrofitHelper;
import com.hyeon.model.KakaoImage;
import com.hyeon.model.KakaoImage.Documents;
import com.hyeon.service.KakaoSearchService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App02 {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.print("검색어 입력 : ");
        String keyword = scan.nextLine();
        scan.close();

        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("https://dapi.kakao.com");

        KakaoSearchService service = retrofit.create(KakaoSearchService.class);

        Call<KakaoImage> call = service.searchImage(keyword);

        call.enqueue(new Callback<KakaoImage>() {

            @Override
            public void onResponse(Call<KakaoImage> call, Response<KakaoImage> response) {
                KakaoImage kakaoImage = response.body();
                List<Documents> list = kakaoImage.getDocuments();

                for (Documents item : list) {
                    System.out.printf("컬렉션 : %s\n", item.getCollection());
                    System.out.printf("썸네일URL : %s\n", item.getThumbnailUrl());
                    System.out.printf("출처 : %s\n\n", item.getDisplaySitename());
                }
            }

            @Override
            public void onFailure(Call<KakaoImage> call, Throwable t) {
                System.out.println("[통신에러발생]");
                System.out.println(call.toString());
                t.printStackTrace();
            }
            
        });

        RetrofitHelper.getInstance().shutdown();
    }
    
}
