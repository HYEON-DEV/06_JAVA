package com.hyeon.mybatis_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hyeon.MyBatisConnectionFactory;
import com.hyeon.models.Department;


public class App01 {
    public static void main(String[] args) {
        
        /**
         * (new) Log4j2 객체 생성
         * => import org.apache.logging.log4j.LogManager;
         * => import org.apache.logging.log4j.Logger;
         */
        Logger logger = LogManager.getLogger(App01.class);

        Scanner scan = new Scanner(System.in);
        System.out.print("학과명 : ");
        String dname = scan.nextLine();
        System.out.print("위치 : ");
        String loc = scan.nextLine();
        scan.close();

        // 입력값을 로그로 기록
        logger.debug("입력된 데이터 : " + dname + ", " + loc);

        /**
         * 데이터베이스 접속
         * => import com.hyeon.MyBatisConnectionFactory;
         * => import org.apache.ibatis.session.SqlSession;
         */
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        
        /** INSERT 를 수행할 데이터 생성
         * => Beans 생성자를 사용하지 않으면 필요한 데이터만 setter로 추가할 수 있다
         * => import com.hyeon.models.Department;
         */
        Department department = new Department();
        department.setDname(dname);
        department.setLoc(loc);

        // 데이터 저장
        int result = 0;

        try {
            /**
             * DepartmentMapper라는 namespace를 갖는 XML에서 id값이 department인 <insert>태그를 호출한다
             * 이 때, 저장할 데이터를 담고 있는 Beans를 파라미터로 전달하고, 자동으로 생성된 PK는 Beans에 저장된다
             */
            sqlSession.insert("DepartmentMapper.insert", department);
            result = department.getDeptNo();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        /** 
         * 결과판별
         * 리턴값이 0이라면 내주벅으로 예외가 발생된 상황으로 간주해야 한다
         */
        logger.info(result + "번 데이터 저장");
        
        /**
         * DB 접속 해제
         * 페이지 종료 전에 데이터의 변경사항을 저장(commit)하고 데이터베이스 접속 해제하기
         */
        sqlSession.commit();
        sqlSession.close();
    }
}
