public class Main implements Runnable {

    static boolean autoSave = false;

    public static void main(String[] args) {
        Thread thread = new Thread(new Main());
        thread.setDaemon(true);
        thread.start();

        for (int i=1; i<=20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            System.out.println(i);
            if (i==5) autoSave = true; // 실행후 5초 경과후부터 자동저장을 시작한다.
        }

        System.out.println("프로그램을 종료합니닷.....!!!");
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(3000); // 3초마다
            } catch (InterruptedException e) {}

            if (autoSave)
                autoSave(); // autosave로 상태 변경되면 자동저장을 반복한다.
        }
    }

    private void autoSave() {
        System.out.println("자동 저장되었습니닷...!!!!");
    }
}
