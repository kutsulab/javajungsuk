
	/* ========================================================================
	 *  Java의 정석 3판 p.801 예제 14-5 : 기본 함수형 인터페이스
	 * ========================================================================
	 *
	 *     1. java.lang.Runnable
	 *         입력이 없고, 반환값도 없음. 주로 쓰레드 구현에 사용
	 *         메서드 : void run()
	 * 
	 *     2. java.util.function.*
	 *     
	 *       1) Supplier<T>
	 *         - 입력이 없고, 반환값만 있음.
	 *         - 메서드 : T get() 
	 *       
	 *       2) Consumer<T>
	 *         - 입력이 존재하고, 반환값이 없음.
	 *         - 메서드 : void accept(T t)
	 *         
	 *       3) Function<T,R> 
	 *         - 입력과 반환이 둘 다 있음.
	 *         - 메서드 : R apply(T t)
	 *       
	 *       4) Predicate<T>
	 *         - 입력과 반환이 둘 다 있는데, 반환이 boolean 타입으로 고정됨. 조건식을 표현하는 함수
	 *         - 메서드 : boolean test(T t)
	 * 
	 * ========================================================================
	 * 
	 *     3. 매개변수가 두개인 함수형 인터페이스
	 *     
	 *        1) BiConsumer<T,U>
	 *           - 입력값이 두개, 반환값 없음.
	 *           - 메서드 : void accept(T t, U u)
	 *           
	 *        2) BiFunction<T,U,R>
	 *           - 입력값이 두개, 반환값 있음.
	 *           - 메서드 : R apply(T t, U u)
	 *        
	 *        3) BiPredicate<T,U>
	 *           - 입력값이 두개, 반환값이 있음.(boolean)
	 *           - 메서드 : boolean test(T t, U u)
	 *           
	 * ========================================================================
	 * 
	 *     4. 매개변수의 타입과 반환타입이 모두 일치하는 함수형 인터페이스
	 *        Function의 변형들
	 *     
	 *        1) UnaryOperator<T>
	 *          - 입력이 T, 반환타입이 T인 Function
	 *          - 메서드 : T apply(T t)
	 *        2) BinaryOperator<T>
	 *          - 입력이 T, T 이고 반환 타입이 T인 Function
	 *          - 메서드 : T apply(T t1, T t2)
	 *     
	 * ========================================================================
	 */
import java.util.*;
import java.util.function.*;

public class LambdaEx5 {

	public static void main(String[] args) {
		
		// 함수들의 정의
		Supplier<Integer> getRandomNumber = () -> (int)(Math.random()*100)+1; // 1~100 중 임의의 값을 반환하는 함수
		Consumer<Integer> printWithDelim = i -> System.out.print(i+", "); // 정수를 입력받아, ", "을 붙여 출력함
		Predicate<Integer> isEvenNumber = i -> i%2==0; // 정수를 입력받아 짝수이면 true, 홀수면 false를 반환 
		Function<Integer, Integer> deleteOnesPlace = i-> i/10*10; // 정수를 입력받아 일의 자리 숫자를 제거
		
		// size가 10인 list에 1~100까지 임의의 값들을 채운다.
		List<Integer> list = new ArrayList<>();
		fillList(list, getRandomNumber, 10);
		System.out.println(list);
		
		// List에서 짝수들만 출력한다
		do_ConsumersWork_with_ValidElement(list, printWithDelim, isEvenNumber);
		
		// List의 각 요소별로 일의자리 숫자를 제거한 숫자들의 List를 반환받고, 이를 출력한다.
		List<Integer> editedList = editList(list, deleteOnesPlace);
		System.out.println(editedList);
	}
	
	
	// 지정 Supplier에 정의된 return값들로 list를 채운다.
	static <T> void fillList(List<T> list, Supplier<T> s, int size) {
		for (int i=0; i<size; i++) {
			T rdm = s.get();
			list.add(rdm);
		}
		return;
	}
	
	// 지정 Predicate 함수의 조건에 부합하는 요소들에 한하여 Consumer의 작업을 수행...
	// 인데 이런식으로 짠 코드는 가독성만 안 좋아보임. 이것은 어디까지나 연습삼하서 기본 함수형 인터페이스를 사용해본 것.
	static <T> void do_ConsumersWork_with_ValidElement(List<T> list, Consumer<T> c, Predicate<T> p) {
		System.out.print('[');
		for (T t : list) {
			if (p.test(t)) c.accept(t);
		}
		System.out.println(']');
		return;
	}
	
	// 지정 Function<T,T>에 정의에 맞게, list의 값을 변형한 값들의 list를 반환한다. 
	static <T> List<T> editList(List<T> list, Function<T,T> f) {
		List<T> newList = new ArrayList<>(list.size());
		
		for (T t : list) {
			T editedElement = f.apply(t);
			newList.add(editedElement);
		}
		return newList;
	}
}
