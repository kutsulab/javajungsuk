
public class Main {

    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread th1 = new Thread(runnable, "*");
        Thread th2 = new Thread(runnable, "**");
        Thread th3 = new Thread(runnable, "***");

        th1.start();
        th2.start();
        th3.start();

        try {
            Thread.sleep(2000);
            th1.suspend();
            System.out.println("th1 suspend");
            Thread.sleep(2000);
            th2.suspend();
            System.out.println("th2 suspend");
            Thread.sleep(3000);

            th1.resume();
            System.out.println("th1 resume");
            Thread.sleep(3000);

            th1.stop();
            System.out.println("th1 stop");
            th2.stop();
            System.out.println("th2 stop");
            Thread.sleep(2000);
            th3.stop();
            System.out.println("th3 stop");
        } catch (InterruptedException e) {}
    }
}
