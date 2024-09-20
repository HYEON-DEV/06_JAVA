public class Ex01_값복사 {
    public static void main(String[] args) {
        int a = 10;
        int b = a;

        System.out.printf("a = %d\n", a);
        System.out.printf("b = %d\n", b);

        a += 10;

        System.out.printf("a = %d\n", a);
        System.out.printf("b = %d\n", b);

        b -= 10;

        System.out.printf("a = %d\n", a);
        System.out.printf("b = %d\n", b);
    }
}