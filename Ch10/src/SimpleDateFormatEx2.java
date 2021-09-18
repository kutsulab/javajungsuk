import java.util.*;
import java.text.*;

public class SimpleDateFormatEx2 {

	/* Java의 정석 3판 p.546 예제 10-13 내용 확인 및 연습
	 * 
	 * SimpleDateFormat 클래스 : 날짜, 시간의 형식화
	 * Calendar 객체의 형식화 
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
	
	private static Calendar myCalendar
	(int year, int month, int date, int hour, int minute, int second) {
		Calendar tmp = Calendar.getInstance();
		tmp.clear();
		tmp.set(year,month,date);
		tmp.set(Calendar.HOUR, hour);
		tmp.set(Calendar.MINUTE, minute);
		tmp.set(Calendar.SECOND, second);
		return tmp;
	}
	
	private static Calendar myCalendar
	(int year, int month, int date, int hour, int minute, int second, int millisecond) {
		Calendar tmp = myCalendar(year,month, date, hour,minute, second);
		tmp.set(Calendar.MILLISECOND, millisecond);
		return tmp;
	}
	
	
	public static void main(String[] args) {
		Calendar cal1 = myCalendar(2013,10,26,14,00,00); //2013년 11월 26일 14시 00분 00초
		Calendar cal2 = myCalendar(2015,7,25,18,53,47,123); //2015년 8월 25일 18시 53분 47초 123
		
		Date day1 = cal1.getTime(); // cal객체로 Date 객체를 반환해야함		
		Date day2 = new Date(cal2.getTimeInMillis()); // 다른 방법 : cal2에 저장된 시간정보를 ms로 반환받아서, 다시 Date 객체로 반환
		
		SimpleDateFormat sdf1, sdf2, sdf3, sdf4;
		sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		sdf2 = new SimpleDateFormat("yy/MM/dd");
		sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		sdf4 = new SimpleDateFormat("yyyy년 MM월 dd일 a hh시 mm분 ss초");

		System.out.println(sdf1.format(day1)); // SimpleDateFormat 객체의  format 메서드는 date만을 매개변수로 받는다.
		System.out.println(sdf2.format(day1));
		System.out.println(sdf3.format(day1));
		System.out.println(sdf4.format(day1));
		System.out.println();
		
		System.out.println(sdf1.format(day2));
		System.out.println(sdf2.format(day2));
		System.out.println(sdf3.format(day2));
		System.out.println(sdf4.format(day2));
		
	}

}
