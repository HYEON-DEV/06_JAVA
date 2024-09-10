import java.util.Scanner;

public class Ex01{
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("체중을 입력하세요 (kg) : ");
        int myWeight = reader.nextInt();
        
        System.out.print("키를 입력하세요 (m) : ");
        double myHeight = reader.nextDouble();

        reader.close();

        int bmi = (int)( (double) myWeight / myHeight*myHeight );

        System.out.printf("BMI : " + bmi);
    }
}