import java.util.Scanner;

public class Ex02_입력 {
    public static void main( String[] args ) {
        Scanner reader = new Scanner(System.in);

        System.out.print("이름을 입력하세요:  ");
        String name = reader.nextLine();
        
        System.out.print("나이를 입력하세요:  ");
        int age = reader.nextInt();

        System.out.print("키를 입력하세요:  ");
        double height = reader.nextDouble();

        reader.close();

        System.out.println("-------------");
        System.out.println(name + "님은" + age + "세 이고 키는 " + height + "cm 입니다.");
        System.out.println("-------------");
    }
}