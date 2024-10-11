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

public class App01 {
    public static void main(String[] args) {
        //  Log4j 객체 생성        
        Logger logger = LogManager.getFormatterLogger(App01.class);

        Scanner scan = new Scanner(System.in);
        System.out.print("이름 : ");
        String name = scan.nextLine();
        System.out.print("아이디 : ");
        String userid = scan.nextLine();
        System.out.print("학년 : ");
        int grade = scan.nextInt();
        scan.nextLine();
        System.out.print("주민번호 : ");
        String idnum = scan.nextLine();
        System.out.print("생년월일 : ");
        String birthdate = scan.nextLine();
        System.out.print("전화번호 : ");
        String tel = scan.nextLine();
        System.out.print("키 : ");
        int height = scan.nextInt();
        scan.nextLine();
        System.out.print("몸무게 : ");
        int weight = scan.nextInt();
        scan.nextLine();
        System.out.print("학과번호 : ");
        int deptno = scan.nextInt();
        scan.nextLine();
        System.out.print("교수번호 : ");
        int profno = scan.nextInt();
        scan.close();

        String inputData = String.format(
            ("입력된 데이터 : %s, %s, %s, %s, %s, %s, %s, %s, %s, %s"), 
            name, userid, grade, idnum, birthdate, tel, height, weight, deptno, profno );
        logger.debug(inputData);

        // 데이터베이스 접속
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        // 저장될 데이터를 담고 있는 Beans 객체 생성
        Student student = new Student();
        student.setName(name);
        student.setUserid(userid);
        student.setGrade(grade);
        student.setIdnum(idnum);
        student.setBirthdate(birthdate);
        student.setTel(tel);
        student.setHeight(height);
        student.setWeight(weight);
        student.setDeptno(deptno);
        student.setProfno(profno);

        //  비즈니스 로직을 위한 Service 객체 생성
        StudentService studentService = new StudentServiceImpl(sqlSession);
        Student result = null;

        try {
            result = studentService.addItem(student);
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
