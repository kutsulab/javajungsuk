public class Main {

    public static void main(String[] args) {

        MyThread th1 = new MyThread("*");
        MyThread th2 = new MyThread("**");
        MyThread th3 = new MyThread("***");

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
            System.out.println("th1 stopped");
            th2.stop();
            System.out.println("th2 stopped");
            Thread.sleep(2000);
            th3.stop();
            System.out.println("th3 stopped");
        } catch (InterruptedException e) {}

    }
}
