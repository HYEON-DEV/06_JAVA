public class Ex01_1차배열의_생성 {
    public static void main (String[] args){
        int[] arr1;

        arr1 = new int[3];

        for ( int i=0; i<arr1.length; i++ ) {
            System.out.printf("arr[%d]=%d\n", i, arr1[i]);
        }

        System.out.println("-------------------");


        int[] arr3 = {100,200,300,400};

        System.out.println(arr3);
        System.out.println("-------------------");

        
    }
}