
public class Main {

    public static void main(String[] args) {
        MyThread mth1 = new MyThread("*");
        MyThread mth2 = new MyThread("**");
        MyThread mth3 = new MyThread("***");

        mth1.start();
        mth2.start();
        mth3.start();

        try {
            Thread.sleep(2000);
            mth1.suspend();
            Thread.sleep(2000);
            mth2.suspend();
            Thread.sleep(3000);
            mth1.resume();
            Thread.sleep(3000);
            mth1.stop();
            mth2.stop();
            Thread.sleep(2000);
            mth3.stop();
        } catch (InterruptedException e) {}
    }
}
