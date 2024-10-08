package com.hyeon.prepared_statement_ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.hyeon.helpers.DBHelper;

public class App02 {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.print("학번 : ");
        int studno = scan.nextInt();

        scan.close();

        String sql = "DELETE FROM student WHERE studno=?";

        Connection conn = DBHelper.getInstance().open();

        PreparedStatement pstmt = null;

        int result = 0;

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, studno);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(result + "Record Deleted");

        DBHelper.getInstance().close();
    }    
}
