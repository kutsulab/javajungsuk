
public class CalendarEx9 {
	
	/* Java의 정석 3판 p.538 예제 10-9 내용 확인 및 연습
	 * 사용자 정의의 날짜 관련 메서드 (Calendar 메서드를 사용하지 않음)
	 * 
	 * 1) boolean isLeapYear(int year) : 년도 입력 시 윤년인지 여부 반환
	 * 2) int getMaxDayOfYear(int year) : isLeapYear 을 거쳐 윤년인지 확인하고, 해당 년도의 최대 일수를 반환
	 * 3) int getMaxDayOfMonth(int year, int month) : isLeapYear 을 거쳐 윤년인지 확인하고, 해당 월의 최대 일수를 반환
	 * 
	 * 4) int convertDateToDay : 서기 1년 1월 1일을 총 일수 1일로 기준으로 하여 해당 일까지의 총 일수를 반환
	 * 5) int convertDayToDate : 총 일수를 날짜로 반환
	 * 
	 * 6) int getDayOfWeek (int year, int month, int date)
	 *     : 날짜를 입력하면 convertDateToDay를 거쳐 총 일수를 구한뒤 7로 나눈 나머지를 기준으로 날짜를 환산
	 *     
	 * 7) int dayDiff (int year1, int month1, int date1, int year2, int month2, int date2)
	 *     : 날짜 두개를 입력하면 convertDateToDay를 거쳐 각 날짜의 총 일수를 환산 후 날짜들의 차를 구하여 반환함 (절댓값)
	 *     
	 */
	
	public final static int[] END_OF_NORMAL_YEAR_MONTH = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public final static int[] END_OF_LEAP_YEAR_MONTH = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	// 년도를 입력하면 그 해가 윤년인지 여부를 boolean으로 반환
	public static boolean isLeapYear(int year) {
		return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
		// 윤년의 조건 : 4의 배수이고 100의 배수가 아니다 // 또는 400의 배수
	}

	// 년도를 입력하면 그 해의 최대 일수를 반환
	public static int getMaxDayOfYear(int year) {
		if (isLeapYear(year))
			return 366;
		else
			return 365;
	}

	// 년, 월을 입력하면 그 달의 최대 일수를 반환
	public static int getMaxDayOfMonth(int year, int month) {
		if (isLeapYear(year))
			return END_OF_LEAP_YEAR_MONTH[month - 1];
		else
			return END_OF_NORMAL_YEAR_MONTH[month - 1];
	}

	// 날짜를 입력하면 요일을 숫자로 반환 (1 : 일요일)
	public static int getDayOfWeek(int year, int month, int date) {
		return convertDateToDay(year, month, date) % 7 + 1; // 서기 1년 1월 1일 월요일 = 2 (기준)
	}

	// 서기 1년 1월 1일의 '총 일수'를 1일로 기준잡아서, 해당일까지 '총 일수'로 환산
	public static int convertDateToDay(int year, int month, int date) {

		// 서기 1년부터 작년까지의 일수를 합산
		int toLastYearDaySum = 0;
		for (int i = 1; i < year; i++) { // 서기 1년부터 이전 년도까지 그 해의 일수를 합산
			toLastYearDaySum += getMaxDayOfYear(i);
		}

		// 올해의 지난 달까지의 날짜 계산
		int toLastMonthDaySum = 0;
		for (int i = 1; i < month; i++) {
			toLastMonthDaySum += getMaxDayOfMonth(year, i);
		}

		return toLastYearDaySum + toLastMonthDaySum + date;
	}

	// 총 일수를 날짜로 환산하여 String 타입으로 반환
	public static String convertDayToDate(int day) {

		int year = 1, month = 1, date = 0;

		while (day > getMaxDayOfYear(year)) { // 일수가 년도의 최대일수보다 크면 차감 후 년도를 증가
			day -= getMaxDayOfYear(year);
			year++;
		}

		while (day > getMaxDayOfMonth(year, month)) { // 일수가 월의 최대일수보다 크면 차감 후 월을 증가
			day -= getMaxDayOfMonth(year, month);
			month++;
		}
		
		date += day; //차감 후 남은 일자가 일

		return year + "-" + month + "-" + date;
	}

	// 두 일자의 날짜 차이를 반환
	public static int dayDiff(int year1, int month1, int date1, int year2, int month2, int date2) {
		return Math.abs(convertDateToDay(year1, month1, date1) - convertDateToDay(year2, month2, date2));
	}

	public static void main(String[] args) {
		System.out.println("2003년 7월 16일의 요일을 숫자로 환산 : "+ getDayOfWeek(2003,7,16));
		System.out.println("2011년 5월 9일의 요일을 숫자로 환산 : "+ getDayOfWeek(2011,5,9));
		System.out.println("2002년 01월 22일과 2021년 9월 17일의 날짜 차이 : "+dayDiff(2002,01,22,2021,9,17));
		System.out.println("1년 1월 1일 -> "+convertDateToDay(1,1,1)); // 날짜를 총 일수로 환산 (1년 1월 1일 == 1 기준)
		System.out.println("2021년 9월 17일 -> "+convertDateToDay(2021,9,17)); //날짜를 총 일수로 환산
		System.out.println("738050일 -> "+convertDayToDate(738050)); // 총 일수를 날짜로 환산
	}

}
