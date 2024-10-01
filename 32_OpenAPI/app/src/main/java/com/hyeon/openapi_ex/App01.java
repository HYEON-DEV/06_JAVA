package com.hyeon.openapi_ex;

import java.util.List;
import java.util.Scanner;

import com.hyeon.helpers.RetrofitHelper;
import com.hyeon.model.BoxOffice;
import com.hyeon.model.BoxOffice.BoxOfficeResult.DailyBoxOfficeList;
import com.hyeon.service.BoxOfficeService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App01 {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.print("조회할 날짜 입력 (yyyymmdd) : ");
        String targetDt = scan.nextLine();
        scan.close();

        // retrofit 객체 생성
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("http://www.kobis.or.kr");

        // retrofit에게 인터페이스 연결
        // 통신 객체로부터 Service에 대한 구현체 자동 생성
        BoxOfficeService service = retrofit.create(BoxOfficeService.class);

        // 메서드 호출해서 call 객체 리턴받기
        Call<BoxOffice> call = service.getBoxOffice(targetDt);

        // HTTP 통신으로 JSON 데이터 요청하기
        call.enqueue(new Callback<BoxOffice>(){

            @Override
            public void onResponse(Call<BoxOffice> call, Response<BoxOffice> response) {
                BoxOffice boxOffice = response.body();
                List<DailyBoxOfficeList> list = boxOffice.getBoxOfficeResult().getDailyBoxOfficeList();

                for (DailyBoxOfficeList item : list) {
                    System.out.printf("제목 : %s\n", item.getMovieNm());
                    System.out.printf("관람객수 : %s\n\n", item.getAudiCnt());
                }
            }

            @Override
            public void onFailure(Call<BoxOffice> call, Throwable t) {
                System.out.println("[통신 에러 발생]");
                System.out.println(call.toString());
                t.printStackTrace();
            }
        });

        RetrofitHelper.getInstance().shutdown();
    }
}
