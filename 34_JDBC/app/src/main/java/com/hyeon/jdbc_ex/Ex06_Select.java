package com.hyeon.jdbc_ex;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hyeon.helpers.DBHelper;

public class Ex06_Select {
    public static void main(String[] args) {
        
        Connection conn = DBHelper.getInstance().open();

        String sql = "SELECT deptno, dname, loc FROM department ORDER BY deptno";

        Statement stmt = null;

        ResultSet rs = null;
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while(rs.next()){
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

        DBHelper.getInstance().close();
    }
}
