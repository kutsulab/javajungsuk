
import java.util.*;
import java.text.*;

public class SimpleDateFormatEx1 {
	
	/* Java의 정석 3판 p.545 예제 10-12 내용 확인 및 연습
	 * 
	 * SimpleDateFormat 클래스 : 날짜, 시간의 형식화 
	 * 
	 * [생성자]
	 * SimpleDateFormat(String format) : 지정된 format을 형식으로 하는 객체 생성
	 * 
	 * [형식화]
	 * SimpleDateFormat 객체.format(Date d)
	 * Date 객체를 매개변수로 하여, 문자열 반환
	 * 
	 * [Calendar 객체의 변환은?]
	 *  Calendar 객체는 Date 객체로 변환해야한다.
	 *  Calendar 객체 : cal이라 할 때
	 * 
	 * 	방법 1) Date d = cal.getTime();
	 *  방법 2) Date d = new Date(cal.getTimeInMillis());
	 * 
	 */
	
	public static void main(String[] args) {
		Date today = new Date();
		SimpleDateFormat sdf1, sdf2, sdf3, sdf4;
		SimpleDateFormat sdf5, sdf6, sdf7, sdf8, sdf9;
		
		sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		sdf2 = new SimpleDateFormat("''yy년 MMM dd일  E요일");
		sdf3 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss.SSS");
		sdf4 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss a");
		sdf5 = new SimpleDateFormat("yyy-MM-dd hh:mm:ss a");
		sdf6 = new SimpleDateFormat("오늘은 올 해의 D번째 날입니다.");
		sdf7 = new SimpleDateFormat("오늘은 올 해의 w번째 주입니다.");
		sdf8 = new SimpleDateFormat("오늘은 이 달의 W번째 주입니다.");
		sdf9 = new SimpleDateFormat("오늘은 이 달의 F번째 E요일입니다.");
		
		System.out.println(sdf1.format(today)); //SimpleDateFormat 객체의 format 메서드는 date 클래스만을 매개변수로 가진다... 
		System.out.println(sdf2.format(today));
		System.out.println(sdf3.format(today));
		System.out.println(sdf4.format(today));
		System.out.println();
		
		System.out.println(sdf5.format(today));
		System.out.println(sdf6.format(today));
		System.out.println(sdf7.format(today));
		System.out.println(sdf8.format(today));
		System.out.println(sdf9.format(today));
	}

}
