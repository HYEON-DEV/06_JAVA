public class Ex06_사용자정의예외 {
    public static void main(String[] args) {
        
        Student s = new Student();

        s.setName("범석");
        
        try {
            s.setKor(-123);
        } catch (MyKorException e) {
            // 에러메시지용 출력문
            System.err.println("[MyKorException] >> " + e.getMessage());
        }

        try {
            s.setKor(123);
        } catch (MyKorException e) {
            System.err.println("[MyKorException] >> " + e.getMessage());
        }

        try {
            s.setMath(-1);
        } catch (MyMathException e) {
            System.err.println("[MyMatException] >> " + e.getMessage());
        }

        try {
            s.setMath(101);
        } catch (MyMathException e) {
            System.err.println("[MyMatException] >> " + e.getMessage());
        }

        System.out.println(s.toString());
    }   
}
