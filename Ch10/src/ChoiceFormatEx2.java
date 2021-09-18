
import java.text.*;

public class ChoiceFormatEx2 {
	
	/* Java의 정석 3판 p.548 예제 10-17 내용 확인 및 연습
	 * 
	 * [ChoiceFormat - 특정 범위(문자열로 패턴 지정)에 속하는 값을 원하는 문자열로 변환]
	 * 
	 * ChoiceFormat(double[] limits, String[] formats)
	 * limits : 범위 지정. 오름차순으로 정렬되어있어야함. 각 limits은 범위의 경계값.
	 * Formats : 범위에 따라 반환될 문자열 포맷
	 * 
	 * public ChoiceFormat(String newPattern)
	 * newPattern : 범위를 문자열로 지정. |를 통해 구분
	 * # : 이상
	 * < : 초과
	 * 예 ) 60<D|70<C|80<B|90<A
	 * 
	 * ChoiceFormat 객체.format(long number)
	 * 입력된 long 값들을 객체의 limits, formats에 따라 String으로 반환
	 */
	
	public static void main(String[] args) {
		String pattern = "0#F|60#D|70#C|80<B|90#A|95#A+"; // 80<B는 80을 경계값으로 취급하지 않는다. (80초과)
		int[] scores = {100,95,90,87,81,80,77,70,65,60,54,42,0};
		
		ChoiceFormat form =  new ChoiceFormat(pattern);
		
		for (int i=0; i<scores.length; i++) {
			System.out.printf("%3d : %s%n",scores[i],form.format(scores[i]));
		}
	}

}
