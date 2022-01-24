public class Main {

    public static void main(String[] args) {
        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup threadGroup1 = new ThreadGroup("ThreadGroup1");
        ThreadGroup threadGroup2 = new ThreadGroup("ThreadGroup2");

        ThreadGroup subThreadGroup1 = new ThreadGroup(threadGroup1, "SubThreadGroup1"); // threadGroup1에 속한 스레드 그룹 생성

        threadGroup1.setMaxPriority(3); // 스레드 그룹의 최대 우선순위를 3으로 지정
        Runnable myRunnable = () -> {
            try {
                Thread.sleep(1000); // 활성화 집계의 편의를 위해 1000ms(=1s)의 지연역할을 수행하게 함.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(threadGroup1, myRunnable, "Thread1").start(); // ThreadGroup1의 최대 우선순위는 3으로 지정했으므로 3이다.
        new Thread(threadGroup2, myRunnable, "Thread2").start(); // ThreadGroup2의 최대 우선순위는 별도로 지정하지 않았고 스레드의 우선순위를 별도로 지정하지 않았으므로 우선순위는 5다.
        new Thread(subThreadGroup1, myRunnable, "Thread3").start(); // subThreadGroup1의 상위 스레드그룹의 최대 우선순위인 3으로 자동 생성됨

        System.out.printf("> List of ThreadGroup [%s]%n", mainThreadGroup.getName());
        System.out.printf(">> Active ThreadGroup : %d%n",mainThreadGroup.activeGroupCount());
        System.out.printf(">> Active Thread : %d%n",mainThreadGroup.activeCount());

        mainThreadGroup.list();
    }
}
