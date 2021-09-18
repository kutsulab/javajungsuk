
import java.util.*; // Scanner 클래스의 소속 패키지
import java.text.*; // MessageFormat 클래스의 소속 패키지
import java.io.*; // File 클래스의 소속 패키지

public class MessageFormatEx4  {
	
	/* Java의 정석 3판 p.551 예제 10-21 내용 확인 및 연습
	 * 파일을 통해 가져온 형식화된 문자열에서 데이터를 추출하고, 데이터를 다른 형식에 맞게 출력하기
	 * 
	 * [작동 매커니즘]
	 * 1. 원본 소스 파일을 Scanner 클래스를 통해 가져옴
	 * 2. 불러온 소스를 줄별로 읽어서 line으로 분리
	 * 3. 각 line의 형식을 지정하고 지정한 형식에 맞게 데이터를 추출하여, 객체배열 Object[]에 담음
	 * 4. Object[]에 담긴 데이터를 또다른 추출 형식에 맞춰서 추출
	 */
	
	public static void main(String[] args) throws Exception {

		//=========== 입력데이터에서 추출할 데이터의 형식=====================================
		
		String ext_pattern = "{0},{1},{2},{3}"; 
		MessageFormat ext_form = new MessageFormat(ext_pattern); // 추출 데이터의 형식 지정
		
		//==============데이터를 출력할 형식=========================================
		
		String tableName = "CUST_INFO";
		String print_pattern = "INSERT INTO "+ tableName + " VALUES ({0},{1},{2},{3});";
		MessageFormat print_form = new MessageFormat(print_pattern); // 데이터를 출력할 방식 지정
		
		//===============입력 데이터=====================================================
		
		String fileName = "data4.txt";
		Scanner sc = new Scanner(new File(fileName));		// 파일을 Scanner로 받아와서 읽게 시킴
		// Exception을 던지는데 이는 main메서드에서 throws 하도록 함

		/* data4.txt 의 실제 내용
		 * '캬루','02-1234-5678',14,'09-02'
		 * '콧코로','02-1111-2222',11,'05-11'
		 */
		
		//========================= 실제 추출 실행 =========================================
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine(); // 줄별로 문자 데이터를 분리
			Object[] extraction = ext_form.parse(line); // 추출
			System.out.println(print_form.format(extraction)); // 추출결과를 형식화(포맷화) 후 출력
		}
		
		sc.close();
		
	}//main 메서드 끝

}
