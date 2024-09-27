import java.io.File;

public class Ex01_File {
    public static void main(String[] args) {

        // 상대경로의 경우 현재 프로젝트 폴더가 기준이 된다
        File f1 = new File("./test.txt");

        boolean is_file = f1.isFile();
        System.out.printf("isFile = %b\n\n", is_file);

        boolean is_dir = f1.isDirectory();
        System.out.printf("isDirectory = %b\n\n", is_dir);

        boolean is_hidden = f1.isHidden();
        System.out.printf("isHidden = %b\n\n", is_hidden);

        String abs = f1.getAbsolutePath();
        System.out.printf("절대경로 = %s\n\n", abs);

        // 파일이나 디렉토리가 물리적으로 존재하는지 검사
        boolean is_exist = f1.exists();
        System.out.printf("존재여부 = %b\n", is_exist);
    }
}
