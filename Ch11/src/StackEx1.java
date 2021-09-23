
import java.util.*;

public class StackEx1 {
	
	/* Java의 정석 3판 p.608 예제 11-9
	 * 
	 * [Stack의 활용 - 웹 브라우저에서 뒤로/앞으로]
	 *  - 이동한 사이트를 순서대로 back 스택에 쌓음
	 *  - back 스택의 마지막에 위치한 사이트는 현재 사이트임.
	 *  - 이전 사이트로 이동했을 때, back의 최신 사이트를 추출(+삭제)하여 forward 스택에 쌓음.
	 *  - 이전 사이트로 이동하면서, 마지막 아래에 있던 스택이 현재 사이트가 됨
	 *  - 새로운 사이트로 이동시, forward 스택은 비워짐
	 */
	
	
	private static Stack back = new Stack(); // 이동한 사이트를 시간 순서대로 Stack에 저장
	private static Stack forward = new Stack(); // 뒤로 갔을 때 stack에서 pop한 객체(url)를 순서대로 저장
	
	private static void goURL(String url) {
		back.push(url); // back 스택에 url을 저장
		if(!forward.empty()) forward.clear(); // 새로운 페이지를 이동 -> forward 스택을 비움
		System.out.println("====='"+url+"' 사이트로 이동 후=====");
		printStatus();
		return;
	}
	
	private static void goBack() {
		if (!back.empty()) { // back 스택이 비어져있지 않다면
			forward.push(back.pop()); // back에서 추출(pop)한 객체를 forward에 저장
			System.out.println("=====뒤로 가기 버튼을 누른 후=====");
			printStatus();
		}
	}
	
	private static void goForward() {
		if (!forward.empty()) { //forward가 비어져있지 않다면
			back.push(forward.pop()); // forward에서 추출(pop)한 객체를 back에 저장
			System.out.println("=====앞으로 가기 버튼을 누른 후=====");
			printStatus();
		}
	}
	
	
	private static void printStatus() {
		System.out.println("back : "+back);
		System.out.println("forward : "+forward);
		System.out.println("현재 페이지는 "+"'"+back.peek()+"' 입니다.");
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		goURL("1. Google");
		goURL("2. MicroSoft");
		goURL("3. Amazon");
		goURL("4. Apple");
		
		goBack();
		goBack();
		
		goForward();
		
		goURL("5. Yahoo"); // 사이트를 새로 이동했으므로 forward가 비워짐
	}
}
