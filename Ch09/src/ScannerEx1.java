
import java.util.*;

public class ScannerEx1 {
	
	/* Java의 정석 3판 p.511 예제 9-35 내용 정리 및 연습
	 * 
	 * 전부터 개인적으로 쓰면서 여러 시행착오를 겪었던 클래스라서 인터넷에서 검색해서 책에 없는 부분까지 아는대로 적어봄.
	 * 잘못된 부분이 많을 것으로 추정되므로 잘못된 부분이 눈에 띄면 제보 부탁드림... 
	 * 
	 * [Scanner 클래스]
	 * 
	 * 입력소스로부터 문자 데이터를 읽어오는 목적으로 사용되는 클래스
	 * 
	 *  <생성자>
	 *  Scanner(System.in) : 사용자의 입력으로부터 값을 버퍼에 저장
	 * 	Scanner(String source) : 문자열 source에 저장된 값을 버퍼에 저장
	 *  Scanner(File source) : 파일 source에 저장된 값을 버퍼에 저장
	 * 	Scanner(InputStream source) : 15장 I/O에서 다룰 예정
	 *  ...
	 * 
	 *  <Scanner(System.in) 사용시 주의할 점>
	 * 
	 * 	1. 사용자의 입력
	 * 	2. 사용자가 입력 한값을 버퍼에 저장. 이 때 공백, 탭문자, 개행자(\n) 등도 버퍼에 저장된다.
	 * 	3. next(), nextInt() 메서드는
	 *     버퍼에서 다음 공백, 탭문자, 개행자를 기점으로 앞부분까지만 가져와서(버퍼에서 해당부분은 지워짐) 반환한다.
	 *  4. nextLine() 메서드는 다음 개행자(\n)까지 가져와서(버퍼에서 해당부분은 지워짐)
	 *    개행자 앞부분까지를 반환한다.
	 *    
	 * 	5. 이런 점에서 next(), nextInt() 등에 이어서 nextLine() 등을 같이 쓸 때는 주의해야하는데,
	 *    버퍼를 nextLine()을 한번 사용해서 버퍼를 비우도록 해야함.
	 * 
	 * 	6. 타입이 맞지 않는 입력값을 받았을 경우 inputMismatchException이 발생하므로 예외처리를 하는 것이 좋다.
	 * 
	 */
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] argArr = null; // String 배열 초기화
		
		while(true) {
			String PROMPT = ">>";
			System.out.print(PROMPT);
			
			// 라인을 입력받는다. (nextLine()은 개행자까지 버퍼에서 가져와서 개행자 전까지의 값을 반환한다.)
			String input = s.nextLine();
			
			
			// 입력받은 문자열을 쪼갠다. 
			
			input = input.trim(); // 양끝의 공백을 제거
			argArr = input.split(" +");//하나 이상의 공백을 구분자로 하여 잘라서, argArr에 분리 결과들을 저장
			
			String command = argArr[0].trim(); // 0번 index에 위치한 문자열의 양 옆을 자른 문자열
			
			if ("".equals(command)) continue; // 공백을 입력해버리면 다시 입력하게 함
			
			// command를 소문자로 변경
			command = command.toLowerCase();
			
			// q 또는 Q를 입력하면 실행 종료
			if (command.equals("q")) {
				System.out.println("종료!");
				s.close();
				System.exit(0); // 종료
			}
			
			else {
				for (int i=0; i < argArr.length; i++)
					System.out.println(argArr[i]); //입력한 것들을 구분자를 기준으로 쪼개서 개행해서 출력
			}
			
		} // while문 (true)
		
	} // main 메서드

}
