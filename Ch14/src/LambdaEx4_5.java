
	/* ========================================================================
	 *  Java의 정석 3판 p.805 예제 14-4 : 컬렉션 프레임웍과 함수형 인터페이스 [Map : replaceAll]
	 * ========================================================================
	 *
	 *   1. Map의 람다식 관련 메서드
	 *   
	 *       https://docs.oracle.com/javase/8/docs/api/
	 *       
	 *       6) default void replaceAll
	 *               (BiFunction<? super K, ? super V, ? extends V> function)
	 *       모든 entry가 function에 처리되거나,
	 *       함수가 예외를 throw할 때까지 각 entry의 value를 주어진 함수의 결과로 변경한다.
	 *       
	 *       기본적으로 다음과 같은 원리로 동작됨
	 *       
	 *       for(Map.Entry<K,V> entry : map.entrySet()) {
	 *         entry.setValue(function.apply(entry.getKey(), entry.getValue()));
	 *       }
	 *       
	 *       function : 각 항목에 적용될 함수
	 *       
	 *       throw :
	 *       
	 *       NullPointerException :
	 *         - 지정된 함수가 null인 경우
	 *         - 지정된 대체값이 null이고 이 맵이 null값을 허용하지 않을 경우
	 *       ClassCastException : 대체값이 이 map에 대해 부적절한 유형인 경우 (선택사항)
	 *       IllegalArgumentException : 대체값의 일부 속성이 이 맵에 저장되는 것을 방지할 경우(선택사항)
	 *       ConcurrentModificationException : entry가 반복중에 제거된 것으로 확인 된 경우
	 *       UnsupportedOperationException : 이 map의 entrySet iterator가 Set 조작을 지원하지 않을 경우
	 *       
	 * ========================================================================
	 */

import java.util.*;

public class LambdaEx4_5 {

	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<>();
		map.put("apple", 5);
		map.put("grape", 3);
		map.put("pear", 4);
		System.out.println("map : \n"+map);
		System.out.println();
		
		map.replaceAll((key, value) -> key.length()+value+5); // map의 각 entry의 value를 지정 function의 결과값으로 대체한다.
		System.out.println("after Operation : \n"+map);
	}
}
