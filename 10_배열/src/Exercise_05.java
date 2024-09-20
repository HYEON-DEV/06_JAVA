public class Exercise_05 {
    public static void main(String[] args) {
        int[] price = { 38000, 20000, 17900, 17900 };
        int[] qty = { 6, 4, 3, 5 };
        int[] money = new int[4];
        int cnt = 0;

        for ( int i=0; i<price.length; i++ ) {
            money[i] = price[i] * qty[i];

            cnt = money[i]>=80000? ++cnt : cnt;
        }

        System.out.printf("무료배송 : %d 개\n", cnt);
    }
}
