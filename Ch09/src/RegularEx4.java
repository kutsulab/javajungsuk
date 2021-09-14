
import java.util.regex.*;

public class RegularEx4 {
	
	/* Java의 정석 3판 p.509 예제 9-34 내용확인 및 연습
	 * 
	 * [Match의 메서드]
	 *  - start() : 매칭된 문자열이 시작하는 index를 반환
	 *  - end() : 매칭된 문자열이 끝나는 index를 반환
	 *  
	 *  - appendReplacement(StringBuffer sb, String replacement)
	 *  	: 매칭된 문자를 replacement로 교체한 결과물을 매칭부분까지 sb에 저장
	 *  
	 *  - appendTail(StringBuffer sb)
	 *    : appendReplacement로 마지막으로 추가된 부분의 뒷부분을 전부 sb에 추가
	 * 
	 *  + StringBuffer의 append를 통해 문자열이 추가될 때 capacity를 초과할 경우 자동으로 capacity가 늘어난다.
	 */
	
	public static void main(String[] args) {
		
		String source = "아줌마 너무 싫어 볼수록 너무 싫어 꽃보다 아름다운 아줌마 정말 싫어"; //원본 문자열
		System.out.println("source : "+source);
		
		String pattern = "싫어"; // regex : 교체하려고 하는 문자열을 패턴으로 지정
		System.out.println("pattern : "+pattern);
		
		String replacement = "좋아"; // 대체할 문자열
		System.out.println("replacement : "+replacement);
		System.out.println();
		
		StringBuffer sb = new StringBuffer(); // 대체 문자열을 저장할 StringBuffer 생성
		System.out.println("변경할 내용을 저장할 StringBuffer sb 생성!");
		System.out.println("sb.capacity() : "+sb.capacity()+"\n"); //sb의 버퍼의 크기 : 16 (디폴트)
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);
		System.out.println("pattern을 패턴으로 하고, source를 매개변수로 하는 Matcher 인스턴스 m 생성!\n");
		
		int i=0;
		
		while (m.find()) {
			System.out.println(++i+"번째 매칭 : "+ m.start() + "~" + m.end());
			//m.start() : 매칭된 문자열이 시작하는 index를 반환함
			//m.end() : 매칭된 문자열이 끝나는 index를 반환함
			
			System.out.println("매칭된 내용을 '"+replacement+"'로 대체합니다.");
			System.out.println("그리고 해당부분까지의 내용을 sb에 저장합니다.");
			m.appendReplacement(sb, replacement);
			// 이전에 매칭된 부분 다음 부분부터(처음의 경우 첫부분 부터)
			// 매칭된 부분까지를 sb에 저장. 매칭된 부분은 해당 문자열로 치환함

			System.out.println("sb : "+sb.toString());
			System.out.println("sb.capacity() : "+sb.capacity()+"\n");
		}
		
		System.out.println("마지막으로 매칭된 부분 이후의 내용을 sb에 덧붙여 저장합니다.");
		m.appendTail(sb); // 마지막으로 치환된 부분의 이후의 내용을 sb에 덧붙임
		System.out.println();
		
		System.out.println("교체 완료!");
		System.out.println("Replace count = " + i); // 교체된 횟수
		System.out.println("Replace result : "+sb.toString()); // 교체한 결과 출력
		System.out.println("Replace sb.capacity() : "+sb.capacity()); // capacity를 초과한 길이의 문자열을 삽입하니 capacity가 자동으로 늘어남 
	}
}
