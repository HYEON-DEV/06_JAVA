import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class Ex04_파일읽기 {
    public static void main(String[] args) {
        
        String filePath = "./test.txt";
        byte[] buffer = null;
        String content = null;
        // 파일 읽기
        InputStream is = null;

        try {
            is = new FileInputStream(filePath);
            // 파일의 크기(용량)만큼 byte[]이 사이즈 생성
            buffer = new byte[is.available()]; 
            // 파일 내용 buffer에 담기
            is.read(buffer);
        } catch (FileNotFoundException e) {
            System.err.println("[ERROR] " + e.getMessage());
            System.err.println("--------------------------");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("[ERROR] " + e.getMessage());
            System.err.println("--------------------------");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("[ERROR] " + e.getMessage());
            System.err.println("--------------------------");
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (buffer != null) {
            try {
                content = new String(buffer, "utf-8");
                System.out.println(content);
            } catch (UnsupportedEncodingException e) {
                System.out.println("[ERROR] 인코딩 지정 에러");
                e.printStackTrace();
            }
        }
        
    }
}
