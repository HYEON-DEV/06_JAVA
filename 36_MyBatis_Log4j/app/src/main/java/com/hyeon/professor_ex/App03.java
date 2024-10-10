package com.hyeon.professor_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hyeon.MyBatisConnectionFactory;
import com.hyeon.models.Professor;


public class App03 {
    public static void main(String[] args) {
        
        Logger logger = LogManager.getLogger(App03.class);

        Scanner scan = new Scanner(System.in);
        System.out.print("수정할 교수 번호 : ");
        int profno = scan.nextInt();
        scan.nextLine();
        System.out.print("수정할 교수 이름 : ");
        String name = scan.nextLine();
        System.out.print("수정할 교수 아이디 : ");
        String userid = scan.nextLine();
        System.out.print("수정할 교수 직급 : ");
        String position = scan.nextLine();
        System.out.print("수정할 교수 급여 : ");
        int sal = scan.nextInt();
        scan.nextLine();
        System.out.print("수정할 교수 입사일 : ");
        String hiredate = scan.nextLine();
        System.out.print("수정할 교수 보직수당 : ");
        Integer comm = scan.nextInt();
        scan.nextLine();
        System.out.print("수정할 교수 학과번호 : ");
        int deptno = scan.nextInt();        
        scan.close();

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
      
        Professor professor = new Professor();
        professor.setProfno(profno);
        professor.setName(name);
        professor.setUserid(userid);
        professor.setPosition(position);
        professor.setSal(sal);
        professor.setHiredate(hiredate);
        professor.setComm(comm);
        professor.setDeptno(deptno);

        int result = 0;

        try {
            result = sqlSession.update("ProfessorMapper.update", professor);
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
