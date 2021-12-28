import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        Stream<String> fileLineStream = Files.lines(Paths.get("src/SourceFile.txt"), Charset.forName("UTF-8"));
        System.out.println("\n=== fileLineStream ===");
        fileLineStream.forEach(System.out::println);
        System.out.println("======================\n");

        Stream<?> emptyStream = Stream.empty(); // 빈 Stream
        System.out.println("emptyStream.count() : "+emptyStream.count());

        String[] strArr1 = {"a","b","c"};
        String[] strArr2 = {"d","e","f"};

        Stream<String> strStream1 = Arrays.stream(strArr1);
        Stream<String> strStream2 = Arrays.stream(strArr2);
        Stream<String> strStream3 = Stream.concat(strStream1, strStream2);
        strStream3.forEach(System.out::print);
        System.out.println();

        strStream3 = Stream.concat(Arrays.stream(strArr2), Arrays.stream(strArr1));
        strStream3.forEach(System.out::print); // 뒤의 스트림의 요소가 뒤에 병합됨
        System.out.println();

        int[] intArr1 = {1,2,3};
        int[] intArr2 = {4,5,6};

        IntStream intStream1 = IntStream.of(intArr1);
        IntStream intStream2 = IntStream.of(intArr2);
        IntStream intStream3 = IntStream.concat(intStream1, intStream2);
        // System.out.println(ints1.sum()); // 에러 : ints1, ints2는 이미 소모되었다

        System.out.println("sum of intStream3 : "+intStream3.sum());
    }
}
