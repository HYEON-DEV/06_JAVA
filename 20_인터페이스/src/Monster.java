public class Monster extends Unit implements IMove, IFight {

    public Monster(String name, int hp, int speed, int dps) {
        super(name, hp, speed, dps);
    }

    @Override
    public void attack() {
        System.out.printf("[Monster]  %s가 %d의 힘으로 주인공 공격\n", this.getName(), this.getDps());
    }

    @Override
    public void defense() {
        System.out.printf("[Monster]  %s가 주인공의 공격 방어\n", this.getName());
    }

    @Override
    public void evasion() {
        System.out.printf("[Monster]  %s가 주인공 공격 회피\n", this.getName());
    }

    @Override
    public void walk() {
        System.out.printf("[Monster]  %s가 주변을 배회\n", this.getName());
    }

    @Override
    public void run() {
        System.out.printf("[Monster]  %s가 주변을 뛰면서 배회\n", this.getName());
    }

    @Override
    public void jump() {
        System.out.printf("[Monster]  %s가 주변에서 점프\n", this.getName());
    }
    
}
