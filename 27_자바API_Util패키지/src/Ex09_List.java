/**
 * ArrayList
 * 배열과 같이 인덱스 번호를 통해 자료를 관리하지만, 저장할 수 있는 데이터의 수가 무제한인 형태
 */

import java.util.ArrayList;
import java.util.List;

public class Ex09_List {
    public static void main(String[] args) {
        
        // 객체 생성시 제너릭 사용
        // 클래스 이름 오른쪽에 <자료형> 형식으로 표현한다
        // 이때 자료형에는 클래스타입만 가능하다
        // 기본 데이터형을 사용하고자 하는 경우에는 해당 데이터형의 Wrapper Class를 사용해야 한다

        List<Integer> numberList = new ArrayList<Integer>();
        
        for ( int i=0; i<9; i++ ) {
            numberList.add(10*(i+1));
        }
        System.out.println(numberList);

        System.out.println("데이터 크기 : " + numberList.size());

        System.out.println("4번째 요소 : " + numberList.get(4));

        numberList.remove(4);
        System.out.println(numberList);
        System.out.println("데이터 크기 : " + numberList.size());

        System.out.println("4번째 요소 : " + numberList.get(4));

        numberList.add(4, 123); // index 직전에 삽입
        System.out.println(numberList);
        System.out.println("데이터 크기 : " + numberList.size());

        for (int i=0; i< numberList.size(); i++) {
            Integer number = numberList.get(i); // 제너릭으로 선언한 클래스에 대한 객체가 된다
            System.out.printf("%d번재 데이터 >> %d\n", i, number);
        }

        numberList.clear();
        System.out.println("데이터 크기 : " + numberList.size());
    }
}
