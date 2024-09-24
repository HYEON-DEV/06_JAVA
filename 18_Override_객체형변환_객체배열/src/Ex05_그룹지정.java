public class Ex05_그룹지정 {
   public static void main(String[] args) {
    
        Protoss[] p = new Protoss[5];

        p[0] = new Zilot("질럿1호", 130,90,100);
        p[1] = new Dragun("드라군1호", 130,90,100);
        p[2] = new Zilot("질럿2호", 130,90,100);
        p[3] = new Dragun("드라군2호", 130,90,100);
        p[4] = new Zilot("질럿3호", 130,90,100);
        System.out.println();

        for ( int i=0; i<p.length; i++ ) {
            //  부모클래스형태로 boxing되더라도 자식들이 override한 고유기능 유지됨
            p[i].move("저그본진");
            p[i].attack("저그본진");

            // 각자가 갖는 고유기능은 사용할 수 X
            //  고유기능 사용을 위해서는 원래 형태로 되돌려야 한다
            //  instanceof  :  해당 객체의 원래 형태가 무엇인지 검사
            if ( p[i] instanceof Zilot ) {
                Zilot z = (Zilot) p[i];
                z.swardAttack("저그본진");
            } else if ( p[i] instanceof Dragun ) {
                Dragun d = (Dragun) p[i];
                d.fireAttack("저그본진");
            }
        }
        System.out.println();
   } 
}
