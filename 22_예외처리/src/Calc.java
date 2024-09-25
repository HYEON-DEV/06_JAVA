public class Calc {
    private static Calc current;

    public static Calc getInstance() {
        if (current == null) {
            current = new Calc();
        }

        return current;
    }

    private Calc() {
        super();
    }

    public int divide(int x, int y) {
        int z=0;

        try{
            z = x/y;
        } catch (Exception e) {
            System.out.println("[divide error] 0으로 나눌 수 없습니다");
        }

        return z;
    }

    public int divideEx(int x, int y) throws Exception {
        return x/y;
    }
    
}
