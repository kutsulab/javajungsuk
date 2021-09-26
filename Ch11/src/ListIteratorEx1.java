
import java.util.*;

public class ListIteratorEx1 {

	/* Java의 정석 3판 p.618 예제 11-14
	 * 
	 * [ListIterator]
	 * List 인터페이스를 구현한 컬렉션만 사용할 수 있음
	 * Iterator에서는 이전 요소에 접근할 수 없었는데, ListIterator는 이전 요소에도 접근할 수 있다.
	 * 생성 : .listIterator()
	 * 
	 * 1. hasPrevious() : 이전 객체를 가지고 있는지 확인
	 * 2. previous() : 이전 객체를 불러옴
	 * 3. nextIndex() : 다음 요소의 index를 반환
	 * 4. previousIndex() : 이전 요소의 index를 반환
	 */
	
	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		ListIterator lit = list.listIterator(); // ListIterator 객체 생성
		
		while(lit.hasNext()) {//다음 객체가 있는지 확인하고 없을 때까지 계속 불러온다.
			System.out.print(lit.next());
		}
		System.out.println();
		
		while(lit.hasPrevious()) { // 이전 객체가 있는지 확인하고 없을 때까지 계속 불러온다.
			System.out.print(lit.previous());
		}
		System.out.println();
	}

}
