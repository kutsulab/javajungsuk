
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ScannerEx2 {
	
	/* Java의 정석 3판 p.512 예제 9-36 내용정리 및 연습
	 * 
	 * <파일 객체 : java.io.File>
	 * 
	 *  - 파일 객체 : File(String source) - soruce에는 파일의 경로 및 이름에 해당하는 문자열
	 *  - 이 생성자는 FileNotFoundeException을 throws함. try-catch로 처리하거나, 또 throws를 시켜야함.
	 * 
	 * <파일 객체로부터 Scanner 객체 생성>
	 *  - 생성자 : Scanner(File source) - 파일 객체를 매개변수로 하여 Scanner 객체를 생성
	 *  - File에 저장된 내용들이 버퍼에 저장된다.
	 *  
	 * <Scanner 클래스의 메서드>
	 *  - hasnextInt() : 버퍼의 다음 부분에 int가 존재하는지 여부를 boolean으로 반환
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner (new File("ScannerData2.txt"));
		// .java 파일와 같은 디렉토리에 있어야함.
		// 여기서 eclipse에서는 src, bin 폴더를 내부적으로 분리하므로 해당 상위 폴더에 소스파일이 있어야함
		
		/* ScannerData2.txt의 내용
		 * 100
		 * 200
		 * 300
		 * 400
		 * 500
		 */
		
		int sum = 0;
		int count = 0;
		
		while (sc.hasNextInt()) { //버퍼의 다음부분에 Int가 있는가? 있으면 true
			sum += sc.nextInt(); // 버퍼의 Int값을 sum에 추가 후 버퍼에서 해당 내용 제거
			count ++; // int의 수를 세어줌.
		}
		
		System.out.println("sum = "+sum); // 합
		System.out.println("ararage = "+ (double)sum/count); // 평균
	}

}
