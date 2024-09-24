class StaticCounter2 {
    static int count=0;     //  static은 객체가 생성되지 않더라도 존재하는 값
    boolean created=false;  //  일반 멤버변수는 객체가 생성돼야만 존재하게 되는 값

    public StaticCounter2() {
        count++;
        created=true;
    }

    /** static 변수를 리턴하는 일반 메서드 */
    //  객체가 생성돼야만 활성화되는 기능
    public int getNormal() {
        created=true;
        return count;
    }

    /** static 변수를 리턴하는 static 메서드 */
    //  객체가 생성되지 않더라도 활성화 돼있는 기능
    public static int getStatic() {
        //  static 기능이 활성화 된 시점에는 객체가 생성돼있지 않을 수도 있기 때문에 일반 기능이 반드시 존재한다는 보장은 없다
        //  static 메서드에서는 일반 변수는 접근 불가
        // created = true;  ->  에러
        return count;
    }
}

public class Ex03_StaticMethod {
    public static void main(String[] args) {
        
        // static 변수에 대한 직접 접근
        // -> 특정 객체에 속해 있는 형태가 아니므로 객체 생성 전에도 클래스 이름을 통해 사용 가능
        System.out.printf("전체 객체 수: %d\n", StaticCounter2.count);
        System.out.println();

        StaticCounter2 c1 = new StaticCounter2();
        StaticCounter2 c2 = new StaticCounter2();

        System.out.printf("c1의 getNormal() 리턴값: %d\n", c1.getNormal());
        System.out.printf("c2의 getNormal() 리턴값: %d\n", c2.getNormal());
        System.out.println();

        System.out.printf("c1의 getStatic() 리턴값: %d\n", StaticCounter2.getStatic());
        System.out.printf("c2의 getStatic() 리턴값: %d\n", StaticCounter2.getStatic());
        System.out.println();

        System.out.printf("전체 객체의 수: %d\n", StaticCounter2.count);
    }
}
