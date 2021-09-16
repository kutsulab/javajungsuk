
import java.util.*;

	/* Java의 정석 3판 p.532 예제 10-2 내용확인 및 연습
	 * 
	 * [Calendar 클래스의 초기화]
	 * 
	 * Calendar.getInstance() 메서드를 사용하여 Calendar 인스턴스를 여러개 생성하고
	 * set() 메서드 등을 통해 시간대를 조작하여 연산할 때 생성 시간에 따른 milliSecond 단위 차이로 오차가 발생한다.
	 * -> 현재시각을 사용하지 않는 상황이라면 Calendar 클래스를 초기화해줄 필요가 있다.
	 * 
	 * 1. void clear() : 현재 Calendar 객체를 EPOCH Time으로 초기화
	 *  EPOCH Time : 1970년 01월 01일 목요일 0시 00분 00초 000
	 *  
	 * 2. void clear(int field) : 지정된 field를 기본값으로 초기화
	 * 
	 * [Calendar 클래스의 set() 메서드]
	 * 
	 * void set(int field, int value) : 특정 필드의 값 지정
	 * 
	 * 1. 날짜 지정 (month는 0부터 시작함에 주의)
	 * 
	 * void set(int year, int month, int date) : 년월일 지정
	 * void set(int year, int month, int date, int hourOfDay, int minute) : 년월일시분
	 * void set(int year, int month, int date, int hourOfDay, int minute, int second) : 년월일시분초 
	 * 
	 * 2. 시간 지정 
	 * void set(int field, int value)을 사용하여 지정
	 *  : HOUR_OF_DAY, MINUTE, SECOND
	 * 
	 */
public class CalendarEx2 {
	public static void main(String[] args) {
		
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		date1.clear(); //date1은 현재 시간을 사용하지 않고 별도로 설정해줄 것이므로 초기화를 해줄 필요가 있음
		
		//date1.set(2004, Calendar.FEBRUARY, 21);
		date1.set(2004, 1, 21); // 날짜를 2004년 2월 21일로 지정
		System.out.println("date1은 "+toString(date1)+"이고, ");
		System.out.println("오늘(date2)은 "+toString(date2)+"입니다.");
		
		//두 날짜간 차이 : MILLISECOND를 통해 MILLISECOND의 차를 구하고 다시 역으로 환산해야함
		
		long difference = (date2.getTimeInMillis()-date1.getTimeInMillis())/(1000);
		// 두 날짜의 차이를 1/1000 초로 환산 -> 다시 1000을 나눠서 초단위로 환산
		// (이때  나머지 Millisecond 버림값은 매우 작은 값이여서 무시해도 됨)
		
		System.out.println("그 날(date1)로부터 지금(date2)까지 "+difference+"초가 지났습니다.");
		
		System.out.println("일(day)로 환산하면 "+(difference/(24*60*60))+"일입니다.");
		//시간차를 24(시간->일)*60(분->시간)*60(초->분)로 환산
		
		} // main 메서드 끝
	
	
	public static String toString(Calendar date) {
		final String[] DAY_OF_WEEK = {"", "일","월","화","수","목","금","토"};
		
		return date.get(Calendar.YEAR)+"년 "+(date.get(Calendar.MONTH)+1)+"월 "
				+date.get(Calendar.DATE)+"일 "+DAY_OF_WEEK[date.get(Calendar.DAY_OF_WEEK)]+"요일";
		// Calendar 객체를 넣으면 년, 월, 일, 요일을 알기 쉽게 알려줌.
	}
}
