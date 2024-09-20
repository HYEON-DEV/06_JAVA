public class Ex02_배열복사 {
    public static void main(String[] args) {
        int[] origin = {1,2};
        int[] copy = origin;

        System.out.printf("origin[o] = %d\n", origin[0]);
        System.out.printf("origin[1] = %d\n", origin[1]);
        System.out.printf("copy[o] = %d\n", copy[0]);
        System.out.printf("copy[1] = %d\n", copy[1]);
        System.out.println();

        copy[0] += 100;
        copy[1] += 200;

        System.out.printf("origin[o] = %d\n", origin[0]);
        System.out.printf("origin[1] = %d\n", origin[1]);
        System.out.printf("copy[o] = %d\n", copy[0]);
        System.out.printf("copy[1] = %d\n", copy[1]);

        //  배열복사  -->  참조복사
    }
}
