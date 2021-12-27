
public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer(); // 외부 클래스 생성
        Outer.Inner inner = outer.new Inner(); // 내부 클래스 생성 : 외부 클래스를 기반으로 생성해야함.

        inner.method1(100);
        System.out.println();
        inner.method2(100);
    }
}
