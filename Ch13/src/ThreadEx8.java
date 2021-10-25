
	/* ========================================================================
	 *  Java의 정석 3판 p.738 예제 13-8 : 쓰레드의 우선순위
	 * ========================================================================
	 *
	 *     1. 쓰레드의 우선순위
	 *      쓰레드는 실행 우선순위를 결정하는 멤버변수 priority를 가지고 있음.
	 *      우선순위를 서로 다르게 지정하여, 특정 쓰레드의 더 많은 작업시간을 갖도록 할 수 있다.
	 *      이 값은 최소 1, 최대 10의 값을 가지며 클 수록 더 높은 우선순위를 가진다.
	 *      
	 *      기본적으로 5로 지정되어 있다.
	 *      
	 *     2. 우선순위의 getter, Setter
	 *      - void setPriority(int newPriority) : Priority를 지정 값으로 변경
	 *      - int getPriority() : 쓰레드의 우선순위를 반환 
	 *     
	 *     3. 우선순위에 대하여
	 *      - OS의 우선순위와 JVM내에서의 우선순위는 별개. 
	 *      - OS마다 다른 방식으로 작업의 순서를 스케쥴링하기 때문에 어떤 OS에서 실행하느냐에 따라 다른 결과를 얻을 수 있음.
	 *      - priority가 높은 값이 무조건적으로 먼저 진행되는 것이 아니라, 더 높은 확률로 작업시간을 할당받을 수 있다는 점 정도.
	 *       
	 * ========================================================================
	 */

public class ThreadEx8 {

	public static void main(String[] args) {
		Thread th1 = new Thread(new ThreadEx8_1("-"));
		Thread th2 = new Thread(new ThreadEx8_1("|"));
		
		th2.setPriority(9); // th2의 우선순위를 더 높게 잡음.
		
		System.out.println("Priority of th1(-) : "+th1.getPriority());
		System.out.println("Priority of th2(|) : "+th2.getPriority());
		th1.start();
		th2.start();
		
		// 결과 : th1의 실행빈도가 더 높다.
	}
}

class ThreadEx8_1 implements Runnable {
	
	private String testString;
	private int repeatCnt;
	
	ThreadEx8_1(String testString, int repeatCnt) {
		this.testString = testString;
		this.repeatCnt = repeatCnt;
		return;
	}
	
	ThreadEx8_1(String testString) {
		this(testString, 1000);
		return;
	}
	
	public void run() {
		printStr();
	}
	
	private void printStr() {
		for(int i=0; i<repeatCnt; i++) {
			System.out.print(testString);
			for(int x=0; x<10000000; x++); // 아무 것도 하지 않는 반목문으로 시간 지연 
		}
		return;
	}
}
