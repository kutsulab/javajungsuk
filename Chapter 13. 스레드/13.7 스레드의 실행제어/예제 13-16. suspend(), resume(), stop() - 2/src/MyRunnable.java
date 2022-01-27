
public class MyRunnable implements Runnable {

    private volatile boolean suspended = false;
    private volatile boolean stopped = false;

    @Override
    public void run() {
        while(!stopped) {
            if (!suspended) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
            }
        }
    }

    public void suspend() {
        suspended = true;
    }

    public void resume() {
        suspended = false;
    }

    public void stop() {
        stopped = true;
    }
}
