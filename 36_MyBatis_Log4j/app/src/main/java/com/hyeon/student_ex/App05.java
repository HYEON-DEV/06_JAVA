package com.hyeon.student_ex;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hyeon.MyBatisConnectionFactory;
import com.hyeon.models.Student;


public class App05 {
    public static void main(String[] args) {
        
        Logger logger = LogManager.getLogger(App05.class);

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
      
        List<Student> result = null;
        
        try {
            result = sqlSession.selectList("StudentMapper.selectList", null);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        if ( result == null) {
            System.out.println("조회결과 없음");
        } else {
            for (int i=0; i<result.size(); i++) {
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
                logger.debug("교수번호 : " + item.getProfno() + "\n");
            }
        }
        
        sqlSession.close();
    }
}
