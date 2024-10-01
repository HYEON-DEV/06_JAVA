package com.hyeon.professor_ex;

import java.util.List;
import java.util.Scanner;

import com.hyeon.helpers.RetrofitHelper;
import com.hyeon.model.Professor;
import com.hyeon.service.ProfessorService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App03 {
    public static void main(String[] args) {
        System.out.println("-- 교수 검색 --");

        Scanner scan = new Scanner(System.in);
        System.out.print("교수 직책: ");
        String position = scan.nextLine();
        scan.close();

        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit(ProfessorService.BASE_URL);

        ProfessorService service = retrofit.create(ProfessorService.class);
        Call<List<Professor>> call = service.listProfessor(position);
        
        call.enqueue(new Callback<List<Professor>>() {

            @Override
            public void onResponse(Call<List<Professor>> call, Response<List<Professor>> response) {
                if (response.isSuccessful()) {
                    List<Professor> p = response.body();

                    for(Professor item : p) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("조회 실패");
                }
            }

            @Override
            public void onFailure(Call<List<Professor>> call, Throwable t) {
                System.out.println("서버 연결 실패: " + t.getMessage());
            }
            
        });

        RetrofitHelper.getInstance().shutdown();
    }
}
