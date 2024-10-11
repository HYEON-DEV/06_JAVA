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


public class App03 {
    public static void main(String[] args) {
        
        Logger logger = LogManager.getFormatterLogger(App03.class);

        Scanner scan = new Scanner(System.in);
        System.out.print("수정할 학생 번호 : ");
        int studno = scan.nextInt(); scan.nextLine();
        System.out.print("수정할 학생 이름 : ");
        String name = scan.nextLine();
        System.out.print("수정할 학생 아이디 : ");
        String userid = scan.nextLine();
        System.out.print("수정할 학생 학년 : ");
        int grade = scan.nextInt(); scan.nextLine();
        System.out.print("수정할 학생 주민번호 : ");
        String idnum = scan.nextLine();
        System.out.print("수정할 생년월일 : ");
        String birthdate = scan.nextLine();
        System.out.print("수정할 학생 전화번호 : ");
        String tel = scan.nextLine();
        System.out.print("수정할 학생 키 : ");
        int height = scan.nextInt(); scan.nextLine();
        System.out.print("수정할 학생 몸무게 : ");
        int weight = scan.nextInt(); scan.nextLine();
        System.out.print("수정할 학생 학과번호 : ");
        int deptno = scan.nextInt(); scan.nextLine();
        System.out.print("수정할 학생 교수번호 : ");
        int profno = scan.nextInt();
        scan.close();

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        Student model = new Student();
        model.setStudno(studno);
        model.setName(name);
        model.setUserid(userid);
        model.setGrade(grade);
        model.setIdnum(idnum);
        model.setBirthdate(birthdate);
        model.setTel(tel);
        model.setHeight(height);
        model.setWeight(weight);
        model.setDeptno(deptno);
        model.setProfno(profno);

        StudentService studentService = new StudentServiceImpl(sqlSession);

        Student result = null;

        try {
            result = studentService.editItem(model);
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
            logger.debug("학생번호 : " + result.getStudno());
            logger.debug("이름 : " + result.getName());
            logger.debug("아이디 : " + result.getUserid());
            logger.debug("학년 : " + result.getGrade());
            logger.debug("주민번호 : " + result.getIdnum());
            logger.debug("생년월일 : " + result.getBirthdate());
            logger.debug("전화번호 : " + result.getTel());
            logger.debug("키 : " + result.getHeight());
            logger.debug("몸무게 : " + result.getWeight());
            logger.debug("학과번호 : " + result.getDeptno());
            logger.debug("교수번호 : " + result.getProfno());
        } else {
            logger.error("저장된 데이터가 없습니다");
        }
        logger.debug("===========================================");

        sqlSession.close();
    }   
}
