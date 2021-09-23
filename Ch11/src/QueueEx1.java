
import java.util.*;

public class QueueEx1 {
	
	/* Java의 정석 3판 p.611 예제 11-11
	 * 
	 * [Queue의 활용 - 최신 명령 이력]
	 *  - Queue에 순서대로 명령 이력 저장(offer)
	 *  - 일정 횟수 이상의 명령이 쌓일 경우, 제일 먼저 입력된 명령 이력부터 제거(remove)
	 *  - 공백을 입력 시 stack에 쌓지 않음
	 */
	
	private static Queue q = new LinkedList(); // Queue를 클래스변수로 생성함
	private static final int MAX_SIZE = 5; //Queue에 최대 5개까지만 저장하도록 함.
	
	private static void save(String input) {//queue에 저장
		
		if (!"".equals(input)) { //input이 공백이 아닐 때
			q.offer(input); // q에 명령어를 저장
		}
		
		if (q.size() > MAX_SIZE) {
			q.remove(); // q의 size가 max_size 이상일 때 현재 Queue에서 제일 먼저 저장된 객체가 삭제됨
		}
	}
	
	public static void main(String[] args) {
		printHelp();
		
		while(true) {
			System.out.print("PROMPT >> ");
			try {
				// 화면으로부터 라인단위로 입력받는다.
				Scanner sc = new Scanner(System.in);
				String input = sc.nextLine().trim(); //입력받은 문자열에서 양 끝의 공백을 제거, 소문자화
				
				if(!"".equals(input)) {
					continue; // 공백을 입력하면 다시 반복문의 처음으로 돌아가게 함
				}
				
				if(input.equalsIgnoreCase("q")) { //equalsIgnoreCase는 대소문자를 구분하지 않는다.
					exit();
				} else if (input.equalsIgnoreCase("help")) {
					printHelp();
				} else if (input.equalsIgnoreCase("history")) {
					printHistory(input);
				} else {
					saveInputAndPrint(input);
				} //if (input.equalsIgnoreCase("q"))문 끝
							
			} catch (Exception e) {
				System.out.println("오류입니다.");
			} // try- catch문 끝
			
		} // while문 끝
		
	} // main 메서드 끝

	private static void saveInputAndPrint(String input) {
		save(input);
		System.out.println(input);
	}

	private static void printHistory(String input) {
		int i=0;
		save(input.toLowerCase()); // 입력받은 명령어 저장
		
		LinkedList tmp = (LinkedList) q; // q를 linkedlist로 참조 변환
		ListIterator it = tmp.listIterator(); // tmp에 접근하는 기능을 가진 ListIterator 객체 생성
		
		while(it.hasNext()) { // 읽어올 다음 요소가 있는지 확인
			System.out.println(++i+"."+it.next()); // i를 증가시키고 다음 요소를 읽어서 출력
		}
	}

	private static void exit() {
		System.out.println("프로그램 종료!");
		System.exit(0); // q를 입력하면 프로그램 종료
	}

	private static void printHelp() {
		System.out.println("help - 도움말을 보여줍니다.");
		System.out.println("q 또는 Q - 도움말을 보여줍니다.");
		
		System.out.println("history - 최근에 입력한 명령어를 "+MAX_SIZE+"개 보여줍니다.");
	}

}//end of class
