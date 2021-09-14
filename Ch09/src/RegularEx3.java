import java.util.regex.*;

public class RegularEx3 {
	
	/* Java의 정석 3판 p.508 예제 9-33 내용 확인 및 연습
	 * 
	 * 
	 * [정규식 - 그룹화 (Grouping)]
	 * 괄호 '()'로 그룹을 나눌 수 있음.
	 * group(0), group() : 매칭된 문자열 전체를 나누어지지 않은 채 반환
	 * group (int n) : 매칭된 문자열의 n번째 group을 반환함
	 * 
	 * [Matcher 인스턴스의 메서드]
	 * find() : 소스 내에서 패턴과 일치하는 부분을 찾아내면 true를 반환 후 매칭된 부분으로 이동
	 * find()를 한번 호출하고 다시 호출 시 패턴과 일치하는 부분의 다음부터 다시 패턴 매칭을 시작함.
	 * 
	 * 

	 * 

	 * 
	 */
	
	
	public static void main(String[] args) {
		String source = "HP : 010-1111-1111, HOME : 02-999-9999 "; // 추출 대상
		
		String pattern = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";
		// (0으로 시작하는 1개 또는 2개 숫자)-(3개 또는 4개의 숫자)-(4개의 숫자)
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source); // 패턴과 soruce 정보를 가진 Matcher 객체 m 생성
		
		int i = 0;
		while (m.find()) {
			
			// find()가 false가 될 때까지 반복
			// find()는 대상이 되는 소스에서 패턴과 일치하는 부분을 찾아내면 true를 반환하고 매칭된 부분으로 이동한다.
			// 다시 호출 시 그 다음 부분부터 일치하는 부분을 찾아내서 매칭함.
			
			System.out.println( ++i+": "+m.group() + " -> "
								+ m.group(1) + ", "
								+ m.group(2) + ", "
								+ m.group(3));
			}
		
		
	}

}
