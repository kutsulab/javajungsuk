
import java.text.*;

public class MessageFormatEx2 {

	/* Java의 정석 3판 p.550 예제 10-19 내용 확인 및 연습 : 반복문으로 복수의 형식화된 데이터를 출력
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
		String tableName = "CUST_INFO";
		String msg = "INSERT INFO "+tableName+" VALUES (''{0}'',''{1}'',{2},''{3}'');"; // 포맷
		// MessageFormat에서 '은 escape 문자로 사용되므로 홑따옴표를 사용하려면 연속으로 두번 써야한다.
		
		Object[][] arguments = {
				{"캬루", "02-1234-5678", 14, "09-02"}, // 실제 출력될 복수의 데이터들
				{"콧코로", "02-1111-2222", 11, "05-11"}
		};
		
		for (int i=0; i< arguments.length; i++) {
			String result = MessageFormat.format(msg, arguments[i]); // 형식화된 문자열
			System.out.println(result);
		}
	}

}
