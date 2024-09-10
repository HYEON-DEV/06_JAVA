public class MyPrint {
    public static void main(String[] args) {
        int num;
        
        num = 10;
        System.out.println( num>0? "양수" : ( num<0? "음수" : "0" ) );

        num = -9;
        System.out.println( num>0? "양수" : ( num<0? "음수" : "0" ) );

        num = 0;
        System.out.println( num>0? "양수" : ( num<0? "음수" : "0" ) );
    }
}
