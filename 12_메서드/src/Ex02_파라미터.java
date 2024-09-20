public class Ex02_파라미터 {
    public static void main(String[] args) {
        f(100);
    }

    public static void f( int x ) {
        int y = x+1;
        System.out.printf("f(%d) = %d\n", x, y);
    }
}
