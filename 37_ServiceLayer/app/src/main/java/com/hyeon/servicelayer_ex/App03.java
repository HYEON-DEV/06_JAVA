package com.hyeon.servicelayer_ex;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hyeon.MyBatisConnectionFactory;
import com.hyeon.exceptions.ServiceNoResultException;
import com.hyeon.models.Department;
import com.hyeon.services.DepartmentService;
import com.hyeon.services.impl.DepartmentServiceImpl;

public class App03 {
    public static void main(String[] args) {
        
        Logger logger = LogManager.getFormatterLogger(App03.class);

        Scanner scan = new Scanner(System.in);
        System.out.print("수정할 학과 번호 : ");
        int deptno = scan.nextInt(); scan.nextLine();
        System.out.print("학과명 : ");
        String dname = scan.nextLine();
        System.out.print("위치 : ");
        String loc = scan.nextLine();     
        scan.close();

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        Department model = new Department();
        model.setDeptNo(deptno);
        model.setDname(dname);
        model.setLoc(loc);

        DepartmentService departmentService = new DepartmentServiceImpl(sqlSession);

        Department result = null;

        try {
            result = departmentService.editItem(model);
        } catch (ServiceNoResultException e) {
            sqlSession.rollback();
            logger.error("[ 수정된 결과가 없습니다 ]");
            logger.error(e.getMessage());
        } catch (Exception e) {
            sqlSession.rollback();
            logger.error("[ SQL문 처리 실패. Mapper를 확인하세요 ]");
            logger.error(e.getMessage());
        } finally {
            sqlSession.commit();
        }

        logger.debug("=====================");
        if (result != null) {
            logger.debug("학과번호 : " + result.getDeptNo());
            logger.debug("학과이름 : " + result.getDname());
            logger.debug("위치 : " + result.getLoc());
        } else {
            logger.error("저장된 데이터가 없습니다");
        }
        logger.debug("=====================");

        sqlSession.close();
    }   
}
