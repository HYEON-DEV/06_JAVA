class HelloWorld {
    String message;

    void sayHello() { System.out.println(message); }
    void setEng() { message = "Hello"; }
    void setKor() { message = "안녕"; }
}

public class Ex03_메서드와_변수를_갖는_클래스 {
    public static void main(String[] args) {
        
        HelloWorld hw = new HelloWorld();
        
        hw.setKor();
        hw.sayHello();

        hw.setEng();
        hw.sayHello();
    }
}

