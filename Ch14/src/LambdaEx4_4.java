import java.util.*;

	/* ========================================================================
	 *  Java의 정석 3판 p.805 예제 14-4 : 컬렉션 프레임웍과 함수형 인터페이스 [Map : merge, forEach]
	 * ========================================================================
	 *
	 *   1. Map의 람다식 관련 메서드
	 *         
	 *     4) default V merge(K key, V value,
	 *               BiFunction<? super V, ? super V, ? extends V> remappingFunction)
	 *        
	 *        
	 *        key : 결과값이 연결되는 key
	 *        value : key와 연결된 oldValue과 병합되는 null이 아닌 값
	 *                key와 연결된 oldValue가 존재하지 않거나 null일 경우, 지정 key와 연결될 값
	 *        remappingFunction : oldValue가 존재할 경우, 다시 계산하는 병합함수
	 *        
	 *        작동 : 
	 *           * 지정 key가 null이고, 이 맵이 null key를 지원하지 않을 경우 NullPointerException을 throw
	 *           * 지정 remappingFunction이 null일 경우 NullPointerException을 throw
	 *           * 지정 value가 null일 때 NullPointerException을 throw
	 *            
	 *           * key를 통해 OldValue를 가져온다.
	 *           * OldValue가 null이면 newValue에 value를,
	 *             OldValue가 null이 아니면, newValue에 (oldValue, value) 의 remappingFunction(병합함수)의 함숫값 입력
	 *           
	 *           * newValue가 null이면 map에서 (key, oldValue)를 제거하고
	 *             newValue가 null이 아니면 (key,newValue)를 map에 put한다.
	 *             
	 *           
	 *        예외>
	 *          - NullPointerException
	 *             1) 지정 key가 null이고, 이 map이 null을 지원하지 않는 경우
	 *             2) 지정 value가 null
	 *             3) 지정 mappingFunction이 null인 경우
	 *             
	 *          - UnsupportedOperationException : 이 맵이 put 작업을 지원하지 않을 경우 (선택)
	 *          - ClassCastException : 지정된 key 또는 value의 클래스가, 이 맵에 저장되는 것을 방지하는 경우 (선택)
	 *          
	 *      5) default void forEach(BiConsumer<? super K, ? super V> action)
	 *           모든 entry에 대해 지정 함수의 작업이 수행되거나, 예외를 throw할 때까지
	 *           map의 각 entry에 대해 지정 작업을 수행한다.
	 *           
	 *           Map의 구현 클래스에서 달리 지정하지 않는 한, 작업은 항상 Set iteration? 의 순서로 진행됨 (반복 순서가 지정된 경우)
	 *           
	 *           작업에서 throw된 예외는 호출자에게 전달된다.
	 *           
	 *           이 디폴트 메서드를 구현하는 기본적 방법>
	 *           for (Map<Entry<K,V>> entry : map.entrySet()) {
	 *               action.accept(entry.getKey, entry.getValue());
	 *               };
	 *               
	 *               action : 수행할 함수
	 *           
	 *           throw :
	 *             NullPointerException : 지정 action이 null일 경우
	 *             ConcurrentModificationException : 어떤 entry가 반복 중에 제거된 것으로 확인된 경우
	 *             
	 * ========================================================================
	 */

public class LambdaEx4_4 {

	public static void main(String[] args) {
		Map<String, Integer> map1 = new HashMap<>();
		map1.put("Apple",1);
		map1.put("Banana",3);
		map1.put("Orange",5);
		
		Map<String, Integer> map2 = new HashMap<>();
		map2.put("Banana",5);
		map2.put("Apple",2);
		map2.put("Orange",9);
		
		System.out.println("map1 : "+map1);
		System.out.println("map2 : "+map2);
		System.out.println();
		
		// map2의 각 (key, Value)에 대하여 map1에서 key를 통해 조회하여, 
		// 연결된 value가 있으면 합산하여 map1에 합산, 그렇지 않다면 map2의 value를 put
		map2.forEach((key,Value) -> 
						map1.merge(key, Value, (v1, v2) -> v1+v2));
		
		//map1의 각 entry에 대하여, 지정 작업을 수행
		System.out.println("After merge to map1 : \n");
		map1.forEach((key,value)-> System.out.print("{\""+key+"\", "+value+"}, "));
		
	}

}
