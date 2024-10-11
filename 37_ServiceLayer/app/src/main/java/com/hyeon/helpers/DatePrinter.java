package com.hyeon.helpers;

import java.util.Calendar;

public class DatePrinter {
    /**
     * 날짜 객체를 파라미터로 받아서 그 객체가 저장하고 있는 성분 값을 추출하여 출력하는 메서드
     * @param cal   Calendar 클래스의 객체
     * ( output ex: 2024년 09월 26일 12시 27분 19초 (24시간제) )
     */
    public static void printDateTime (Calendar cal) {
        int yy = cal.get(Calendar.YEAR);
        int mm = cal.get(Calendar.MONTH) + 1;
        int dd = cal.get(Calendar.DAY_OF_MONTH);
        int hh = cal.get(Calendar.HOUR_OF_DAY);     // 24시간제
        int mi = cal.get(Calendar.MINUTE);
        int ss = cal.get(Calendar.SECOND);

        System.out.printf("%04d년 %02d월 %02d일 %02d시 %02d분 %02d초\n", yy, mm, dd, hh, mi, ss);
    }
}
