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

public class App01 {
    public static void main(String[] args) {
        //  Log4j 객체 생성        
        Logger logger = LogManager.getFormatterLogger(App01.class);

        Scanner scan = new Scanner(System.in);
        System.out.println("-- 교수 추가 --");
        System.out.print("이름 : ");
        String name = scan.nextLine();
        System.out.print("아이디 : ");
        String userid = scan.nextLine();
        System.out.print("직급 : ");
        String position = scan.nextLine();
        System.out.print("급여 : ");
        int sal = scan.nextInt(); scan.nextLine();
        System.out.print("입사일 : ");
        String hiredate = scan.nextLine();
        System.out.print("보직수당 : ");
        Integer comm = scan.nextInt(); scan.nextLine();
        System.out.print("학과번호 : ");
        int deptno = scan.nextInt();  
        scan.close();

        String inputData = ("입력된 데이터 : %s, %s, %s, %s, %s, %s, %s");
        inputData = String.format(inputData, name, userid, position, sal, hiredate, comm, deptno);
        logger.debug(inputData);

        // 데이터베이스 접속
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        // 저장될 데이터를 담고 있는 Beans 객체 생성
        Professor professor = new Professor();
        professor.setName(name);
        professor.setUserid(userid);
        professor.setPosition(position);
        professor.setSal(sal);
        professor.setHiredate(hiredate);
        professor.setComm(comm);
        professor.setDeptno(deptno);

        //  비즈니스 로직을 위한 Service 객체 생성
        ProfessorService professorService = new ProfessorServiceImpl(sqlSession);
        Professor result = null;

        try {
            result = professorService.addItem(professor);
        } catch (ServiceNoResultException e) {
            sqlSession.rollback();
            logger.error("[ 저장된 결과가 없습니다 ]");
            logger.error(e.getMessage());
        } catch (Exception e) {
            sqlSession.rollback();
            logger.error("[ SQL문 처리 실패. Mapper를 확인하세요 ]");
            logger.error(e.getMessage());
        } finally {
            sqlSession.commit();
        }

        if (result != null) {
            logger.debug("===========================================");
            logger.debug(result.toString());
            logger.debug("===========================================");
        } else {
            logger.error("저장된 데이터가 없습니다");
        }

        sqlSession.close();
    }
}
