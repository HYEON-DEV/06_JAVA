package com.hyeon.student_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hyeon.MyBatisConnectionFactory;
import com.hyeon.models.Student;


public class App02 {
    public static void main(String[] args) {
        
        Logger logger = LogManager.getLogger(App02.class);

        Scanner scan = new Scanner(System.in);
        System.out.print("삭제할 학생 번호 : ");
        int studno = scan.nextInt();
        scan.close();

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
      
        Student student = new Student();
        student.setStudno(studno);
        
        int result = 0;

        try {
            result = sqlSession.delete("StudentMapper.delete", student);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        logger.debug(result + "개 데이터 삭제");
        
        sqlSession.commit();
        sqlSession.close();
    }
}
