
import java.util.*;

public class CalendarEx6 {

	/* Java의 정석 3판 p.534 예제 10-6 내용확인 및 연습 : Calendar 클래스의 활용 - 달력 찍기
	 * 
	 * [Calendar 클래스의 활용 - 달력 찍기]
	 * 
	 * 1. 년도, 월만으로 그 달의 달력을 특정하는 것이 가능함.
	 * 2. 반복문을 통해 달력을 찍어내므로, 반복의 시작(첫날 정보 : 요일), 반복의 끝(끝나는 날짜)을 설정하는 것이 필요
	 * 3. 토요일이 끝나고 줄바꿈이 일어나므로 각 날짜의 요일에 해당하는 값이 필요하고, 이 값도 변화해야함. 이를 조건식으로 체크해야함
	 */
	
	
	public static void main(String[] args) {
		
		// 상황 : 실행시 매개변수를 2개 받아서 년,월로 삼고 그것으로 달력을 출력함
		
		// Eclipse 기준으로 매개변수 넣으려면
		// Run > Run Configurations > Arguments에서 program arguments를 넣어주면 됨
		
		if (args.length !=2) { // 매개변수의 갯수가 맞지 않으면 
			System.out.println("Usage : java CalendarEx6 2021 9");
			return;
		}
		 
		int year = Integer.valueOf(args[0]); //년
		int month = Integer.valueOf(args[1]); //월
		

		
		Calendar sDay = Calendar.getInstance();
		sDay.clear();
		sDay.set(year, month-1, 1); // 달의 첫날 (날짜 셋팅 끝)
		
		Calendar eDay = Calendar.getInstance(); // 달의 마지막날을 저장할 eDay
		eDay.clear(); // 초기화
		eDay.set(year, month,1); // 다음 달의 첫날
		eDay.add(Calendar.DATE, -1); // 달의 마지막 날 = 다음 달의 첫날 - 1 (날짜 셋팅 끝)
		
		int START_DAY_OF_WEEK = 0; // 첫 날의 요일을 받는 값
		int END_DAY = 0; // 달의 마지막 날의 DATE를 받는 값
		
		// 달의 첫날의 요일을 얻어옴
		START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);
		
		// 달의 말일의 날짜를 얻어옴
		END_DAY = eDay.get(Calendar.DATE);
		
		System.out.printf("=========%4d년 %2d월=========%n",year,month);
		System.out.println("SUN MON TUE WED THU FRI SAT");
		
		for (int i=1; i< START_DAY_OF_WEEK; i++) { // 시작 일 전까지 공백 출력
			System.out.print("    "); 
		}
		for (int i=1, j=START_DAY_OF_WEEK ; i<=END_DAY; i++, j++) { // 첫날부터 말일까지
			System.out.printf("%3d ",i); // 일자 계속 출력
			if (j%7 == 0) System.out.println(); // 출력 후 해당 일의 요일이 7의 배수(토요일)일 때, 줄바꿈
		}
	}

}
