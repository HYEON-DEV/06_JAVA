package com.hyeon.jdbc_ex;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hyeon.helpers.DBHelper;

public class Ex07_CountEX {
    public static void main(String[] args) {
        
        Connection conn = DBHelper.getInstance().open();

        String sql = "SELECT COUNT(*) AS `cnt` FROM student WHERE grade=4";

        Statement stmt = null;
        
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            boolean first = rs.next();

            if (first) {
                // SELECT 절에 명시된 1번째 항목을 int형으로 추출하기
                //int count = rs.getInt(1);

                // SELECT 절에 명시된 `cnt` 컬럼을 int형으로 추출하기
                int count = rs.getInt("cnt");

                System.out.println("4학년 학생은 " + count + "명 입니다");
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

        DBHelper.getInstance().close();
    }
}
