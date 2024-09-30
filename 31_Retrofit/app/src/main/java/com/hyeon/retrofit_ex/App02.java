
package com.hyeon.retrofit_ex;

import java.util.List;

import com.hyeon.helpers.RetrofitHelper;
import com.hyeon.model.Professor;
import com.hyeon.service.MySchoolService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App02 {
    public static void main(String[] args) {
        
        // 1) 접속 초기화
        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit("http://localhost:3001");     

        // 2) 비즈니스 로직 처리
        // Retrofit 객체를 통해 서비스 객체 생성
        MySchoolService service = retrofit.create(MySchoolService.class);

        // 메서드를 호출해서 call 객체 리턴받는다
        Call<List<Professor>> call = service.getProfessors();

        // HTTP 통신으로 JSON 데이터 요청하기
        call.enqueue( new Callback<List<Professor>>() {

            @SuppressWarnings("null")
            @Override
            public void onResponse(Call<List<Professor>> call, Response<List<Professor>> response) {
                List<Professor> list = response.body();
                for (Professor d : list) {
                    System.out.println(d);
                }
            }

            @Override
            public void onFailure(Call<List<Professor>> call, Throwable t) {
                System.out.println("[통신 에러 발생]");
                System.out.println(call.toString());
                t.printStackTrace();
            }

        });

        // 통신 종료
        RetrofitHelper.getInstance().shutdown();
    }
}
