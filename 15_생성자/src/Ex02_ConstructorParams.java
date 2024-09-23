class Student {
    String name;
    int level;
    int age;

    Student( String n, int l, int a ){
        System.out.printf("----- %s의 생성자가 실행되었습니다 -----\n", n);
        name = n;
        level = l;
        age = a;
    }
}

public class Ex02_ConstructorParams {
    public static void main(String[] args) {
        Student s1 = new Student("보경", 1, 20);
        Student s2 = new Student("해민", 2, 21);
        
        System.out.printf("%s, %d학년, %d세 \n", s1.name, s1.level, s1.age);
        System.out.printf("%s, %d학년, %d세 \n", s2.name, s2.level, s2.age);
    }
}