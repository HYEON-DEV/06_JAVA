public class Exercise_1 {
    public static void main(String[] args) {
        int sum=0;
        for ( int i=0; i<101; i+=2 ) {
            sum += i;
            System.out.printf( "i=%3d   sum=%3d\n", i, sum );
        }
    }
}