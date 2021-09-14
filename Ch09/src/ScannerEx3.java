
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ScannerEx3 {

	/* Java의 정석 p.512 예제 9-37 내용 정리 및 연습
	 * 
	 * [구분자를 사용하는 Scanner 객체 생성]
	 * Scanner useDelimiter(Pattern pattern) : Pattern 객체에 저장된 패턴(정규식)을 구분자로 한 Scanner 생성
	 * Scanner useDelimiter(String pattern) : 문자열로 된 패턴(정규식)을 구분자로 한 Scanner 생성
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		
		int linesCount = 0;
		
		Scanner sc1 = new Scanner(new File("ScannerData3.txt"));
		
		int totalSum = 0;
		
		while (sc1.hasNextLine()) {// 다음 Line이 있는가?
			String line = sc1.nextLine(); // 버퍼에서 다음 Line을 개행자 포함 가져와, 개행자 전까지 반환함
			Scanner sc2 = new Scanner(line).useDelimiter(",");
			// line을 소스로 하고 문자열 ","를 구분자로 한 Scanner 객체 생성
			
			int lineSum = 0; // 라인별 sum 초기화
			
			while(sc2.hasNextInt()) { // 다음 int가 있는가?
				lineSum += sc2.nextInt(); // 다음 int를 sum에 합산함 
			}
			System.out.println(line + " -> lineSum = "+lineSum);
			totalSum += lineSum; // 위에서 합산 완료 된 sum을 totalSum에 합산함
			linesCount ++;
		}
		System.out.println("linesCount : "+linesCount+", totalSum : "+totalSum);
	}

}
