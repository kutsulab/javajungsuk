
	/* ========================================================================
	 *  Java의 정석 3판 p.812 : 메서드 참조 
	 * ========================================================================
	 *
	 *     1. 메서드 참조
	 *       어떤 함수의 선언부에서, 매개변수 및 결과값의 타입이 주어지면
	 *       람다식에서 타입을 선언하지 않고도 이 함수의 입력 타입과, 반환 타입을 짐작할 수 있다.
	 *       이를 이용해 실제 함수에 해당하는 람다식을  간략화할 수 있다.
	 *       
	 *       1) static메서드의 참조
	 *         
	 *        (x) -> 참조클래스.참조메서드(x)
	 *        참조클래스 :: 참조 메서드
	 *        
	 *        예> Function<String, Integer> f = (s) -> Integer.parseInt(s);
	 *        메서드 참조> Function<String, Integer> f = Integer :: parseInt;
	 *      
	 *       2) 인스턴스 메서드 참조
	 *        
	 *        (obj, x) -> obj.참조메서드(x)
	 *        클래스명 :: 메서드
	 *       
	 *        예> Function<String, Integer> g = (s) -> s.length();
	 *        메서드 참조> Function<String, Integer> g = String :: length
	 *        
	 *        예> BiFunction<String,String,Boolean> g = (s1, s2) -> s1.equals(s2);
	 *        메서드 참조> BiFunction<String,String,Boolean> g = String :: equals;
	 *        
	 *       3) 특정 객체의 인스턴스 메서드 참조
	 *       
	 *         x -> 특정참조객체.참조 메서드(x)
	 *         특정참조객체 :: 참조 메서드
	 *         
	 *         예) String str = "위대한 "; 
	 *            Function<String,String> f = s-> str.concat(s);
	 *         메서드 참조> Function<String> f = str :: concat   
	 *       
	 * ========================================================================
	 */

import java.util.Arrays;
import java.util.function.*;

public class LambdaEx8 {

	public static void main(String[] args) {
		ToIntFunction<String> f = Integer :: parseInt; // 메서드를 참조하여 파싱하는 함수 
		//ToIntFunction<String> f = s -> Integer.parseInt(s);
		int f_result = f.applyAsInt("3");
		System.out.println("f_result : "+f_result);
		System.out.println();
		
		Supplier<MyClassEx8> s = MyClassEx8::new; // 생성자를 참조하여 객체를 생성, 반환하는 함수
		// Supplier<MyClassEx8> s = () -> new MyClassEx8();
		MyClassEx8 s_result = s.get();
		System.out.println("s_result : "+s_result);
		System.out.println();
		
		IntFunction<MyClassEx8> intf = MyClassEx8::new; // 생성자를 참조하여 객체를 생성, 반환하는 함수
		// IntFunction<MyClassEx8> intf = (i) -> new MyClassEx8(i);
		MyClassEx8 intf_result = intf.apply(20);
		System.out.println("intf_result : "+intf_result);
		System.out.println();
		
		IntFunction<int[]> intArrf = int[]::new; // 배열의 생성자를 호출하여, 배열을 생성, 반환
		// IntFunction<int[]> intArrf = (i) -> new int[i];
		int[] intArr = intArrf.apply(10);
		Arrays.setAll(intArr, i->i+1);
		System.out.println(Arrays.toString(intArr));
		
		ToIntFunction<String> toIntf = String::length;
		System.out.println(toIntf.applyAsInt("멍멍멍"));
		
		MyClassEx8 mc = intf.apply(5);
		IntUnaryOperator io = mc::getAddition; // mc 객체의 getAddition 메서드를 호출하여 return값을 반환
		System.out.println(io.applyAsInt(10));
	}

}

class MyClassEx8 {
	
	private int value;
	
	MyClassEx8() {
		this((int)(Math.random()*10)+1); // 1~10 중 임의의 값
	}
	
	MyClassEx8(int value) {
		this.value = value;
		return;
	}
	
	// 지정 값을 객체의 value에 합산하여 반환
	int getAddition(int addNumber) {
		return value+addNumber;
	}
	
	public String toString() {return String.valueOf(value);}
}
