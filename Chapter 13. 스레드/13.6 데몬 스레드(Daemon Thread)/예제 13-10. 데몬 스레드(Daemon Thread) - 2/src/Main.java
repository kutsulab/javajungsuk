public class Main {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable1(), "Thread1");
        Thread thread2 = new Thread(new MyRunnable2(), "Thread2");

        thread1.start();
        thread2.start();
    }
}
