package com.hyeon.jdbc_ex;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.hyeon.helpers.DBHelper;

public class Ex08_Search {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("아이디 입력 : ");
        String userid = scan.nextLine();

        System.out.print("주민 등록 번호 입력 : ");
        String idnum = scan.nextLine();

        scan.close();

        Connection conn = DBHelper.getInstance().open();

        String sql = "SELECT studno, s.name, grade, birthdate, tel, height, weight, dname, p.name FROM student s " +
        "INNER JOIN department d ON s.deptno = d.deptno " +
        "INNER JOIN professor p ON s.profno = p.profno " +
        "WHERE s.userid = '%s' AND idnum = '%s'";
        sql = String.format(sql, userid, idnum);
        //System.out.println(sql);

        Statement stmt = null;

        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while(rs.next()){
                int studno = rs.getInt("studno");
                String name = rs.getString("s.name");
                int grade = rs.getInt("grade");
                String birthdate = rs.getString("birthdate");
                String tel = rs.getString("tel");
                int height = rs.getInt("height");
                int weight = rs.getInt("weight");
                String dname = rs.getString("dname");
                String profname = rs.getString("p.name");

                System.out.println("학번 : " + studno);
                System.out.println("이름 : " + name);
                System.out.println("학년 : " + grade);
                System.out.println("생년월일 : " + birthdate);
                System.out.println("전화번호 : " + tel);
                System.out.println("키 : " + height);
                System.out.println("몸무게 : " + weight);
                System.out.println("학과 : " + dname);
                System.out.println("지도교수 : " + profname);
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("=== Query Error ===");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("=== Unknown Error ===");
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
