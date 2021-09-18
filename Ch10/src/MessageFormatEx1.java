
import java.text.*;

public class MessageFormatEx1 {

	/* Java의 정석 3판 p.549 예제 10-18 내용 확인 및 연습 : 데이터를 정해진 양식에 맞게 출력 (MessageFormat)
	 * 
	 * [MessageFormat]
	 * 	데이터를 정해진 양식에 맞게 출력
	 * 	String 형식으로 출력을 메시지의 포맷을 지정. {0}, {1}, {2}, ...은 데이터가 출력될 자리
	 *	사용될 데이터는 객체배열인 Object[]. 배열의 0,1,2,3... 인덱스의 요소들이 차례로 format의 위치에 출력된다.
	 *
	 * [사용법]
	 * MessageFormat.format(msg, arguments)
	 * msg : 형식화된 String 타입의 msg
	 * arguments : msg의 {숫자}의 위치에 순서대로 출력될 요소들
	 * 
	 */
	
	public static void main(String[] args) {
		String msg = "Name : {0}\nTel : {1}\nAge : {2}\nBirthday : {3}";
		Object[] arguments = {"캬루", "010-1234-5678", "14", "09-02"};
		
		String result = MessageFormat.format(msg, arguments); // 이 방법 외에도 msg만으로 MessageFormat 객체를 만들고 format 메서드로 String을 반환받을 수 있다.
		System.out.println(result);
	}

}
