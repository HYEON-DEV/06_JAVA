package com.hyeon.retrofit_ex;

import java.util.List;

import com.hyeon.helpers.RetrofitHelper;
import com.hyeon.model.Titanic;
import com.hyeon.service.MySchoolService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App05 {
    public static void main(String[] args) {
        
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("http://localhost:3001");

         MySchoolService service = retrofit.create(MySchoolService.class);

        Call<List<Titanic>> call = service.getTitanics();

        call.enqueue(new Callback<List<Titanic>>() {

            @SuppressWarnings("null")
            @Override
            public void onResponse(Call<List<Titanic>> call, Response<List<Titanic>> response) {
                List<Titanic> list = response.body();
                
                for ( Titanic d : list ) {
                    System.out.println("id: " + d.getId());
                    System.out.println("survived: " + d.isSurvived());
                    System.out.println("name: " + d.getName());
                    System.out.println("sex: " + d.getSex());
                    System.out.println("age: " + d.getAge());
                    System.out.println("sibsp: " + d.getSibsp());
                    System.out.println("parch: " + d.getParch());
                    System.out.println("ticket: " + d.getTicket());
                    System.out.println("fare: " + d.getFare());
                    System.out.println("cabin: " + d.getCabin());
                    System.out.println("embarked: " + d.getEmbarked());
                    System.out.println();
                }
            }

            @Override
            public void onFailure(Call<List<Titanic>> call, Throwable t) {
                System.out.println("[통신 에러 발생]");
                System.out.println(call.toString());
                t.printStackTrace();
            }
            
        });
    }
}
