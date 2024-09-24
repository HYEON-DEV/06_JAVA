class StaticCounter {
    // 정적 멤버변수 --> 이 클래스에 대한 모든 객체가 공유하는 값
    static int count=0;

    public StaticCounter() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class Ex02_StaticCounter {
    public static void main(String[] args) {
        // 객체 생성
        // -> c1,c2가 접근하는 count 값은 서로 공유하는 데이터

        StaticCounter c1 = new StaticCounter();
        StaticCounter c2 = new StaticCounter();

        System.out.printf("c1의 count: %d\n", c1.getCount());
        System.out.printf("c2의 count: %d\n", c2.getCount());
    }
}
