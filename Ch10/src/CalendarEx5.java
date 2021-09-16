import java.util.*;

public class CalendarEx5 {
	
	/* Java의 정석 3판 p.534 예제 10-5
	 * 
	 * [roll이 다른 필드에 영향을 끼치는 예외]
	 * 
	 * 일(DATE) 필드가 말일일 때 MONTH를 roll로 증감 시
	 * 말일이 다를 경우 DATE 필드에 영향을 끼친다.
	 * 
	 */
	
	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();
		date.clear();
		
		date.set(2015,0,31); // 2015년 1월 31일
		System.out.println(toString(date));
		
		date.roll(Calendar.MONTH, 1); // roll로 MONTH을 1 증가시킴
		System.out.println(toString(date)); // 2015년 2월 28일
	}

	
	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR) +"년 "
			+ (date.get(Calendar.MONTH) + 1)+"월 "
			+ date.get(Calendar.DATE) + "일";
	}
}
