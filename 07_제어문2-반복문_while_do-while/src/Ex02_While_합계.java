public class Ex02_While_합계 {
    public static void main(String[] args) {
        int sum = 0;
        int i=1;

        while (i<11) {
            sum += i;

            System.out.printf("i = %2d,  sum = %2d \n", i, sum);

            i++;
        }
    }
}
