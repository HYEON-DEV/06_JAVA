public class Exercise_1 {
    public static void main(String[] args) {
        
        int x = 0;
        int sum = 0;

        while ( x < 101 ) {
            sum += x;
            System.out.printf("x=%4d, sum=%4d\n", x, sum);
            x += 2;
        }
        System.out.println();
        System.out.println(sum);
    }
}
