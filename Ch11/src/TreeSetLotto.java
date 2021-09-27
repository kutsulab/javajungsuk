
import java.util.*;

public class TreeSetLotto {
	
	/* Java의 정석 3판 p.641 예제 11-26
	 * 
	 * [TreeSet]
	 * - 이진탐색트리(binary search tree)를 통한 정렬
	 * 
	 * [이진 트리 (binary tree)]
	 * - 각 노드는 저장객체를 가진다.
	 * - 모든 노드는 최대 두개의 자식 노드(왼쪽, 오른쪽)를 가질 수 있다.
	 * - 제일 처음 저장한 객체를 루트(root)라고 한다.
	 * 
	 * [이진탐색트리 (binary search tree)]
	 * - 이진트리의 특성을 가짐 (저장객체, 왼쪽 자식 노드, 오른쪽 자식 노드)
	 * - 왼쪽 자식 노드의 값은 부모노드의 값보다 작고(비교 기준 compareTo, compare에 의해) 오른쪽자식노드의 값은 부모노드의 값보다 커야한다.
	 * - 노드의 추가 삭제에 시간이 걸린다. (순차적으로 저장하는게 아닌, 비교기준에 따라 루트부터 따져서 저장하기 때문)
	 * - 데이터들의 검색(범위검색)과 정렬에 유리하다.
	 * - 중복된 값을 저장하지 못 한다.
	 * 
	 * [TreeSet의 메서드들]
	 *  1. 생성자
	 *   - TreeSet() : 기본 비교기준 Comparable에 의한 정렬 저장 TreeSet 생성
	 *   - TreeSet(Collection c) : 주어진 정렬조건으로 정렬하는 TreeSet 생성
	 *   - TreeSet(SortedSets s) : SortedSet을 구현한 컬렉션을 저장하는 TreeSet 생성
	 *   - TreeSet(Comparator comp) : 지정 정렬 기준에 의해 저장하는 TreeSet 생성
	 *   
	 *  2. 추가
	 *   - boolean add(Object o)
	 *   - boolean addAll(Collection c)
	 *   
	 *  3. 제거
	 *   - void clear() : 저장된 모든 객체를 삭제
	 *   - boolean remove(Object o) : 지정 객체를 삭제
	 *   - boolean removeAll(Collection c) : 지정 컬렉션과 공통된 객체들을 제거 (차집합)
	 *   - boolean retainAll(Collection c) : 지정 컬렉션과 공통된 객체를 제외한 객체들을 제거 (교집합)
	 *  
	 *  4. 검색
	 *   - boolean contains(Object o) : 컬렉션이 지정 객체를 포함하고 있으면 true, 아니면 false
	 *   - boolean containsAll(Collection c) : 컬렉션이 지정 컬렉션의 모든 객체를 포함하고 있으면 true, 아니면 false
	 *  
	 *  5. 컬렉션 비교 (Collection에서 상속)
	 *   - boolean equals(Object o) : 동일한 컬렉션인지 비교
	 *   
	 *  6. 상태
	 *   - int size() : 저장된 객체의 갯수 반환
	 *   - int hashCode() : HashSet의 hashCode를 반환
	 *   - boolean isEmpty() : HashSet이 비어있으면 true, 아니면 false
	 *    
	 *  7. 배열로 반환
	 *   - Object[] toArray() : 컬렉션에 저장되어있는 객체들을 객체배열로 반환
	 *   - Object[] toArray(Object[] a) : 컬렉션에 저장되어 있는 객체들을 지정배열 a에 저장해서 반환
	 *   
	 *  8. 접근
	 *   - iterator() : Iterator 객체 반환
	 *   
	 *  9. 객체 반환
	 *   - Object ceiling(Object o) : 지정 객체와 같은 객체 반환. 없으면 한 단계 더 큰 값을 가진 객체를 반환
	 *   - Object floor(Object o) : 지정 객체와 같은 객체 반환. 없으면 한 단계 더 작은 값을 가진 객체를 반환
	 *   - Object higher(Object o) : 지정 객체보다 한 단계 더 큰 값을 가진 객체 반환. 없으면 null
	 *   - Object loser(Object o) : 지정 객체보다 한 단계 더 작은 값을 가진 객체 반환. 없으면 null
	 *   - Object first() : 정렬된 순서에서 첫번째 객체 반환
	 *   - Object last() : 정렬된 순서에서 마지막 객체 반환
	 *   - Object pollFirst() : TreeSet의 첫번째 요소(제일 작은 값)를 꺼내서 반환
	 *   - Object polllast() : TreeSet의 마지막 요소(제일 큰 값)를 꺼내서 반환
	 *   
	 *  10. Set 반환
	 *   - SortedSet headSet(Object o) : 지정된 객체보다 작은 값의 객체들을 반환한다.
	 *   - SortedSet tailSet(Object o) : 지정된 객체보다 큰 값의 객체들을 반환한다.
	 *   - NavigableSet headSet(Object o, boolean inclusive) : 지정된 객체보다 작은 값의 객체를 반환. inclusive가 true이면 같은 값 포함
	 *   - NavigableSet tailSet(Object o, boolean inclusive) : 지정된 객체보다 큰 값의 객체를 반환. inclusive가 true이면 같은 값 포함
	 *   - SortedSet subSet(Object fromElement, Object toElement) : from 이상 to미만 객체 반환
	 *   - NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, E toInclusive) : 범위검색. fromInclusive가 true이면 from 포함, toInclusive가 true이면 포함  
	 *   - NavigableSet descendingSet() : TreeSet에 저장된 요소들을 역순으로 정렬해서 반환
	 *   
	 *  11. 그 외
	 *   - Spliterator spliterator() : 쓰레드 관련. TreeSet의 spliterator 반환
	 */
	
	public static void main(String[] args) {
		Set set1 = new HashSet(); // 정렬 필요(새로운 List 객체 생성 후, Collections.sort()를 통해 정렬해야함)
		
		// 범위 검색, 정렬에 유리 -> 정렬 필요 없음.
		// set2를 채워나갈 Integer 객체들은 Comparable 인터페이스를 구현하여 자체적인 정렬 기준이 있음 -> 별도의 Comparator 지정 안 해도 됨
		Set set2 = new TreeSet();
		
		// set3의 Comparator DescComp()는 숫자를 역순으로 정렬하도록 함
		// (cf) DescComp 클래스는 동일 폴더내의 ComparableEx.java 파일에 정의해둠
		// (cf) JDK 1.6부터 추가된 descendingSet() 메서드를 이용하여, 본래 순서로 생성한 Set을 역순 정렬하는 방법도 있음.
		Set set3 = new TreeSet(new DescComp());
		
		fillSetRdmNumber(set1, 6, 1, 45); // set1, set2에 6개의 1~45 난수를 중복되지 않게 채움
		fillSetRdmNumber(set2, 6, 1, 45);
		fillSetRdmNumber(set3, 6, 1, 45);
		
		//HashSet은 따로 정렬되지 않았지만, TreeSet은 별도의 정렬을 안 했음에도 자체적으로 이진탐색을 통해 정렬됨
		System.out.println("set1 : "+set1);
		System.out.println("set2 : "+set2);
		System.out.println("set3 : "+set3);
	}
	
	private static void fillSetRdmNumber(Set set, int size, int start, int end) {
		if (rangeCount(start,end) < size) {// 숫자수보다 많은 size를 채우지 않도록 숫자 범위 갯수만큼 채우도록 함
			for (int i=0; set.size() < rangeCount(start,end); i++) {
				set.add(getRdmNumber(start,end));
			}
			return;
		}
		
		for (int i=0; set.size() < size; i++) {//지정 size만큼을 start~end 내의 난수로 중복되지 않게 채움
			set.add(getRdmNumber(start,end));
		}
		return;
	}
	
	private static int rangeCount(int start, int end) {
		return Math.abs(end-start)+1; //지정 범위 내의 정수의 갯수를 반환
	}
	
	private static int getRdmNumber(int start, int end) {
		//start 이상 end 이하의 난수를 반환함
		return (int)(Math.random() * rangeCount(start,end)) + Math.min(start,end);
	}
	
}


