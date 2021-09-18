
import java.text.*;

public class MessageFormatEx3 {

	/* Java의 정석 3판 p.550 예제 10-20 내용확인 및 연습
	 * 
	 * [형식화된 데이터에서 데이터들을 추출하기]
	 * MessageFormat 객체.parse(String source)
	 * 형식화된 문자열이 있을 때 형식을 지정하여 MessageFormat 객체를 생성하고
	 * mf.parse(String Soruce)를 사용할 때 각 데이터들을 Object[]의 각 요소에 순서대로 반환함
	 * 
	 */
	
	
	public static void main(String[] args) throws Exception {
		String[] data = {
				"INSERT INFO CUST_INFO VALUES ('캬루','02-1234-5678',14,'09-02');",
				"INSERT INFO CUST_INFO VALUES ('콧코로','02-1111-2222',11,'05-11');"
		}; // 형식화 되어있는 데이터
		
		String pattern = "INSERT INFO CUST_INFO VALUES ({0},{1},{2},{3});"; // 형식 지정
		MessageFormat mf = new MessageFormat(pattern);
		
		for (int i=0; i<data.length; i++) {
			Object[] objs = mf.parse(data[i]); // 형식화된 데이터에서 데이터를 추출해 배열에 순서대로 집어 넣음
			//예외를 던지므로 예외처리해줘야하는데 main메서드가 throws 하도록 처리함
			
			for(int j=0; j<objs.length; j++) {
				System.out.print(objs[j] +", ");
			}
			System.out.println();
		}
	}

}
