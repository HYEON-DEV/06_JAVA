package com.hyeon.professor_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hyeon.MyBatisConnectionFactory;
import com.hyeon.exceptions.ServiceNoResultException;
import com.hyeon.models.Professor;
import com.hyeon.services.ProfessorService;
import com.hyeon.services.impl.ProfessorServiceImpl;

public class App02 {
    public static void main(String[] args) {
        
        Logger logger = LogManager.getFormatterLogger(App02.class);

        Scanner scan = new Scanner(System.in);
        System.out.print("삭제할 교수 번호 : ");
        int profno = scan.nextInt();
        scan.close();

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        Professor model = new Professor();
        model.setProfno(profno);

        ProfessorService professorService = new ProfessorServiceImpl(sqlSession);

        int result = 0;

        try {
            result = professorService.deleteItem(model);
        } catch (ServiceNoResultException e) {
            sqlSession.rollback();
            logger.error("[ 삭제된 결과가 없습니다 ]");
            logger.error(e.getMessage());
        } catch (Exception e) {
            sqlSession.rollback();
            logger.error("[ SQL문 처리 실패. Mapper를 확인하세요 ]");
            logger.error(e.getMessage());
        } finally {
            sqlSession.commit();
        }

        logger.debug("===========================================");
        logger.debug("삭제된 데이터: " + result + "개");
        logger.debug("===========================================");

        sqlSession.close();
    }
}
