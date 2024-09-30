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
    @GET("/department")
    Call<List<Department>> getDepartments();

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
