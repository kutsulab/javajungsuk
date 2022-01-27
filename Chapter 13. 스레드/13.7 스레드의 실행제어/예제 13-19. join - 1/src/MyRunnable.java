public class MyRunnable implements Runnable{

    private String str;

    public MyRunnable(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        for (int i=0; i<300; i++) {
            System.out.print(new String(str));
        }
    }
}
