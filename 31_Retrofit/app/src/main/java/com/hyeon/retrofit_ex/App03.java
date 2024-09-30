package com.hyeon.retrofit_ex;

import java.util.List;

import com.hyeon.helpers.RetrofitHelper;
import com.hyeon.model.Student;
import com.hyeon.service.MySchoolService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App03 {
    public static void main(String[] args) {
        
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("http://localhost:3001");

        MySchoolService service = retrofit.create(MySchoolService.class);

        Call<List<Student>> call = service.getStudents();

        call.enqueue(new Callback<List<Student>>() {

            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                List<Student> list = response.body();
                for (Student d : list) {
                    System.out.println(d);
                }
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                System.out.println("[통신 에러 발생]");
                System.out.println(call.toString());
                t.printStackTrace();
            }
            
        });

        RetrofitHelper.getInstance().shutdown();
    }
}
