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

public class App01 {
    public static void main(String[] args) {
        
        Logger logger = LogManager.getFormatterLogger(App01.class);

        Scanner scan = new Scanner(System.in);
        System.out.print("학과명 : ");
        String dname = scan.nextLine();
        System.out.print("위치 : ");
        String loc = scan.nextLine();     
        scan.close();

        String inputData = String.format("입력된 데이터: %s, %s", dname, loc);
        logger.debug(inputData);

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        Department dept = new Department();
        dept.setDname(dname);
        dept.setLoc(loc);

        DepartmentService departmentService = new DepartmentServiceImpl(sqlSession);
        Department result = null;

        try {
            result = departmentService.addItem(dept);
        } catch (ServiceNoResultException e) {
            sqlSession.rollback();
            logger.error("[ 저장된 결과가 없습니다 ]");
            logger.error(e.getMessage());
        } catch (Exception e) {
            sqlSession.rollback();
            logger.error("[ SQL문 처리 실패. Mapper를 확인하세요 ]");
            logger.error(e.getMessage());
        } finally {
            sqlSession.commit();
        }

        if (result != null) {
            logger.debug("=====================");
            logger.debug(result.toString());
            logger.debug("=====================");
        } else {
            logger.error("저장된 데이터가 없습니다");
        }

        sqlSession.close();
    }
}
