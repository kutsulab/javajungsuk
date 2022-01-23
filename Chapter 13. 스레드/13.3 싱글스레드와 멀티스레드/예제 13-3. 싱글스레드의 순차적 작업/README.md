
## 예제 13-3. 싱글스레드의 순차적 작업

자바의 정석 3판 기준 예제 13-4(p.732)의 예제를 실습한 결과.

## method
```
    private static void method(String s) {
        for (int i=0; i< 1000; i++) {
            System.out.printf("%s",new String(s)); // 쓰레드의 지연시간 확인을 용이하게 하기 위해 성능이 떨어지는 방식으로 문자열을 출력함
        }
        System.out.println();
        return;
    }
```
- 1000회동안 인자로 입력된 문자를 출력하는 메서드
- 본래 문자열을 연이어서 여러번 반복해서 출력할 때는 StringBuilder, StringBuffer 등을 이용하는 것이 효과적이지만, 작업 지연시간 측정을 위해 비효율적으로 출력했다.


## main
```
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); // 현재 시각에 해당하는 값을 ms 단위로 받아옴

        method("|");
        long middleTime = System.currentTimeMillis(); // 현재 시각에 해당하는 값을 ms 단위로 받아옴
        long timeGap1 = middleTime - startTime;
        System.out.println("소요 시간 1 : "+timeGap1);


        // 위의 작업이 종료되고 다음 작업이 수행된다. (순차적 진행)
        method("-");
        long endTime = System.currentTimeMillis(); // 현재 시각에 해당하는 값을 ms 단위로 받아옴
        long timeGap2 = endTime - startTime;
        System.out.println("소요 시간 2 : "+timeGap2);

        // 메인 쓰레드 종료
    }
```
- startTime을 저장한다.
- method를 1회 실행하고, middleTime을 저장 후 startTime, middleTime의 시간차를 출력한다.
- method를 다시 실행하고, endTime을 저장후 startTime, middleTime의 시간차를 출력한다.

## 결과
```
||||||||||||||||||||||||||||||||||||||||||||||||||||||| (... 생략)
소요 시간 1 : 32
---------------------------------------------------------(... 생략)
소요 시간 2 : 51
```
- 메서드가 순차적으로 진행됨.
- 작업1이 진행 후, 작업 2가 진행되므로 각각의 작업 완료 시각은 전-후 관계이다.
- **예제 13-4와 비교해서 볼 것.**

## 연속적으로 실행시 결과
```
1회 : 24 / 39
2회 : 28 / 46
3회 : 30 / 47
4회 : 28 / 47
5회 : 31 / 48
```