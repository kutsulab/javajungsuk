# 예제 13-9. 데몬 스레드(Daemon Thread)

자바의 정석 3판 기준 예제 13-10

---

## Runnable 구현

```
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
```
1. run() : 3초마다 autoSave가 true인지 확인하고 true 상태로 변경되면 autosave()를 계속 호출한다.
2. autosave() : 자동저장 메시지를 출력

---

## Main
```
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

}
```
- 스레드를 생성하고 이를 데몬스레드로 하여 실행한다.
- 1초마다 카운트를 세고, 5초가 됐을 때 autoSave를 true로 한다.

---

## 결과

```
1
2
3
4
5
자동 저장되었습니닷...!!!!
6
7
8
자동 저장되었습니닷...!!!!
9
10
11
자동 저장되었습니닷...!!!!
12
13
14
자동 저장되었습니닷...!!!!
15
16
17
자동 저장되었습니닷...!!!!
18
19
20
프로그램을 종료합니닷.....!!!
```
- 5초 경과 후, autosave가 true로 변하고 3초 간격으로 autosave()를 호출한다.

---

## 번외

```
Exception in thread "main" java.lang.IllegalThreadStateException
	at java.base/java.lang.Thread.setDaemon(Thread.java:1410)
	at Main.main(Main.java:8)
```
- 스레드를 실행 후 도중에 데몬스레드로 변경할 상태를 변경하면(setDaemon) IllegalThreadStateException이 발생
- 만약 자동저장 스레드를 데몬스레드로 지정하지 않았을 경우, 메인 스레드가 종료되더라도 무한 반복을 계속하여 종료되지 않는 프로그램이 될 것이다.

---