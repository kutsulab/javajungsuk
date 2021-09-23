
import java.util.*;

public class ExpValidCheck {
	
	/* Java의 정석 3판 p.610 예제 11-10
	 * 
	 * [Stack의 활용 - 수식의 유효성 (괄호) 검사]
	 *  - 수식 문자열에서 여는 괄호 '(' 를 발견하면 스택에 저장
	 *  - 닫는 괄호를 발견하면 스택에서 pop함
	 *  
	 *  - 최종적으로 스택이 비워져 있으면 정상적으로 괄호의 갯수를 맞게 입력한 것
	 *  
	 *  - 여는 괄호보다 닫는 괄호가 많으면 스택이 비워진 상태에서 pop을 하게 되므로 예외(EmptyStackException)가 발생함
	 *  - 이에 대한 예외처리까지 해야 완전하게 처리됨
	 * 
	 */
	
	public static void main(String[] args) {
		if (args.length!=1) { // args로 1개의 문자열을 입력하지 않은 경우
			System.out.println("Usage : java ExpValidCheck \"EXPRESSION\""); // \는 ""에서의 escape 문자다.
			System.out.println("EXPRESSION Example : java ExpValidCheck \"((1+2)*3)+4\"");
			System.exit(0); // 프로그램 강제 종료
		}
		
		Stack st = new Stack();
		String expression = args[0]; // 실행 인수를 저장
		
		System.out.println("expression : "+expression);
		
		try {
			
			for (int i=0; i < expression.length(); i++) {
				char ch = expression.charAt(i); // 각 index의 문자를 ch 저장
				
				if (ch=='(') {
					st.push(String.valueOf(ch)); // ch가 여는 괄호'('이면  스택에 저장
				} else if (ch==')') {
					st.pop(); // 닫는 괄호 ')'를 발견하면 스택에서 제거
				}
				
			} // for문 끝
			
			if (st.isEmpty()) { // 괄호를 정상적으로 열고 닫으면 stack이 비워짐 
				System.out.println("괄호가 일치합니다.");
			} else { // stack이 안 비워져있음 : 괄호를 열고 안 닫은 비정상적인 상황
				System.out.println("괄호가 일치하지 않습니다.");
			}
			
		} catch (EmptyStackException ese) {// 스택이 비워있는 상태에서 스택을 pop할 때 예외 발생
			System.out.println("괄호가 일치하지 않습니다.");
		} // try-catch문 끝
		
		
	} // 메인 메서드 끝

}
