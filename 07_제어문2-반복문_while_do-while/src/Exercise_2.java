public class Exercise_2 {
    public static void main(String[] args) {
        int i = 1;
        int j = 1;

        while ( i < 11 ) {
            j *= 2;
            System.out.printf("이진수 %2d개는 %4d개의 정보를 표시가능\n", i, j );
            i++;
        }
    }
}
