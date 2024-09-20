public class Ex05_정렬 {
    public static void main(String[] args) {
        int[] data = {1,5,2,4,3};

        //  순차정렬

        for ( int i=0; i<data.length-1; i++ ) {
            for ( int j=i+1; j<data.length; j++) {
                if ( data[i] > data[j] ) {
                    int tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                }
            }
        }

        for ( int i=0; i<data.length; i++ ) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();


        //  버블정렬
        int[] data2 = {3,5,4,2,1};
        
        for ( int i=0; i<data2.length-1; i++ ) {
            for ( int j=0; j<data2.length-1-i; j++ ) {
                if ( data2[j] > data2[j+1] ) {
                    int tmp = data2[j];
                    data2[j] = data2[j+1];
                    data2[j+1] = tmp;
                }
            }
        }

        for ( int i=0; i<data2.length; i++ ) {
            System.out.print(data2[i] + "\t");
        }
        System.out.println();
    }
}
