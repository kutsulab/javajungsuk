
import java.util.*;

public class CalendarEx7 {

	/* Java의 정석 3판 p.534 예제 10-7 내용확인 및 연습 : Calendar 클래스의 활용 - 꽉찬 달력 찍기
	 * 
	 * [Calendar 클래스의 활용 - 달력 찍기]
	 * 
	 * 1. 년도, 월만으로 그 달의 달력을 특정하는 것이 가능함.
	 * 2. 반복문을 통해 달력을 찍어내므로, 반복의 시작(첫날 정보 : 요일), 반복의 끝(끝나는 날짜)을 설정하는 것이 필요
	 * 3. 토요일이 끝나고 줄바꿈이 일어나므로 각 날짜의 요일에 해당하는 값이 필요하고, 이 값도 변화해야함. 이를 조건식으로 체크해야함
	 * 
	 * [Calendar 클래스의 활용 - 빈 공간을 지난 달, 다음 달 날짜로 채우기]
	 * 1. 반복문 시작 : 입력한 달의 첫날이 속한 주의 일요일
	 * 2. 반복문 종료 : 입력한 달의 말일이 속한 주의 토요일
	 * 3. 반복문 내 조건식 : 요일에 해당하는 값의 나머지에 따라 줄바꿈
	 * 
	 */
	
	
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("usage : java CalendarEx7 1996 4");
			return;
		}
		
		int year = Integer.valueOf(args[0]);
		int month = Integer.valueOf(args[1]);
		
		Calendar sDay = Calendar.getInstance();
		sDay.clear();
		sDay.set(year, month-1, 1);
		sDay.add(Calendar.DATE, -sDay.get(Calendar.DAY_OF_WEEK) + 1);
		// 입력 달의 시작일이 속한 주의 일요일로 날짜를 설정
		
		Calendar eDay = Calendar.getInstance();
		eDay.clear();
		eDay.set(Calendar.YEAR, year);
		eDay.set(Calendar.MONTH, month-1);
		eDay.set(Calendar.DATE, eDay.getActualMaximum(Calendar.DATE));
		eDay.add(Calendar.DATE, -eDay.get(Calendar.DAY_OF_WEEK)+7);
		// 입력 달의 마지막일이 속한 주의 토요일로 날짜를 설정
		

		
		System.out.printf("=========%4d년 %2d월=========%n",year,month);
		System.out.println("SUN MON TUE WED THU FRI SAT");
		

		for (int i= sDay.get(Calendar.DAY_OF_WEEK) ;
			 sDay.before(eDay) || sDay.equals(eDay); // 달력의 첫날부터 마지막날까지
			 sDay.add(Calendar.DATE, 1)) { // 날짜, 요일 증감  
			
			System.out.printf("%3d ",sDay.get(Calendar.DATE));
			if (i++%7 == 0) System.out.println(); // i++ : 값 접근 후 증가

			} // end of for
		
	} // end of main

} // end of class
