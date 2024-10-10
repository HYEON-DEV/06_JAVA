package com.hyeon.mybatis_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hyeon.MyBatisConnectionFactory;
import com.hyeon.models.Department;

public class App03 {
    public static void main(String[] args) {
        
        Logger logger = LogManager.getLogger(App03.class);

        Scanner scan = new Scanner(System.in);
        System.out.print("수정할 학과 이름 : ");
        String dname = scan.nextLine();
        System.out.print("수정할 위치 : ");
        String loc = scan.nextLine();
        System.out.print("수정할 학과 번호 : ");
        int deptNo = scan.nextInt();
        scan.close();

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        Department model = new Department();
        model.setDeptNo(deptNo);
        model.setDname(dname);
        model.setLoc(loc);

        int result = 0;

        try {
            result = sqlSession.update("DepartmentMapper.update", model);

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
