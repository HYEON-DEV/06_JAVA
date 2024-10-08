package com.hyeon.prepared_statement_ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.hyeon.helpers.DBHelper;

public class App03 {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.print("교수이름 : ");
        String pname = scan.nextLine();
        System.out.println();

        scan.close();

        String sql = "SELECT profno, name, userid, position, sal, hiredate, comm, deptno FROM professor " +
        "WHERE name LIKE concat('%',?,'%')";
        
        Connection conn = DBHelper.getInstance().open();

        PreparedStatement pstmt = null;

        ResultSet rs = null;
        
        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, pname);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                int profno = rs.getInt("profno");
                String name = rs.getString("name");
                
                System.out.println("교수번호 : " + profno);
                System.out.println("이름 : " + name);
            }
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

        DBHelper.getInstance().close();
    }
}
