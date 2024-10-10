package com.hyeon.student_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hyeon.MyBatisConnectionFactory;
import com.hyeon.models.Student;


public class App03 {
    public static void main(String[] args) {
        
        Logger logger = LogManager.getLogger(App03.class);

        Scanner scan = new Scanner(System.in);
        System.out.print("수정할 학생 번호 : ");
        int studno = scan.nextInt();
        scan.nextLine();
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
      
        Student student = new Student();
        student.setStudno(studno);
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
            result = sqlSession.update("StudentMapper.update", student);
            if (result == 0) {
                throw new Exception("수정된 데이터가 없습니다");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        System.out.println(result + "개의 데이터 수정");
        
        sqlSession.commit();
        sqlSession.close();
    }
}
