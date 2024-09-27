/**
 * 다양한 클래스의 객체를 보관할 수 있는 클래스
 * 보관하고자 하는 클래스의 종류별로 이 클래스를 여러개 만든느 번거로움을 대체하는 방법
 * 
 * 클래스 선언시 클래스 이름 옆에 <키워드>를 선언하면 해당 키워드를 클래스처럼 사용할 수 있다
 * 
 * 이 키워드는 객체 생성시 클래스 이름을 직접 정해줄 수 있다
 */


public class UseGen <T> {
    private T sample;

    public T getSample() {
        return this.sample;
    }

    public void setSample(T sample) {   // Sample1 sample = new Sample1();
        this.sample = sample;   // 
    }
}
