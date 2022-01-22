public class ThreadEx2 implements Runnable {

    @Override
    public void run() {
        for (int i=0; i<100; i++) {
            String currentThreadName = Thread.currentThread().getName(); // 현재 스레드의 이름을 호출
            System.out.println(currentThreadName);
            try {
                Thread.sleep(100); // 스레드를 100ms 멈춘다.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
