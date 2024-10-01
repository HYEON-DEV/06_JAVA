package com.hyeon.service;

import java.util.List;

import com.hyeon.model.Department;

import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.Call;

public interface DepartmentService {
    public static final String BASE_URL = "http://localhost:3001";

    /**
     * 학과 정보 저장
     * @param dname - 학과이름
     * @param loc - 위치
     * @return Department 객체
     */
    @FormUrlEncoded     // POST, PUT, DELETE 방식 전송일 경우 명시
    @POST("/department")    // 데이터 저장 요청                 ** Create **
    Call<Department> addDepartment(@Field("dname") String dname, @Field("loc") String loc);

    /**
     * 학과 정보 조회
     * @param id - 학과번호
     * @return Department 객체
     */
    @GET("/department/{id}")        //  ** Read **
    Call<Department> getDepartment(@Path("id") int id);

    /**
     * 검색한 학과 조회
     * @param dname - 학과이름
     * @return Department List 객체
     */
    @GET("/department")         // ** Read **
    Call<List<Department>> listDepartment(@Query("dname_like") String dname);

    /**
     * 학과 정보 수정
     * @param id - 학과번호
     * @param dname - 학과이름
     * @param loc - 위치
     * @return Department 객체
     */
    @FormUrlEncoded
    @PUT("/department/{id}")        // ** Upadate **
    Call<Department> updateDepartment(@Path("id") int id, @Field("dname") String dname, @Field("loc") String loc);

    /**
     * 학과 정보 삭제
     * @param id - 학과번호
     * @return Department 객체
     */
    @DELETE("/department/{id}")         // ** Delete **
    Call<Department> deleDepartment(@Path("id") int id);

}
