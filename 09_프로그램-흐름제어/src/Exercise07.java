public class Exercise07 {
    public static void main(String[] args) {
       double h = 100;
       int i=0;
 
       while (true) {
            i++;
            h *= 3.0/5.0;
            System.out.printf("%d번째 : %f\n", i, h);
            
            if ( (int)h == 0 ) {
                i--;
                break;
            }
       }

       System.out.printf("%d번 튀어오른다", i); 
    }
}
