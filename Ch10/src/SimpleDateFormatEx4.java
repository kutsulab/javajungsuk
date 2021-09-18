
import java.util.*;
import java.text.*;

public class SimpleDateFormatEx4 {
	
	/* Java의 정석 3판 p.547 예제 10-15 : 날짜를 형식에 맞게 입력받기
	 * 
	 * 
	 * 날짜 형식을 지정해주고 입력받을 때 형식에 어긋나면 ParseException이 발생함.
	 * 이런 점을 이용해 while문 및 try-catch문을 사용, 유효한 날짜 데이터를 입력받을 수 있게 된다.
	 * 
	 */

	public static void main(String[] args) {
		
		String Pattern = "yyyy-MM-dd";
		DateFormat df = new SimpleDateFormat(Pattern); //형식
		Scanner sc = new Scanner(System.in);
		
		Date inputDate = null;
		
		System.out.println("날짜를 "+Pattern+"의 형태로 입력해주세욧. (예시:2010-09-17)");
		
		while(sc.hasNextLine()) { // 다음 Line이 존재하는가?
			try {
				inputDate = df.parse(sc.nextLine()); // 형식에 맞게 날짜를 입력받음.
				break;
			} catch (Exception e) {
				System.out.println("날짜를 "+Pattern+"의 형태로 다시 입력해주세욧! (예시:2021-09-17)");
			}
		} //while문 끝
		
		sc.close();
		System.out.println("입력하신 날짜 : "+df.format(inputDate));//Date로 다시 형식화 출력
		
		Calendar inputCal = Calendar.getInstance();
		inputCal.setTime(inputDate); // 입력일
		
		Calendar currentCal = Calendar.getInstance(); //현재 시각
		
		long timediff = Math.abs(currentCal.getTimeInMillis()-inputCal.getTimeInMillis())/(60*60*1000);
		// 시간차
		
		System.out.println("입력하신 날짜는 현재와 "+timediff+"시간 차이가 있습니다.");
		
	}

}
