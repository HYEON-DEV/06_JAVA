package com.hyeon.professor_ex;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hyeon.MyBatisConnectionFactory;
import com.hyeon.models.Professor;


public class App05 {
    public static void main(String[] args) {
        
        Logger logger = LogManager.getLogger(App05.class);

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
      
        List<Professor> result = null;
        
        try {
            result = sqlSession.selectList("ProfessorMapper.selectList", null);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        if ( result == null) {
            System.out.println("조회결과 없음");
        } else {
            for (int i=0; i<result.size(); i++) {
                Professor item = result.get(i);
                logger.debug("교수번호 : " + item.getProfno());
                logger.debug("이름 : " + item.getName());
                logger.debug("아이디 : " + item.getUserid());
                logger.debug("직급 : " + item.getPosition());
                logger.debug("급여 : " + item.getSal());
                logger.debug("입사일 : " + item.getHiredate());
                logger.debug("보직수당 : " + item.getComm() + "\n");
            }
        }
        
        sqlSession.close();
    }
}
