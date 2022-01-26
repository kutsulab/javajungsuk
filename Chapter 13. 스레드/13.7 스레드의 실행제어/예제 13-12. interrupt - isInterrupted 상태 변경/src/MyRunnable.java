public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.printf("isInterrupted : %b%n", Thread.currentThread().isInterrupted()); // 최초 isInterrupted 상태 출력

        int i= 10;
        while (i!=0 && !Thread.currentThread().isInterrupted()) {
            System.out.println(i--);
            for (long x=0; x<25_0000_0000L; x++); // 시간 지연
        }
        System.out.printf("Interrupted : %b%n", Thread.interrupted()); // Thread.interrupted() 메서드는 호출한 스레드의 isInterrupted 상태를 반환 후, isInterrupted 상태를 false로 돌린다.
        System.out.printf("isInterrupted : %b%n", Thread.currentThread().isInterrupted()); // isInterrupted() 메서드는 스레드의 isInterrupted의 상태를 반환한다.
        System.out.println("카운터가 종료되었습니다.");
    }
}
