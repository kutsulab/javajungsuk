public class MyRunnable implements Runnable{

    private String name;
    private String str;

    MyRunnable(String name, String str) {
        this.name = name;
        this.str = str;
    }

    public void run() {
        method();
        finishTimePrint();
    }

    private void method() {
        for(int i=0; i<1000; i++) {
            System.out.print(str);
            for(int x=0; x<10000000; x++); // 아무 것도 하지 않는 반목문으로 시간 지연
        }
        return;
    }

    private void finishTimePrint() {
        long finishTime = System.currentTimeMillis();
        long timeGap = finishTime - Main.startTime;
        System.out.printf("(%s 경과시간 : %d)", name, timeGap);
    }


}
