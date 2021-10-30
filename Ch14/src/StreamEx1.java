
	/* ========================================================================
	 *  Java의 정석 3판 p.814 : Stream이란 무엇일까?
	 * ========================================================================
	 *
	 *     1. Stream이란?
	 *     
	 *       데이터의 연속적인 흐름. 다양한 데이터 소스를 표준화된 방법으로 다루기 위한 것
	 *       
	 *       1) Stream의 도입 계기 : 기존 방식의 불편함
	 *       
	 *         - 여러 데이터를 다루기 위해서, for문, Iterator문 등을 이용해 코드를 작성함
	 *            -> 코드의 길이도 길고, 재사용성이 좋지 못 하다.
	 *            
	 *         - 데이터 소스마다 다른 방식으로 처리해야해서 불편하다.
	 *         
	 *       2) Stream의 편리성
	 *       
	 *         - 다양한 종류의 데이터 소스를 추상화하고, 데이터를 다루는데 자주 사용되는 메서드들을 정의함.
	 *         - 어떤 데이터소스든간에 표준화된 방법으로 데이터를 처리할 수 있고, 코드의 재사용성이 높아진다.
	 *       
	 *       3) Stream을 통한 작업의 흐름
	 *    
	 *      - 스트림 생성 : 데이터소스를 기반으로 스트림 생성
	 *      - 중간 연산 : 연산결과가 Stream인 연산. 반복적으로 적용 가능.
	 *      - 최종 연산 : 연산결과가 Stream이 아닌 연산. 단 한번만 적용가능. (Stream의 요소를 소모)
	 *      
	 * ========================================================================
	 * 
	 *      2. Stream의 특징
	 *      
	 *        1) 데이터 소스를 변경하지 않음. (Read Only)
	 *        2) 재사용을 허용하지 않음. 재사용을 하기 위해서는 데이터 소스를 기반으로 다시 Stream을 생성해야한다.
	 *            -> 사용된 Stream을 다시 재사용하면 예외가 발생함.
	 *            
	 *        3) Stream은 작업을 내부반복으로 처리한다. (for문, iterator 등이 메서드 내부에 숨겨짐)
	 *        4) 다양한 연산 제공 : 여러가지 중간연산, 최종 연산 메서드를 통해 복잡한 작업을 간단히 처리할 수 있음
	 *            예> forEach, count, ...
	 *            
	 *        5) 지연된 연산 : 최종연산이 수행되기 전까지 중간연산이 수행되지 않는다.
	 *        6) 기본형 타입에 대한 Stream이 별도로 존재한다. (IntStream, DoubleStream, ...)
	 *           -> 오토박싱, 오토 언박싱으로 인한 비효율을 줄이기 위함.
	 *           -> 이들 기본형 Stream은 각각 기본형에 대한 유용한 메서드들이 추가적으로 포함되어 있음.
	 *        7) 병렬 스트림 : 여러 작업을 병렬로 연산을 수행할 수 있음. (parallel() 메서드)
	 *        
	 * ========================================================================
	 * 
	 *      3. Stream의 생성 (1) 가변인자, 배열, 컬렉션을 기반으로 한 Stream 생성
	 *      
	 *        1) 컬렉션을 통한 Stream의 생성
	 *        
	 *          - Stream<T> Collection.stream()
	 *        
	 *        2) 가변 인자, 배열을 통한 Stream의 생성
	 *          - Stream<T> Stream.of(T... values)
	 *          - Stream<T> Stream.of(T[] tArr)
	 *          - Stream<T> Arrays.stream(T[] tArr)
	 *          - Stream<T> Arrays.stream(T[] array, int startInclusive, int endExclusive)
	 *              : 지정 배열의 start<=i<end 범위 인덱스에 존재하는 객체를 기반으로 한 Stream 생성
	 *        
	 *        3) 기본형 배열을 소스로 하는 기본형 Stream 생성
	 *          예시> IntStream의 생성법
	 *            - IntStream IntStream.of(int ...values)
	 *            - IntStream IntStream.of(int[] intArr)
	 *            - IntStream Arrays.stream(int[] intArr)
	 *            - IntStream Arrays.stream(int[] intArr, int startInclusive, int endExclusive)
	 *                : 지정 int배열의 start<=i<end 범위 인덱스에 존재하는 객체를 기반으로 한 Stream 생성
	 *                
	 * ========================================================================
	 */


import java.util.*;
import java.util.stream.*;

public class StreamEx1 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Stream<Integer> intStream0 = list.stream(); // list를 기반으로 한 Stream 생성
		System.out.print("list.stream() : ");
		intStream0.forEach(System.out::print); // forEach() : 최종연산을 했기 때문에 재사용이 불가능 (close)
		System.out.println();
		
		intStream0 = list.stream(); // list로부터 Stream을 다시 생성
		System.out.print("list.stream() : ");
		intStream0.forEach(System.out::print);
		System.out.println("\n");
		
		String[] strArr = new String[] {"a","b","c"}; // 객체 배열
		
		Stream<String> strStream1 = Stream.of("a","b","c"); // 가변인자
		Stream<String> strStream2 = Stream.of(strArr); // 배열
		Stream<String> strStream3 = Arrays.stream(strArr); // Arrays.stream의 배열 참조
		Stream<String> strStream4 = Arrays.stream(strArr,1,3); // Arrays.stream의 배열 부분 참조 
		
		System.out.println("strStream 1 ↓");
		strStream1.forEach(System.out::println);
		System.out.println();
		
		System.out.println("strStream 4 ↓");
		strStream4.forEach(System.out::println);
		System.out.println();
		
		int[] intArr = new int[] {1,2,3,4,5}; // int 배열
		
		IntStream intStream1 = IntStream.of(1,2,3,4,5); // 가변 인자로 IntStream 생성
		IntStream intStream2 = IntStream.of(intArr); // 배열로 IntStream 생성
		IntStream intStream3 = Arrays.stream(intArr); //Arrays.stream으로 기본형 데이터의 배열
		IntStream intStream4 = Arrays.stream(intArr,2,intArr.length); //Arrays.stream으로 기본형 데이터의 배열 부분 참조
		
		System.out.println("intStream1 ↓");
		intStream1.forEach(System.out::print);
		System.out.println('\n');
		
		System.out.println("intStream2.sum() : "+intStream2.sum()); // 총합을 출력
		System.out.println();
		
		System.out.println("intStream3.average().getAsDouble() : "+intStream3.average().getAsDouble()); // 평균을 출력
		
		System.out.println();
		
		System.out.println("intStream4 ↓");
		intStream4.forEach(System.out::print);
		System.out.println('\n');
		
		Integer[] integer_Arr = {6,7,8,9,0}; // 객체 배열
		Stream<Integer> integer_Stream1 = Stream.of(6,7,8,9,0);
		Stream<Integer> integer_Stream2 = Stream.of(integer_Arr);
		Stream<Integer> integer_Stream3 = Arrays.stream(integer_Arr);
		Stream<Integer> integer_Stream4 = Arrays.stream(integer_Arr,2,integer_Arr.length); // 2번 인덱스부터, 배열의 끝까지를 데이터소스로 한 Stream 생성
		
		System.out.println("integer_Stream1 ↓");
		integer_Stream1.forEach(System.out::print);
		System.out.println('\n');
		
		System.out.print("integer_Stream2.count() : "+integer_Stream2.count()); // 객체의 갯수를 반환
		System.out.println('\n');
		
		System.out.println("integer_Stream4 ↓");
		integer_Stream4.forEach(System.out::print);
		System.out.println('\n');
	}

}
 