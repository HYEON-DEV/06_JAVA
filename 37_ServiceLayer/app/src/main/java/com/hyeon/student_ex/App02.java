package com.hyeon.student_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hyeon.MyBatisConnectionFactory;
import com.hyeon.exceptions.ServiceNoResultException;
import com.hyeon.models.Student;
import com.hyeon.services.StudentService;
import com.hyeon.services.impl.StudentServiceImpl;

public class App02 {
    public static void main(String[] args) {
        
        Logger logger = LogManager.getFormatterLogger(App02.class);

        Scanner scan = new Scanner(System.in);
        System.out.print("삭제할 학생 번호 : ");
        int studno = scan.nextInt();
        scan.close();
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        Student model = new Student();
        model.setStudno(studno);

        StudentService studentService = new StudentServiceImpl(sqlSession);

        int result = 0;

        try {
            result = studentService.deleteItem(model);
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
