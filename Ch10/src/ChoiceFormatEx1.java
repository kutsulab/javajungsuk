
import java.text.*;

public class ChoiceFormatEx1 {
	
	/* Java의 정석 3판 p.548 예제 10-16 내용 확인 및 연습
	 * 
	 * [ChoiceFormat - 특정 범위에 속하는 값을 원하는 문자열로 변환]
	 * 
	 * ChoiceFormat(double[] limits, String[] formats)
	 * limits : 범위 지정. 오름차순으로 정렬되어있어야함. 각 limits은 범위의 경계값.
	 * Formats : 범위에 따라 반환될 문자열 포맷
	 * 
	 * ChoiceFormat 객체.format(long number)
	 * 입력된 long 값들을 객체의 limits, formats에 따라 String으로 반환
	 */
	
	public static void main(String[] args) {
		double[] limits = {0, 60, 70, 80, 90, 95};
		// ChoiceFormat을 통해 대응시킬 것이므로, 여기서 각 배열의 값들은 index와 갯수를 각각 맞춰야한다.
		String[] grades = {"F", "D", "C", "B", "A", "A+"};
		
		int[] scores = {100, 95, 92, 89, 84, 73, 68, 59, 41, 22, 0};
		
		ChoiceFormat form = new ChoiceFormat (limits, grades); // 포맷 지정 : 경계값, 출력포맷

		for (int i=0; i<scores.length; i++) {
			System.out.printf("%3d : %s%n", scores[i], form.format(scores[i]));
		}
	}

}
