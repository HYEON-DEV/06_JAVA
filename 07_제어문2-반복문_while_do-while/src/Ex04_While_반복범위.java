import java.util.Scanner;

public class Ex04_While_반복범위 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("x를 입력하세요 : ");
        int x = scan.nextInt();

        System.out.print("y를 입력하세요 : ");
        int y = scan.nextInt();

        scan.close();

        int i = x;
        int sum = 0;

        //  y까지의 합을 구하는 것이니까 y+1보다 작을때까지 or  y와 같거나 작을 경우
        //  i <= y     i < y+1
        while ( i < y+1 ) {
            System.out.printf("%4d + %2d = ", sum, i );
            sum += i;
            System.out.printf("%4d\n", sum);
            i++;
        }
    }    
}
