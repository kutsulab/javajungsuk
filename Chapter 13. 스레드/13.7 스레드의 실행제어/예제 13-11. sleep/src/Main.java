public class Main {

    public static void main(String[] args) {
        Thread th1 = new Thread(new MyRunnable("-"), "th1");
        Thread th2 = new Thread(new MyRunnable("|"), "th2");

        th1.start();
        th2.start();
        try {
            th1.sleep(2000);
        } catch (InterruptedException e) {} // interrupt 명령이 발생하면, InterruptException이 throw되고 탈출한다.
        System.out.printf("<<%s 종료>>", Thread.currentThread().getName());
    }

}
