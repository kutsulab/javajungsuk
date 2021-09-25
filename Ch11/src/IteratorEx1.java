
import java.util.*;

public class IteratorEx1 {
	
	/* Java의 정석 3판 p.616 예제 11-13 : 컬렉션에 저장된 데이터에 접근하기 위해 사용하는 인터페이스 Iterator
	 *  
	 *  [Enumeration, Iterator, ListIterator]
	 *  - Enumeration : 구버전
	 *  - Iterator : Enumeration의 개선판
	 *  - ListIterator : Iterator + 양방향 읽기 가능 (List를 구현한 인터페이스를 구현한 컬렉션에만 사용 가능)
	 *  
	 *  [Iterator]
	 *  - 컬렉션에 저장된 데이터에 접근하는데 사용되는 인터페이스
	 *  - List, Set, Map은 각각 저장된 객체들에 접근할 때 각기 다른 메서드들을 사용한다.
	 *  - Iterator를 통해 저장 객체를 읽어오는 방식을 표준화 가능함 
	 *  - Collection 인터페이스에는 iterator() 메서드가 존재함 -> 컬렉션 클래스에 대해 Iterator 객체를 반환함
	 *  
	 *  [Iterator의 메서드]
	 *   - .hasNext() : 다음 객체가 있는지 boolean 타입으로 반환함
	 *   - .next() : 다음 객체를 반환함
	 *   - .remove() : next()로 읽어온 요소를 삭제. next()를 호출 후에 remove()를 호출해야함. (선택적 기능)
	 *  
	 *  [Map 인터페이스를 구현한 컬렉션은?]
	 *  - Map 인터페이스는 Collection 인터페이스로부터 상속받지 않았기 때문에 .iterator() 메서드를 사용할 수 없다.
	 *  - keySet() 메서드를 통해 key들을 Set으로 반환받은 뒤 iterator() 메서드를 사용하거나
	 *  - values() 메서드를 통해 value들을 Collection으로 반환받은 뒤 iterator() 메서드를 사용하거나
	 *  - entrySet() 메서드를 통해 key-value 쌍들을 Set으로 반환받은 뒤 iterator() 메서드를 사용함으로서 Iterator 사용
	 * 
	 */
	

	public static void main(String[] args) {
		Collection c = new ArrayList();
		
		// Collection c = new HashSet();
		// Collection c = new TreeSet();
		// Collection으로 받으면 다른 타입의 컬렉션 인스턴스를 사용하더라도 이후의 코드를 변경할 필요가 없어짐.
		// 유지, 보수 등에서 편의성을 고려했을 때 Collection으로 받고 Collection을 기준으로 코드를 작성하면 편리해짐
		
		c.add("1");
		c.add("2");
		c.add("3");
		c.add("4");
		c.add("5");
		
		Iterator it = c.iterator(); // 1회용
		
		while(it.hasNext()) {
			Object obj = it.next(); // 다음 객체를 순서대로 읽어옴
			System.out.println(obj);
		}

		// 위에서 이미 모든 객체를 읽었기 때문에 it.hasNext()가 false
		// 즉 Iterator는 모든 기능을 다하고 더 이상 기능할 수 없기 때문에 또 사용하려면 새로운 Iterator 객체를 호출해서 사용해야한다.
		it = c.iterator();
		
		while(it.hasNext()) { 
			Object obj = it.next(); // 다음 객체를 순서대로 읽어옴
			System.out.println(obj);
		}
		
		
	}

}
