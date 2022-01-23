public class MyRunnable implements Runnable{

    private String testString;

    MyRunnable(String testString) {
        this.testString = testString;
    }

    @Override
    public void run() {

        String threadName = Thread.currentThread().getName();
        // 작업 시작
        System.out.printf("(%s 작업 시작)", threadName);

        // 작업
        method();

        // 작업 시작 시점으로부터의 경과 시간
        long finishTime = System.currentTimeMillis();
        long timeGap = finishTime - Main.startTime;

        // 경과시간 출력
        System.out.printf("(%s 경과시간 : %d)", threadName, timeGap);
        return;
    }

    private void method() {
        for (int i=0; i< 1000; i++) {
            System.out.printf("%s",new String(testString)); // 쓰레드의 지연시간 확인을 용이하게 하기 위해 성능이 떨어지는 방식으로 문자열을 출력함
        }
    }
}
