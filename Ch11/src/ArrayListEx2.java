
import java.util.*;

public class ArrayListEx2 {
	
	/*	Java의 정석 3판 p.585 예제 11-2 내용확인 및 연습
	 *  문자열을 일정 간격으로 끊고 ArrayList에 저장, 호출하기
	 * 
	 *  [ArrayList]
	 *  
	 *  List 인터페이스를 구현한 컬렉션 클래스.
	 *  순서가 있음(index), 중복 허용 OK
	 *  내부에 Object[]가 저장되어있으며, 배열에 더 이상 저장할 공간이 없으면
	 *  보다 큰 새로운 배열을 생성, 기존의 배열에 저장된 내용을 새로운 배열로 복사한 뒤 새로 저장시킴
	 *  
	 *  1. 생성자
	 *  	ArrayList() : 크기(capacity)가 10인 ArrayList 생성
	 *  	ArrayList(Collection c) : 지정 컬렉션의 모든 객체들이 저장된 ArrayList를 생성
	 *  	ArrayList(int initialCapacity) : 지정된 초기 용량을 갖는 ArrayList 생성.
	 *  									  처음 저장할 때 사용 목적에 맞는 용량의 ArrayList를 만들고 용량의 변화가 적어야 성능 저하가 적어짐 
	 *  2. 추가
	 *  	boolean add(Object o) : ArrayList의 마지막에 객체를 추가, 성공하면 true
	 *  	void add(int index, Object o) : 지정된 index에 객체 저장
	 *  	boolean addAll(Collection c) : ArrayList의 마지막에 지정 컬렉션의 객체들을 추가, 성공하면 true
	 *  	boolean addAll(int index, Collection c) : 지정된 index부터 주어진 컬렉션의 모든 객체를 저장
	 *  
	 *  3. 삭제
	 *  	void clear() : Arraylist를 완전히 비움
	 *  	Object remove(int index) : 지정 index에 존재하는 객체를 제거 후 반환
	 *  	boolean remove(Object o) : 지정 객체를 제거 (성공하면 true)
	 *  	boolean removeAll(Collection c) : 지정된 컬렉션에 저장된 것들과 동일한 객체들을 ArrayList에서 제거
	 *  	boolean retainAll(Collection c) : 지정된 컬렉션에 저장된 것들과 공통인 객체들을 제외한 객체들을 ArrayList에서 제거
	 *  
	 *  4. 검색
	 *  	boolean contains(Object o) : ArrayList가 지정 객체(o)를 포함하고 있는지 확인
	 *  	boolean containsAll(Collection c) : ArrayList가 지정 컬렉션의 모든 객체를 포함하고 있으면 true, 아니면 false
	 *  	int indexOf(Object o) : 지정된 객체가 저장된 index를 찾아 반환
	 *  	int lastIndexOf(Object o) : 지정된 객체가 저장된 index를 뒤에서 부터 찾아서 반환
	 *  
	 *  5. 객체 반환
	 *  	Object get(int index) : 지정된 index에 저장된 객체 반환
	 *  
	 *  6. 객체 변경
	 *  	Object set(int index, Object o) : 지정된 index에 지정 객체를 저장함
	 *  
	 *  7. 객체의 순서 정렬
	 *  	void sort(Comparator c) : 지정된 정렬기준(c)으로 ArrayList 정렬
	 *  
	 *  8. ArrayList의 정보 및 상태
	 *  (Collection)
	 *  	int hashCode() : 컬렉션의 hashCode를 반환
	 *  	int size() : 해당 컬렉션에 저장된 객체의 갯수를 반환
	 *  	int capacity() : 실제 저장할 수 있는 객체의 최대 갯수(현재 ArrayList가 참조하고 있는 배열의 length)
	 *  	boolean isEmpty() : 해당 컬렉션이 비어있으면 true, 아니면 false
	 *  
	 *  9. ArrayList 복제
	 *  	Object clone() : ArrayList를 복제
	 *  
	 *  10. ArrayList를 배열로 반환
	 *  	Object[] toArray() : ArrayList에 저장되어있는 객체들을 객체배열로 반환
	 *  	Object[] toArray(Object[] a) : ArrayList에 저장되어 있는 객체들을 지정배열 a에 저장해서 반환
	 *  
	 *  11. ArrayList의 일부를 List로 반환
	 *  	List subList(int fromindex, int toindex) : fromindex <= x < toindex 범위의 인덱스에 위치한 객체들을 저장한 List를 반환
	 *  	여기서 반환된 List는 읽기 전용이기 때문에 ArrayList로 활용하고 싶다면 ArrayList(Collection c) 생성자를 통해 새로 생성해줘야함
	 *  
	 *  12. 기타
	 *  	void ensureCapacity(int minCapacity) : ArrayList의 용량이 최소한 minCapacity가 되도록 함
	 *  	void trimToSize() : 용량을 크기에 맞게 줄인다. (빈공간 없앤다.)
	 */

	public static void main(String[] args) {
		
		// 지정된 문자열 source를 LIMIT만큼 길이를 쪼개서 ArrayList에 저장하는 상황
		
		final int LIMIT = 10; // source를 끊을 단위
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ"; // 43자
		int srcLength = source.length();
		
		List list = new ArrayList(srcLength/LIMIT + 10);
		System.out.println(list);
		
		for (int i=0; i < srcLength; i += LIMIT) {
			
			if (i+LIMIT>=srcLength) {
				//source의 마지막 index는 i+LIMIT -1이므로 i+LIMIT가 srcLength 이상인 경우는
				//다음번 자르는 단위가 존재하지 않는다는 뜻. 즉 이번이 마지막 분리라는 뜻이다.
				list.add(source.substring(i));
				break;
			}
			
			list.add(source.substring(i, i+LIMIT)); // LIMIT 간격으로 끊어서 배열에 저장
		}
		
		for (int i=0; i< list.size(); i ++) {
			System.out.println(list.get(i)); // ArrayList의 i번째 인덱스에 위치한 객체(LIMIT단위로 끊은 것들)를 호출
		}
	}
}
