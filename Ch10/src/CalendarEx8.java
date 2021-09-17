
public class CalendarEx8 {
	
	// Java의 정석 3판 p.537 예제 10-8 내용 확인 및 연습 : 개월차
	
	public static void main(String[] args) {
		 
		String date1 = "202009";
		String date2 = "202107"; // 개월차를 구해야하는 상황
		
		int month1 = Integer.valueOf(date1.substring(0,4))*12 + // 굳이 Calendar 클래스를 사용하지 않고, 년월을 분리(substring)해서 년을 월로 환산시킴
					Integer.valueOf(date1.substring(4));
		int month2 = Integer.valueOf(date2.substring(0,4))*12 +
				Integer.valueOf(date2.substring(4)); 
		
		System.out.println(date1 + "과 " + date2 +"의 차이는 "
				+ Math.abs(month1-month2) + "개월입니다.");
		
	} // end of main
	
} // end of Class