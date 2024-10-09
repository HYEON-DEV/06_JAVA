
package com.hyeon.jdbc_ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Ex01_Insert {
   
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("학과 이름 입력 : ");
        String dname = scan.nextLine();

        System.out.print("학과 위치 입력 : ");
        String loc = scan.nextLine();

        scan.close();

        String db_hostname = "127.0.0.1";
        int db_portnumber = 3306;
        String db_database = "myschool";
        String db_charset = "utf8";
        String db_username = "root";
        String db_password = "123qwe!@#";

        /**
         * 데이터베이스 접속 ==> mysql -uroot -p
         * 접속 개체 선언
         * 데이터베이스와의 연결을 나타낸다
         * 이 객체는 SQL 쿼리를 실행하고, 트랜잭션을 관리하며, 연결을 닫을 때 사용된다
         */
        Connection conn = null;

        //  접속 주소 구성
        //  jdbc:mysql://127.0.01:3306/myschool?characterEncoding=utf8&serverTimezone=UTC
        String urlFormat = "jdbc:mysql://%s:%d/%s?characterEncoding=%s&serverTimezone=UTC";
        String url = String.format(urlFormat, db_hostname, db_portnumber, db_database, db_charset);

        // MySQL JDBC 드라이버 클래스 로딩해서 DriverManager 클래스에 등록
        try {
            /**
             * Class.forName() 메서드는 Java에서 동적으로 클래스를 로드하는 역할
             * 이 경우, com.mysql.cj.jdbc.Driver 클래스(MySQL JDBC 드라이버)를 로드하고, 
             * 이 클래스가 정적으로 DriverManager에 등록된다
             */
            Class.forName("com.mysql.cj.jdbc.Driver");

            /**
             * DriverManager 객체 사용해서 DB에 접속한다
             * => 접속 url, id, pw 전달
             * => DriverManager에 등록된 Driver 객체를 사용해 DB에 접속 후 Connection 객체를 리턴받는다
             * => import java.sql.DriverManager 필요
             */ 
            conn = DriverManager.getConnection(url, db_username, db_password);             

        } catch (ClassNotFoundException e) {
            System.out.println("=== MySQL Driver Loading Fail ===");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("=== MySQL Connection Fail ===");
            e.printStackTrace();
        }

        // 수행할 SQL문 문자열 변수로 준비
        String sql = "INSERT INTO department (dname, loc) VALUES ('%s', '%s')";
        sql = String.format(sql, dname, loc);
        //System.out.println(sql);

        //  MySQL 에 SQL문 전달하고 결과 반환

        //  SQL문 실행할 수 있는 객체
        /**
         * Statement 객체는 SQL 쿼리를 데이터베이스에 전달하고 그 결과를 받아오기 위한 객체이다
         * 기본 SQL 쿼리뿐만 아니라,  업데이트, 삭제, 삽입 등의 작업을 할 수 있다
         */
        Statement stmt = null;

        //  결과값 (저장된 데이터 수)
        int result = 0;

        try {
            //  SQL문 실행할 수 있는 객체 생성 
            stmt = conn.createStatement();
            
            //  SQL문 실행  =>  결과 행 리턴된다
            /**
             * executeUpdate(sql)는 SQL 쿼리를 실행하고, 주로 데이터베이스의 데이터를 변경하는 쿼리(예: INSERT, UPDATE, DELETE)를 수행할 때 사용된다
             * 반환값(result)은 SQL 문에 의해 영향을 받은 행의 수
             */
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
