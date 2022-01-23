public class Main {

    static long startTime;

    public static void main(String[] args) {
        startTime = System.currentTimeMillis();
        Thread th1 = new Thread(new MyRunnable("th1","-"));
        Thread th2 = new Thread(new MyRunnable("th2","|"));

        th1.setPriority(1);
        th2.setPriority(10);

        System.out.println("Priority of th1(-) : "+th1.getPriority());
        System.out.println("Priority of th2(|) : "+th2.getPriority());
        th1.start();
        th2.start();

        // 결과 : th1의 실행빈도가 더 높다.
    }
}
