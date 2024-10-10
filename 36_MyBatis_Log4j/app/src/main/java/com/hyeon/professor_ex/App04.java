package com.hyeon.professor_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hyeon.MyBatisConnectionFactory;
import com.hyeon.models.Professor;


public class App04 {
    public static void main(String[] args) {
        
        Logger logger = LogManager.getLogger(App04.class);

        Scanner scan = new Scanner(System.in);
        System.out.print("조회할 교수 번호 : ");
        int profno = scan.nextInt();
        scan.close();

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
      
        Professor professor = new Professor();
        professor.setProfno(profno);

        Professor result = null;

        try {
            result = sqlSession.selectOne("ProfessorMapper.selectItem", professor);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        if ( result == null) {
            System.out.println("조회결과 없음");
        } else {
            System.out.println(result.toString());
        }
        
        sqlSession.close();
    }
}
