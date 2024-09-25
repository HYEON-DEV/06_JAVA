/**
 * 1) 파일 복사를 수행하는 기능에서 하드디스크의 용량이 가득 찬 경우
 * 2) 다운로드를 수행하는 기능에서 인터넷 접속이 끊긴 경우
 * 3) USB에 파일을 저장하는 과정에서 USB의 연결이 강제로 해제된 경우
 * 
 * 위와 같은 상황은 if문으로 해결이 어렵기 때문에
 * 자바에서는 예외 상황에 대처하기 위한 try catch finally 문법 제공
 */

public class Ex03_예외처리 {
    public static void main(String[] args) {
        
        int[] k = {10,20,30};

        try {
            //  에러가 발생할 것으로 예상되는 코드를 try블록으로 감싸기
            for ( int i=0; i<5; i++ ) {
                System.out.println(k[i]);
            }
        } catch (Exception e) {
                /** 
                 * try 블록 안에서 에러가 발생하는 경우 실행되는 블록
                 * try 는 항상 catch와 함께 명시돼야 함
                 * try 블록 수행하는 과정에서 에러 발생하면 프로그램 다운되지 않고 그 즉시 catch블록으로 제어가 이동된다
                 */
                System.out.println("에러 발생");
                System.out.println("에러 원인: " + e.getMessage());

                //  시스템에 의해 출력되는 에러메시지 전문을 강제로 출력
                System.out.println("====================");
                e.printStackTrace();
                System.out.println("====================");
        } finally {
            //  에러 발생 여부에 상관없이 무조건 실행되는 블록
            //  생략가능
            System.out.println("finish");
        }
        System.out.println("---FIN---");
    }
}
