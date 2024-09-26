import java.util.Calendar;

public class Ex04_날짜기타 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

        int day = cal.get(Calendar.DAY_OF_WEEK);
        System.out.printf("요일 인덱스 : %d\n\n", day);

        String[] day_name = {"일","월","화","수","목","금","토"};
        System.out.printf("요일 : %s\n\n", day_name[day-1]);

        int week_count = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
        System.out.printf("이번 달은 %d주로 되어 있다.\n\n", week_count);

        int day_count = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.printf("이번 달은 %d일 까지 있다.\n\n", day_count);

        cal.set(Calendar.DAY_OF_MONTH, 1);
        int first_day = cal.get(Calendar.DAY_OF_WEEK);
        System.out.printf("이번 달의 시작 인덱스 : %d\n", first_day);
        System.out.printf("이번 달의 시작 요일 : %s\n", day_name[first_day-1]);
    }
}
