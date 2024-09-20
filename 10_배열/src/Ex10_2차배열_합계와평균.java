public class Ex10_2차배열_합계와평균 {
    public static void main(String[] args) {
        String[] names = {"창기","민재","보경"};

        int[][] grade = {
            { 92, 81,76 }, 
            { 72, 95, 84 },
            { 80, 86, 98 }
        };

        int sum = 0;

        for ( int i=0; i<grade.length; i++ ) {
            int personalSum = 0;

            for ( int j=0; j<grade[i].length; j++ ) {
                sum += grade[i][j];
                personalSum += grade[i][j];
            }

            int personalAvg = personalSum / grade[i].length;
            System.out.printf("");
        }
    }
}
