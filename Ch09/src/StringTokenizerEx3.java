
import java.util.*;

public class StringTokenizerEx3 {

	/* Java의 정석 3판 p.515 예제 9-40 내용 확인 및 연습
	 * 
	 * StringTokenizer 클래스의 활용 - 큰 규모로 쪼개고, 작은 규모로 쪼개기
	 * 
	 * [StringTokenizer]
	 * 
	 * 문자열을 구분자를 기준으로 여러 개의 Token으로 잘라내여 활용하는 클래스
	 * 다른 방법과 달리 정규식을 사용하지 않고 사용하는 차별점이 있음
	 * 
	 * 다만, 구분자를 하나씩 인식한다는 점이 한계.
	 * 두 글자 이상의 복잡한 구분자로 나누거나 복잡한 형식에 맞춰 쪼갤 때는 정규식을 사용할 필요가 있다.
	 * (예를 들어 ",.#+"을 구분자로 지정하면 "," "." "#" "+" 각각의 문자들이 구분자로 취급됨.)
	 * 
	 *  1. 생성자
	 *  	StringTokenizer (String str, String delim) : 문자열 지정, 구분자 지정
	 *      StringTokenizer (String str, String delim, boolean returnDelims) : true일 때 구분자도 토큰으로 간주 
	 *      
	 *  2. 메서드
	 *  	int countTokens() : 전체 토큰의 수 반환
	 *  	boolean hasMoreTokens() : 토큰이 남아있는지를 boolean으로 반환 
	 * 		String nextToken() : 다음 토큰을 반환
	 * 
	 * [구분자로 문자열을 쪼개는 다른 방법]
	 * 
	 * String 객체.split(String regex) : 문자열을 regex로 쪼개서 배열로 반환
	 * Scanner 객체.useDelimiter(String pattern) : Scanner 객체의 내용을 pattern을 구분자로 한 Scanner 객체 반환
	 * 
	 */
	
	public static void main(String[] args) {
		String source = "1,캬루,0,0,0,0|2,페코린느,80,98,95,87|3,콧코로,100,100,100,100";
		
		StringTokenizer st1 = new StringTokenizer(source, "|"); // source를 "|" 기준으로 한번 쪼갬
	
		while (st1.hasMoreTokens()) {
			String bigToken = st1.nextToken(); // 쪼개진 token들을 각각 bigToken으로 취급
			StringTokenizer st2 = new StringTokenizer (bigToken, ","); // 쪼개진 bigToken들을 다시 "," 기준으로 쪼갬
			
			while (st2.hasMoreTokens())
				System.out.println(st2.nextToken()); // 다시 나눠진 토큰들을 순서대로 출력
			
			System.out.println("===============");
			}
	
	} //main 메서드 끝

} // 클래스 끝
