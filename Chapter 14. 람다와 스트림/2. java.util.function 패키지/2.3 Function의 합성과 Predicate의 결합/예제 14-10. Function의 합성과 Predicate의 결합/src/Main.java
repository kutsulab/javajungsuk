import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Function<String, Integer> f = str -> Integer.valueOf(str, 16); // 지정 문자열을 16진수로 파싱하여 Integer로 반환
        Function<Integer, String> g = i -> Integer.toBinaryString(i); // 지정 Integer을 이진문자열로 반환

        Function<String, String> h1 = f.andThen(g); // 지정 문자열을 16진수 문자열로 읽어 Integer로 파싱 후, 이진 문자열로 변환하여 반환
        Function<Integer, Integer> h2 = f.compose(g); // 지정 Integer을 이진 문자열로 변환 후, 16진수로 파싱하여 Integer로 반환

        System.out.println(h1.apply("FF")); // "FF" -> 255 -> "11111111"
        System.out.println(h2.apply(2)); // 2 -> "10" -> 16

        Function<String, String> f2 = Function.identity();
        // Function<String, String> f2 = str -> str (항등함수)
        System.out.println(f2.apply("AAA"));

        Predicate<Integer> p = i-> i<100; // i가 100보다 작으면 true
        Predicate<Integer> q = i-> i<200; // i가 200보다 작으면 true
        Predicate<Integer> r = i-> i%2==0; // i가 짝수이면 true
        Predicate<Integer> notP = p.negate(); // p의 부정 : i>=100

        Predicate<Integer> s = notP.and(q).or(r); // 100 이상 200미만이거나, 짝수
        System.out.println("s.test(150) : "+s.test(150));
        System.out.println("s.test(300) : "+s.test(300));
        System.out.println("s.test(301) : "+s.test(301));

        String str1 = "abc";
        String str2 = "abc";
        String str3 = "abcd";
        String str4 = new String("abc");

        Predicate<String> t = Predicate.isEqual(str1); // 입력값이 str1과 동등하면 true
        boolean result = t.test(str2);
        System.out.println("t.test(str2) : "+result); // 서로 동등함

        boolean result2 = t.test(str3);
        System.out.println("t.test(str3) : "+result2); // 서로 동등하지 않음

        boolean result3 = t.test(str4);
        System.out.println("t.test(str4) : "+result3);
        // 주소값이 다른 객체들이지만 문자열이 동등한지 기준으로 판단되서 true가 반환됨
        // isEqual이 == 기반으로 비교를 하는 것이 아닌 equals를 기반으로 객체가 다른지의 여부를 판단함을 알 수 있다.
    }

}
