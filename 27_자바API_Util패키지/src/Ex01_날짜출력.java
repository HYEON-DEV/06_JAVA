//  날짜 처리 기능을 제공하는 클래스 
import java.util.Calendar;

public class Ex01_날짜출력 {
    public static void main(String[] args) {
        
        //  Calendar 클래스 객체 생성 -> 싱글톤 객체
        //  컴퓨터 시각을 멤버변수로 복사한다
        Calendar cal = Calendar.getInstance();

        int yy = cal.get(Calendar.YEAR);
        int mm = cal.get(Calendar.MONTH) + 1;   // Java에서 월은 0부터 시작
        int dd = cal.get(Calendar.DAY_OF_MONTH);
        int hh = cal.get(Calendar.HOUR_OF_DAY);     // 24시간제
        int mi = cal.get(Calendar.MINUTE);
        int ss = cal.get(Calendar.SECOND);

        System.out.printf("%04d년 %02d월 %02d일 %02d시 %02d분 %02d초\n", yy, mm, dd, hh, mi, ss);

        
        hh = cal.get(Calendar.HOUR);    // 12시간제
        mi = cal.get(Calendar.MINUTE);
        ss = cal.get(Calendar.SECOND);

        int ampm = cal.get(Calendar.AM_PM); // 오전:0, 오후:1
        String[] apname = {"오전","오후"};
        System.out.printf("%04d년 %02d월 %02d일 %s %02d시 %02d분 %02d초", yy, mm, dd, apname[ampm], hh, mi, ss);
    }
}
