public class Exercise_09 {
    public static void main(String[] args) {
        char[] cs = {'1','5','7','J','Q','A'};
        char[] yh = {'2','3','4','5','Q','K','A'};
        //Char[] arr = new Char[yh.length];
        int cnt = 0;

        for ( int i=0; i<yh.length; i++ ) {
            for ( int j=0; j<cs.length; j++ ) {
                if ( yh[i] == cs[j] ) {
                    cnt++;
                }
            }
        }

        System.out.printf("가져올 수 있는 카드의 수 : %d 장\n", cnt);

        for ( int i=0; i<yh.length; i++ ) {
            for ( int j=0; j<cs.length; j++ ) {
                if ( yh[i] == cs[j] ) {
                    System.out.printf("%d번째 >> %s\n", j, cs[j] );
                }
            }
        }

        System.out.println();
        
    }
}
