class Student {
    private String name;
    private int point;

    public Student( String name, int point ){
        this.setName(name);
        this.setPoint(point);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return this.point;
    }

    public void setPoint(int point){
        if ( point<0 ){
            point = 0;
        } else if ( point>100 ){
            point = 100;
        }
        this.point = point;
    }

    String getValues() {
        return String.format("이름: %s, 점수: %d", name, point);
    }
}

public class Ex02_멤버변수_은닉 {
    public static void main(String[] args) {
        Student s = new Student("성주", -50);
        System.out.println(s.getValues());

        s.setPoint(12344);
        System.out.println(s.getValues());
    }
}

