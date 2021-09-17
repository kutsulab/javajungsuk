import java.util.*;

public class CalendarEx5 {
	
	/* Java의 정석 3판 p.534 예제 10-5 내용 확인 및 연습 : roll이 다른 필드에 영향을 끼치는 예외
	 * 
	 * [시간대의 증감 - add, roll]
	 * 
	 * 1. void add(int field, int amount)
	 * 	field의 값을 amount 만큼 증감시킨다. 다른 필드도 영향을 받는다.
	 * 
	 * 2. void roll(int field, int amount)
	 * 	field의 값을 amount 만큼 증감시킨다. 다른 필드에 영향을 끼치지 않는다.
	 *  (변경대상이 되는 field를 처음과 끝이 이어져있는 띠처럼 생각)
	 * 
	 *   - roll이 다른 필드에 영향을 끼치는 예외
	 * 
	 *   일(DATE) 필드가 말일일 때 MONTH를 roll로 증감 시
	 *   말일이 다를 경우 DATE 필드에 영향을 끼친다.
	 * 
	 */
	
	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();
		date.clear(); // set으로 날짜를 변경하기 전에는 초기화를 해주는 것이 좋다.
		
		date.set(2015,0,31); // 2015년 1월 31일
		System.out.println(toString(date));
		
		date.roll(Calendar.MONTH, 1); // roll로 MONTH을 1 증가시킴
		System.out.println(toString(date));
		// 2015년 2월 28일 (DATE 필드가 말일일 때 MONTH 필드를 roll로 증감시 필드에 영향을 끼칠 수 있다.
		
	}

	
	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR) +"년 "
			+ (date.get(Calendar.MONTH) + 1)+"월 "
			+ date.get(Calendar.DATE) + "일";
	}
}
