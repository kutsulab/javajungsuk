
import java.util.*;

public class CalendarEx4 {
	
	/* Java의 정석 3판 p.533 예제 10-4
	 * 
	 * [시간대의 증감 - add, roll]
	 * 
	 * 1. void add(int field, int amount)
	 * 	field의 값을 amount 만큼 증감시킨다. 다른 필드도 영향을 받는다.
	 * 
	 * 2. void roll(int field, int amount)
	 * 	field의 값을 amount 만큼 증감시킨다. 다른 필드에 영향을 끼치지 않는다.
	 *  (변경대상이 되는 field를 처음과 끝이 이어져있는 띠처럼 생각)
	 */
	
	
	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();
		date.clear();
		
		System.out.println("=========================");
		date.set(2015, 7, 31); //2015년 8월 31일
		System.out.println(toString(date));
		System.out.println();
		
		System.out.println("======== 1일 후 ==========");
		date.add(Calendar.DATE, 1); // 1일 증가 (다른 필드에 영향이 있음)
		System.out.println(toString(date));
		System.out.println();
		
		System.out.println("======== 6달 전 ==========");
		date.add(Calendar.MONTH, -6); // 6달 감소 (다른 필드에 영향이 있음)
		System.out.println(toString(date));
		System.out.println();
		
		System.out.println("======== 31일 후(roll) ==========");
		date.roll(Calendar.DATE, 31); // 31일 증가 (다른 필드에 영향이 없음)
		System.out.println(toString(date));
		System.out.println();
		
		System.out.println("======== 31일 후(add) ===========");
		date.add(Calendar.DATE, 31); // 31일 증가 (다른 필드에 영향이 있음)
		System.out.println(toString(date));
		System.out.println();
	}
	
	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR)+"년 "
				+(date.get(Calendar.MONTH)+1)+"월 "
				+date.get(Calendar.DATE)+"일";
	}

}
