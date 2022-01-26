public class MyRunnable implements Runnable {

    @Override
    public void run() {
        int i = 10;
        Thread.currentThread().interrupt(); // isInterrupted 상태를 true로 변경한다.
        System.out.printf("isInterrupted : %b%n", Thread.currentThread().isInterrupted());
        while (i > 0) {
            System.out.println(i--); // 타이머 감소
            try {
                Thread.sleep(1000); // 1초 지연
            } catch (InterruptedException e) {
                break; // InterruptException이 발생하면 반복을 탈출한다.
            }
        }
        System.out.printf("isInterrupted : %b%n", Thread.currentThread().isInterrupted());
        System.out.println("카운트가 종료되었습니다.");
    }
}
