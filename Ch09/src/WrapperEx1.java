
public class WrapperEx1 {
	/*
	 * [래퍼 클래스]
	 * 
	 * 1. 래퍼클래스 : 기본형 변수를 객체로 다룰 때 사용
	 * 
	 * 2. 래퍼클래스의 종류
	 * 	boolean -> Boolean
	 * 	char -> Character
	 * 	byte -> Byte
	 * 	short -> Short
	 * 	int -> Integer
	 * 	long -> Long
	 * 	float -> Float
	 * 	double -> Double
	 * 
	 * 3. 래퍼클래스의 생성자
	 *		1) 기본형 변수를 매개변수로 하여 생성. 혹은 문자열로 표현된 같은 타입의 기본형 변수를 매개변수로 하여 생성
	 *			예> Integer (int value), Integer(String s)
	 *				-> Integer(100), Integer ("100")
	 *		2) 타입에 맞지 않는 매개변수를 입력시 Exception 발생함
	 *			예> Integer("10.0") -> NumberFormatException! (타입이 안 맞음)
	 * 
	 * 4. 래퍼클래스의 주요 메서드 (예 : Integer)
	 * 		1) .equals(Integer i) : 두 Integer 객체의 value를 비교하도록 오버라이드
	 *		2) .compareTo(Integer i) : 두 Integer 객체의 value를 비교하여 대소관계를 정수로 반환
	 *			(호출 객체를 기준으로, 호출객체의 value가 크면 양수, 작으면 음수, 같으면 0 반환)
	 *		3) .toString() : 객체의 value를 문자열로 출력하도록 오버라이드
	 */

	
	
	public static void main(String[] args) {
		Integer i1 = new Integer(100); // Integer 타입의 객체 i1 생성 (안에 int 100이 저장)
		Integer i2 = new Integer(100); // Integer 타입의 객체 i2 생성 (안에 int 100이 저장)
		Integer i3 = new Integer("100"); // Integer 타입의 객체 i3 생성 ("100"을 int 100으로 변환하여 저장)
		
		System.out.println("i1==i2 ? : "+(i1==i2)); // i1, i2의 주소 비교
		System.out.println("i1.equals(i2) ? : "+i1.equals(i2)); // i1, i2의 인스턴스 변수 value의 값 비교 : 오버라이딩 되어 있음
		System.out.println("i1.equals(i3) ? : "+i3.equals(i3)); // i1, i3의 인스턴스 변수 value의 값 비교 : 오버라이딩 되어 있음
		System.out.println("i1.compareTo(i2) : "+i1.compareTo(i2)); // 대소관계 비교
		System.out.println("i1.toString() : "+i1.toString()); // 값을 문자열로 출력하도록 오버라이딩 됨
		System.out.println("MAX_VALUE : "+Integer.MAX_VALUE); // int 타입 값의 최댓값 (상수)
		System.out.println("MIN_VALUE : "+Integer.MIN_VALUE); // int 타입 값의 최솟값 (상수)
		System.out.println("SIZE : "+Integer.SIZE+" bits"); // int 타입 값의 크기 (bit)
		System.out.println("BYTES : "+Integer.BYTES+" bytes"); // int 타입 값의  크기 (byte)
		System.out.println("TYPE : "+Integer.TYPE); // 변수 타입 (상수) 
	}

}
