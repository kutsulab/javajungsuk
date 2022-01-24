# 예제 13-10. 데몬 스레드(Daemon Thread) - 2

자바의 정석 3판 기준 예제 13-11(p.745)

---

## Main
```
public class Main {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable1(), "Thread1");
        Thread thread2 = new Thread(new MyRunnable2(), "Thread2");

        thread1.start();
        thread2.start();
    }
}
```
- MyRunnable1, MyRunnable2를 기반으로 스레드를 생성하고 start 메서드를 실행하여 각각을 실행한다.

---

## MyRunnable1
```
public class MyRunnable1 implements Runnable {

    @Override
    public void run() { // 단순히 5초간 기다리는 스레드
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}
    }
}
```
- 측정을 위해 고의적으로 5초간 대기하는 스레드

---

## MyRunnable2

```
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
```
- 모든 스레드들에 대한 Stack 및 실행 중인 메서드들에 대한 정보를 출력
  - 스레드별 정보 : 스레드 명, 소속 스레드 그룹, 데몬스레드 여부
  - 스레드별 스택에 올려진 메서드 내역

---

## 결과

```
[ 1 ] name : Reference Handler, group : system, daemon : true
java.base@11.0.13/java.lang.ref.Reference.waitForReferencePendingList(Native Method)
java.base@11.0.13/java.lang.ref.Reference.processPendingReferences(Reference.java:241)
java.base@11.0.13/java.lang.ref.Reference$ReferenceHandler.run(Reference.java:213)

[ 2 ] name : Common-Cleaner, group : InnocuousThreadGroup, daemon : true
java.base@11.0.13/java.lang.Object.wait(Native Method)
java.base@11.0.13/java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:155)
java.base@11.0.13/jdk.internal.ref.CleanerImpl.run(CleanerImpl.java:148)
java.base@11.0.13/java.lang.Thread.run(Thread.java:834)
java.base@11.0.13/jdk.internal.misc.InnocuousThread.run(InnocuousThread.java:134)

[ 3 ] name : Attach Listener, group : system, daemon : true

[ 4 ] name : Monitor Ctrl-Break, group : main, daemon : true
java.base@11.0.13/java.util.concurrent.ConcurrentSkipListMap.<clinit>(ConcurrentSkipListMap.java:3408)
java.base@11.0.13/java.util.concurrent.ConcurrentSkipListSet.<init>(ConcurrentSkipListSet.java:113)
java.base@11.0.13/java.net.InetAddress.<clinit>(InetAddress.java:772)
java.base@11.0.13/java.net.InetSocketAddress.<init>(InetSocketAddress.java:220)
java.base@11.0.13/java.net.Socket.<init>(Socket.java:230)
app//com.intellij.rt.execution.application.AppMainV2$1.run(AppMainV2.java:44)

[ 5 ] name : Thread2, group : main, daemon : false
java.base@11.0.13/java.lang.Thread.dumpThreads(Native Method)
java.base@11.0.13/java.lang.Thread.getAllStackTraces(Thread.java:1657)
app//MyRunnable2.run(MyRunnable2.java:8)
java.base@11.0.13/java.lang.Thread.run(Thread.java:834)

[ 6 ] name : Signal Dispatcher, group : system, daemon : true

[ 7 ] name : Thread1, group : main, daemon : false
java.base@11.0.13/java.lang.Thread.sleep(Native Method)
app//MyRunnable1.run(MyRunnable1.java:6)
java.base@11.0.13/java.lang.Thread.run(Thread.java:834)

[ 8 ] name : Finalizer, group : system, daemon : true
java.base@11.0.13/java.lang.Object.wait(Native Method)
java.base@11.0.13/java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:155)
java.base@11.0.13/java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:176)
java.base@11.0.13/java.lang.ref.Finalizer$FinalizerThread.run(Finalizer.java:170)
```
- 각 스레드명, 소속 스레드 그룹, 데몬 스레드 여부가 출력됨
- 각 스레드별 Stack에 올려진 메서드들의 정보가 출력된다.
- 개발자가 명시적으로 생성한 스레드들 외에, 몇 가지 데몬스레드들이 실행 시 생성되어있음을 알 수 있다.

---

