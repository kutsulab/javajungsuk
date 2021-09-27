
import java.util.*;


public class HashSetEx1 {

	/*	Java의 정석 3판 p.632 예제 11-20 : HashSet
	 *  
	 *  [HashSet]
	 *   Set 인터페이스를 구현한 컬렉션
	 *   중복을 허용하지 않고, 순서가 없다.
	 *   
	 *   1. 생성자
	 *   - HashSet()
	 *   - HashSet(Collection c) : 지정 컬렉션을 포함하는 HashSet 객체 생성
	 *   - HashSet(int initialCapacity) : 초기용량 지정
	 *   - HashSet(int initialCapacity, float loadFactor)
	 *       (cf) loadFactor은? : 컬렉션 클래스에 저장공간이 가득차기 전에 미리 용량을 확보하기 위해 지정하는 값
	 *                            저장공간이 지정 loadFactor를 넘었을 때 capacity가 2배 증가한다.
	 *                           예를 들어 디폴트 loadFactor은 0.75 즉 75%인데 저장공간이 이만큼 채워지면, capacity가 2배 증가한다.
	 *   2. 추가
	 *   - boolean add(Object o) : HashSet에 객체 추가
	 *   - boolean addAll(Colleciton c) : HashSet에 지정 컬렉션에 존재하는 모든 객체를 추가 (합집합)
	 *   
	 *   3. 삭제
	 *   - void clear() : HashSet에 존재하는 모든 객체를 삭제
	 *   - boolean remove(Object o) : 지정된 객체를 가지고 있으면 제거하고 true를 반환 (단일 객체 삭제) 
	 *   - boolean removeAll(Collection c) : 지정된 Collection에 포함된 모든 객체를 제거 (차집합)
	 *   - boolean retainAll(Collection c) : 지정된 Collection에 포함된 객체만 남기고 나머지 모든 객체를 제거 (교집합)
	 *  
	 *   4. 검색
	 *   - boolean contains(Object o) : 컬렉션이 지정 객체를 포함하고 있으면 true, 아니면 false
	 *   - boolean containsAll(Collection c) : 컬렉션이 지정 컬렉션의 모든 객체를 포함하고 있으면 true, 아니면 false
	 *  
	 *   5. 컬렉션 비교 (Collection에서 상속)
	 *   - boolean equals(Object o) : 동일한 컬렉션인지 비교
	 *   
	 *   6. 상태
	 *   - int size() : 저장된 객체의 갯수 반환
	 *   - int hashCode() : HashSet의 hashCode를 반환
	 *   - boolean isEmpty() : HashSet이 비어있으면 true, 아니면 false
	 *    
	 *   7. 배열로 반환
	 *   - Object[] toArray() : 컬렉션에 저장되어있는 객체들을 객체배열로 반환
	 *   - Object[] toArray(Object[] a) : 컬렉션에 저장되어 있는 객체들을 지정배열 a에 저장해서 반환
	 *   
	 *   8. 접근
	 *   - iterator() : Iterator 객체 반환
	 */
	
	public static void main(String[] args) {
		Object[] objArr = {"1", new Integer(1), "2", "2", "3", "3", "4", "4", "4"};
		Set set = new HashSet();
		
		for (int i=0; i<objArr.length; i++) {
			System.out.println(objArr[i]+" 추가 : "+set.add(objArr[i])); // 배열의 객체들을 모두 순서대로 저장. 중복되면 추가 안 됨
		}
		System.out.println();
		
		//HashSet에 저장된 객체들을 출력
		System.out.println("set : "+set); // HashSet은 저장순서를 유지하지 않기 때문에 출력문의 결과인 [1,1,2,3,4]만 봐서는 어떤 것이 "1"인지 알 수 없다.
		System.out.println();
		
		//HashSet에 접근하는 iterator() 객체 생성
		Iterator ir = set.iterator();
		
		while(ir.hasNext()) {
			System.out.println(ir.next()); // 요소들을 읽어오지만, HashSet은 저장순서를 유지하지 않음 -> 저장순서 그대로 출력되는지의 여부가 보장되지 않음 
		}
		
	}

}
