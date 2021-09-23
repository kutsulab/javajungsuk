
import java.util.*;

public class ArrayListLinkedListTest2 {
	
	/* Java의 정석 3판 p.602 예제 11-6
	 * 
	 * [배열기반 자료구조 ArrayList vs 연결기반 자료구조 LinkedList간의 접근성 차이]
	 * 
	 * - ArrayList는 개별 객체에 접근할 때
	 *    인덱스가 n인 데이터의 주소 = 배열의 주소 + n * 데이터 타입의 크기
	 *    를 통하여 객체 주소에 접근하기 때문에 접근이 빠르다.
	 * - LinkedList는 개별 객체에 접근할 때
	 *    첫번째 노드 - 다음 노드 - 다음 노드 - ... 인덱스가 n인 노드
	 *    의 방식을 거쳐서 접근해야 원하는 데이터에 접근하기 떄문에 접근이 느리다.
	 *    
	 * [어떻게 활용할 것인가?]
	 *  - 컬렉션 프레임웍끼리는 데이터의 호환이 용이하므로 (생성자에서 다른 컬렉션을 활용) 간단히 다른 컬렉션 클래스로 전환해서 사용 가능.
	 *  - 작업하기 전 배열의 순차적 추가 삭제, 접근은 ArrayList를 통하여 하면 성능이 좋다.
	 *  - 중간 작업 (배열의 중간 데이터 추가 및 삭제, 변경)은 Linked List에 옮겨서 작업하면 성능이 좋다.
	 *  
	 */
	
	public static void main(String[] args) {
		ArrayList al = new ArrayList(1000000);
		LinkedList ll = new LinkedList();
		
		add(al);
		add(ll);
		
		System.out.println("=========접근시간 테스트=======");
		System.out.println("ArrayList : "+access(al)+"ms"); // 개별 데이터의 접근성능은 ArrayList가 더 빠르다. 
		System.out.println("LinkedList : "+access(ll)+"ms");
	}
	
	private static void add(List list) { //성능 테스트를 위하여 객체를 10만개 추가
		for (int i=0; i<100000; i++) {
			list.add(String.valueOf(i)); 
		}
	}
	
	private static long access(List list) {
		long start = System.currentTimeMillis();
		for (int i=0; i<10000; i++) {
			list.get(i); // 각 객체에 접근
		}
		long end = System.currentTimeMillis();
		return end-start; // 시작 시점, 종료시점의 시간차를 반환
	}

}
