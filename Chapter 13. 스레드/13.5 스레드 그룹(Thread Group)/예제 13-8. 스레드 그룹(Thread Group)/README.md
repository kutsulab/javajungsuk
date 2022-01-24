# 예제 13-8. 스레드 그룹(Thread Group)

자바의 정석 3판 기준 예제 13-9(p.742)

---

## 1. 스레드 그룹 생성

```
ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();
ThreadGroup threadGroup1 = new ThreadGroup("ThreadGroup1");
ThreadGroup threadGroup2 = new ThreadGroup("ThreadGroup2");

ThreadGroup subThreadGroup1 = new ThreadGroup(threadGroup1, "SubThreadGroup1"); // threadGroup1에 속한 스레드 그룹 생성
```
- mainThreadGroup : 메인 스레드 그룹.
  - threadGroup1 : 메인 스레드그룹의 하위에 생성된 스레드그룹
    - subThreadGroup1 : threadGroup1의 하위에 생성된 스레드 그룹
  - threadGroup2 : 메인 스레드그룹의 하위에 생성된 스레드그룹

---

## 2. 조작변인 - threadGroup1의 최대 우선순위 설정

```
threadGroup1.setMaxPriority(3); // 스레드 그룹의 최대 우선순위를 3으로 지정
```
- 이 명령을 수행한 시점부터, threadGroup1의 하위에 생성되는 스레드그룹 및 스레드들의 최대 우선순위는 3이다.

---

## 3. Runnable 구현체

```
Runnable myRunnable = () -> {
    try {
        Thread.sleep(1000); // 활성화 집계의 편의를 위해 1000ms(=1s)의 지연역할을 수행하게 함.
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
};
```
- 빠르게 스레드가 작업을 종료하고 비활성화되는 것을 막기 위해 1초의 지연시간을 둔 Runnable 구현체를 생성

---

## 4. 스레드 생성

```
new Thread(threadGroup1, myRunnable, "Thread1").start(); // ThreadGroup1의 최대 우선순위는 3으로 지정했으므로 3이다.
new Thread(threadGroup2, myRunnable, "Thread2").start(); // ThreadGroup2의 최대 우선순위는 별도로 지정하지 않았고 스레드의 우선순위를 별도로 지정하지 않았으므로 우선순위는 5다.
new Thread(subThreadGroup1, myRunnable, "Thread3").start(); // subThreadGroup1의 상위 스레드그룹의 최대 우선순위인 3으로 자동 생성됨
```
- 스레드들을 생성 후 각각 ThreadGroup1, ThreadGroup2, SubThreadGroup1에 속하게함.

---

## 5. 출력

```
System.out.printf("> List of ThreadGroup [%s]%n", mainThreadGroup.getName());
System.out.printf(">> Active ThreadGroup : %d%n",mainThreadGroup.activeGroupCount());
System.out.printf(">> Active Thread : %d%n",mainThreadGroup.activeCount());

mainThreadGroup.list();
```
- main 스레드 그룹의 이름, 활성중인 스레드그룹, 스레드의 갯수를 출력
- list 메서드를 호출하여 하위 스레드 그룹 및 스레드에 관한 정보를 출력하도록 한다.

---

## 결과

```
> List of ThreadGroup [main]
>> Active ThreadGroup : 3
>> Active Thread : 5
java.lang.ThreadGroup[name=main,maxpri=10]
    Thread[main,5,main]
    Thread[Monitor Ctrl-Break,5,main]
    java.lang.ThreadGroup[name=ThreadGroup1,maxpri=3]
        Thread[Thread1,3,ThreadGroup1]
        java.lang.ThreadGroup[name=SubThreadGroup1,maxpri=3]
            Thread[Thread3,3,SubThreadGroup1]
    java.lang.ThreadGroup[name=ThreadGroup2,maxpri=10]
        Thread[Thread2,5,ThreadGroup2]
```
- 별도로 최대 우선순위를 지정하지 않으면, 기본적으로 스레드 그룹의 최대 우선순위는 10이다. 
- 별도로 최대 우선순위를 지정하면 하위 스레드 및 스레드그룹의 최대 우선순위는 그 값이 된다.
  - 본래 기본 우선순위는 5인데, 스레드 그룹의 최대 우선순위가 5보다 낮을 경우 더 낮은 우선순위를 갖게 된다.
- 스레드를 별도로 변수에 할당하지 않더라도, 스레드를 생성한 시점에 바로 소속 ThreadGroup에 저장되어 있기 때문에 가비지 컬렉터의 제거대상이 되지 않음.

---
