
	/* ========================================================================
	 *  Java의 정석 3판 p.730 예제 13-2 : 쓰레드와 CallStack
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


public class ThreadEx2 {

	public static void main(String[] args) {
		
		ThreadEx2_2 instance = new ThreadEx2_2(); // 일반 인스턴스
		instance.start();

//		java.lang.Exception
//		at ThreadEx2_2.throwException(ThreadEx2.java:49)
//		at ThreadEx2_2.run(ThreadEx2.java:44)
//		at ThreadEx2_2.start(ThreadEx2.java:40)
//		at ThreadEx2.main(ThreadEx2.java:7)
// 		예외 로그에 main 메서드, 그리고 start메서드가 같이 잡힘. (main 쓰레드에서 실행됐기 때문)
		
		Thread th = new Thread(new ThreadEx2_1()); // Runnable 구현체로 생성한 Thread 객체
		th.start();
		
//		java.lang.Exception
//		at ThreadEx2_1.throwException(ThreadEx2.java:30)
//		at ThreadEx2_1.run(ThreadEx2.java:25)
//		at java.lang.Thread.run(Thread.java:748)
// 		예외 로그에 main 메서드가 잡히지 않고, run()메서드만 잡힘.
//		main 쓰레드의 CallStack에 올려진 main() 메서드는 이미 종료되어, 예외와 무관함.
		
	}

}

class ThreadEx2_1 implements Runnable {
	
	@Override
	public void run() {
		throwException();
	}
	
	private void throwException () {
		try {
			throw new Exception(); // 예외를 발생시킴
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class ThreadEx2_2 {
	
	public void start() {
		run();
	}
	
	public void run() {
		throwException(); // 고의적으로 예외를 발생시킴.
	}
	
	private void throwException() {
		try {
			throw new Exception(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}