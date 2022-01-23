public class Main {

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

    private static void method(String s) {
        for (int i=0; i< 1000; i++) {
            System.out.printf("%s",new String(s)); // 쓰레드의 지연시간 확인을 용이하게 하기 위해 성능이 떨어지는 방식으로 문자열을 출력함
        }
        System.out.println();
        return;
    }

}
