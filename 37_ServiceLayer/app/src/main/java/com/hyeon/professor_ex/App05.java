package com.hyeon.professor_ex;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hyeon.MyBatisConnectionFactory;
import com.hyeon.exceptions.ServiceNoResultException;
import com.hyeon.models.Professor;
import com.hyeon.services.ProfessorService;
import com.hyeon.services.impl.ProfessorServiceImpl;

public class App05 {
    public static void main(String[] args) {
        
        Logger logger = LogManager.getFormatterLogger(App05.class);

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        ProfessorService professorService = new ProfessorServiceImpl(sqlSession);

        List<Professor> result = null;

        try {
            result = professorService.getList(null);
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
                Professor item = result.get(i);
                logger.debug("교수번호 : " + item.getProfno());
                logger.debug("이름 : " + item.getName());
                logger.debug("아이디 : " + item.getUserid());
                logger.debug("직급 : " + item.getPosition());
                logger.debug("급여 : " + item.getSal());
                logger.debug("입사일 : " + item.getHiredate());
                logger.debug("보직수당 : " + item.getComm());
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
