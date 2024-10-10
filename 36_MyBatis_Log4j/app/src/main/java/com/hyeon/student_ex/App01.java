package com.hyeon.student_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hyeon.MyBatisConnectionFactory;
import com.hyeon.models.Student;



public class App01 {
    public static void main(String[] args) {
        
        Logger logger = LogManager.getLogger(App01.class);

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

        String inputData = ("입력된 데이터 : %s, %s, %s, %s, %s, %s, %s, %s, %s, %s");
        inputData = String.format(inputData, name, userid, grade, idnum, birthdate, tel, height, weight, deptno, profno);
        logger.debug(inputData);

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
      
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

        int result = 0;

        try {
            sqlSession.insert("StudentMapper.insert", student);
            result = student.getStudno();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        logger.info(result + "번 데이터 저장");
        
        sqlSession.commit();
        sqlSession.close();
    }
}
