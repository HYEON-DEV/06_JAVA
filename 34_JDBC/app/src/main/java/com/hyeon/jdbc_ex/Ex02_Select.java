package com.hyeon.jdbc_ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex02_Select {
    public static void main(String[] args) {
        
        String db_hostname = "127.0.0.1";
        int db_portnumber = 3306;
        String db_database = "myschool";
        String db_charset = "utf8";
        String db_username = "root";
        String db_password = "123qwe!@#";

        //  데이터베이스 접속 ==> mysql -uroot -p
        //  접속 개체 선언
        Connection conn = null;

        //  접속 주소 구성
        //  jdbc:mysql://127.0.01:3306/myschool?characterEncoding=utf8&serverTimezone=UTC
        String urlFormat = "jdbc:mysql://%s:%d/%s?characterEncoding=%s&serverTimezone=UTC";
        String url = String.format(urlFormat, db_hostname, db_portnumber, db_database, db_charset);

        // MySQL JDBC 드라이버 클래스 로딩해서 DriverManager 클래스에 등록
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //  DriverManager 객체 사용해서 DB에 접속한다
            //  => 접속 url, id, pw 전달
            //  => DriverManager에 등록된 Driver 객체를 사용해 DB에 접속 후 Connection 객체를 리턴받는다
            //  => import java.sql.DriverManager 필요
            
            conn = DriverManager.getConnection(url, db_username, db_password);             
        } catch (ClassNotFoundException e) {
            System.out.println("=== MySQL Driver Loading Fail ===");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("=== MySQL Connection Fail ===");
            e.printStackTrace();
        }

        String sql = "SELECT deptno, dname, loc FROM department ORDER BY deptno";

        //  MySQL 에 SQL문 전달하고 결과 반환

        //  SQL문 실행할 수 있는 객체
        Statement stmt = null;

        //  SELECT 결과를 저장할 객체
        //  =>  import java.sql.ResultSet;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int deptno = rs.getInt("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");

                System.out.println("학과번호 : " + deptno);
                System.out.println("학과이름 : " + dname);
                System.out.println("위치 : " + loc);
                System.out.println();
            }
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

        //  데이터베이스 접속 해제
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("=== MySQL Disconnection Fail ===");
                System.out.println(e.getMessage());
            }
        }
        
    }
}
