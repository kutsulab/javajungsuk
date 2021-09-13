
public class WrapperEx2 {

	public static void main(String[] args) {
		
		
		/* Java의 정석 3판 p.491 예제 9-24 내용 확인 및 연습 : Number 클래스, 문자열-기본형데이터, 문자열-래퍼클래스 객체
		 *
		 * [Number 클래스]
		 * 
		 * 모든 Wrpper 클래스는 Number 클래스의 자손이다.
		 * Number 클래스는 abstract 클래스로서,
		 * abstract 메서드 intValue, longValue, floatValue, doubleValue, ... 을 가지고 있다.
		 * 
		 * ~Value 메서드들은 각각의 래퍼 클래스에서를 오버라이드되어있어서
		 * 각 객체에 저장된 값을 ~Value 메서드를 호출함으로서 원하는 타입의 기본형 데이터로 반환할 수 있다.
		 * 
		 * [문자열로 된 숫자를 기본형 데이터로 반환하기]
		 * 	여기서는 int 타입만을 예시를 들어 설명함
		 * 
		 * 	1. new Integer("숫자").intValue() : Integer 객체를 생성하여, intValue()를 통해 value를 int 타입으로 반환 
		 *  2. Integer.parseInt("숫자") : Integer 클래스의 static 메서드 parseInt()를 통해 int 타입으로 반환
		 *  3. Integer.valueOf("숫자") : 본래 래퍼클래스로 반환하지만, 사용처에서 int로 사용할 경우 컴파일러가 자동으로 int 타입으로 변환 해준다. (언박싱)
		 *  
		 * [문자열로 된 숫자를 래퍼 클래스 객체로 반환하기]
		 *  - Integer.valueOf("숫자") : 문자열을 숫자로 변환하여 value로 저장한 Integer 객체를 반환함
		 *  - 기본형 데이터를 사용처에서 Integer로 사용할 경우 컴파일러가 알아서 Integer로 변환함 (오토박싱)
		 * 
		 * [오토박싱, 언박싱]
		 *  - 기본형 데이터, 래퍼클래스의 객체를 각각 반대로(기본형데이터를 객체로, 래퍼클래스를 기본형 데이터로) 사용하려 할 때
		 *    컴파일 할 때 컴파일러가 알아서 반대로 바꾸는 코드를 작성해줌. (JDK 1.5부터)
		 * 
		 */ 
		int i1 = new Integer("100").intValue();
		// 100을 저장한 Integer 객체를 생성 후 객체의  value를 int 타입으로 반환하여 저장
		
		int i2 = Integer.parseInt("100");
		// 문자열 "100"을 int 100으로 변환하여 반환
		
		Integer i3 = Integer.valueOf("100");
		// 문자열 "100"을 value에 100이 저장된 Integer 객체로 반환
		
		int i4 = Integer.parseInt("100", 2);
		// 문자열 "100"을 2진법 숫자로 해석, 10진수 int로 변환하여 반환
		
		int i5 = Integer.parseInt("100", 8);
		// 문자열 "100"을 8진법 숫자로 해석, 10진수 int로 변환하여 반환
		
		int i6 = Integer.parseInt("100", 16);
		// 문자열 "100"을 16진법 숫자로 해석, 10진수 int로 변환하여 반환
		
		int i7 = Integer.parseInt("FF", 16);
		// 문자열 "FF"을 16진법 숫자로 해석, 10진수 int로 변환하여 반환

		// int i8 = Integer.parseInt("FF");
		// 진법을 지정해주지 않으면 "FF"는 숫자로 인식되지 않음
		
		Integer i9 = Integer.valueOf("100", 2);
		// 문자열 "100"을 2진법 숫자로 해석, 10진수 Integer 객체로 반환
		
		Integer i10 = Integer.valueOf("100", 8);
		// 문자열 "100"을 8진법 숫자로 해석, 10진수 Integer 객체로 반환
		
		Integer i11 = Integer.valueOf("100", 16);
		// 문자열 "100"을 16진법 숫자로 해석, 10진수 Integer 객체로 반환
		
		Integer i12 = Integer.valueOf("FF", 16);
		// 문자열 "FF"을 16진법 숫자로 해석, 10진수 Integer 객체로 반환
		
		// Integer i13 = Integer.valueOf("FF");
		// 진법을 지정해주지 않으면 "FF"는 숫자로 인식되지 않음
		
		System.out.println("i1 : "+i1);
		System.out.println("i2 : "+i2);
		System.out.println("i3 : "+i3);
		// Integer 클래스는 toString() 메서드가 오버라이드 되어 있어서 value가 그대로 문자열로 반환됨
		
		System.out.println("100 (2) : "+i4); // 반환타입이 int인 것들
		System.out.println("100 (8) : "+i5);
		System.out.println("100 (16) : "+i6);
		System.out.println("FF (16) : "+i7);
		
		System.out.println("100 (2) : "+i9); // 반환타입이 Integer인 것들
		System.out.println("100 (8) : "+i10);
		System.out.println("100 (16) : "+i11);
		System.out.println("FF (16) : "+i12);
		
	}

}
