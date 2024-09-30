package com.hyeon.retrofit_ex;

import java.util.List;

import com.hyeon.helpers.RetrofitHelper;
import com.hyeon.model.News;
import com.hyeon.service.MySchoolService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App04 {
    public static void main(String[] args) {
        
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("http://localhost:3001");

         MySchoolService service = retrofit.create(MySchoolService.class);

        Call<List<News>> call = service.getNews();

        call.enqueue(new Callback<List<News>>() {

            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                List<News> list = response.body();
                for ( News d : list ) {
                    System.out.println("author: " + d.getAuthor());
                    System.out.println("title: " + d.getTitle());
                    System.out.println("description: " + d.getDescription());
                    System.out.println("url: " + d.getUrl());
                    System.out.println("image: " + d.getImage());
                    System.out.println("datetime: " + d.getDatetime());
                    System.out.println();
                }
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                System.out.println("[통신 에러 발생]");
                System.out.println(call.toString());
                t.printStackTrace();
            }
            
        });

        RetrofitHelper.getInstance().shutdown();
    }
}
