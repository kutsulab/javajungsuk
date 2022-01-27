
public class Main1 {

    public static void main(String[] args) {
        GarbageCollector gc = new GarbageCollector();
        gc.setDaemon(); // gc를 데몬스레드로 만든다.
        gc.start(); // gc start

        int requiredMemory = 0; // 필요 메모리

        for (int i=0; i<20; i++) {
            requiredMemory = (int) (Math.random() * 10) * 20; // 현재 작업에서 필요한 메모리양(여기선 랜덤으로 지정했음.)

            // 남은 메모리의 양이 필요 메모리의 양보다 작거나, 남은 메모리의 양이 전체 메모리양의 40% 미만일 경우 gc를 작동한다.
            if (gc.freeMemory() < requiredMemory || gc.freeMemory() < gc.totalMemory() * 0.4) {
                gc.interrupt();
            }
            gc.useMemory(requiredMemory); // requiredMemory 만큼, usedMemory를 증가시킨다.
            System.out.printf("usedMemory : %4d/%4d (Free Memory : %4d)%n", gc.usedMemory(), gc.totalMemory(), gc.freeMemory());
        }
    }

}
