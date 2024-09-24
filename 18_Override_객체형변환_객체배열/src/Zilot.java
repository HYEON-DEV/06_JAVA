public class Zilot extends Protoss {
    
    public Zilot(String name, int hp, int speed, int dps) {
        super(name, hp, speed, dps);
    }

    // 자식 클래스의 객체를 통해 이 메서드 호출하면 부모 원본 비활성화
    @Override
    public void move(String position) { 
        //  부모 클래스의 멤버변수는 은닉된 상태이므로 접근 불가
        //  대신 부모 클래스의 getter setter가 상속되었으므로 이를 통해 데이터에 접근
        System.out.printf("[Zilot]  %s(이)가  %s까지  빠른 속도로 이동\n", this.getName(), position);
    }

    @Override
    public void attack(String target) {
        System.out.printf("[Zilot]  %s(이)가 %s(을)를 칼로 찌른다  >>  데미지: %d\n", this.getName(), target, this.getDps());
    }

    /**
     * Zilot 클래스가 독자적으로 갖는 고유 기능
     * @param target    공격할 대상
     */
    public void swardAttack(String target) {
        System.out.printf("[Zilot 고유스킬]  %s가 %s을 칼로 공격\n", this.getName(), target);
    }
}
