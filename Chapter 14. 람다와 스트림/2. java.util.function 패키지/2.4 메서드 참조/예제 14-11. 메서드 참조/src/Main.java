import java.util.Arrays;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class Main {

    public static void main(String[] args) {
        ToIntFunction<String> f = Integer :: parseInt; // 메서드를 참조하여 파싱하는 함수 
        //ToIntFunction<String> f = s -> Integer.parseInt(s);
        int f_result = f.applyAsInt("3");
        System.out.println("f.applyAsInt(\"3\") : "+f_result);
        System.out.println();

        Supplier<MyNumber> s = MyNumber::new; // 생성자를 참조하여 객체를 생성, 반환하는 함수
        // Supplier<MyClassEx8> s = () -> new MyClassEx8();
        MyNumber s_result = s.get();
        System.out.println("s.get() : "+s_result);
        System.out.println();

        IntFunction<MyNumber> intf = MyNumber::new; // 생성자를 참조하여 객체를 생성, 반환하는 함수
        // IntFunction<MyClassEx8> intf = (i) -> new MyClassEx8(i);
        MyNumber intf_result = intf.apply(20);
        System.out.println("intf.apply(20) : "+intf_result);
        System.out.println();

        IntFunction<int[]> intArrf = int[]::new; // 배열의 생성자를 호출하여, 배열을 생성, 반환
        // IntFunction<int[]> intArrf = (i) -> new int[i];
        int[] intArr = intArrf.apply(10);
        Arrays.setAll(intArr, i->i+1); // 모든 값에 대해 인덱스+1의 값을 부여
        System.out.println("intArrf.apply(10) : "+Arrays.toString(intArr));
        System.out.println();

        ToIntFunction<String> toIntf = String::length;
        System.out.println("toIntf.applyAsInt(\"멍멍멍\") : "+toIntf.applyAsInt("멍멍멍"));
        System.out.println();

        MyNumber mc = intf.apply(5);
        System.out.println("inf.apply(5) : "+intf.apply(5));
        IntUnaryOperator io = mc::getAddition; // mc 객체의 getAddition 메서드를 호출하여 return값을 반환
        System.out.println("io.applyAsInt(10) : "+io.applyAsInt(10));
    }
    
}
