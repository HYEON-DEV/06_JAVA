public class Dragun extends Protoss {

    public Dragun(String name, int hp, int speed, int dps) {
        super(name, hp, speed, dps);
    }

    @Override
    public void move(String position) {
        System.out.printf("[Dragun]  %s가 %s까지  천천히  이동\n", this.getName(), position);
    }

    @Override
    public void attack(String target) {
        System.out.printf("[Dragun]  %s가 %s에  포탄 발사 >> 데미지: %d\n", this.getName(), target, this.getDps());
    }
    
}
