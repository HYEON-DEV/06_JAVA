public class Exercise_01 {
    public static void main(String[] args) {
        int[] grade = {75,82,91};
        int sum=0;

        for ( int i=0; i<grade.length; i++ ) {
            sum += grade[i];
        }

        int avg = sum / grade.length;

        System.out.printf("총점 : %d\n", sum);
        System.out.printf("평균 : %d\n", avg);
    }
}
