
	/* ========================================================================
	 *  Java의 정석 3판 p.819 : Stream의 생성 (2), (3), (4)
	 * ========================================================================
	 *
	 *     1. Stream의 생성 (2) 임의의 수
	 *     
	 *       1) 무한 난수 Stream
	 *         Random 클래스의 인스턴스 메서드
	 *         
	 *         - IntStream ints() : Integer.MIN_VALUE <= ints() <= Integer.MAX_VALUE
	 *         - LongStream longs() : LONG.MIN_VALUE <= longs() <= LONG.MAX_VALUE
	 *         - DoubleStream doubles() : 0.0 <= doubles() < 1.0
	 *         
	 *       2) 무한 Stream의 크기 제한
	 *         - 각 기본형 변수 Stream에 .limit(long streamSize)를 지정해주면,
	 *           지정 값만큼을 크기로 하는 Stream으로 만들어줌
	 *       
	 *       3) 난수의 범위 제한 : 여기서 end는 범위에 포함되지 않음
	 *         - IntStream ints(int begin, int end)
	 *         - LongStream longs(long begin, long end) 
	 *         - DoubleStream doubles(double begin, double end)
	 *         
	 *       4) 크기, 범위 제한을 동시에
	 *         - IntStream ints(long streamSize, int begin, int end)
	 *         - LongStream longs(long streamSize, long begin, long end)
	 *         - DoubleStream doubles(long streamSize, double begin, double end)
	 *      
	 * ========================================================================
	 * 
	 *      2. Stream의 생성 (3) 특정 범위의 정수
	 *      
	 *       - IntStream IntStream.range(int begin, int end)
	 *       - IntStream IntStream.rangeClosed(int begin, int end)
	 *       - LongStream LongStream.range(long begin, long end)
	 *       - LongStream LongStream.rangeClosed(long begin, long end)
	 *                
	 * ========================================================================
	 * 
	 *      3. Stream의 생성 (4) 람다식을 통한 생성
	 *      
	 *       1) iterate() : 초깃값 지정 o, 이전 요소에 종속적
	 *       
	 *        - static <T> Stream<T> iterate(T seed, UnaryOperator<T> f)
	 *        
	 *          - 초깃값(seed)를 지정하여,
	 *            지정된 값부터 시작하여 람다식 f에 의해 계산된 결과를 다음 Seed값으로 하길 반복함.
	 *       
	 *       2) generate() : 초깃값 지정 x, 이전 요소에 독립적
	 *       
	 *        - static <T> Stream<T> generate(Supplier<T> s)
	 *         
	 *          - 초깃값(seed) 없음. 람다식이 Supplier(입력이 없고 return만 있음)
	 *          
	 *       3) 주의점
	 *        - 기본형 Stream을 생성할 수 없음
	 *        - 굳이 필요하다면 mapToInt()와 같은 메서드를 사용해야함.
	 *        
	 *          예> IntStream evenStream = Stream.iterate(0, n->n+2).mapToInt(Integer::ValueOf)
	 *          
	 *         (cf) IntStream을 Stream<Integer>로 변경시에는 boxed() 메서드를 쓰면 됨
	 *          
	 * ========================================================================
	 */

import java.util.*;
import java.util.stream.*;

public class StreamEx2 {

	public static void main(String[] args) {
		// IntStream intStream = new Random().ints(); // 무한 Stream
		// IntStream intStream = new Random().ints(5,10); // 무한 Stream (5~10범위)
		// IntStream intStream = new Random().ints().limit(5); // 유한 Stream (5개)
		// IntStream intStream = new Random().ints(5); // 유한 Stream (5개)
		
		IntStream intStream = new Random().ints(10,0,10); // 0이상 10미만의 임의의 수 10개
		intStream.forEach(System.out::print);
		System.out.println();
		
		IntStream intStream2 = IntStream.range(0,10); // 0이상 10미만의 연속된 정수 Stream
		IntStream intStream3 = IntStream.rangeClosed(0,10); // 0이상 10이하의 연속된 정수 Stream
		
		intStream2.forEach(System.out::print);
		System.out.println();
		intStream3.forEach(System.out::print);
		System.out.println();
		
		Stream<Integer> integerStream = Stream.iterate(1, n-> n+2).limit(10);
		integerStream.forEach(System.out::print);;
		System.out.println();
		
		Stream<Integer> rdmStream = Stream.generate(()->(int)(Math.random()*10)).limit(5);
		// IntStream rdmStream = new Random().ints(5,0,10);
		rdmStream.forEach(System.out::print);
	}

}
