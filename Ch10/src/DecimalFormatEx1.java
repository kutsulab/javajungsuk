
import java.text.*;

public class DecimalFormatEx1 {
	
	/* Java의 정석 3판 p.542 예제 10-10 내용 확인 : DecimalFormat
	 * 
	 *  [형식화]
	 *  DecimalFormat(String Format) : 형식을 지정하여 객체 생성
	 *  
	 *  [형식에 맞는 문자 출력]
	 *  DecimalFormat 객체.format(double number) : 형식화할 숫자를 넣으면 문자열로 출력
	 *  
	 *  [Decimal Format의 여러가지 Format]
	 *  0 : 십진수 (값이 없으면 0)
	 *  # : 십진수
	 *  . : 소숫점
	 *  - : 음수부호
	 *  , : 단위 구분자
	 *  E0 : 지수
	 *  ; : 패턴 구분자
	 *  % : 퍼센트
	 *  \u2030 : 퍼밀 (퍼센트 * 10)
	 *  \u00A4 : 통화
	 *  ' : escape 문자
	 */
	public static void main(String[] args) {
		double number = 1234567.89; // 원본 double값
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
			DecimalFormat df = new DecimalFormat(pattern[i]); // 형식 객체
			String result = df.format(number); // .format(double number) : 실수값을 형식에 맞게 문자열로 반환(형식화)
			
			System.out.printf("%19s : %s%n",pattern[i],result);
		}
	}

}
