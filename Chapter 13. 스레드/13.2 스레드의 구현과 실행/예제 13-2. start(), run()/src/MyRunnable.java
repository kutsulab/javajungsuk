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
