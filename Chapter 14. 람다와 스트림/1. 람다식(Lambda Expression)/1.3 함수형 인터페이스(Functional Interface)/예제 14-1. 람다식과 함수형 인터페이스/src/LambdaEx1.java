public class LambdaEx1 {

    // 람다식으로 반환할 수 있다.
    private static MyFunction getMyFunction3() {
        return () -> System.out.println("mf3 실행!");
    }

    private static void execute(MyFunction mf) {
        mf.run();
    }

    public static void main(String[] args) {

        // 1.8 이전 : 익명 클래스를 통해 메서드 전달
        MyFunction mf1 = new MyFunction() {
            @Override
            public void run() {
                System.out.println("mf1 실행!");
            }
        };

        //함수형 인터페이스 MyFunction을 람다식으로 구현
        MyFunction mf2 = () -> System.out.println("mf2 실행!");

        //함수형 인터페이스 MyFunction의 구현체를 메서드를 통해 전달받아 mf3이 참조하도록 함
        MyFunction mf3 = getMyFunction3();

        mf1.run();
        mf2.run();
        mf3.run();

        // 함수형 인터페이스를 매개변수로 한 메서드
        execute(mf1);

        // 람다식 그 자체로 MyFunction 인터페이스를 구현하고, 이를 인자로 메서드에 전달
        execute(()-> System.out.println("Hello, Lambda!"));
    }

}
