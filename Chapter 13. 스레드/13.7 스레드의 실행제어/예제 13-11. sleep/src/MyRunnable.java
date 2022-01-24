public class MyRunnable implements Runnable{

    private String str;

    MyRunnable(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        for(int i=0; i<300; i++) {
            System.out.print(str);
        }
        System.out.printf("<<%s 종료>>", Thread.currentThread().getName());
    }

}
