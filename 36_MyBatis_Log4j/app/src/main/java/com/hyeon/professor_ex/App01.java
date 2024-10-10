package com.hyeon.professor_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hyeon.MyBatisConnectionFactory;
import com.hyeon.models.Professor;


public class App01 {
    public static void main(String[] args) {
        
        Logger logger = LogManager.getLogger(App01.class);

        Scanner scan = new Scanner(System.in);
        System.out.print("이름 : ");
        String name = scan.nextLine();
        System.out.print("아이디 : ");
        String userid = scan.nextLine();
        System.out.print("직급 : ");
        String position = scan.nextLine();
        System.out.print("급여 : ");
        int sal = scan.nextInt();
        scan.nextLine();
        System.out.print("입사일 : ");
        String hiredate = scan.nextLine();
        System.out.print("보직수당 : ");
        Integer comm = scan.nextInt();
        scan.nextLine();
        System.out.print("학과번호 : ");
        int deptno = scan.nextInt();
        scan.close();

        String inputData = ("입력된 데이터 : %s, %s, %s, %s, %s, %s, %s");
        inputData = String.format(inputData, name, userid, position, sal, hiredate, comm, deptno);
        logger.debug(inputData);

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
      
        Professor professor = new Professor();
        professor.setName(name);
        professor.setUserid(userid);
        professor.setPosition(position);
        professor.setSal(sal);
        professor.setHiredate(hiredate);
        professor.setComm(comm);
        professor.setDeptno(deptno);

        // 데이터 저장
        int result = 0;

        try {
            sqlSession.insert("ProfessorMapper.insert", professor);
            result = professor.getProfno();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        logger.info(result + "번 데이터 저장");
        
        sqlSession.commit();
        sqlSession.close();
    }
}
