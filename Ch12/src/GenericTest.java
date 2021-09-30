
import java.util.*;

public class GenericTest {

	/* Java의 정석 3판 p.670
	 * 
	 * [지네릭스]
	 *  다양한 타입의 객체들을 다루는 메서드나 컬렉션 클래스에 컴파일 시 타입체크 (compile-time type check)를 해주는 기능
	 *   - 예 : ArrayList<Object> : Object 타입 또는 Object 타입의 자손 객체들을 Object 타입으로 형변환하여 저장.
	 *   - 예 : ArrayList<Integer> : Integer 타입으로만 저장받도록 명시
	 *   - 예 : ArrayList<String> : String 타입으로만 저장받도록 명시
	 *     
	 * [지네릭스의 장점]
	 *  - 타입 안정성 제공 (다루는 객체의 타입을 미리 명시)
	 *  - 타입체크, 형변환 생략 -> 코드가 간결해짐
	 *  - 런타임 시 발생하는 에러 RuntimeException을 컴파일 에러로 끌어옴으로서, 개발 단계에서 사전에 오류를 방지하는데 도움이 된다.
	 * 
	 * [지네릭스를 배웠으니, 앞으로는?]
	 *  - 지네릭 클래스들을 사용시, 입력 타입이 Object더라도 타입을 Object로 선언하는게 좋다.
	 *    예) ArrayList list -> ArrayList<Object> list
	 */
	
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList();
		list1.add(10); //list에 Integer 객체 10을 추가
		list1.add(20);
		list1.add("30"); // 숫자만 넣고 싶은데 String도 들어가서, 나중에 데이터를 다룰 때 혼동이 생길 가능성이 있음
		
		Integer l1_i0 = (Integer) list1.get(0);
		Integer l1_i1 = (Integer) list1.get(1);
		
		//Integer l1_i2 = (Integer) list1.get(2);
		// 컴파일에서 문제는 없지만, 실행 시 ClassCastException 발생 : String 객체는 Integer 타입으로 형변환 불가능
		// 컴파일러의 한계 - 컴파일러는 이 과정에서 Object 참조변수를 Integer로 형변환하는 것에 문법적 오류가 없다고 판단하지만, 실제로 무슨 객체가 있는지 체크할 수 없다.
		
		System.out.println("ArrayList list1 : "+list1);
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(10);
		list2.add(20);
		//list2.add("30");
		//list2에 저장할 수 있는 객체 타입이 Integer로 제한되어있기 때문에,String 객체를 저장할 수 없다.
		//지네릭스 덕분에 타입 체크가 강화됨.
		
		Integer l2_i0 = list2.get(0); // 이미 list2의 저장 타입이 Integer로 제한되어있기 때문에 객체를 꺼낼 때도 Integer로 반환된다. -> 코드가 간결해짐 
		Integer l2_i1 = list2.get(1);
		
		System.out.println("ArrayList<Integer> list2 : "+list2);
		
	}

}
