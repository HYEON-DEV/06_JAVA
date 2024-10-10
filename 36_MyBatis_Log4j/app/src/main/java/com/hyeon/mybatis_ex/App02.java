package com.hyeon.mybatis_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hyeon.MyBatisConnectionFactory;
import com.hyeon.models.Department;

public class App02 {
    public static void main(String[] args) {
        
        Logger logger = LogManager.getLogger(App02.class);

        Scanner scan = new Scanner(System.in);
        System.out.print("삭제할 학과 번호 : ");
        int deptNo = scan.nextInt();
        scan.close();

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        // DELETE를 수정할 데이터 생성
        Department model = new Department();
        model.setDeptNo(deptNo);

        // 데이터 삭제
        int result = 0;

        try {
            result = sqlSession.delete("DepartmentMapper.delete", model);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        logger.debug(result + "개의 데이터 삭제");

        sqlSession.commit();
        sqlSession.close();        
    }
}
