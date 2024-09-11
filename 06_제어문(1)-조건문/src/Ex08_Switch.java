public class Ex08_Switch {
    public static void main(String[] args) {
        String grade = "B";

        switch (grade) {
            case "A":
                System.out.println("91~100 사이");
                break;
            case "B":
                System.out.println("81~90 사이");
                break;
            case "C":
                System.out.println("71~80 사이");
                break;
            default:
                System.out.println("70 이하");
                break;
        }
    }
}
