
import java.util.*;
import static java.util.Collections.*;

public class CollectionsEx {

	/* Java의 정석 3판 p.666 예제 11-39
	 * 
	 * [Collections 클래스]
	 *  - 컬렉션과 관련된 메서드들을 제공
	 * 
	 * [Collections의 메서드들]
	 *  1. 각종 기능
	 *   - addAll(list, Object ...) : 여러 객체들을 순서대로 추가
	 *   - rotate(list, count) : 시계방향으로 count회 이동
	 *   - swap(list, index1, index2) : 두 index에 위치한 요소들을 바꿈
	 *   - reverse(list) : 저장순서를 반대로 뒤집음
	 *   - shuffle(list) : 저장된 요소의 순서를 임의로 변경
	 *   - sort(list) : 기본정렬기준에 의한 정렬
	 *   - sort(list, Comparator comp) : Comparator에 의한 정렬
	 *   - binarySearch (list, Object o) : 이진탐색으로 지정 객체 찾기. 정렬이 선행되야함
	 *   - max,min (list) : 기본 정렬 기준으로 최대, 최소
	 *   - max,min (list, Comparator comp) : Comparator에 의한 최대 최소
	 *   - fill(list, Object) : 지정 객체로 채움
	 *   - nCopies(n, Object o) : 지정 갯수만큼 Object를 복사한 list를 반환
	 *   - disjoint(Colleciton 1, Collection 2) : 두 컬렉션이 공통된 요소를 가지고 있지 않으면 true
	 *   - copy(dest,src) : src list의 모든 요소를 dest에 순서대로 복사
	 *   - replaceAll(list, old, new) : 지정 list의 old 객체를 new 객체로 전부 교체
	 *   - enumeration(Collection) : 지정 Collection의 모든 객체에 접근하는 Enumeration 반환
	 *   - list(Enumeration e) : 지정 e를 통해 모든 객체를 읽어서 ArrayList로 복제해 반환
	 * 
	 *  2. 컬렉션의 동기화 (동기화되지 않은 컬렉션을 동기화 컬렉션으로 반환)
	 *   - synchronizedXXX()
	 *   
	 *  3. 변경불가 컬렉션
	 *   - unmodifiableXXX()
	 *  
	 *  4. 싱글톤(단 하나의 객체만 저장)
	 *   - singletonXXX
	 *  
	 *  5. 한 종류의 객체만 저장
	 *   - checkedXXX(Collection c, Class Type)
	 *  
	 */
	
	public static void main(String[] args) {
		List list = new ArrayList();
		System.out.println("====== list 추가! ======");
		System.out.println(list);
		System.out.println();
		
		System.out.println("====== addAll(list, 1,2,3,4,5) ======");
		addAll(list, 1,2,3,4,5); // 지정 컬렉션에 뒤의 요소를 추가
		System.out.println(list);
		System.out.println();
		
		System.out.println("====== rotate(list, 2) ======");
		rotate(list, 2); // 시계방향으로 2회 이동
		System.out.println(list);
		System.out.println();
		
		System.out.println("====== swap(list, 0, 2) ======");
		swap(list, 0, 2); //0번째 요소와 2번째 요소를 바꿈
		System.out.println(list);
		System.out.println();
		
		System.out.println("====== reverse(list) ======"); // 컬렉션의 저장 순서를 뒤집기
		reverse(list);
		System.out.println(list);
		System.out.println();

		System.out.println("====== shuffle(list) ======");
		shuffle(list); //저장된 요소의 위치를 임의 변경
		System.out.println(list);
		System.out.println();
		
		System.out.println("====== sort(list, reverseOrder()) ======"); // 역순 기본 정렬
		sort(list, reverseOrder());
		System.out.println(list);
		System.out.println();
		
		System.out.println("====== sort(list) ======"); //기본 정렬
		sort(list);
		System.out.println(list);
		System.out.println();
		
		int index = binarySearch(list, new Integer(3)); // 이진탐색(정렬 선행되야함)
		System.out.println("index of 3 = "+index);
		
		System.out.println("max = "+max(list)); //기본 정렬기준에 의한 최댓값
		System.out.println("min = "+min(list)); //기본 정렬기준에 의한 최솟값
		
		System.out.println("max reverseOrder = "+max(list,reverseOrder())); //역순정렬기준에 의한 최댓값
		System.out.println("min reverseOrder = "+min(list,reverseOrder())); //역순정렬기준에 의한 최솟값
		System.out.println();
		
		System.out.println("====== fill(list,9) ======");
		fill(list,9); //list의 모든 요소를 9 객체로 채움
		System.out.println(list);
		System.out.println();
		
		
		System.out.println("====== List newList = nCopies(list.size(), 2) ======");
		List newList = nCopies(list.size(), 2); // list의 size만큼 모든 요소를 2로 채운다. 단, 결과는 변경 불가 (List 객체)
		System.out.println("newList = "+newList);
		System.out.println();
		
		System.out.println("disjoint(list,newList) : "+disjoint(list,newList)); // 공통된 요소가 없으면 true
		System.out.println();
		
		System.out.println("====== copy(list, newList) ======");
		copy(list, newList); //newList의 요소를 복사해서 list에 덮어씌움
		System.out.println("newList = "+newList);
		System.out.println("list = "+list);
		System.out.println();
		
		System.out.println("====== replaceAll(list,2,1) ======");
		replaceAll(list, 2, 1); // 모든 2 객체를 1 객체로 변경
		System.out.println("list = "+list);
		System.out.println();
		
		Enumeration e = enumeration(list); //list에 접근하는 enumeration을 반환
		ArrayList list2 = list(e); // e로 접근하여 복사한 ArrayList 객체를 반환
		System.out.println("list2 = "+list2);
	}

}
