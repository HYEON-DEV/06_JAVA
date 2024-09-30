package com.hyeon.retrofit_ex;

import java.util.List;

import com.hyeon.helpers.RetrofitHelper;
import com.hyeon.model.Traffic_Acc;
import com.hyeon.service.MySchoolService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App07 {
    public static void main(String[] args) {
        
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("http://localhost:3001");

        MySchoolService service = retrofit.create(MySchoolService.class);

        Call<List<Traffic_Acc>> call = service.getTraffics();

        call.enqueue(new Callback<List<Traffic_Acc>>() {

            @SuppressWarnings("null")
            @Override
            public void onResponse(Call<List<Traffic_Acc>> call, Response<List<Traffic_Acc>> response) {
                List<Traffic_Acc> list = response.body();

                for(Traffic_Acc d : list) {
                    System.out.println("id: " + d.getId());
                    System.out.println("year: " + d.getYear());
                    System.out.println("month: " + d.getMonth());
                    System.out.println("accident: " + d.getAccident());
                    System.out.println("death: " + d.getDeath());
                    System.out.println("injury: " + d.getInjury());
                    System.out.println();
                }
            }

            @Override
            public void onFailure(Call<List<Traffic_Acc>> call, Throwable t) {
                System.out.println("[통신 에러 발생]");
                System.out.println(call.toString());
                t.printStackTrace();
            }
            
        });

        RetrofitHelper.getInstance().shutdown();
    }
}
