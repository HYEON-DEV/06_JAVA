
public class SingleTonPattern {
    private static SingleTonPattern current;

    public static SingleTonPattern getInstance() {
        if (current == null) {
            current = new SingleTonPattern();
        }

        return current;
    }

    private SingleTonPattern() {
        super();
    }

}
