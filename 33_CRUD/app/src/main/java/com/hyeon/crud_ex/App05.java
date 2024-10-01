package com.hyeon.crud_ex;

import java.util.Scanner;

import com.hyeon.helpers.RetrofitHelper;
import com.hyeon.model.Department;
import com.hyeon.service.DepartmentService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class App05 {
    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        System.out.print("삭제할 학과 번호 : ");
        int id = scan.nextInt();
        scan.close();

        Retrofit retrofit = RetrofitHelper.getInstance().getRetrofit(DepartmentService.BASE_URL);

        DepartmentService service = retrofit.create(DepartmentService.class);
        Call<Department> call = service.deleDepartment(id);

        call.enqueue(new Callback<Department>() {

            @Override
            public void onResponse(Call<Department> call, Response<Department> response) {
                if(response.isSuccessful()){
                    System.out.println("삭제성공");
                } else {
                    System.out.println("삭제실패");
                }
            }

            @Override
            public void onFailure(Call<Department> call, Throwable t) {
                System.out.println("서버 연결 실패: " + t.getMessage());
            }
            
        });

        RetrofitHelper.getInstance().shutdown();
 }   
}
