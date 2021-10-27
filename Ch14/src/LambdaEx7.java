
	/* ========================================================================
	 *  Java의 정석 3판 p.811 예제 14-7 : Function의 합성, Predicate의 결합
	 * ========================================================================
	 *
	 *     1. Function의 합성
	 *     
	 *       Function<T,U> f, Function<U,V>가 있을 때
	 *       f 함수를 수행하고 g함수를 수행한 함수와 동등한 합성함수 h는
	 *       
	 *       Function<T,V> h = f.andThen(g); // f합성 g
	 *       Function<T,V> h = g.compose(f); // f합성 g
	 *       
	 *       와 같이 정의할 수 있다.
	 *       
	 *       여기서 andThen과 compose 메서드는 Function 인터페이스에서
	 *       
	 *       default <V> Function<T,V> andThen(Function<? super R, ? extends V> after)
	 *       default <V> Function<T,V> compose(Function<? super V, ? extends T> before)
	 *       로 정의 되어 있다.
	 *
	 *       
	 * ========================================================================
	 *     
	 *     2. 항등함수
	 *      static <T> Function<T,T> identity() : 자기 자신을 반환함
	 *       
	 * ========================================================================
	 * 
	 *     3. Predicate의 결합
	 *     
	 *       default Predicate<T> and(Predicate<? super T> other) : &&
	 *       default Predicate<T> or(Predicate<? super T> other) : ||
	 *       default Predicate<T> negate() : not
	 *       
	 * ========================================================================
	 *     
	 *     4. 상등 여부를 판단하는 Predicate
	 *     
	 *       static <T> Predicate<T> isEqual(Object tartgetRef)
	 *       - 지정 객체와 같은 지의 여부를 판단하는 Perdicate를 반환
	 *       - 등가비교연산자 == 을 이용해서 비교하는 것이 아닌, equals 메서드를 기반으로 비교한다.
	 *       
	 * ========================================================================
	 */

import java.util.function.*;

public class LambdaEx7 {

	public static void main(String[] args) {
		Function<String, Integer> f = s -> Integer.valueOf(s, 16); // 지정 문자열을 16진수로 파싱하여 Integer로 반환
		Function<Integer, String> g = i -> Integer.toBinaryString(i); // 지정 Integer을 이진문자열로 반환
		
		Function<String, String> h1 = f.andThen(g); // 지정 문자열을 16진수 문자열로 읽어 Integer로 파싱 후, 이진 문자열로 변환하여 반환
		Function<Integer, Integer> h2 = f.compose(g); // 지정 Integer을 이진 문자열로 변환 후, 16진수로 파싱하여 Integer로 반환
		
		System.out.println(h1.apply("FF")); // "FF" -> 255 -> "11111111" 
		System.out.println(h2.apply(2)); // 2 -> "10" -> 16
		
		Function<String, String> f2 = Function.identity();
		// Function<String, String> f2 = str -> str (항등함수)
		System.out.println(f2.apply("AAA"));
		
		Predicate<Integer> p = i-> i<100; // i가 100보다 작으면 true
		Predicate<Integer> q = i-> i<200; // i가 200보다 작으면 true
		Predicate<Integer> r = i-> i%2==0; // i가 짝수이면 true
		Predicate<Integer> notP = p.negate(); // p의 부정 : i>=100
		
		Predicate<Integer> s = notP.and(q).or(r); // 100 이상 200미만이거나, 짝수
		System.out.println("s.test(150) : "+s.test(150));
		
		String str1 = "abc";
		String str2 = "abc";
		String str3 = "abcd";
		String str4 = new String("abc");
		
		Predicate<String> t = Predicate.isEqual(str1); // 입력값이 str과 같으면 true
		boolean result = t.test(str2);
		System.out.println("t.test(str2) : "+result); // 서로 같음
		
		boolean result2 = t.test(str3);
		System.out.println("t.test(str3) : "+result2); // 서로 다름
		
		boolean result3 = t.test(str4);
		System.out.println("t.test(str4) : "+result3);
		// isEqual이 == 기반으로 비교를 하는 것이 아닌 equals를 기반으로 객체가 다른지의 여부를 판단함을 알 수 있다.
	}

}