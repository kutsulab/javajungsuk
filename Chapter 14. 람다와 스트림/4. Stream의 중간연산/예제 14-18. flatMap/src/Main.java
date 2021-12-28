import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream<String[]> strArrStream = Stream.of(
                new String[] {"abc", "def", "jkl"},
                new String[] {"ABC", "GHI", "JKL"}
        );

        // Stream<Stream<String>> strStreamStream = strArrStream.map(Arrays::stream);
        Stream<String> strStream1 = strArrStream.flatMap(Arrays::stream);
        // 각 배열을 Stream으로 변환하면, Stream<Stream>의 Stream이 되지만, flatMap을 사용하여, 한차원 낮춰서 Stream<String>화 해줌.

        strStream1.map(String::toLowerCase) // 소문자화
                .distinct() // 중복 제거
                .sorted() // 정렬
                .forEach(System.out::println); // 출력
        System.out.println();

        String[] lineArr = {
                "Believe or not It is true",
                "Do or do not There is no try"
        };

        Stream<String> lineStream = Arrays.stream(lineArr);

        lineStream.flatMap(line -> Stream.of(line.split(" +"))) // 모든 문자열을 공백 기준으로 쪼갠 String[]을 기반으로 Stream을 생성. 이 때 flatMap을 통해 한 차원 낮춤
                .map(String::toLowerCase) // 소문자화
                .distinct() // 중복 제거
                .sorted() // 정렬
                .forEach(System.out::println); // 각각 출력
        System.out.println();

        Stream<String> strSubStream1 = Stream.of("AAA","ABC","bBb", "Dd");
        Stream<String> strSubStream2 = Stream.of("bbb","aaa","ccc", "dd");

        Stream<Stream<String>> strStreamStream = Stream.of(strSubStream1, strSubStream2); // Stream<String>의 Stream
        Stream<String> strStream2 = strStreamStream
                .map(stream -> stream.toArray(String[]::new)) // 각 Stream을 배열로 변환함(toArray의 매개변수를 지정하지 않으면 Object[]로 변환되므로 별도로 타입을 지정해서 배열을 생성해야함.)
                .flatMap(Arrays::stream); // 배열을 기반으로 String<Stream>의 Stream으로 변환하고, flatMap을 통해 Stream<String>으로 변환

        strStream2.map(String::toLowerCase) // 소문자화
                .distinct() // 중복 제거
                .forEach(System.out::println); // 출력
    }
}
