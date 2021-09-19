
import java.util.*;

public class ArrayListEx1 {
	
	/* Java의 정석 3판 p.585 예제 11-1
	 * 
	 * [컬렉션 프레임워크 (Collection FrameWork)]
	 *  컬렉션(다수의 객체=데이터)를 다루기 위한 표준화된 프로그래밍 방식
	 *  컬렉션을 쉽고 편리하게 다룰 수 있는(저장, 삭제, 검색, 정렬) 다양한 클래스 제공
	 *   - Collection : 여러 객체(데이터)를 모아놓은 것
	 *   - FrameWork : 표준화, 정형화된 체계적인 프로그래밍 방식
	 *   
	 * [컬렉션 프레임워크의 인터페이스]
	 *     List와 Set은 Collection 인터페이스를 상속받았음.
	 *     
	 *  1. List : 순서가 있는 데이터의 집합, 데이터의 중복 허용
	 *  2. Set : 순서가 없는 데이터의 집합, 데이터의 중복을 허용하지 않음
	 *  3. Map : 키(key)와 값(value)의 쌍으로 이루어진 데이터의 집합.
	 *           순서가 없고, 키(key)의 중복을 허용하지 않으며, 값(Value)의 중복은 허용한다.
	 * 
	 *  [Collection 인터페이스]
	 *  
	 *  1. 추가
	 *  boolean add(Object o) : 컬렉션에 객체 추가
	 *  boolean addAll(Colleciton c) : 컬렉션에 다른 컬렉션의 모든 객체를 추가
	 *  
	 *  2. 삭제
	 *  void clear() : 컬렉션의 모든 객체를 삭제 (전체삭제)
	 *  boolean remove(Object o) : 컬렉션이 지정된 객체를 가지고 있으면 제거하고 true를 반환 (단일 객체 삭제) 
	 *  boolean removeAll(Collection c) : 지정된 Collection에 포함된 모든 객체를 제거 (컬렉션 단위로 삭제)
	 *  boolean retainAll(Collection c) : 지정된 Collection에 포함된 객체만 남기고 나머지 모든 객체를 제거
	 *  
	 *  3. 검색
	 *  boolean contains(Object o) : 컬렉션이 지정 객체를 포함하고 있으면 true, 아니면 false
	 *  boolean containsAll(Collection c) : 컬렉션이 지정 컬렉션의 모든 객체를 포함하고 있으면 true, 아니면 false
	 *  
	 *  4. 컬렉션의 비교 
	 *  boolean equals(Object o) : 동일한 컬렉션인지 비교
	 *  
	 *  5. 컬렉션의 정보 및 상태
	 *  int hashCode() : 컬렉션의 hashCode를 반환
	 *  int size() : 해당 컬렉션에 저장된 객체의 갯수를 반환
	 *  boolean isEmpty() : 해당 컬렉션이 비어있으면 true, 아니면 false
	 *  
	 *  6. 컬렉션을 배열로 반환
	 *  Object[] toArray() : 컬렉션에 저장되어있는 객체들을 객체배열로 반환
	 *  Object[] toArray(Object[] a) : 컬렉션에 저장되어 있는 객체들을 지정배열 a에 저장해서 반환
	 *  
	 *  [List 인터페이스]
	 *  순서가 있고(index가 있다!), 중복을 허용
	 *  
	 *  1. 추가
	 *  (Collection)
	 *  	boolean add(Object o) : 컬렉션에 객체 추가
	 *  	boolean addAll(Colleciton c) : 컬렉션에 다른 컬렉션의 모든 객체를 추가
	 *  (List)
	 *  	void add(int index, Object element) : 지정 index에 지정 객체 추가
	 *  	boolean addAll(int index, Collection c) : 지정 index에 지정 Collection에 속한 모든 객체 추가
	 *  
	 *  2. 삭제
	 *  (Collection)
	 *  	void clear() : 컬렉션의 모든 객체를 삭제 (전체삭제)
	 *  	boolean remove(Object o) : 컬렉션이 지정된 객체를 가지고 있으면 제거하고 true를 반환 (단일 객체 삭제) 
	 *  	boolean removeAll(Collection c) : 지정된 Collection에 포함된 모든 객체를 제거 (컬렉션 단위로 삭제)
	 *  	boolean retainAll(Collection c) : 지정된 Collection에 포함된 객체만 남기고 나머지 모든 객체를 제거
	 *  (List)
	 *  	Object remove(int index) : 지정 index에 위치한 객체를 삭제하고 삭제한 객체된 객체를 반환
	 *  
	 *  3. 검색
	 *  (Collection)
	 *  	boolean contains(Object o) : 컬렉션이 지정 객체를 포함하고 있으면 true, 아니면 false
	 *  	boolean containsAll(Collection c) : 컬렉션이 지정 컬렉션의 모든 객체를 포함하고 있으면 true, 아니면 false
	 *  (List)
	 *  	int indexOf(Object o) : 지정된 객체의 위치(index)를 반환
	 *  	int lastIndexOf(Object o) : 지정된 객체의 위치(index)를 뒤에서부터 찾아서 반환
	 *  
	 *  4. 객체 반환
	 *  (List)
	 *  	Object get(int index) : 지정된 index에 위치한 객체를 반환
	 *  
	 *  5. 객체 변경
	 *  (List)
	 *  	Object set(int index, Object element) : 지정된 index에 위치한 객체를 저장
	 *  
	 *  6. 객체 순서 정렬
	 *  (List)
	 *  	void.sort(Comparator c) : 지정된 비교자로 List 정렬
	 *  
	 *  7. 리스트의 비교
	 *  (Collection)
	 *  	boolean equals(Object o) : 동일한 컬렉션인지 비교
	 *  
	 *  8. 리스트의 정보 및 상태
	 *  (Collection)
	 *  	int hashCode() : 컬렉션의 hashCode를 반환
	 *  	int size() : 해당 컬렉션에 저장된 객체의 갯수를 반환
	 *  	boolean isEmpty() : 해당 컬렉션이 비어있으면 true, 아니면 false
	 *  
	 *  9. 리스트를 배열로 반환
	 *  (Collection)
	 *  	Object[] toArray() : 컬렉션에 저장되어있는 객체들을 객체배열로 반환
	 *  	Object[] toArray(Object[] a) : 컬렉션에 저장되어 있는 객체들을 지정배열 a에 저장해서 반환
	 *  
	 *  10. 리스트의 일부를 List로 반환
	 *  (List)
	 *  	List subList(int fromindex, int toindex) : fromindex <= x < toindex 범위의 인덱스에 위치한 객체들을 저장한 List를 반환
	 *  
	 *  
	 *  [ArrayList]
	 *  
	 *  List 인터페이스를 구현한 컬렉션 클래스.
	 *  순서가 있음(index), 중복 허용 OK
	 *  내부에 Object[]가 저장되어있으며, 배열에 더 이상 저장할 공간이 없으면
	 *  보다 큰 새로운 배열을 생성, 기존의 배열에 저장된 내용을 새로운 배열로 복사한 뒤 새로 저장시킴
	 *  
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
	
	
	static void print (ArrayList list1, ArrayList list2) {
		System.out.println("list1 : "+list1);
		System.out.println("list2 : "+list2);
		System.out.println();
	}
	public static void main(String[] args) {
		

		ArrayList list1 = new ArrayList(10); //초기 용량(capacity, 길이)이 10인 ArrayList 생성
		// ArrayList에는 객체만 저장 가능
		list1.add(new Integer(5)); // list1에 객체를 추가
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		// list1의 1<=i<4 에 속한 인덱스 i에 위치한 객체들을 저장한 List객체를 반환
		// 이 추출한 List는 읽기 전용. ArrayList로 활용하려면 이 List의 객체를 포함하는 ArrayList를 생성해야함
		
		print(list1, list2);
		
		System.out.println("Collections.sort(list1), Collections.sort(list2) 로 정렬");
		
		//Collection : 인터페이스, Collections : 유틸(기능) 클래스
		Collections.sort(list1); // 오름차순 정렬
		Collections.sort(list2);
		print(list1,list2);
		
		//list1은 list2의 모든 객체를 가지고 있니?
		System.out.println("list1.containsAll(list2) : "+list1.containsAll(list2));
		System.out.println();
		
		list2.add("B"); // 객체를 다음 index에 추가
		list2.add("C");
		list2.add(3,"A"); // 3번 index부터 존재하는 모든 인덱스를 뒤로 밀어내고 빈 자리에 "A"를 삽입
		print(list1,list2);
		
		list2.set(3, "AA"); // 3번 index의 객체를 "AA"로 교체
		print(list1,list2);
		
		System.out.println("list1.retainAll(list2) : "+list1.retainAll(list2));
		//list1로부터 list2와 공통인 객체를 제외하고 모두 제거, true 또는 false를 반환
		print(list1,list2);
		
		for(int i=list2.size()-1; i>=0; i--) {
			if (list1.contains(list2.get(i))) // 해당 인덱스의 객체를 list1이 포함하고 있으면
				list2.remove(i); // i번째 인덱스에 위치한 객체 삭제
		}
		// i를 0부터 증가하면서 제거할 경후, 제거할 때마다 뒤의 index의 객체들이 앞으로 당겨와지기 때문에 정확한 수행할 수 없게됨
		
		print(list1,list2);
	}

}
