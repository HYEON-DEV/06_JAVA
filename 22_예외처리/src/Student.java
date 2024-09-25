public class Student {
    private String name;
    private int kor;
    private int math;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return this.kor;
    }

    public void setKor(int kor) throws MyKorException {
        if (kor<0 || kor>100) {
            throw new MyKorException();
            //  에러를 강제로 발생시킨다
            //  throw 명령은 try~catch 구문으로 감싸지거나
            //  throw 명령을 사용하는 메서드는 throws를 통해 강제로 발생하는 에러에 대한 처리를 호출하는 위치로 떠넘겨야 한다
        }        
        this.kor = kor;
    }

    public int getMath() {
        return this.math;
    }

    public void setMath(int math) throws MyMathException {
        if (math<0) {
            throw new MyMathException("수학 점수가 0보다 작다");
        }
        else if (math>100) {
            throw new MyMathException("수학 점수가 100보다 크다");
        }
        this.math = math;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", kor='" + getKor() + "'" +
            ", math='" + getMath() + "'" +
            "}";
    }

}
