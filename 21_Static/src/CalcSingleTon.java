public class CalcSingleTon {
    /** 은닉된 형태로 자기 자신에 대한 객체를 static 멤버변수로 선언 */
    // -> static 은 공유자원이므로 이 클래스의 객체가 몇 개가 생성되더라도 단 하나만 존재하게 된다
    private static CalcSingleTon current;

    private static int count=0;

    /** 불필요한 객체 생성 없이 static 객체를 할당하기 위한 static 메서드 */
    public static CalcSingleTon getInstance() {
        // 공유자원으로 설정한 객체가 할당되지 않았다면
        if (current == null) {  // null : 선언O 할당X
            current = new CalcSingleTon();  
            // 같은 클래스 안에서는 호출 가능하므로 이 소스 안에서 new를 사용하는 것은 허용됨
        }
        System.out.printf("현재 CalcSingleTon 클래스 객체 수: %d\n", count);
        return current;
    }

    /** 외부에서 new 키워드를 통한 객체 생성을 금지하기 위해 생성자를 은닉 */
    //  같은 클래스 안에서는 호출 가능하므로 이 소스 안에서 new를 사용하는 것은 허용됨
    private CalcSingleTon() {
        super();
        count++;
        System.out.println("CalcSingleTon에 대한 current 객체 생성됨");

        // 부모 클래스가 명시적으로 지정되지 않았기 때문에 기본적으로 Object 클래스를 상속받는다
        // 따라서 super()는 Object 클래스의 기본 생성자를 호출한다
        // 여기서는 super()는 사실상 생략해도 무방하다 
        // 아래와 같이 작성해도 동일한 동작한다
        // 명시적으로 포함되어 있는 것은 코드의 명확성을 높이는 방법일 수 있습니다
    }

    public int plus(int x, int y) { return x+y; }
    public int minus(int x, int y) { return x-y; }
    public int times(int x, int y) { return x*y; }
    public int divide(int x, int y) { return x/y; }
}
