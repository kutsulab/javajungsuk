public class LambdaEx2 {

    public static void main(String[] args) {
        MyFunction f = () -> {}; // 앞에 (MyFunction)이 생략됨.
        Object obj = (MyFunction) (() -> {}); // (Object)이 생략됨. 명시적으로 MyFunction으로 형변환하는 것을 생략할 순 없다.
        String str = ((Object) (MyFunction) (()->{})).toString();

        System.out.println(f); // f.toString()
        System.out.println(obj); // obj.toString()
        System.out.println(str); // str.toString()

        // System.out.println(()-> {}); // 람다식 그 자체만으로는 객체 취급할 수 없음. 그것이 어떤 함수형 인터페이스의 구현체인지 정보가 있어야하며, 그것을 함수형 인터페이스 참조변수로 형변환할 수 있어야한다.
        System.out.println((MyFunction)(()->{}));

        // System.out.println((MyFunction)(()->{}).toString())
        // (()->{})은 객체가 아니므로, toString() 메서드를 호출할 수 없다.

        System.out.println(((MyFunction)(()->{})).toString());
        // 하지만 ((MyFuncfion)(()->{}))은 MyFunction의 구현체이므로 toString() 메서드를 호출할 수 있다.

    }
}
