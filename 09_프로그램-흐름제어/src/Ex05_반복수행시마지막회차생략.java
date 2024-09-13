public class Ex05_반복수행시마지막회차생략 {
    public static void main(String[] args) {
        for ( int i=0; i<10; i++ ) {
            if ( i+1 < 10 ) {
                System.out.printf("i = %d\n", i);
            }
        }
    }
}
