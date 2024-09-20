public class Exercise_08 {
    public static void main(String[] args) {
        String[] names = {"재석","민영","종민","광수","승기","새정"};
        int[] points = {82,91,54,62,88,90};

        for ( int i=0; i<points.length-1; i++ ) {
            for ( int j=0; j<points.length-1-i; j++ ) {
                if ( points[j] < points[j+1] ) {
                    int tmp = points[j];
                    points[j] = points[j+1];
                    points[j+1] = tmp;

                    String tmp2 = names[j];
                    names[j] = names[j+1];
                    names[j+1] = tmp2;
                }
            }
        }

        System.out.print("점수 높은 순  :  ");
        for ( int i=0; i<names.length; i++ ) {
            System.out.print(names[i] + "\t");
        }
        System.out.println();
    }
}
