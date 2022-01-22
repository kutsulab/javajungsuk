public class Main {

    public static void main(String[] args) {
        Thread th1 = new Thread(new MyRunnable("th1")); // Runnable 구현체를 통해 Thread 생성
        Thread th2 = new Thread(new MyRunnable("th2"));

        th1.start(); // 새로운 스레드의 스택에 run 스택프레임 push
        th2.run(); // Main 스레드의 main 스택 프레임 위에 run 메서드 호출
    }

}
