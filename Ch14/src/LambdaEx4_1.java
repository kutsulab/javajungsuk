
	/* ========================================================================
	 *  Java의 정석 3판 p.805 예제 14-4 : 컬렉션 프레임웍과 함수형 인터페이스 [List]
	 * ========================================================================
	 *
	 *      1. Collection의 람다식 관련 메서드
	 *        boolean removeIf(Predicate<E> filter) : 조건에 맞는 요소를 삭제
	 *      
	 *      2. List의 람다식 관련 메서드
	 *        void replaceAll(UnarayOperator<E> operator) : 모든 요소를 지정 함수를 통해 대체
	 *      
	 *      3. Iterable의 람다식 관련 메서드
	 *        void forEach(Consumer<T> action) : 모든 요소에 대하여 지정 작업 action을 수행
	 *      
	 * ========================================================================
	 */

import java.util.*;

public class LambdaEx4_1 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		for (int i=0; i<10; i++) list.add(i); // 리스트의 각 index마다 index의 값을 추가
		
		list.forEach(i-> System.out.print(i+", ")); // list의 모든 요소를 출력한다.
		System.out.println();
		
		list.removeIf(i->i%2==0||i%3==0); // 2의 배수이거나 3의 배수이면 지운다.
		System.out.println(list);
		
		list.replaceAll(i->i*10); // 각 요소에 10을 곱한다.
		System.out.println(list);
		
	}

}
