public class ThreadEx1 extends Thread {

    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            String thisThreadName = super.getName(); // 상위클래스인 Thread의 getName 메서드 호출
            System.out.println(thisThreadName);
            try {
                Thread.sleep(100); // 스레드를 100ms 멈춘다.
            } catch (InterruptedException e) {
            }
        }
    }
}
