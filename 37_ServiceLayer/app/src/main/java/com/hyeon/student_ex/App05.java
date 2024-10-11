package com.hyeon.student_ex;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hyeon.MyBatisConnectionFactory;
import com.hyeon.exceptions.ServiceNoResultException;
import com.hyeon.models.Student;
import com.hyeon.services.StudentService;
import com.hyeon.services.impl.StudentServiceImpl;

public class App05 {
    public static void main(String[] args) {
        
        Logger logger = LogManager.getFormatterLogger(App05.class);

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        StudentService studentService = new StudentServiceImpl(sqlSession);

        List<Student> result = null;

        try {
            result = studentService.getList(null);
        } catch (ServiceNoResultException e) {
            sqlSession.rollback();
            logger.error("[ 조회된 결과가 없습니다 ]");
            logger.error(e.getMessage());
        } catch (Exception e) {
            sqlSession.rollback();
            logger.error("[ SQL문 처리 실패. Mapper를 확인하세요 ]");
            logger.error(e.getMessage());
        } finally {
            sqlSession.commit();
        }

        logger.debug("===========================================");
        if (result != null) {
            int size = result.size();
            
            for ( int i=0; i<size; i++) {
                Student item = result.get(i);
                logger.debug("학생번호 : " + item.getStudno());
                logger.debug("이름 : " + item.getName());
                logger.debug("아이디 : " + item.getUserid());
                logger.debug("학년 : " + item.getGrade());
                logger.debug("주민번호 : " + item.getIdnum());
                logger.debug("생년월일 : " + item.getBirthdate());
                logger.debug("전화번호 : " + item.getTel());
                logger.debug("키 : " + item.getHeight());
                logger.debug("몸무게 : " + item.getWeight());
                logger.debug("학과번호 : " + item.getDeptno());
                logger.debug("교수번호 : " + item.getProfno());
                if (i+1 < size) {
                    logger.debug("----------------------------------------");
                }
            }
            
        } else {
            logger.error("조회된 데이터가 없습니다");
        }
        logger.debug("===========================================");

        sqlSession.close();
    }
}
