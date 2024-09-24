public class Ex04_SingleTonPattern {
    public static void main(String[] args) {
        
        int x=100;
        int y=50;

        //  일반 클래스의 경우 객체 생성에 아무런 제약이 없기 때문에 각각의 메서드를 호출할 때마다 새로운 객체를 생성할 수 있다  ->  메모리 낭비

        //  싱글톤 객체를 생성하여 활용하기
        /**
         * 1) 생성자가 은닉되어 있으므로 new 키워드 사용은 금지
         * 2) 객체는 반드시 getInstance() 메서드를 통해서 반환받아야 한다
         * CalcSingleTon 클래스 안에서 static(공유자원)으로 객체 선언하고,
         * null인 경우에만 할당하고 있으므로 1회만 객체 생성하고
         * 생성된 객체를 getInstance()메서드를 통해 돌려 사용한다
         */

         CalcSingleTon cs1 = CalcSingleTon.getInstance();
         System.out.printf("%d + %d = %d\n\n", x, y, cs1.plus(x,y));

         CalcSingleTon cs2 = CalcSingleTon.getInstance();
         System.out.printf("%d + %d = %d\n\n", x, y, cs2.minus(x,y));

         CalcSingleTon cs3 = CalcSingleTon.getInstance();
         System.out.printf("%d + %d = %d\n\n", x, y, cs3.times(x,y));

         CalcSingleTon cs4 = CalcSingleTon.getInstance();
         System.out.printf("%d + %d = %d\n\n", x, y, cs4.divide(x,y));

    }
}

