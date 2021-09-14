
import java.util.regex.*; // Pattern, Matcher 클래스는 regex 패키지에 속해있다.

public class RegularEx1 {
	
	/* Java의 정석 3판 p.505 예제 9-31 내용 확인 및 연습
	 * 
	 * [정규식(Regular Expression)]
	 * 	텍스트 데이터 중에서 원하는 조건(패턴, pattern)과 일치하는 문자열을 찾아내기 위해 사용하는 표현양식
	 * 
	 * [java.util.regex 패키지의 클래스들]
	 * 
	 *  1. Pattern 클래스
	 *   패턴을 정의하는 클래스.
	 *   패턴으로 사용할 정규식을 정의하여 인스턴스를 생성할 수 있다.
	 *   
	 *   static Pattern compile(String regex)
	 *   	regex를 패턴으로 하는 Pattern 인스턴스 반환
	 *   
	 *   Matcher matcher(CharSequence input)
	 *     패턴(정규식)으로 비교할 문자열(input)을 매개변수로 하는 Matcher 인스턴스 반환
	 *     
	 *    -> Matcher 객체는 패턴과, 문자열의 정보를 갖게 됨
	 *    
	 *    (cf)
	 *     CharSequence는 인터페이스.
	 *     이를 구현한 클래스로는 String, CharBuffer, StringBuffer가 있다.
	 *    
	 *  2. Matcher 클래스
	 *   패턴(정규식), 비교 데이터를 비교하는 역할
	 *  
	 *   boolean matches()
	 *   비교 데이터가 패턴(정규식)에 부합하는지 확인하여 boolean 값으로 반환
	 *   
	 */
	
	public static void main(String[] args) {

		String[] data = {"make", "YUZU", "great", "again",
				"fire", "punch", "king", "queen", "knife",
				"ice", "kick", "enjoy", "kyaru", "like",
				"kitchen", "ultimate", "endless", "life", "Korea"};
		
		Pattern p = Pattern.compile("k[a-z]*"); //소문자 k로 시작하는 문자열
		// static Pattern compile(regex)
		// 패턴으로 사용할 정규식을 매개변수로 받아 Pattern 인스턴스 반환
		
		
		for (int i = 0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			// p.matcher(Charsequence input)
			// 인스턴스에 저장된 패턴(정규식)과 문자열을 매개로 Matcher 인스턴스 생성
			
			if (m.matches()) System.out.print(data[i]+"   ");
			// m.matches() : 문자열이 패턴(정규식)이 부합하는지 확인하여 boolean 값 반환
			
		}
		
	}

}
