public class Ex03_MemberJoinTest {
    public static void main(String[] args) {
        
        Member s = new Member("민재", 20);

        String name = s.getName();
        System.out.println("이름: " + name);

        System.out.println("나이 " + s.getAge());        
    }
}
