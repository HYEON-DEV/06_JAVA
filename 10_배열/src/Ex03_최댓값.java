public class Ex03_최댓값 {
    public static void main(String[] args) {
        int[] data = {5,2,7,9,2};
        int max = data[0];

        for ( int i=1; i<data.length; i++ ) {
            System.out.printf("max=%d   data[%d]=%d\n", max, i, data[i]);
            
            if ( max < data[i] ) {
                max = data[i];
            }
        }

        System.out.println("최댓값 = " + max );
    }
}
