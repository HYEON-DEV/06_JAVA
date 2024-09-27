import java.io.File;

public class Ex02_File2 {
    public static void main(String[] args) {
        
        File f2 = new File("a/b/c/target");
        System.out.println("isFile : " + f2.isFile());
        System.out.println("isDirectory : " + f2.isDirectory());
        System.out.println("isHidden : " + f2.isHidden());
        System.out.println("절대경로 : " + f2.getAbsolutePath());
        System.out.println("존재여부 : " + f2.exists());

        // mkdir()  -->  최종폴더만 생성하려고 함

        f2.mkdirs();

        // 마지막 "/" 이후 단어 리턴
        System.out.println(f2.getName());

        // 처음부터 마지막 "/" 직전까지 리턴
        System.out.println(f2.getParent());

        boolean del_ok = f2.delete();
        System.out.println("삭제성공여부 : " + del_ok);
    }
}
