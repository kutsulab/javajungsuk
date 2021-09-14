
import java.util.regex.*;

public class RegularEx2 {
	
	/* Java의 정석 3판 p.506 예제 9-32 내용확인 및 연습
	 *  : 여러가시 정규식 패턴
	 */
	
	public static void main(String[] args) {
		String[] data = {"bat", "baby", "bonus", "c", "cA", "ca", "co",
				"c.","c0","c#","car","combat","count","date","disc",
				"Cat"};
		
		
		//패턴으로 사용할 정규식들
		String[] regex = {
				
				"c", // c와 일치하는 문자열
				"c\\.", // c\. : c.과 일치하는 문자열 (.은 패턴 작성에 사용되는 문자이므로 \는 escape 문자로 사용됨)
				".*", // .* : 모든 문자열 (기호 포함)
				"c.*", // c.* : c로 시작하는 모든 문자열 (기호 포함)
				"c.", // c. : c로 시작하는 모든 두자리 문자열
				
				"c\\d", // c\d : c로 시작하고 숫자가 따라오는 두자리 문자열
				"c[0-9]", // c[0-9] : c로 시작하고 숫자가 따라오는 두자리 문자열
				
				"c\\w", // c\w : c로 시작하고 숫자 또는 영어가 뒤에 따라오는 두자리 문자열
				"c[a-zA-Z0-9]", // c[a-zA-Z0-9] : c로 시작하고 뒤에 숫자 또는 영어가 뒤에 따라오는 두자리 문자열
								
				"c[a-z]*", // c[a-z]* : c로 시작 하고 뒤에 소문자 영어만 오는 문자열들
				"c[a-z]", // c[a-z] : c로 시작하는 두글자 영단어(뒤에는 소문자만 허용)
				"c[a-zA-Z]", // c[a-zA-Z] : c로 시작하는 두자리 영단어 (뒤에 오는 글자는 대소문자 구분 안 함)
				
				"c.*t", // c.*t : c로 시작하고 t로 끝나는 모든 문자열
				
				"[b|c].*", // [b|c].* : b 또는 c로 시작하는 모든 문자열
				
				".*a.*", // a를 포함한 모든 문자열. 여기서 *은 0개 이상의 문자열이 있어야한다는 뜻
				
				".*a.+", // a를 포함한 모든 문자열. 여기서 *은 1개 이상의 문자열이 있어야한다는 뜻 (즉 a로 끝나는 것은 허용하지 않는다는 뜻)
				
				"[b|c].{2}" // b또는 c로 시작하는 세자리 문자열 {}안의 숫자는 뒤에 오는 문자의 갯수를 의미한다.
				
				}; 
		
		for (int i=0; i < regex.length; i++) {
			System.out.println("=======================");
			Pattern p = Pattern.compile(regex[i]);
			System.out.println("Pattern : "+regex[i]);
			System.out.println("조회 결과 ");
			
			for (int j=0; j < data.length; j ++) {
				Matcher m = p.matcher(data[j]);
				if (m.matches()) System.out.print(data[j] + " ");
			}
			System.out.println();
		}
	}

}
