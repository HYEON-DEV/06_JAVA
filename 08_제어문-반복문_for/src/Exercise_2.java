public class Exercise_2 {
    public static void main(String[] args) {
        
        int bit = 1;
        for ( int i=1; i<11; i++ ) {
            bit *= 2;
            System.out.printf("이진수 %2d개는 %4d개의 정보를 표시가능\n", i, bit);
        }
    }
}
