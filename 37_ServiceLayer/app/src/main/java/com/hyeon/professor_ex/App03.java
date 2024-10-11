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


public class App03 {
    public static void main(String[] args) {
        
        Logger logger = LogManager.getFormatterLogger(App03.class);

        Scanner scan = new Scanner(System.in);
        System.out.print("수정할 교수 번호 : ");
        int profno = scan.nextInt(); scan.nextLine();
        System.out.print("수정할 교수 이름 : ");
        String name = scan.nextLine();
        System.out.print("수정할 교수 아이디 : ");
        String userid = scan.nextLine();
        System.out.print("수정할 교수 직급 : ");
        String position = scan.nextLine();
        System.out.print("수정할 교수 급여 : ");
        int sal = scan.nextInt(); scan.nextLine();
        System.out.print("수정할 교수 입사일 : ");
        String hiredate = scan.nextLine();
        System.out.print("수정할 교수 보직수당 : ");
        Integer comm = scan.nextInt(); scan.nextLine();
        System.out.print("수정할 교수 학과번호 : ");
        int deptno = scan.nextInt();           
        scan.close();

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        Professor model = new Professor();
        model.setProfno(profno);
        model.setName(name);
        model.setUserid(userid);
        model.setPosition(position);
        model.setSal(sal);
        model.setHiredate(hiredate);
        model.setComm(comm);
        model.setDeptno(deptno);

        ProfessorService professorService = new ProfessorServiceImpl(sqlSession);

        Professor result = null;

        try {
            result = professorService.editItem(model);
        } catch (ServiceNoResultException e) {
            sqlSession.rollback();
            logger.error("[ 수정된 결과가 없습니다 ]");
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
            logger.debug("교수번호 : " + result.getProfno());
            logger.debug("이름 : " + result.getName());
            logger.debug("아이디 : " + result.getUserid());
            logger.debug("직급 : " + result.getPosition());
            logger.debug("급여 : " + result.getSal());
            logger.debug("입사일 : " + result.getHiredate());
            logger.debug("보직수당 : " + result.getComm());
        } else {
            logger.error("저장된 데이터가 없습니다");
        }
        logger.debug("===========================================");

        sqlSession.close();
    }   
}
