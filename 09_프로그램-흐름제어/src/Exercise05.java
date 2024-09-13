import java.util.Scanner;

public class Exercise05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("100~200 사이의 숫자 입력 : ");
        int number = scan.nextInt();
        scan.close();

        int sum=0;
        for ( int i=1; i<number; i++ ) {
            if ( i%3 == 0 ) {
                sum += i;
                System.out.printf("%d, 합=%d\n", i, sum);
            }
        }

        //if ( n<100 || n>200)
    }    
}
