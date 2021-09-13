
public class WrapperEx3 {
	public static void main(String[] args) {
		
		/* Java의 정석 3판 p.495 내용 정리 : 오토박싱, 언박싱
		 * 
		 * [오토박싱, 언박싱]
		 *  본래 래퍼클래스 타입의 참조변수는 기본형 데이터를 저장하지 못 함.
		 *  반대로 기본형 데이터에는 래퍼클래스의 객체를 저장하지 못 함.
		 *  
		 *  JDK 1.5부터,
		 *  본래 래퍼클래스 타입의 객체를 받아야하는 곳에 기본형 데이터를 뒀을 경우
		 *  컴파일러가  자동으로 래퍼클래스의 객체를 생성해서 대체함. (예 : int->Integer : 오토박싱)
		 *  
		 *  또, 기본형 데이터를 받아야하는 곳에 래퍼클래스 객체를 뒀을 경우
		 *  컴파일러가 자동으로 value를 꺼내서 대체함. (예 : Integer -> int : 언박싱)
		 *  
		 */
		
		int i = 10;
		
		Integer intg = (Integer)i;
		// 기본형을 참조형으로 형변환 하는 것이 아니라
		// Integer intg = Integer.valueOf(i) 을 컴파일러가 자동으로 작성해 주는 것 : 오토박싱
		
		Object obj = (Object) i;
		// Object obj = (Object) Integer.valueOf(i) : 오토박싱 후 Object로 형변환
		
		Long lng = 100L;
		// Long lng = new Long(100L); : 오토박싱
		
		int i2 = intg + 10;
		// int i2 = intg.intValue() + 10 : 언박싱
		
		long l = intg + lng;
		// long l = intg.longValue() + lng.longValue() : 언박싱
		
		Integer intg2 = new Integer(20);
		int i3 = (int)intg2;
		// 참조형을 기본형으로 형변환하는 것은 기본기능이 아니라,
		// int i3 = intg2.intValue()을 컴파일러가 알아서 작성해주는 것.
		
		Integer intg3 = intg2 + i3;
		// 각 각의 값을 합친 새로운 객체 intg3을 생성
		
		System.out.println("i = "+i);
		System.out.println("intg = "+intg);
		System.out.println("obj = "+obj);
		System.out.println("lng = "+lng);
		System.out.println("i2 = intg + 10 = "+i2);
		System.out.println("l = intg + lng = "+l);
		System.out.println("intg2 = "+intg2);
		System.out.println("i3 = "+i3);
		System.out.println("intg3 = intg2 + i3 = "+intg3);
		
	}
}
