public class Dragun extends Protoss {
    /**
     * 생성자는 상속되지 않는다.
     * 하지만 부모 클래스가 기본 생성자가 아닌 다른 형태의 생성자를 갖고 있는 경우 그 생성자는 반드시 실행되어야만 한다.
     * 그렇지 않으면 부모의 멤버변수는 초기화될 수 없다.
     * 자식 클래스는 자신의 생성자를 통해 부모의 생성자를 강제로 호출해야 한다
     * 부모 생성자가 파라미터를 받는다면 자식 클래스는 자신이 부모와 동일한 파라미터를 받는 생성자를 정의하고 자신의 생성자로 주입되는 파라미터를 부모에게 전달해야 한다
     */
    public Dragun(String name, int hp, int speed, int dps) {
        super(name, hp, speed, dps);
    }

    //  Override를 처리하는 과정에서 발생할 수 있는 오타 방지를 위한 옵션
    @Override
    public void attack(String target) {
        // super  :  부모클래스
        // -> super.메서드  :  부모가 갖는 원본 메서드
        super.attack(target);
        
        //  부모의 원본 메서드 실행 후 기능 추가
        System.out.println("[Dragun] >>> 원거리 공격 포탄 발사 !!! >>>");
    }

    @Override
    public void move(String position) { 
        super.move(position);
        System.out.println("[Dragun] >>> 지정된 위치까지 지상으로 이동 !!! >>>");
    }

    /**
     * 드라군이 독자적으로 갖는 고유 기능
     * @param target    공격할 대상
     */
    public void fireAttack(String target) {
        System.out.printf("[Dragun 고유스킬]  %s가 %s에게 포탄 발사\n", this.getName(), target);
    }
}
