import java.util.Map;

public class MyRunnable2 implements Runnable {

    @Override
    public void run() {

        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();

        int x = 0;

        for (Map.Entry<Thread, StackTraceElement[]> threadEntry : allStackTraces.entrySet()) {
            Thread thread = threadEntry.getKey();
            StackTraceElement[] stackTraceElements = threadEntry.getValue();

            System.out.printf("[ %d ] name : %s, group : %s, daemon : %b%n",
                    ++x, thread.getName(), thread.getThreadGroup().getName(), thread.isDaemon());
            printStackTraceElements(stackTraceElements);
            System.out.println();
        }

    }

    private void printStackTraceElements(StackTraceElement[] stackTraceElements) {
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            System.out.println(stackTraceElement);
        }
    }

}
