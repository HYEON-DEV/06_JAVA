package com.hyeon.professor_ex;

import java.util.Scanner;

import com.hyeon.helpers.RetrofitHelper;
import com.hyeon.model.Professor;
import com.hyeon.service.ProfessorService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App02 {
    public static void main(String[] args) {
        System.out.println("-- 조회할 교수 번호 --");

        Scanner scan = new Scanner(System.in);
        System.out.print("교수 번호: ");
        int id = scan.nextInt();
        scan.close();

        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit(ProfessorService.BASE_URL);

        ProfessorService service = retrofit.create(ProfessorService.class);
        Call<Professor> call = service.getProfessor(id);
        
        call.enqueue(new Callback<Professor>() {

            @Override
            public void onResponse(Call<Professor> call, Response<Professor> response) {
                if (response.isSuccessful()) {
                    Professor professor = response.body();
                    System.out.println("조회된 교수 정보: " + professor);
                } else {
                    System.out.println("조회 실패");
                }
            }

            @Override
            public void onFailure(Call<Professor> call, Throwable t) {
                System.out.println("서버 연결 실패: " + t.getMessage());
            }
            
        });

        RetrofitHelper.getInstance().shutdown();
    }
}
