public class Main {

    public static void main(String[] args) {

        Thread th1 = new Thread(new MyRunnable("-"));
        Thread th2 = new Thread(new MyRunnable("|"));

        th1.start();
        th2.start();
        long startTime = System.currentTimeMillis();

        try {
            th1.join(); // th1, th2가 종료될 때까지 기다린다.
            th2.join();
        } catch (InterruptedException e) {}

        long finishTime = System.currentTimeMillis();
        System.out.printf("%n소요 시간 : %d%n", finishTime - startTime);
    }
}
