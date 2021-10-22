
	/* ========================================================================
	 *  Java의 정석 3판 p.736 예제 13-6 : 쓰레드의 I/O 블락킹(blocking)
	 * ========================================================================
	 *
	 *     1. I/O 블락킹
	 *      입출력을 마치기 전까지는 다음 작업을 수행하기 전까지 쓰레드가 기다리게 되는데, 이를 I/O 블락킹이라고 한다. 
	 *      기다리는 시간만큼 시간지연이 발생하게 되는 문제가 발생함.
	 *      
	 *      I/O와 다른 작업을 동시에 진행하려면 멀티 쓰레드로 코드를 작성하면 작업 소요시간이 감소한다. 
	 *       
	 * ========================================================================
	 */


import javax.swing.JOptionPane;

public class ThreadEx6 {

	public static void main(String[] args) {
		ThreadEx6_IO io = new ThreadEx6_IO(); // 일반 객체
		ThreadEx6_Counter counter = new ThreadEx6_Counter(); // 일반 객체

		// 입력단
		io.run();
		
		// 싱글 쓰레드 : io.run()의 입출력을 기다리는 I/O 블락킹이 발생함. -> counter가 일을 안해서 시간이 추가 지연됨
		counter.run();
	}

}

class ThreadEx6_Counter {
	
	private int countTime; // 카운트 time
	
	ThreadEx6_Counter(int countTime) {
		this.countTime = countTime;
	}
	
	ThreadEx6_Counter() {
		this(10); // 디폴트 : 10
	}
	
	public void run() {
		countDown();
	}
	
	private void countDown() {
		for (int i = countTime; i>0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000); // 1000ms = 1s 지연
			} catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
}

class ThreadEx6_IO {
	
	private String input;
	
	public void run() {
		read();
		write();
	}
	
	private void read() {
	    input = JOptionPane.showInputDialog("아무 값이나 입력하셈"); // 사용자로부터 창을 통해 입력을 저장한다.
	}
	
	private void write() {
		System.out.println("입력한 값은 "+input+"이다."); // input을 출력한다.
	}
}