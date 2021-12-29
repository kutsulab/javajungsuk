import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("Inheritance"); strs.add("Java"); strs.add("Lambda");
        strs.add("Stream"); strs.add("OptionalDouble"); strs.add("IntStream");
        strs.add("count"); strs.add("sum");

        strs.stream()
                .map(s-> s.concat(", ")) // 각 문자 뒤에 " "을 붙임
                .parallel() // 병렬처리
                .forEach(System.out::print); // 순서는 상관 없으므로 그냥 forEach 처리
        System.out.println('\n');

        boolean hasNotEmptyStr = strs.stream().noneMatch(s->s.length()==0); // 문자열 길이가 0인 것이 하나도 없으면 true
        Optional<String> sWord = strs.stream().filter(s->s.charAt(0)=='s').parallel().findAny(); // 첫번째 문자가 's'인 것을 아무거나 찾아서 반환

        System.out.println("hasNotEmptyStr = "+hasNotEmptyStr);
        System.out.println("sWord = "+sWord.orElseGet(String::new)+'\n');

        IntStream intStream1 = strs.stream().mapToInt(String::length); // 문자열의 길이 Stream
        IntStream intStream2 = strs.stream().mapToInt(String::length); // 문자열의 길이 Stream
        IntStream intStream3 = strs.stream().mapToInt(String::length); // 문자열의 길이 Stream
        IntStream intStream4 = strs.stream().mapToInt(String::length); // 문자열의 길이 Stream

        int count = intStream1.reduce(0, (a,b)-> a+1); // 문자열의 갯수 : 값이 존재하면 계속해서 1을 누적해서 더해감.
        int sum = intStream2.reduce(0, (a,b)-> a+b); // 문자열 길이의 합 : 각 값을 계속 누적해서 더해감.

        OptionalInt max = intStream3.reduce(Integer::max); // 각 값들을 비교해가며, 최댓값을 구함.
        OptionalInt min = intStream4.reduce(Integer::min); // 각 값들을 비교해가며, 최솟값을 구함.

        System.out.println("count = "+count);
        System.out.println("sum = "+sum);
        System.out.println("max = "+max.orElseGet(()->-1));
        System.out.println("min = "+min.orElseGet(()->-1));
    }
}
