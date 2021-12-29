import java.util.Optional;
import java.util.OptionalInt;

public class Main {

    public static void main(String[] args) {
        Optional<String> optStr = Optional.of("abcde"); // 문자열을 감싼 Optional
        Optional<Integer> optInt1 = optStr.map(String::length); // 문자열의 길이를 감쌈
        System.out.println("optStr="+optStr.get());
        System.out.println("optInt1="+optInt1.get());

        int result1 = myParseInt("123"); // 파싱
        int result2 = myParseInt(""); // 파싱

        System.out.println("result1="+result1);
        System.out.println("result2="+result2);

        Optional.of("456")
                .map(Integer::parseInt)
                .ifPresent(x-> System.out.printf("result3=%d%n",x)); // 파싱한 문자열 출력

        OptionalInt optInt2 = OptionalInt.of(0); // 0이 저장된 OptionalInt
        OptionalInt optInt3 = OptionalInt.empty(); // 빈 OptionalInt

        System.out.println(optInt2.isPresent()); // true
        System.out.println(optInt3.isPresent()); // false

        System.out.println(optInt2.getAsInt()); // 0
        // System.out.println(optInt3.getAsInt()); // NoSuchElementException
        System.out.println("optInt2="+optInt2);
        System.out.println("optInt2="+optInt3);
        System.out.println("optInt2.equals(optInt3) ? : "+optInt2.equals(optInt3));

        int result4 = myParseInt("123", 0);
        int result5 = myParseInt("", 0);

        System.out.println("result4="+result4);
        System.out.println("result5="+result5);


        Optional<String> optStr2 = Optional.empty();
        Optional<Integer> optInt4 = Optional.empty();
        System.out.println("optStr2.equals(optInt4)? : "+optStr2.equals(optInt4)); // Optional의 empty()는 타입 불문하고 단 하나의 싱글톤 인스턴스이다.
    }

    private static int myParseInt(String str, int defaultValue) {
        try {
            int parseInt = Optional.ofNullable(str)
                    .filter(s-> s.length()>0) // 빈 문자열이면 제거
                    .map(Integer::parseInt)
                    .orElse(defaultValue);
            return parseInt;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    private static int myParseInt(String str) {
        return myParseInt(str,-1);
    }

}
