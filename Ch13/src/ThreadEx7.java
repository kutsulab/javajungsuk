	/* ========================================================================
	 *  Java의 정석 3판 p.736 예제 13-7 : 쓰레드의 I/O 블락킹(blocking)
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

public class ThreadEx7 {

	public static void main(String[] args) {
		Thread io = new Thread(new ThreadEx7_IO()); // 쓰레드 객체
		Thread counter = new Thread(new ThreadEx7_Counter()); // 쓰레드 객체 
		
		// 멀티쓰레드로 진행 : I/O 블락킹이 발생하지 않아서 작업이 더 빨리 완료됨.
		io.start();
		counter.start();
	}

}

class ThreadEx7_Counter implements Runnable {
	
	private int countTime; // 카운트 time
	
	ThreadEx7_Counter(int countTime) {
		this.countTime = countTime;
	}
	
	ThreadEx7_Counter() {
		this(10); // 디폴트 : 10
	}
	
	@Override
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

class ThreadEx7_IO implements Runnable {
	
	private String input;
	
	public void run() {
		read();
		write();
	}
	
	private void read() {
	    input = JOptionPane.showInputDialog("아무 값이나 입력하셈");
	}
	
	private void write() {
		System.out.println("입력한 값은 "+input+"이다.");
	}
}