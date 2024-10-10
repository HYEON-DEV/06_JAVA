package com.hyeon.prepared_statement_ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.hyeon.helpers.DBHelper;

public class App01 {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.print("학과명 : ");
        String dname = scan.nextLine();

        System.out.print("위치 : ");
        String loc = scan.nextLine();

        scan.close();

        //  SQL 구문 정의하기
        String sql = "INSERT INTO department (dname, loc) VALUES (?,?)";
        // ?는 PreparedStatement를 사용하여 나중에 값을 바인딩할 자리

        Connection conn = DBHelper.getInstance().open();

        //  SQL 구문 실행
        //  SQL문의 템플릿 사용하여 쿼리 실행을 준비하는 객체
        //  =>  import java.sql.PreparedStatement;
        PreparedStatement pstmt = null;

        //  처리 결과 받을 객체
        ResultSet rs = null;

        int result = 0;

        int autoGeneratedID = 0;

        try {
            //  pstmt 객체할당 => AUTO_INCREMENT 조회 옵션 사용
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            //  SQL문의 ? 자리에 데이터 바인딩
            pstmt.setString(1, dname);
            pstmt.setString(2, loc);

            //  SQL문 실행  =>  결과 행 리턴   ( 파라미터 없음 !!! )
            result = pstmt.executeUpdate();

            //  생성된 AUTO_INCREMENT 값 얻기
            rs = pstmt.getGeneratedKeys();
            rs.next();
            autoGeneratedID = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(result + " Record Insert");
        System.out.println("New Deptno = " + autoGeneratedID);

        DBHelper.getInstance().close();
    }
}