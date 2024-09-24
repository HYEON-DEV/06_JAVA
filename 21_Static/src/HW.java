public class HW {
    private static HW current;

    public static HW getInstance() {
        if (current == null) {
            current = new HW();
        }

        return current;
    }

    private HW() {
        super();
    }

    
}