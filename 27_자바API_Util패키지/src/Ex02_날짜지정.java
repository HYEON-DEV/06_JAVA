import java.util.Calendar;

import com.HYEON.helpers.DatePrinter;

public class Ex02_날짜지정 {
   public static void main(String[] args) {
      Calendar cal = Calendar.getInstance();
      DatePrinter.printDateTime(cal);
      
      cal.set(Calendar.YEAR, 2025);
      cal.set(Calendar.MONTH, 2);   //  -> 3월 (Java는 0부터 월 관리)
      cal.set(Calendar.DAY_OF_MONTH, 15);
      cal.set(Calendar.HOUR_OF_DAY, 13);
      cal.set(Calendar.MINUTE, 30);
      cal.set(Calendar.SECOND, 33);
      DatePrinter.printDateTime(cal);
      
      cal.set(1997,03,15);
      DatePrinter.printDateTime(cal);

      cal.set(2024,03,17,19,11,13);  // 24시간제만 가능
      DatePrinter.printDateTime(cal);
    
   } 
}
