public class Exercise_04 {
    public static void main(String[] args) {
        int[] price = { 38000, 20000, 17900, 17900 };
        int[] qty = { 6, 4, 3, 5 };
        int[] money = new int[4];
        //int money = 0;

        for ( int i=0; i<price.length; i++ ) {
            money[i] = price[i] * qty[i];
        }

        System.out.print("상품금액   :   ");
        for ( int i=0; i<money.length; i++ ) {
            System.out.print( money[i] + "\t" );
        }
        System.out.println();
        
        int max = money[0];

        for ( int i=1; i<money.length; i++ ) {
            if ( max < money[i] ) {
                max = money[i];
            }
        }

        System.out.println("최댓값 : " + max);
    }
}
