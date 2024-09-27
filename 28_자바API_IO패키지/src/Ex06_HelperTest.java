import com.HYEON.helpers.FileHelper;

public class Ex06_HelperTest {
    public static void main(String[] args) {
        
        String filePath = "./helperTest2.txt";
        String content = "test2 test2 test2";

        // 저장 테스트
        try {
            FileHelper.getInstance().writeString(filePath, content);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            String read = FileHelper.getInstance().readString(filePath);
            System.out.println(read);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
