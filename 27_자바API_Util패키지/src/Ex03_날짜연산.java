import java.util.Calendar;

import com.HYEON.helpers.DatePrinter;

public class Ex03_날짜연산 {
    public static void main(String[] args) {

        Calendar cal = Calendar.getInstance();
        DatePrinter.printDateTime(cal);

        cal.add(Calendar.DAY_OF_MONTH, 100);
        DatePrinter.printDateTime(cal);

        cal.add(Calendar.DAY_OF_MONTH, -200);
        DatePrinter.printDateTime(cal);

        cal.add(Calendar.HOUR, 7);
        DatePrinter.printDateTime(cal);

        cal.add(Calendar.MONTH, 8);
        DatePrinter.printDateTime(cal);
    }
}
