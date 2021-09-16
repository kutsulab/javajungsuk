
import java.util.*; // Calendar Class는 java.util 패키지에 속해있다.

public class CalendarEx1 {
	
	/* Java의 정석 3판 p.529 예제 10-1 내용 확인 및 연습 : Calendar 클래스에 정의된 필드들과 get메서드
	 * 
	 * [Calendar 클래스의 생성]
	 *  Calendar.getInstance() : 실행환경의 현재 날짜, 시각의 Calendar(일반적인 국가에서는 GregorianCalendar() 객체가 반환됨) 객체 생성
	 *  - 주의 : Calendar는 추상 클래스이므로, 자손 클래스에서 구현을 통해서만 생성 가능하다.
	 * 
	 * [Calendar의 메서드]
	 *  - get(int field) : 필드값을 입력하면 필드값에 맞는 객체의 정보를 가져옴
	 *  - getActualMaximum(Calendar.DATE) : 그 달의 마지막 일을 가져옴
	 *  - set 메서드
	 * 
	 * [Calendar 클래스에 정의된 필드]
	 * 
	 * 1. 날짜에 관한 필드
	 * 	- YEAR : 년
	 * 	- MONTH : 월 (0~11)
	 * 	- DATE : 일
	 * 	- WEEK_OF_YEAR : 그 해의 몇 번째 주
	 * 	- WEEK_OF_MONTH : 그 달의 몇 번째 주
	 * 	- DAY_OF_YEAR : 그 해의 몇 번째 일
	 * 	- DAY_OF_MONTH : 그 달의 몇 번째 일
	 * 	- DAY_OF_WEEK : 그 주의 몇 번째 일 -> 요일(1~7)
	 * 	- DAY_OF_WEEK_IN_MONTH : 그 달의 몇번째 요일
	 * 
	 * 2. 시간에 관한 필드
	 *  - HOUR : 시간 (0~11)
	 *  - HOUR_OF_DAY : 시간 (0~23)
	 *  - MINUTE : 분
	 *  - SECOND : 초
	 *  - MILLISECOND : 1/1000초
	 *  - ZONE_OFFSET : GMT 기준 시차 (1/1000 초 단위)
	 *  - AM_PM : 오전/오후 (0 : 오전, 1 : 오후) 
	 */
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance(); // 실행환경의 현재 날짜, 시각의 Calendar 객체 생성
		//(일반적인 국가에서는 GregorianCalendar() 객체가 반환됨)
		
		System.out.println("=========================================================");
		System.out.println("이 해의 연도 : "+today.get(Calendar.YEAR));
		System.out.println("월(0~11, 0:1월) : "+today.get(Calendar.MONTH));
		System.out.println("일 : "+today.get(Calendar.DATE));
		System.out.println("이 해의 몇 째 주 : "+today.get(Calendar.WEEK_OF_YEAR));
		System.out.println("이 달의 몇 째 주 : "+today.get(Calendar.WEEK_OF_MONTH));
		System.out.println("이 해의 몇 일 : "+today.get(Calendar.DAY_OF_YEAR));
		System.out.println("이 달의 몇 일 : "+today.get(Calendar.DAY_OF_MONTH));
		System.out.println("이 주의 몇 번째 일 (1~7, 1:일요일) : "+today.get(Calendar.DAY_OF_WEEK));
		System.out.println("이 달의 몇 번째 요일 : "+today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("이 달의 마지막 날 : "+today.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println();
		
		System.out.println("=========================================================");
		System.out.println("오전/오후 (0,1) : "+today.get(Calendar.AM_PM));
		System.out.println("시간(0~11) : "+today.get(Calendar.HOUR));
		System.out.println("시간(0~23) : "+today.get(Calendar.HOUR_OF_DAY));
		System.out.println("분(0~59) : "+today.get(Calendar.MINUTE));
		System.out.println("초(0~59) : "+today.get(Calendar.SECOND));
		System.out.println("1/1000초 (0~999) : "+today.get(Calendar.MILLISECOND));
		System.out.println("TIMEZONE(-12~+12) : "+today.get(Calendar.ZONE_OFFSET)/(60*60*1000));
		// get(Calendar.ZONE_OFFSET)은
		// GMT 기준 시차를 1/1000초 단위로 반환하므로 (60*60*1000)으로 나누어 시간으로 환산 시, 한국은 +9의 차이가 발생한다.
	}

}
