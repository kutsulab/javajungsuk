public class MyThread implements Runnable {

    private Thread thread;

    private volatile boolean stopped;
    private volatile boolean suspended;


    public MyThread(String name) {
        this.thread = new Thread(this, name);
    }

    public void start() {
        this.thread.start();
    }

    @Override
    public void run() {
        String name = thread.getName();
        while (!stopped) {
            if (!suspended) {
                System.out.println(name);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.printf("%s - interrupted%n", name);
                }
            } else {
                Thread.yield(); // 현재 스레드의 주어진 실행시간을 포기하고, 다음 스레드에게 양보한다. -> 반응성 향상
            }
        }
        System.out.printf("%s - stopped%n", name);
    }

    public void suspend() {
        this.suspended = true;
        thread.interrupt(); // sleep중인 상황에서 suspend 발생시 바로 InterruptException을 발생시켜서, sleep 상태에서 탈출하도록 하기 위함
        System.out.printf("%s - interrupted by suspend()%n", thread.getName());
    }

    public void resume() {
        this.suspended = false;
        System.out.printf("%s - resumed%n", thread.getName());
    }

    public void stop() {
        this.stopped = true;
        thread.interrupt(); // sleep중인 상황에서 stop 발생시 바로 InterruptException을 발생시켜서, sleep 상태에서 탈출하도록 하기 위함
        System.out.printf("%s - interrupted by stop()%n", thread.getName());
    }
}
