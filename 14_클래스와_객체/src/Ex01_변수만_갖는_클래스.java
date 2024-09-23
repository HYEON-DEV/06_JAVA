class Member {
    String userName = "이름";
    String email = "이메일";
    int age = 0;
}

public class Ex01_변수만_갖는_클래스 {
    public static void main(String[] args) {
        
        Member m1 = new Member();
        System.out.println(m1.userName);
        System.out.println(m1.email);
        System.out.println(m1.age);

        Member m2 = new Member();
        System.out.println(m2.userName);
        System.out.println(m2.email);
        System.out.println(m2.age);

        m1.userName = "창기";
        m1.email = "ck@gmail.com";
        m1.age = 20;

        m2.userName = "보경";
        m2.email = "bk@gmail.com";
        m2.age = 21;

        System.out.println(m1.userName);
        System.out.println(m1.email);
        System.out.println(m1.age);

        System.out.println(m2.userName);
        System.out.println(m2.email);
        System.out.println(m2.age);
    }
}
