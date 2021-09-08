import java.util.Date;

	/* 자바의 정석 3판 p.455 예제 9-5
	 * 
	 * String 클래스는 기본적으로 toString() 호출 시 인스턴스가 가지고 있는 문자열을 출력하도록 오버라이드 되어있다.
	 * java.util.Date 클래스는 toString() 호출 시 호출 시점의 시각을 출력하도록 오버라이드 되어있다.
	 */

public class ToStringTest {

	public static void main(String[] args) {
		String str = new String("캬루"); // 문자열 리터럴이 아닌 새로운 인스턴스 생성 후 참조변수 str에 저장
		Date today = new Date(); // java.util.Date 클래스의 인스턴스 생성 후 참조변수 today에 저장
		
		System.out.println(str); // 인스턴스들은 print()에서 호출 시 일반적으로 클래스명 + 16진수 해시코드를 출력하지만
		System.out.println(str.toString()); // String 클래스는 호출 시 가지고 있는 문자열을 출력한다.
		System.out.println(today); // Date 함수 역시 toString() 오버라이드에 의해 클래스명 + 16진수 해시코드가 아닌
		System.out.println(today.toString()); // 현재 시각을 출력한다.
	}

}
