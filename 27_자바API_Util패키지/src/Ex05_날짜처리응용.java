import java.util.Calendar;
import java.util.Scanner;

public class Ex05_날짜처리응용 {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.print("년도를 입력하세요: ");
        int year = scan.nextInt();
        System.out.print("월을 입력하세요: ");
        int month = scan.nextInt();
        scan.close();
 
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        int weekCount = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);   // 이번달이 몇주인지
        int dayCount = cal.getActualMaximum(Calendar.DAY_OF_MONTH);     // 이번달이 몇일까지있는지

        cal.set(Calendar.DAY_OF_MONTH, 1);  // 이 달의 1일로 설정
        int first_day = cal.get(Calendar.DAY_OF_WEEK);  // 이달의 1일의 요일 인덱스

        int[][] data = new int[weekCount][7];

        int count = 1;

        for ( int i=0; i<data.length; i++ ) {
            for (int j =0; j<data[i].length; j++) {
                if(!(i==0 && j+1<first_day) && count<=dayCount) {
                    // i=0, j 가 first_Day(시작요일)보다 작지 않을 때
                    // count가 이번달의 마지막 날짜 이하일 때
                    data[i][j] = count;
                    count++;
                }
            }
        }

        for (int i=0; i<data.length; i++) {
            for(int j=0; j<data[i].length; j++) {
                if(data[i][j] == 0){
                    System.out.print("\t");
                } else {
                    System.out.printf("%2d\t", data[i][j]);
                }
            }
            System.out.println();
        }

    }
}
