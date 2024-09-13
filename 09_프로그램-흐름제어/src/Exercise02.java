public class Exercise02 {
    public static void main(String[] args) {
        for ( int i=0; i<4; i++ ) {
            for ( int j=0; j<4; j++ ) {
                System.out.printf("%d ", i+j);
            }
            System.out.println();
        }

        for ( int i=0; i<4; i++ ) {
            for ( int j=i; j<i+4; j++ ) {
                System.out.printf("%d ", j);
            }
            System.out.println();
        }
    }
}
