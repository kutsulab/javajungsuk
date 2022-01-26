public class MyRunnable implements Runnable {

    @Override
    public void run() {
        int i = 10;
        while (i > 0 && !Thread.currentThread().isInterrupted()) {
            System.out.println(i--); // 타이머 감소
            try {
                Thread.sleep(1000); // 1초 지연
            } catch (InterruptedException e) {}
        }
        System.out.printf("isInterrupted : %b%n", Thread.currentThread().isInterrupted());
        System.out.println("카운트가 종료되었습니다.");
    }
}
