package com.hyeon.jdbc_ex;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.hyeon.helpers.DBHelper;

public class Ex03_Insert {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("학과 이름 입력 : ");
        String dname = scan.nextLine();

        System.out.print("학과 위치 입력 : ");
        String loc = scan.nextLine();

        scan.close();

        Connection conn = DBHelper.getInstance().open();

        // 수행할 SQL문 문자열 변수로 준비
        String sql = "INSERT INTO department (dname, loc) VALUES ('%s', '%s')";
        sql = String.format(sql, dname, loc);
        //System.out.println(sql);

        //  MySQL 에 SQL문 전달하고 결과 반환

        //  SQL문 실행할 수 있는 객체
        Statement stmt = null;

        //  결과값 (저장된 데이터 수)
        int result = 0;

        try {
            //  SQL문 실행할 수 있는 객체 생성 
            stmt = conn.createStatement();
            
            //  SQL문 실행  =>  결과 행 리턴된다
            result = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("=== Query Error ===");
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("--" + result + "개의 데이터 저장--");

        DBHelper.getInstance().close();
    }
}
