public class Exercise_02 {
    public static void main(String[] args) {
        int[] time = {7,5,5,5,5,10,7};
        int money;
        int sum = 0;

        for ( int i=0; i<time.length; i++ ) {
            money = i<4? 4500 : 5200;
            sum += money * time[i];
        }

        System.out.println("총 급여 : " + sum);
    }
}
