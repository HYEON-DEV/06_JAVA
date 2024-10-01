package com.hyeon.crud_ex;

import java.util.List;
import java.util.Scanner;

import com.hyeon.helpers.RetrofitHelper;
import com.hyeon.model.Department;
import com.hyeon.service.DepartmentService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App03 {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.print("검색할 학과 이름 : ");
        String keyword = scan.nextLine();
        scan.close();

        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit(DepartmentService.BASE_URL);

        DepartmentService service = retrofit.create(DepartmentService.class);
        Call<List<Department>> call = service.listDepartment(keyword);

        call.enqueue(new Callback<List<Department>>() {

            @SuppressWarnings("null")
            @Override
            public void onResponse(Call<List<Department>> call, Response<List<Department>> response) {
                if(response.isSuccessful()){
                    List<Department> department = response.body();
                    
                    for ( Department item : department ) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("조회 실패");
                }
            }

            @Override
            public void onFailure(Call<List<Department>> call, Throwable t) {
                System.out.println("서버 연결 실패: " + t.getMessage());
            }
            
        });

        RetrofitHelper.getInstance().shutdown();
    }
}
