import java.util.ArrayList; // Ctrl + Shift + O (자동 import문 추가)

public class AutoBoxing {

	/* Java의 정석 3판 p.494 내용 정리 : 오토박싱, 언박싱
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
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(new Integer(100)); // list에 Integer 객체만 저장 가능
		list.add(100); // JDK 1.5 이전에는 에러. 1.5 이후에는 컴파일러가 알아서 바꿔줌
		
		// Integer i = list.get(0); // 리스트의 첫번째 객체를 꺼냄
		// int i = list.get(0).intValue(); // intValue()로 Integer를 int 로 원래 변환해야함
		int i = list.get(0); // 컴파일러가 알아서 .intValue()를 호출해서 int로 변환해서 저장해줌
	}

}
