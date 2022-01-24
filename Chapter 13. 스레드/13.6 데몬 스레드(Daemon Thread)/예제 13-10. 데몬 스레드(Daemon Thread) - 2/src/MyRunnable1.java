public class MyRunnable1 implements Runnable {

    @Override
    public void run() { // 단순히 5초간 기다리는 스레드
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}
    }
}