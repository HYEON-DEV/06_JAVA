
public class Ex04_에러상황의_세분화 {
    public static void main(String[] args) {
        int[] data = {100,200,300};

        try {
            for (int i=2; i>=-1; i--) {
                int k = i!=0? data[i]/i : i;
                System.out.println(k);
            }
        } catch (ArrayIndexOutOfBoundsException e1) {
            //  에러의 경우에 수에 따라 여러개 정의하면 상황별로 에러 구분하여 대응할 수 있다
            System.out.println("배열의 인덱스를 초과했습니다");
        } catch (ArithmeticException e2) {
            System.out.println("잘못된 연산입니다");
        } catch (Exception e) {
            // Exception 클래스는 Java의 모든 예외 클래스에 대한 최상위 클래스
            // Exception 객체를 선언하여 모든 에러 상황들이 Exception 형태로 암묵적 형변환 된다
            // 모든 예외상황에 대응한 후 마지막에 알 수 없는 에러에 대한 대비책으로 명시해 둘 수 있다
            System.out.println("알 수 없는 에러 발생");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("---FIN---");
        }
    }
}
