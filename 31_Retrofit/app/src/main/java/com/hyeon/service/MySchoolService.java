package com.hyeon.service;

import java.util.List;

import com.hyeon.model.Department;
import com.hyeon.model.News;
import com.hyeon.model.Professor;
import com.hyeon.model.Student;
import com.hyeon.model.Titanic;
import com.hyeon.model.Traffic_Acc;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MySchoolService {
    @GET("/department")     //  => import retrofit2.http.GET;
    Call<List<Department>> getDepartments();    //  => import retrofit2.Call;

    @GET("/professor")
    Call<List<Professor>> getProfessors();

    @GET("/student")
    Call<List<Student>> getStudents();

    @GET("/news")
    Call<List<News>> getNews();

    @GET("/titanic")
    Call<List<Titanic>> getTitanics();

    @GET("/traffic_acc")
    Call<List<Traffic_Acc>> getTraffics();
}

// Retrofit은 백엔드에서 JSON을 받아오면 전부 Call 이라는 클래스로 받는다
// model 객체는 단일객체만 담음
// List 형태의 백엔드를 보관하겠다 => Call <List<Department>>  =>  import retrofit2.Call / import com.hyeon.model.Department;
// Retrofit 이 제공해주는 annotation @GET  =>  baseUrl + @GET() 겟 안의 단어를 조합해서 주소 만듬