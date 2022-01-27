
public class GarbageCollector implements Runnable {

    private final static int MAX_MEMORY = 1000;
    private int usedMemory = 0;

    private Thread thread;

    public GarbageCollector() {
        this.thread = new Thread(this);
    }

    // 현재 사용된 메모리를 반환한다.
    public int usedMemory() {
        return usedMemory;
    }

    // 최대 메모리를 반환한다.
    public int totalMemory() {
        return MAX_MEMORY;
    }

    // 여유 메모리를 반환한다.
    public int freeMemory() {
        return MAX_MEMORY - usedMemory;
    }

    // thread를 daemon 스레드로 만든다.
    public void setDaemon() {
        this.thread.setDaemon(true);
    }

    // thread를 실행한다.
    public void start() {
        this.thread.start();
    }

    // 지정 메모리만큼 사용한다.
    public void useMemory(int usingMemory) {
        this.usedMemory += usingMemory;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10_000); // 10초 대기
            } catch (InterruptedException e) { // 도중에 interrupt가 발생하면 깨어난다.
                System.out.println("Awaken by interrupt()");
            }
            garbageCollect(); // garbageCollect를 작동한다.
            System.out.println("Garbage Collected.");
            System.out.printf("usedMemory : %4d/%4d (Free Memory : %4d) (GC)%n", usedMemory, totalMemory(), freeMemory());
        }
    }

    public void interrupt() {
        this.thread.interrupt();
    }

    public void join(int millis) {
        try {
            thread.join(millis);
        } catch (InterruptedException e) {}
    }

    // 가비지 컬렉터 작동 - 불필요한 메모리를 300 정리한다.
    private void garbageCollect() {
        this.usedMemory -= 300;
        if (this.usedMemory < 0) usedMemory = 0;
    }

}
