public class Main {

    public static long startTime; // 작업 시작시점


    public static void main(String[] args) {
        // currentTime을 현재 시각으로 변경
        startTime = System.currentTimeMillis();

        // 스레드 생성
        Thread th1 = new Thread(new MyRunnable("|"));
        Thread th2 = new Thread(new MyRunnable("-"));

        // 각 스레드의 이름
        System.out.println("th1 : "+th1.getName());
        System.out.println("th2 : "+th2.getName());

        // 각 쓰레드에서  실행
        th1.start();
        th2.start();

        System.out.print("(메인 쓰레드 종료)"); // 메인 쓰레드 종료
    }

}
