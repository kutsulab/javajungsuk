
import java.util.*;

public class CalendarEx3 {
	
	/* Java의 정석 3판 p.532 예제 10-3
	 * 
	 * [두 날짜, 시간의 차이]
	 * 
	 * 1. Calendar 객체에 저장된 시간을 getTimeMillis()을 통해 1/1000초 단위로 받아올 수 있다.
	 * 2. 1/1000초 단위로 된 정수값의 차만큼의 차가 가장 정확한 milliSecond차이가 된다.
	 * 3. 이 값을 1000으로 나눈 몫이 second 차이가 된다.
	 * 4. 1000으로 나눈 나머지 millisecond는 무시하고 보통 second를 기준으로 시간차를 생각.
	 * 5. 이를 다시 적절한 방식으로 시간차, 혹은 날짜 차이로 단위 환산해서 사용하면 됨
	 * 
	 * [두 날짜, 시간의 전후관계 파악]
	 * 1. 두 시간대의 차가 양수인지, 음수인지로 시간의 전후관계를 파악할 수 있음.
	 * 2. 혹은, boolean after(Object when) boolean before(Object when)으로 비교 가능
	 * 
	 */
	
	public static void main(String[] args) {
	
		Calendar time1 = Calendar.getInstance();
		Calendar time2 = Calendar.getInstance();
		
		time1.set(Calendar.HOUR_OF_DAY,10);
		time1.set(Calendar.MINUTE,20);
		time1.set(Calendar.SECOND,30); //time1의 시각을 10시 20분 30초로 변경
		
		time2.set(Calendar.HOUR_OF_DAY,20);
		time2.set(Calendar.MINUTE,30);
		time2.set(Calendar.SECOND,10); //time2의 시각을 20시 30분 10초로 변경
		
		System.out.println("time1 : "+timeString(time1));
		System.out.println("time2 : "+timeString(time2));
		
		long difference = Math.abs(time2.getTimeInMillis()-time1.getTimeInMillis())/1000;
		// 두 시간대의 millisecond 값을 second로 환산
		
		System.out.println("time1과 time2의 차이는 "+ difference + "초입니다.");
		System.out.println("이를 시분초로 환산하면 "+secondToTime(difference)+"입니다.");
	}
	
	public static String timeString(Calendar time) {
		//Calendar 객체에 저장된 시간을 일반적으로 사용하는 시간 표현 문자열로 반환
		
		return time.get(Calendar.HOUR_OF_DAY)+"시 "
				+time.get(Calendar.MINUTE)+"분 "
				+time.get(Calendar.SECOND)+"초";
	}
	
	public static String secondToTime(long second) {
		//초단위로 된 시간을 일반적으로 사용하는 시간 표현 문자열로 반환
		
		final int[] TIME_UNIT = {3600, 60, 1}; // 각 시간 단위를 '초'로 환산 (시간, 분, 초)
		final String[] TIME_UNIT_NAME = {"시간 ", "분 ", "초"};
		
		StringBuffer sb = new StringBuffer(); //시간을 문자열로 환산한 것을 저장하는 StringBuffer
		
		for (int i=0; i < TIME_UNIT.length; i++) { //큰 단위 -> 작은 단위 순으로 해야 정확히 나눌 수 있음.
			
			String tmp = second/TIME_UNIT[i] + TIME_UNIT_NAME[i]; //각 단위로 나눈 몫을 단위별로 문자화
			second %= TIME_UNIT[i]; // second에 second를 TIME_UNIT[i]로 나눈 나머지를 저장한다.		
			sb.append(tmp); // 버퍼에 tmp를 추가한다.				
		}
		
		return sb.toString();
		
	}
}
