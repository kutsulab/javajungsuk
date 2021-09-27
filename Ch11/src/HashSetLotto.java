
import java.util.*;

public class HashSetLotto {
	
	/* Java의 정석 3판 p.632 예제 11-21
	 * 
	 * [HashSet의 활용 - 로또번호 만들기]
	 *  HashSet은 중복을 허용하지 않는 점을 이용하여, 중복을 허용하지 않는 랜덤값을 반복을 통해 저장
	 * 
	 * [Collections.sort(List list)에 의한 정렬]
	 * 
	 * - Set은 순서가 없으므로, 정렬이 불가능하다.
	 * - 정렬하려면 List로 옮긴 뒤, 정렬을 해야함
	 * 
	 */
	public static void main(String[] args) {
		Set set = new HashSet(); // Lotto Set을 생성
		
		for (int i=0; set.size() < 6; i++) {
			
			int num = (int)(Math.random()*45) +1;
			
			//set.add(new Integer(num));
			set.add(num); // Integer 객체로 auto-boxing 됨.
		}
		
		System.out.println("정렬 전(Set) : "+set);
		
		// 정렬은 순서가 있어야하는데, Set은 순서가 없으므로 순서를 부여하기 위해 LinkedList 객체에 모든 요소를 저장
		List list = new LinkedList(set);
		
		// Collections.sort(List list) Integer 클래스의 Comparable 구현에 의한 정렬 (오름차순)
		Collections.sort(list);
		
		//List 출력
		System.out.println("정렬 후(List) : "+list);
	}

}
