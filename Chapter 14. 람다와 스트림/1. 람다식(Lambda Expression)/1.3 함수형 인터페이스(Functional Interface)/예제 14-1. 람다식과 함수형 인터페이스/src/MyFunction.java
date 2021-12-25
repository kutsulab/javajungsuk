
@FunctionalInterface
public interface MyFunction {

    void run(); // 단 하나의 추상 메서드

    public final int number = 0; // public static 상수와 무관


    public static String staticStringMethod() { // public static 메서드와 무관
        return "static 메서드";
    }

    public default void nyaa() { // public default 메서드와 무관
        System.out.println("디폴트 메서드 테스트");
    }

}
