
	/* ========================================================================
	 *  Java의 정석 3판 p.805 예제 14-4 : 컬렉션 프레임웍과 함수형 인터페이스 [Map : computeIfAbsent, computeIfPresent]
	 * ========================================================================
	 *
	 *   1. Map의 람다식 관련 메서드
	 *         
	 *     2) default V computeIfAbsent(K key,
	 *                   Function<? super K, ? extends V> mappingFunction)
	 *        
	 *        지정 key가 존재하지 않거나, 존재하는데 value가 null인 경우, mapping 함수가 null이 아닌 값을 반환하면
	 *        (key, newValue)을 put함
	 *        
	 *        key : value에 연결할 key
	 *        mappingFunction : value를 계산할 함수
	 *        
	 *        작동 : 
	 *           * 지정 key가 null이고 이 map이 null key를 지원하지 않을 경우 NullPointerException을 throw
	 *           * 지정 mappingFunction이 null일 경우 NullPointerException을 throw
	 *           
	 *           * map에서 key에 연결된 oldValue를 찾아온다.
	 *              - oldValue가 null일 때
	 *                지정된 mappingFunction를 통하여 함숫값 newValue를 반환받은 뒤
	 *                  
	 *                  newValue가 null이 아닐 경우 map에 (key, newValue)를 put 후 newValue를 반환
	 *                  newValue가 null일 경우 null을 반환 (아무 것도 안 한다)
	 *               
	 *              - value가 null이 아닐 때 (map에 key-value쌍이 존재하고 null이 아닐 때) value 반환
	 *        
	 *        일반적인 사용례> map.computeIfAbsent(key, k-> mappingValue);
	 *        
	 *        key당 여러 값을 저장하는 다중 value의 Map<K, Collection<V>>의 경우
	 *                     map.computeIfAbsent(key, k-> new HashSet<V>()).add(v); 
	 *              
	 *        예외>
	 *          - NullPointerException : 지정 key가 null이고, 이 map이 null을 지원하지 않는 경우 또는 mappingFunction이 null인 경우
	 *          - UnsupportedOperationException : 이 맵이 put 작업을 지원하지 않을 경우 (선택)
	 *          - ClassCastException : 지정된 key 또는 value의 클래스가, 이 맵에 저장되는 것을 방지하는 경우 (선택)
	 *          
	 *          
	 *     3) default V computeIfPresent(K key,
	 *                   BiFunction<? super K, ? super V, ? extends V> remappingFunction)
	 *        
	 *        지정 key가 존재하지 않거나, 존재하는데 value가 null인 경우, mapping 함수가 null이 아닌 값을 반환하면
	 *        (key, newValue)을 put함
	 *        
	 *        key : value에 연결되어 있는 key
	 *        remappingFunction : 값을 계산하는 함수
	 *        
	 *        작동 : 
	 *              * 지정 key가 null이고 이 map이 null key를 지원하지 않을 경우 NullPointerException을 throw
	 *              * 지정 remappingFunction이 null일 경우 NullPointerException을 throw
	 *              
	 *              * map에서 key를 통해 OldValue를 가져온다.
	 *              
	 *                - OldValue가 null이다. -> null을 반환
	 *                - Oldvalue가 null이 아닐 때(map에 존재한다)
	 *                  remappingFunction을 통해, 함숫값 newValue를 구한다.
	 *                  
	 *                    newValue가 null이면, map에서 (key, Oldvalue)을 지우고 null을 반환
	 *                    newValue가 null이 아니면, map에 (key, newValue)를 put하고 newValue를 반환
	 *        일반적인 사용례> map.computeIfPresent(key, (k,v) -> remappingValue);
	 *              
	 *        예외>
	 *          - NullPointerException : 지정 key가 null이고, 이 map이 null을 지원하지 않는 경우 또는 remappingFunction이 null인 경우
	 *          - UnsupportedOperationException : 이 맵이 put 작업을 지원하지 않을 경우 (선택)
	 *          - ClassCastException : 지정된 key 또는 value의 클래스가, 이 맵에 저장되는 것을 방지하는 경우 (선택)	 *
	 * ========================================================================
	 */

import java.util.*;

public class LambdaEx4_3 {

	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<>();
		map.put("key1", 10);
		map.put("key2", 20);
		map.put("key3", 30);
		map.put("key4", 40);
		System.out.println("map : "+map);
		
		//computeIfAbsent
		map.computeIfAbsent("key4", key-> 45); // 지정 key가 존재할 경우, 수행되지 않고 value가 그대로 반환된다.
		map.computeIfAbsent("key5", key-> 50);
		map.computeIfAbsent("key6", key-> 60);
		System.out.println("map : "+map);
		System.out.println();
		
		Map<Integer, String> map2 = new HashMap<>();
		map2.put(1, "유니콘");
		map2.put(2, "벨파스트");
		map2.put(3, "세인트루이스");
		map2.put(4, "다이호");
		
		System.out.println("map2 : "+map2);
		
		map2.computeIfAbsent(4, key -> "엔터프라이즈"); // 지정 key가 존재할 경우, 수행되지 않고 value가 그대로 반환된다.
		map2.computeIfAbsent(5, key -> "후드");
		map2.computeIfAbsent(6, key -> "헬레나");
		System.out.println("map2 : "+map2);
		
		map2.put(7, null);
		System.out.println("map2 after put(7,null) : \n"+map2);
		
		map2.computeIfAbsent(7, key -> null); // newValue가 null일 경우 아무 것도 하지 않는다.
		System.out.println("map2 after computeIfAbsent(7,key-> null) : \n"+map2); 
		
		map2.computeIfAbsent(7, key -> "캬루"); // 지정 key가 value와 연결되어 있지 않은(null) 경우도 지정된 매핑 값을 맵에 입력한다.
		System.out.println("map2 : "+map2);
		System.out.println();
		
		Map<String, Set<Integer>> map3 = new HashMap<>();
		
		Set<Integer> set1 = new HashSet<>();
		set1.add(1);
		set1.add(2);
		
		map3.put("key1", set1);
		System.out.println("map3 : "+map3);
		
		map3.computeIfAbsent("key2", k-> new HashSet<>()).add(3);
		System.out.println("map3 : "+map3);
		System.out.println();
		
		Map<Integer, Integer> map4 = new HashMap<>();
		map4.put(1,1);
		map4.put(2,2);
		System.out.println("map4 : "+map4);
		
		System.out.println("after map4.computeIfAbsent(3, null)========= ");
		try {
			map4.computeIfAbsent(3, null); // mappingFunction이 null일 경우 NullPointerException 발생
		} catch (NullPointerException e) {
			System.out.println("Exception : "+e);
		}
		System.out.println();
		
		//ComputeIfPresent
		Map<String, Integer> map5 = new HashMap<>();
		map5.put("국어", 10);
		map5.put("수학", 20);
		map5.put("영어", 30);
		System.out.println("map5 before 'computeIfPresent Operation' :\n" + map5);
		
		map5.computeIfPresent("영어", (k,v) -> k.length()+v+10);
		map5.computeIfPresent("과학", (k,v) -> 50);
		System.out.println("map5 after 'computeIfPresent Operation' :\n" + map5);
		
		map5.computeIfPresent("수학", (k,v) -> null); // remappingFunction의 함숫값이 null인 경우 map에서 이 key가 제거됨
		System.out.println("map5 after 'computeIfPresent Operation2' :\n"+ map5);
	}
}
