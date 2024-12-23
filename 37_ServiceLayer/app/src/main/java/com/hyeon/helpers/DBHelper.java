package com.hyeon.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private static final String db_hostname = "127.0.0.1";
    private static final int db_portnumber = 3306;
    private static final String db_database = "myschool";
    private static final String db_charset = "utf8";
    private static final String db_username = "root";
    private static final String db_password = "123qwe!@#";

    // 접속 객체 선언
    private Connection conn = null;

    // 싱글톤 객체
    private static DBHelper current;

    public static DBHelper getInstance() {
        if (current == null) {
            current = new DBHelper();
        }
        return current;
    }

    // 싱글톤 객체 삭제
    public static void freeInstance() {
        current = null;
    }

    private DBHelper() {
        //super();
    }


    /** 데이터베이스에 접속 후, 접속 객체를 리턴한다 */
    public Connection open() {
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

        return conn;
    }


    /** 데이터베이스의 접속을 해제한다 */
    public void close() {
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
