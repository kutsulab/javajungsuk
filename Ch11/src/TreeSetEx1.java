
import java.util.*;

public class TreeSetEx1 {

	/* Java의 정석 3판 p.642 예제 11-27
	 * 
	 *  [특정 범위의 Set 추출]
	 *   - SortedSet headSet(Object o) : 지정된 객체보다 작은 값의 객체들을 반환한다.
	 *   - SortedSet tailSet(Object o) : 지정된 객체보다 큰 값의 객체들을 반환한다.
	 *   - NavigableSet headSet(Object o, boolean inclusive) : 지정된 객체보다 작은 값의 객체를 반환. inclusive가 true이면 같은 값 포함
	 *   - NavigableSet tailSet(Object o, boolean inclusive) : 지정된 객체보다 큰 값의 객체를 반환. inclusive가 true이면 같은 값 포함
	 *   - SortedSet subSet(Object fromElement, Object toElement) : from 이상 to미만 객체 반환
	 *   - NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, E toInclusive) : 범위검색. fromInclusive가 true이면 from 포함, toInclusive가 true이면 포함  
	 *   - NavigableSet descendingSet() : TreeSet에 저장된 요소들을 역순으로 정렬해서 반환
	 *    
	 */
	
	public static void main(String[] args) {
		String from = "b";
		String to = "d";
		System.out.println("range search : from "+from+" to "+to);
		System.out.println();
		
		TreeSet set1 = new TreeSet();
		
		set1.add("abc"); set1.add("alien"); set1.add("bat");
		set1.add("car"); set1.add("Car"); set1.add("disc");
		set1.add("dance"); set1.add("dZZZ"); set1.add("dzzzz");
		set1.add("elephant"); set1.add("elevator"); set1.add("fan");
		set1.add("flower");
		
		TreeSet set2 = new TreeSet(String.CASE_INSENSITIVE_ORDER); // 대소문자 구분 없이 정렬하는 TreeSet
		set2.addAll(set1);
		
		System.out.println("Set1 : "+set1);
		System.out.println("Set2 : "+set2);
		System.out.println();
		
		System.out.println("result 1-1 : "+set1.subSet(from, to)); // from 이상 to 미만 추출
		System.out.println("result 1-2 : "+set1.subSet(from, true, to + "zzz", true)); // from, to를 포함하여 추출. (d로 시작하는 단어들까지)
		System.out.println("result 2-1 : "+set2.subSet(from, true, to + "zzz", true));
		System.out.println();
		
	}

}
