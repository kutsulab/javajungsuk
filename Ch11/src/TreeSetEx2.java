
import java.util.*;

public class TreeSetEx2 {
	
	/* Java의 정석 3판 p.643 예제 11-29
	 * 
	 *  [특정 범위의 Set 추출]
	 *   - SortedSet headSet(Object o) : 지정된 객체보다 작은 값의 객체들을 반환한다.
	 *   - SortedSet tailSet(Object o) : 지정된 객체보다 큰 값의 객체들을 반환한다.
	 *   - NavigableSet headSet(Object o, boolean inclusive) : 지정된 객체보다 작은 값의 객체를 반환. inclusive가 true이면 같은 값 포함
	 *   - NavigableSet tailSet(Object o, boolean inclusive) : 지정된 객체보다 큰 값의 객체를 반환. inclusive가 true이면 같은 값 포함
	 *   - SortedSet subSet(Object fromElement, Object toElement) : from 이상 to미만 객체 반환
	 *   - NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, E toInclusive) : 범위검색. fromInclusive가 true이면 from 포함, toInclusive가 true이면 포함  
	 *   - NavigableSet descendingSet() : TreeSet에 저장된 요소들을 역순으로 정렬해서 반환	 * 
	 * 
	 */

	public static void main(String[] args) {
		TreeSet set = new TreeSet(); // Comparable에 따라 정렬됨 -> int는 오름차순
		int[] score = {80, 95, 50, 35, 45, 65, 10, 100};
		
		for (int i=0; i<score.length; i++) {
			set.add(score[i]); // 배열의 요소들을 TreeSet에 추가
		}
		
		System.out.println("50보다 작은 값 : "+set.headSet(50,false)); // 경계값을 포함하는 지의 여부를 확실히 설정하기 위해 true, false를 인수로 입력하면 편리하다.
		System.out.println("50보다 큰 값 : "+set.tailSet(50,false)); 
		System.out.println("40과 80 사이의 값 : "+set.subSet(40,false,80,false));
	}

}
