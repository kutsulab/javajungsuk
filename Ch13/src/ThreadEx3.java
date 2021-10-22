
	/* ========================================================================
	 *  Java의 정석 3판 p.730 예제 13-3 : 쓰레드와 CallStack
	 * ========================================================================
	 *
	 *     1. CallStack
	 *      쓰레드가 작업(메서드)을 실행하는데에는 CallStack이 필요하다.
	 *      쓰레드들은 메서드가 CallStack에 올라간 뒤, OS의 스케쥴러가 정한 순서에 의해서 번갈아가면서 수행됨. 
	 *     
	 *     2. main 쓰레드
	 *      - main메서드를 실행하는 쓰레드가 main 쓰레드.
	 *      - main메서드 역시 main쓰레드의 CallStack에 올려져서 실행됨.
	 *     
	 *     3. Thread의 start() 메서드는?
	 *      - 쓰레드 객체의 run()을 수행하는데 필요한 CallStack을 생성
	 *      - 새로 생성된 CallStack에 run()을 호출
	 *      - 이후 OS의 스케쥴러가 정한 순서에 의해 CallStack에 올라간 메서드들이 번갈아가면서 수행됨.
	 *     
	 *     4. CallStack의 소멸
	 *      - 쓰레드가 종료되면 작업에 사용된 CallStack이 소멸
	 *      
	 *     5. 프로세스의 종료
	 *      - 실행 중인 사용자 쓰레드가 하나도 없을 때 종료됨.
	 *      
	 * ========================================================================
	 */

public class ThreadEx3 {

	public static void main(String[] args) {
		Thread th = new Thread(new ThreadEx3_1());
		th.run(); // 메인 쓰레드의 CallStack에 run()메서드를 직접 호출
		//th.start() // th 쓰레드의 Callstack에 run() 메서드를 호출.
		
		/*
		 * java.lang.Exception
		 * at ThreadEx3_1.throwException(ThreadEx3.java:21)
		 * at ThreadEx3_1.run(ThreadEx3.java:15)
		 * at java.lang.Thread.run(Thread.java:748)
		 * at ThreadEx3.main(ThreadEx3.java:6) // 메인 쓰레드에서 예외 발생
		 * 
		 */
	}

}

class ThreadEx3_1 implements Runnable {
	
	@Override
	public void run() {
		throwException();
	}
	
	public void throwException() {
		
		try {
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}