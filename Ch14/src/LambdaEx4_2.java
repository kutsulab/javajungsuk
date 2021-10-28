
	/* ========================================================================
	 *  Java의 정석 3판 p.805 예제 14-4 : 컬렉션 프레임웍과 함수형 인터페이스 [Map : compute]
	 * ========================================================================
	 *
	 *   1. Map의 람다식 관련 메서드
	 *   
	 *     1) default V compute(K key,
	 *                BiFunction<? super K, ? super V, ? extends V> remappingFunction)
	 *        
	 *        특징 : map에서 key의 존재여부와 관계 없이 작동
	 *        
	 *        key : 변경하고자 하는 value에 연결된 key
	 *        remappingFunction : value를 변경하는 함수
	 *        
	 *        작동 : 
	 *          * 지정 key가 null이고 이 map이 null key를 지원하지 않을 경우 NullPointerException을 throw
	 *          * 지정 remappingFunction이 null일 경우 NullPointerException을 throw
	 *          
	 *          * map에서 지정 key에 연결된 oldValue를 가져온다. (만약 현재 매핑이 없을 경우 null을 가져옴)
	 *            OldValue를 remapping한 새로운 newValue를 구한다.
	 *          
	 *          * newValue가 null이 아닐 경우
	 *             - map에 (key,newValue)를 put 후 newValue 반환
	 *          * newValue가 null일 경우
	 *             - oldValue가 null이 아니거나, key가 존재할 경우 : map에서 (key, OldValue)를 제거 후 null 반환
	 *             - oldValue가 null이 아니고, 
	 *          
	 *          * 지정된 key와 연결된 oldValue를 remapping한 새로운 newValue를 덮어씌운뒤 반환
	 *          * newValue가 null일 경우
	 *            - oldValue가 null이 아니거나 key가 존재할 경우 : key를 제거하고 null 반환
	 *            - oldValue가 null이고, key가 존재하지 않을 경우 : null반환
	 *                   
	 *        예외 : 이 메서드는 다음을 throw한다.
	 *         - NullPointerException : key가 null이고, 이 맵이 null키를 지원하지 않거나 remappingFunction이 null일 경우
	 *         - UnsupportedOperatorException : 이 맵이 put 작업을 지원하지 않을 경우
	 *         - ClassCastException : key또는 value의 클래스가, 이 맵에 저장되는 것을 막을 경우
	 *         - illegalArgumentException : key 또는 value의 일부 속성으로 인 해 이 맵에 저장되지 않는 경우
	 *         
	 * ========================================================================
	 */


import java.util.*;

public class LambdaEx4_2 {

	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<>();
		map.put("종류", "토끼");
		map.put("이름", "토실이");
		System.out.println("map1 : "+map);
		
		// compute : 지정 key의 value를 람다식을 통해 변경 후 반환
		map.compute("종류", (key, value) -> value.concat("고기"));
		map.compute("이름", (key, value) -> value.concat("였던 것"));
		System.out.println("map1 : "+map);
		
		// compute : oldValue가 null이 아니거나 key가 존재하는데 newValue가 null일 경우 map에서 제거된다.
		map.put("친구", null); // key는 존재하지만 value가 null임
		System.out.println("map1 : "+map);
		
		map.compute("이름", (key,value) -> null); // oldValue가 null이 아닌 것을, null로 변경했더니 entry가 map에서 제거된다.
		map.compute("친구", (key,value) -> null); // oldValue가 null인 것을 null로 덮어씌웠음에도 entry가 map에서 제거된다.
		System.out.println("map1 : "+map);
		System.out.println();
		
		Map<String, Integer> map2 = new HashMap<>();
		map2.put("key1", 10);
		map2.put("key2", 20);
		map2.put("key3", null);
		System.out.println("map2 : "+map2);
		
		map2.compute("key1", (key,value) -> (value==null)? 1 : value+1);
		map2.compute("key2", (key,value) -> (value==null)? 1 : value+2);
		map2.compute("key3", (key,value) -> (value==null)? 1 : value+3);
		System.out.println("map2 : "+map2);
		
		try {
			map2.compute(null, (key, value)-> value+4); // 지정 key값이 null일 경우 NullPointerException을 throw
			System.out.println("map2 : "+map2);
		} catch (NullPointerException e) {
			System.out.println("Exception : "+e);
		}
		
	}
}
