public class Exercise_06 {
    public static void main(String[] args) {
        int[] money = {209000,109000,119000,109000,94000};

        for ( int i=0; i<money.length-1; i++ ) {
            for ( int j=i+1; j<money.length; j++ ) {
                if ( money[i] > money[j] ) {
                    int tmp = money[i];
                    money[i] = money[j];
                    money[j] = tmp;
                }
            }
        }

        System.out.print("낮은가격순  :  ");
        for ( int i=0; i<money.length; i++ ) {
            System.out.print(money[i] + "\t");
        }
        System.out.println();
    }
}
