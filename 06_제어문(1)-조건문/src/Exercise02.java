import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("키 입력 (cm) : ");
        int myHeight = scan.nextInt();
        System.out.print("몸무게 입력 (kg) : ");
        int myWeight = scan.nextInt();
        scan.close();

        double standardWeight = myHeight<=150? myHeight-110 : (myHeight-110)*0.9;

        double obesity = (myWeight-standardWeight)/standardWeight * 100;

        /* if( obesity <= 20 ){
            System.out.println("정상(안심)");
        } else if ( obesity>20 && obesity<=30 ) {
            System.out.println("경도비만(주의)");
        } else if ( obesity>30 && obesity<=50 ) {
            System.out.println("중등도 비만(위험)");
        } else {
            System.out.println("고도비만(매우위험)");
        } */

        if( obesity <= 20 ){
            System.out.println("정상(안심)");
        } else if ( obesity<=30 ) {
            System.out.println("경도비만(주의)");
        } else if ( obesity<=50 ) {
            System.out.println("중등도 비만(위험)");
        } else {
            System.out.println("고도비만(매우위험)");
        }
    }
}
