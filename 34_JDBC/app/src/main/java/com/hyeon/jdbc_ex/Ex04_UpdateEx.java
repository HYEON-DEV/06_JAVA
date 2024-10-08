package com.hyeon.jdbc_ex;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.hyeon.helpers.DBHelper;

public class Ex04_UpdateEx {
    public static void main(String[] args) {
        
        Connection conn = DBHelper.getInstance().open();

        String sql = "UPDATE department SET dname='hello', loc='world' WHERE deptno >= 103";

        Statement stmt = null;
        int result = 0;

        try {
            stmt = conn.createStatement();
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

        System.out.println("--" + result + "개의 데이터 수정--");

        DBHelper.getInstance().close();
    }
}
