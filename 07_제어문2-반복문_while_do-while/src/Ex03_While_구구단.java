import java.util.Scanner;

public class Ex03_While_구구단 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("숫자를 입력하세요(2~9) : ");
        int x = scan.nextInt();
        scan.close();

        int y = 1;

        while ( y<10 ) {
            System.out.printf("%d X %d = %d\n", x, y, x*y);
            y++;
        }
    }
}
