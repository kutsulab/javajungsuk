
import java.text.*;

public class DecimalFormatEx1 {
	
	/* Java의 정석 3판 p.542 예제 10-10 내용 확인
	 *  : 자주 쓰이는 DecimalFormat들
	 * 
	 */
	public static void main(String[] args) {
		double number = 1234567.89;
		System.out.println(number);
		
		String[] pattern = {
				"0", // 일반적인 십진수 표현 (값 없다 -> 0)
				"#", // 일반적 십진수 표현
				"0.0", // 소숫점 (값 없다 -> 0)
				"#.#", // 소숫점
				"0000000000.0000", // 값 없는 부분은 0으로 채워 넣음
				"##########.####", // 값 없는 부분은 안 채워 넣음
				"#.#-", // 음수부호 -
				"-#.#", // 앞에 음수 부호
				"#,###.##", // 세자리 단위로 ,를 끊음
				"#,####.##", // 네자리 단위로 ,를 끊음
				"#E0", // 지수꼴
				"0E0",
				"##E0",
				"00E0",
				"####E0", 
				"0000E0",
				"#.#E0",
				"0.0E0",
				"0.000000000E0",
				"00.00000000E0",
				"000.0000000E0",
				"#.#########E0",
				"##.########E0",
				"###.#######E0",
				"#,###.##+;#,###.##-", // 패턴 구분자 ; -> 양수일 때 음수일 때
				"#.#%", //double값을 0~1 기준으로 %로 환산 후 #.# 형태로 출력
				"#.#\u2030", // 퍼밀 : (%값 * 10)
				"\u00A4 #,###", // 통화 \u00A4
				"'#'#,###", //escape 문자 '
				"''#,###" // escape 문자 ''을 연달아 쓰면 문자 '로 출력
				
		};  //end of patten
		
		
		for (int i=0; i < pattern.length; i++) {
			DecimalFormat df = new DecimalFormat(pattern[i]);
			String result = df.format(number);
			
			System.out.printf("%19s : %s%n",pattern[i],result);
		}
	}

}
