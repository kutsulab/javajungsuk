import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        Thread thread1 = new ThreadEx1(); // Thread의 하위 클래스에서 run메서드 구현 후, 사용
        Thread thread2 = new Thread(new ThreadEx2()); // Runnable 구현체를 인자로 상속하기

        thread1.start();
        thread2.start();

        String thisThreadName = Thread.currentThread().getName();


        for (int i=0; i<100; i++) {
            System.out.println(thisThreadName);
            Thread.sleep(100); // 스레드를 100ms 멈춘다.
        }

    }

}
