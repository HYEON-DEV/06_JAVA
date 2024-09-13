import java.util.Scanner;

public class Exercise06 {
    public static void main(String[] args) {
        /* 
        int k = 20; // 과자 한 개 가격
        int n = 10; // 사려고 하는 과자 개수
        int m = 320; // 현재 돈
         */

        Scanner scan = new Scanner(System.in);
        System.out.print("과자 한 개 가격 : ");
        int k = scan.nextInt();

        System.out.print("사려고 하는 과자 개수 : ");
        int n = scan.nextInt();

        System.out.print("현재 가진 돈 : ");
        int m = scan.nextInt();

        scan.close();

        int money = m-k*n >= 0 ? 0 : -1*(m-k*n);

        System.out.println(money);
    }
}
