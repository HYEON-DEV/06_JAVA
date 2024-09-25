import java.util.Scanner;

public class Ex05_예외처리 {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.print("x 입력: ");
        int x = scan.nextInt();
        System.out.print("y 입력: ");
        int y = scan.nextInt();
        scan.close();

        Calc c = Calc.getInstance();

        int z = c.divide(x,y);

        System.out.printf("%d나누기 %d는 %d입니다\n\n", x, y, z);

        int a = 0;
        try {
            a = c.divideEx(x, y);
        } catch (Exception e) {
            System.out.println("[divideEX error] 0으로 나눌 수 없습니다");
        }
        System.out.printf("[divideEx] %d나누기 %d는 %d입니다\n\n", x,y,a);
    }
}
