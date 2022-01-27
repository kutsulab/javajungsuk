public class Main {

    public static void main(String[] args) {
        MyRunnable r1 = new MyRunnable();
        MyRunnable r2 = new MyRunnable();
        MyRunnable r3 = new MyRunnable();

        Thread th1 = new Thread(r1, "*");
        Thread th2 = new Thread(r2, "**");
        Thread th3 = new Thread(r3, "***");

        th1.start();
        th2.start();
        th3.start();

        try {
            Thread.sleep(2000);
            r1.suspend();
            System.out.println("th1 suspend");
            Thread.sleep(2000);
            r2.suspend();
            System.out.println("th2 suspend");
            Thread.sleep(3000);

            r1.resume();
            System.out.println("th1 resume");
            Thread.sleep(3000);

            r1.stop();
            System.out.println("th1 stopped");
            r2.stop();
            System.out.println("th2 stopped");
            Thread.sleep(2000);
            r3.stop();
            System.out.println("th3 stopped");
        } catch (InterruptedException e) {}

    }
}
