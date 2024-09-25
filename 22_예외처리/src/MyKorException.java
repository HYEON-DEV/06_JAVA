public class MyKorException extends Exception {

    public MyKorException() {   // 기본생성자
        super("국어 점수가 범위를 벗어났습니다");   // 부모 클래스 Exception의 생성자 호출
    }

    public MyKorException(String message) {     // message를 인자로 받는 생성자
        super(message);     //전달받은 메시지를 부모 클래스의 생성자에 전달하여 설정
    }
}
