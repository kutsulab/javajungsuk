
import java.util.*;

public class StringTokenizerEx5 {

	/* Java의 정석 3판 p.517 예제 9-42 내용 확인 및 연습
	 * 
	 * [StringTokenizer - String.split 비교]
	 * 
	 * 1) StringTokenizer(String str, String delim)
	 *  - 지정 구분자로 쪼갬. 공백분자열은 분리대상 취급 안 됨
	 *  
	 * 2) String[] split(String regex)
	 *  - 분리자(정규식)로 쪼갬. 공백문자열도 분리 대상으로 취급되어 분리됨
	 *  - 토큰으로 잘라낸 결과를 배열에 다시 담아내는 과정을 거치기 때문에 StringTokenizer보다 성능면에서 떨어짐
	 *  
	 */
	
	public static void main(String[] args) {
		String source = "100,,,200,300";
		System.out.println("source : \""+source+"\"");
		
		String[] src_Split = source.split(","); // ,를 구분자로 공백문자열도 쪼개 분리
		StringTokenizer src_Tokens = new StringTokenizer(source,","); // ,를 구분자로 공백 문자열은 토큰으로 취급 안 하고 분리
		
		// src_Split 출력
		System.out.print("src_Split : ");
		
		for (int i=0; i< src_Split.length; i++) {
			System.out.print(src_Split[i]+"|");
		}
		
		System.out.println("분리 갯수 : "+src_Split.length); // 공백문자열도 토큰 취급 -> 5개
		
		// src_Tokens 출력
		
		System.out.print("src_Tokens : ");
		
		int i = 0;
		
		for (; src_Tokens.hasMoreTokens(); i++) {
			System.out.print(src_Tokens.nextToken()+"|");
		}
		System.out.println("분리 갯수 : "+i); // 공백문자열을 토큰취급하지 않음 -> 3개
		
		
	}

}
