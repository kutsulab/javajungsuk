
import java.util.*;
import java.text.*;

public class SimpleDateFormatEx3 {
	
	/* Java의 정석 3판 p.546 예제 10-14 내용 확인 : 형식화된 날짜 문자열을 Date 객체로 역형식화
	 * 
	 * [SimpleDateFormat - parse 메서드 : 형식화된 날짜 문자열을 Date 객체 추출]
	 * public Date parse(String source) throws ParseException 
	 * 
	 * SimpleDateFormat 객체의 parse 메서드는 Pattern에 맞는 source를 Date객체로 변환해서 반환한다.
	 * 이 객체는 ParseException이 throws 되므로 예외처리를 해야한다.
	 */
	
	public static void main(String[] args) {
		DateFormat df1 = new SimpleDateFormat("yyyy년 MM월 dd일");
		DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");

		try {
			Date d = df1.parse("2021년 09월 18일"); // 형식화된 문자열을 역으로 date 객체로 반환
			System.out.println(df2.format(d)); // 객체 d를 다시 df2 형식의 문자열로 형식화 후 출력
		} catch (ParseException pe) {
			/* 예외처리 */
		} // try문 끝

	}// main 메서드 끝

}// 클래스 끝
