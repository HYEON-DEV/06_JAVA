public class Ex05_자릿수지정 {
    public static void main(String[] args){
        System.out.printf("%10s\n", "java");
        System.out.printf("%10s\n", "java programming");

        System.out.printf("%5d\n", 123);
        //  5자리 보다 긴 경우 전체 출력
        System.out.printf("%5d\n", 1234567);

        System.out.printf("%010d\n", 12345);
        
        System.out.printf("%10f\n", 123.4567);
        System.out.printf("%010f\n", 123.4567);
        
        //  소수점 둘째자리까지만 출력
        System.out.printf("%.2f\n", 123.4567);
        //  소수점 자릿수, 10칸에서 오른쪽 정렬
        System.out.printf("%10.2f\n", 123.4567);
        //  소수점 자릿수, 빈자리 0으로 채우고 오른쪽 정렬
        System.out.printf("%010.2f", 123.4567);
    }
}
