import java.util.Map;
import java.util.HashMap;

public class Ex07_Map {
    public static void main(String[] args) {
        
        // Map : 자료를 key-value 쌍으로 보관할 수 있는 객체

        // Map 객체 생성
        // key, value 로 사용할 값에 대한 데이터 타입을
        // 객체 선언시 <key, value> 형식으로 명시 --> "제너릭"
        // 기본 자료형을 사용할 경우 WrapperClass 로 선언한다

        Map<String, Integer> map = new HashMap<String,Integer>();

        map.put("나이", 27);
        map.put("키", 163);
        map.put("몸무게", 53);

        System.out.printf("\n저장된 데이터의 수 : %d\n\n", map.size());
        System.out.println(map);
        System.out.printf("\nAGE : %d\n", map.get("나이"));
        
    }
}
