package com.hyeon.services.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hyeon.exceptions.ServiceNoResultException;

import com.hyeon.models.Professor;
import com.hyeon.models.Student;
import com.hyeon.services.ProfessorService;




/**
 * 교수 관리 기능과 관련된 MyBatis Mapper를 간접적으로 호출하기 위한 기능 명세
 * 
 * (1) 모든 메서드를 재정의 한  직후 리턴값 먼저 정의
 */

public class ProfessorServiceImpl implements ProfessorService {

    /**
     * (2) MyBatis 의 Mapper 를 호출하기 위한 SqlSession 객체
     * => import org.apache.ibatis.session.SqlSession;
     */ 
    private SqlSession sqlSession; 

    /**(3) 생성자, SqlSession을 전달받는다 */
    public ProfessorServiceImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Professor addItem(Professor params) throws ServiceNoResultException, Exception {
        Professor result = null;

        /**
         * insert문 수행
         * 리턴되는 값은 저장된 데이터 수
         * 생성된 PK는 파라미터로 전달된 params 객체의 적절한 멤버변수에 설정된다
         * => getter를 통해 취득 가능
         */
        int rows = sqlSession.insert("ProfessorMapper.insert", params);

        if (rows == 0){
            throw new ServiceNoResultException("저장된 데이터가 없습니다");
        }
        
        // params에 설정된 PK 값을 활용해 저장된 내용을 그대로 조회한다
        result = sqlSession.selectOne("ProfessorMapper.selectItem", params);

        return result;
    }

    @Override
    public Professor editItem(Professor params) throws ServiceNoResultException, Exception {
        Professor result = null;

        int rows = sqlSession.update("ProfessorMapper.update", params);

        // 수정된 데이터가 없다면
        if (rows == 0){
            throw new ServiceNoResultException("수정된 데이터가 없습니다");
        }
        
        result = sqlSession.selectOne("ProfessorMapper.selectItem", params);

        return result;
    }

    @Override
    public int deleteItem(Professor params) throws ServiceNoResultException, Exception {
        int result = 0;

        // 교수 데이터 삭제를 위해 참조관계에 있는 자식 데이터를 순서대로 삭제
         
        Student student = new Student();
        student.setProfno(params.getProfno());
        sqlSession.delete("StudentMapper.deleteByProfno", student);
 
        result = sqlSession.delete("ProfessorMapper.delete", params);

        if (result==0) {
            throw new ServiceNoResultException("삭제된 데이터가 없습니다");
        }

        return result;
    }

    @Override
    public Professor getItem(Professor params) throws ServiceNoResultException, Exception {
        Professor result = null;

        result = sqlSession.selectOne("ProfessorMapper.selectItem", params);

        if (result==null) {
            throw new ServiceNoResultException("조회된 데이터가 없습니다");
        }

        return result;
    }

    @Override
    public List<Professor> getList(Professor params) throws ServiceNoResultException, Exception {
        return sqlSession.selectList("ProfessorMapper.selectList", params);
    }
    
}
