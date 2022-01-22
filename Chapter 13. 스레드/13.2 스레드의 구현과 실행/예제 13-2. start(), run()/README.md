
# 예제 13-2. start(), run()

자바의 정석 3판 기준 예제 13-2(p.730), 예제 13-3(p.731)을 재구성한 것이다.

---

# Main
```
    public static void main(String[] args) {
        Thread th1 = new Thread(new MyRunnable("th1")); // Runnable 구현체를 통해 Thread 생성
        Thread th2 = new Thread(new MyRunnable("th2"));

        th1.start(); // 새로운 스레드의 스택에 run 스택프레임 push
        th2.run(); // Main 스레드의 main 스택 프레임 위에 run 메서드 호출
    }
```
- `MyRunnable` 인스턴스를 인자로 한 `Thread` 인스턴스 두개를 생성한다.
- 하나는 start()를 호출하고, 다른 하나는 run()을 호출한다.

---

# MyRunnable

```
public class MyRunnable implements Runnable{

    private String name;
    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        throwExceptionAndHandling(); // 예외를 throw하고, 내부적으로 처리하는 메서드
    }

    private void throwExceptionAndHandling() {
        try {
            throw new Exception(String.format("%s - %s에서 throw됨", this.name, Thread.currentThread().getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
- Exception을 throw 하고, 내부적으로 catch문으로 잡아내, 예외 메시지를 출력한다.
- 예외메시지에서는 해당 메서드가 호출된 Thread를 출력하도록 한다.  

---

# 결과

```
java.lang.Exception: th2 - main에서 throw됨
	at MyRunnable.throwExceptionAndHandling(MyRunnable.java:15)
	at MyRunnable.run(MyRunnable.java:10)
	at java.base/java.lang.Thread.run(Thread.java:834)
	at Main.main(Main.java:8)
java.lang.Exception: th1 - Thread-0에서 throw됨
	at MyRunnable.throwExceptionAndHandling(MyRunnable.java:15)
	at MyRunnable.run(MyRunnable.java:10)
	at java.base/java.lang.Thread.run(Thread.java:834)
```
- Exception이 양쪽에서 throw되고 예외 메시지가 출력된다.
- `run()`을 호출한 쪽의 예외는 main 메서드의 스택 프레임의 위에서 발생했으므로 main부터 출력되고  
  `start()`을 호출한 쪽의 예외는 MyRunnable의 run()에 관한 정보부터 출력된다.

---