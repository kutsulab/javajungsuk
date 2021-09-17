import java.text.*;

public class DecimalFormatEx2 {
	
	/* Java의 정석 3판 p.543 예제 10-11 내용 확인
	 * 
	 * [parse 메서드 : 형식화된 숫자를 Number 객체로 값 추출]
	 * public Number parse(String source) throws ParseException 
	 * 
	 * DecimalFormatEx 객체의 parse 메서드는 Pattern에 맞는 source를 Number 객체로 변환해서 반환한다.
	 * 이 객체는 ParseException이 throws 되므로 예외처리를 해야한다.
	 * 
	 * ParseException은 source가 형식에 맞지 않을 경우 발생한다.
	 * 
	 * [추출한 Number 객체는?]
	 * 원하는 기본형 숫자로 출력하기 위해서는 .doubleValue() 메서드 등을 사용해서 원하는 타입으로 뽑아내야함.
	 * 
	 * */
	
	
	public static void main(String[] args) {
		DecimalFormat df1 = new DecimalFormat("#,###.##");
		DecimalFormat df2 = new DecimalFormat("#.###E0");
		
		try {
			Number num = df1.parse("1,234,567.89"); // 형식화된 숫자를 다시 역으로 Number 객체로 반환시킴
			double d = num.doubleValue(); // double값을 d에 저장
			System.out.print("1,234,567.89 -> "+ d);
			
			String reformStr = df2.format(d); // 다시 형식화
			System.out.print(" -> "+reformStr);
		} catch (ParseException pe) { // parse 메서드는 throws ParseException 하므로 예외처리가 강제됨
			pe.printStackTrace();
		}
		
	}

}
