
import java.util.*;

public class HashMapEx1 {
	
	/* Java의 정석 3판 p.646 예제 11-30
	 * 
	 * [Map 인터페이스]
	 *  - key와 value의 쌍을 Map.Entry 인터페이스를 구현한 Entry로 묶어서 저장
	 *  - key의 중복을 허용하지 않고, value의 중복을 허용함
	 *  - 순서가 정해지지 않음
	 * 
	 * [HashMap]
	 *  - Map 인터페이스를 구현
	 *  - 자료구조 : 해시 테이블
	 * 
	 * [해시 테이블]
	 *  - 배열 및 linkedlist의 조합으로 이루어져 있음.
	 *  - key값을 인수로 하여 해싱함수를 통해 hashCode()를 반환
	 *  - hashCode를 통해 배열의 인덱스를 조회 (배열을 이용하기 때문에 접근 속도가 빠름)
	 *  - hashCode에 해당하는 인덱스에 저장된  Linked list를 조회하여 value를 찾아냄
	 *  
	 * [hash함수]
	 *  - Objects.hash(Object obj...) : 여러 객체, 혹은 변수들을 기반으로 hashCode 반환
	 *  
	 * [HashMap의 여러 메서드]
	 * 
	 *  1. 생성자
	 *   - HashMap()
	 *   - HashMap(int initialCapacity)
	 *   - HashMap(int initialCapacity, float loadFactor)
	 *   - HashMap(Map m)
	 *   
	 *  2. 추가
	 *   - Object put(Object key, Object value) : 지정된 키, 값을 HashMap에 저장
	 *   - void putAll(Map m) : 지정 Map에 저장된 모든 요소를 저장
	 *   
	 *  3. 제거
	 *   - void clear() : 전체 삭제
	 *   - Object remove(Object key) : 지정된 key로 저장된 value 제거
	 *  
	 *  4. 조회
	 *   - boolean containsKey(Object key) : HashMap에 지정 key가 있는가?
	 *   - boolean contiansValue(Object value) : HashMap에 지정 Value이 포함되어 있는가?
	 *  
	 *  5. 객체반환
	 *   - Object get(Object key) : 지정된 key의 객체를 반환. 못 찾으면 null
	 *   - Object getOrDefault(Object key, Object defaultValue) : 지정된 key로 저장된 value 반환. 못 찾으면 null
	 *  
	 *  6. 컬렉션 반환
	 *   - Set keySet() : HashMap에 저장된 모든 key가 저장된 Set을 반환
	 *   - Collection values() : HashMap에 저장된 모든 value들을 컬렉션의 형태로 반환
	 *   - Set entrySet() : HashMap에 저장된 모든 key, value를 Entry(key, value가 저장된 객체)의 형태의 형태로 Set에 저장해서 반환
	 *  
	 *  7. 교체
	 *   - Object replace(Object key, Object value) : 지정된 키의 value를 교체
	 *   - boolean replace(Object key, Object oldValue, Object newValue) : 지정된 key, oldValue가 모두 일치하는 경우에만 새로운 객체 newValue로 대체
	 *   
	 *  8. 복제
	 *   - Object clone() : 현재 HashMap을 복제해서 반환
	 *   
	 *  9. 상태
	 *   - int size() : 현재 HashMap에 저장된 요소들의 갯수 반환
	 *   - boolean isEmpty() : 현재 HashMap이 비어있는지 알려줌     
	 * 
	 */
	
	
	public static void main(String[] args) {
		
		HashMap map = new HashMap();
		map.put("kyaru", "1234");
		map.put("dog", "2345");
		System.out.println(map);
		map.put("dog", "5678");
		System.out.println(map); // 같은 key, 다른 value 가진 데이터를 put할 경우 기존의 key에 덮어씌운다.
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("id와 pw를 입력해주세요.");
			
			System.out.print("id :");
			String id = sc.nextLine().trim(); // 라인단위로 입력받아 공백 제거
			System.out.print("pw :");
			String pw = sc.nextLine().trim();
			System.out.println();
			
			if(!map.containsKey(id)) { //id에 해당하는 value가 존재하지 않으면
				System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.");
				System.out.println();
				continue;
			}
			
			if (!(map.get(id).equals(pw))) {//id에 대응되는 value가 입력 pw와 다를 경우
				System.out.println("입력값이 잘못 됐습니다. 다시 입력해주세요.");
				System.out.println();
			} else {//id에 대응되는 value와 입력 pw가 부합할 경우
				System.out.println("'"+id+"'님 로그인 성공하셨습니다.");
				break;
				}
		}
		
		sc.close();
	}			
}
