
	/* ========================================================================
	 *  Java의 정석 3판 p.733 예제 13-5 : 멀티쓰레드 프로세스
	 * ========================================================================
	 *
	 *     1. 멀티 쓰레드 프로세스
	 *      두개 이상의 쓰레드로 작업을 수행하는 프로세스
	 *      
	 *      모든 프로세스, 그리고 쓰레드들은 OS의 스케쥴러에 의해 실행순서, 실행시간이 결정되기 때문에
	 *      매 순간 각각에게 할당되는 실행시간이 일정하지 않음. 
	 *      
	 *     2. 컨텍스트 스위칭(context switching)
	 *      쓰레드 간의 작업 전환 과정.
	 *      컨텍스트 스위칭 과정에서는 실행할 작업의 정보가 매번 변경되므로 시간 소요가 추가적으로 발생한다.
	 *      싱글코어에서 단순히 cpu만을 사용한 계산작업에 있어서는 멀티쓰레드보다 싱글쓰레드가 더 효율적이다.
	 *       
	 * ========================================================================
	 */


public class ThreadEx5 {
	
	static long startTime; // 작업 시작시점
	
	public static void main(String[] args) {
		// 쓰레드 생성
		Thread th1 = new ThreadEx5_1("|");
		Thread th2 = new ThreadEx5_1("-");
		
		// currentTime을 현재 시각으로 변경
		startTime = System.currentTimeMillis();
		
		// 각 쓰레드의 이름
		System.out.println("th1 : "+th1.getName());
		System.out.println("th2 : "+th2.getName());
		
		// 각 쓰레드에서  실행
		th1.start();
		th2.start();
		
		System.out.print("(메인 쓰레드 종료)"); // 메인 쓰레드 종료
	}
}

class ThreadEx5_1 extends Thread {
	
	private String testString;
	private int repeatCnt;
	
	ThreadEx5_1(String testString, int repeatCnt) {
		this.testString = testString;
		this.repeatCnt = repeatCnt;
	}
	
	ThreadEx5_1(String testString) {
		this(testString, 1000); // 디폴트 1000;
	}
	
	@Override
	public void run() {
		
		// 작업 시작
		System.out.printf("(%s 작업 시작)", getName());
		
		// 작업
		printTestString();
		
		// 작업 시작 시점으로부터의 경과 시간
		long finishTime = System.currentTimeMillis();
		long timeGap = finishTime - ThreadEx5.startTime;
		
		// 경과시간 출력
		System.out.printf("(%s 경과시간 : %d)", getName(),timeGap);
		return;
	}

	private void printTestString() {
		for (int i=0; i< repeatCnt; i++) {
			System.out.printf("%s",new String(testString)); // 쓰레드의 지연시간 확인을 용이하게 하기 위해 성능이 떨어지는 방식으로 문자열을 출력함
		}
	}
}
