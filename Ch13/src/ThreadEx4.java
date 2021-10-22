
	/* ========================================================================
	 *  Java의 정석 3판 p.730 예제 13-4 : 싱글쓰레드
	 * ========================================================================
	 *
	 *     1. 싱글 쓰레드 프로세스
	 *      쓰레드 하나로 작업을 수행하는 프로세스
	 *      하나의 쓰레드로 작성됐을 경우, 메서드들이 동일한 CallStack에 순차적으로 호출됨 
	 *      
	 * ========================================================================
	 */

public class ThreadEx4 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis(); // 현재 시각에 해당하는 값을 ms 단위로 받아옴
		
		 
		
		run("|");
		long middleTime = System.currentTimeMillis(); // 현재 시각에 해당하는 값을 ms 단위로 받아옴
		long timeGap1 = middleTime - startTime;
		System.out.println("소요 시간 1 : "+timeGap1);
		
		
		// 위의 작업이 종료되고 다음 작업이 수행된다. (순차적 진행)
		run("-");
		long endTime = System.currentTimeMillis(); // 현재 시각에 해당하는 값을 ms 단위로 받아옴
		long timeGap2 = endTime - startTime;
		System.out.println("소요 시간 2 : "+timeGap2);
		
		// 메인 쓰레드 종료
	}
	
	private static void run(String testString) {
		for (int i=0; i< 1000; i++) {
			System.out.printf("%s",new String(testString)); // 쓰레드의 지연시간 확인을 용이하게 하기 위해 성능이 떨어지는 방식으로 문자열을 출력함
		}
		System.out.println();
		return;
	}

}


