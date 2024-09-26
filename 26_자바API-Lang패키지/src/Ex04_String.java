
public class Ex04_String {
    public static void main(String[] args) {
        
        String msg = "Life is too short. You need Java!";
        System.out.println("문자열 : " + msg);

        int len = msg.length();
        System.out.println("문자열 길이 : " + len);

        char str2nd = msg.charAt(2);
        System.out.println("두 번째 글자 : " + str2nd);

        int p1 = msg.indexOf("f");
        System.out.println("f 가 처음 나타나는 위치 : " + p1);

        System.out.println("z 가 처음 나타나는 위치 : " + msg.indexOf("z"));

        System.out.println("short 가 처음 나타나는 위치 : " + msg.indexOf("short"));

        int p2 = msg.indexOf("i");
        int p3 = msg.indexOf("i", p2+1);
        System.out.println("i 가 첫 번째로 나타나는 위치 : " + p2);
        System.out.println("i 가 두 번째로 나타나는 위치 : " + p3);

        int p4 = msg.lastIndexOf("a");
        System.out.println("a 의 마지막 위치" + p4);

        if (msg.indexOf("Hello") > -1) {
            System.out.println("Hello 포함");
        } else {
            System.out.println("Hello 포함 X");
        }

        String substring1 = msg.substring(0, 18);
        System.out.println("문자열 자르기 : " + substring1);

        String substring2 = msg.substring(19);
        System.out.println("문자열 자르기 : " + substring2);

        String up = msg.toUpperCase();
        System.out.println("모든 글자의 대문자 변환 : " + up);

        String low = msg.toLowerCase();
        System.out.println("모든 글자의 소문자 변환 : " + low);

        String src1 = "     LG Twins     ";
        String src2 = src1.trim();
        System.out.printf("src1 = [%s]\n", src1);
        System.out.printf("src2 = [%s]\n", src2);

        String txt = "HTML,CSS,JAVASCRIPT";
        String[] arr = txt.split(",");
        for ( int i=0; i<arr.length; i++ ) {
            System.out.println(arr[i]);
        }

        String txt2 = txt.replace(",", "$");
        System.out.println(txt2);

        String txt3 = "Hello";
        System.out.println(txt3.equals("hello"));

        if ( txt3.equals("Hello")) {
            System.out.println("txt3는 Hello입니다");
        } else {
            System.out.println("txt3는 Hello 가 아닙니다");
        }
        
    }
}
