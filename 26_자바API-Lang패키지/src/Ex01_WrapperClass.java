public class Ex01_WrapperClass {
    public static void main(String[] args) {
        
        //  1) Wrapper 클래스의 기본특성
        //  Wrapper Class는 기본 데이터 타입과 완벽히 호환된다
        int number=100;
        Integer a = number;
        System.out.printf("a=%d\n", a);

        //  기존 방식  -->  (deprecated) 다음 버전부터 이 기능이 사라질 것이 예고됨
        Integer b = new Integer(number);
        System.out.printf("b=%d\n", b);

        int c = 100;
        System.out.println(a+c);

        //  2) Wrapper Class의 의의
        String s1 = "20";
        String s2 = "3.14";

        //  Wrapper Class의 가장 중요한 기능은 특정 데이터형의 모양을 하고 있는 문자열을 실제 데이터 형으로 변환하는 기능
        //  각 데이터 타입에 맞는 Wrapper Class 안에 static 메서드로 정의되어 있다
        int num_a = Integer.parseInt(s1);
        float num_b = Float.parseFloat(s2);

        int v1 = num_a + 500;
        float v2 = num_b + 500;
    }
}
