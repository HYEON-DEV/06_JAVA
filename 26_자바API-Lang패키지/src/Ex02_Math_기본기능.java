public class Ex02_Math_기본기능 {
    public static void main(String[] args) {
        
        int max = Math.max(100, 999);
        System.out.println("최댓값 = " + max);

        int min = Math.min(100,999);
        System.out.println("최솟값 = " + min);

        int abs = Math.abs(-234);
        System.out.println("절댓값 = " + abs);

        long num = Math.round(3.1223344);
        System.out.println("소수점 반올림 = " + num);

        double rnd = Math.random();
        System.out.println("랜덤값 = " + rnd);
    }
}
