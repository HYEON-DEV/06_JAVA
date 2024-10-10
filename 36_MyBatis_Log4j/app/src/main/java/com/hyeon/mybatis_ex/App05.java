package com.hyeon.mybatis_ex;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hyeon.MyBatisConnectionFactory;
import com.hyeon.models.Department;

public class App05 {
    public static void main(String[] args) {
        
        Logger logger = LogManager.getLogger(App05.class);

        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        /**
         * 데이터 조회
         * 다중행 조회이므로 List<Beans>로 결과를 받는다
         */
        List<Department> result = null;
        
        try {
            /**
             * DepartmentMapper라는 namespace를 갖는 XML에서 id값이 selectList인 <select>태그 호출
             * 이 때, 조회할 데이터를 담고 있는 Beans를 파라미터로 전달하고, 결과를 List<Beans>로 받는다
             * 전달할 파리미터가 없는 경우 beans를 null로 설정한다
             */
            result = sqlSession.selectList("DepartmentMapper.selectList", null);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        if ( result == null) {
            System.out.println("조회결과 없음");
        } else {
            for (int i=0; i<result.size(); i++) {
                Department item = result.get(i);
                logger.debug("학과번호 : " + item.getDeptNo());
                logger.debug("학과명 : " + item.getDname());
                logger.debug("위치 : " + item.getLoc());
            }
        }

        sqlSession.close();
    }
}
