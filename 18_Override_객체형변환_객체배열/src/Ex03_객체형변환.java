public class Ex03_객체형변환 {
    public static void main(String[] args) {
        
        Protoss p0 = new Protoss("프로브1호", 50, 30, 2);

        // 자식 객체로 생성 후 부모 형식의 객체에 참조
        Zilot z = new Zilot("질럿1호", 300, 150, 120);
        Protoss p1 = z;

        // 선언은 부모형식,  할당은 자식형식
        Protoss p2 = new Dragun("드라군1호", 280, 120, 170);

        System.out.println();

        // 부모 객체로 변환되더라도 자식클래스가 override한 기능은 유지된다
        p0.move("저그본진");
        p0.attack("저그본진");
        System.out.println();

        p1.move("저그본진");
        p1.attack("저그본진");
        System.out.println();

        p2.move("저그본진");
        p2.attack("저그본진");
        System.out.println();

    }
}
