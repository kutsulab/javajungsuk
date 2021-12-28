import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 컬렉션 -> Stream

        List<Integer> integers = Arrays.asList(5,2,4,1,3);

        // 모든 요소 출력
        Stream<Integer> integerStream1 = integers.stream(); // list를 기반으로 한 Stream 생성
        System.out.print("integers.stream() : ");
        integerStream1.forEach(System.out::print); // forEach() : 최종연산 -> 재사용 불가능
        System.out.println('\n');

        // 모든 요소를 오름차순 정렬해서 출력
        integerStream1 = integers.stream(); // list로부터 다시 Stream 생성
        System.out.print("integers.stream().sorted() : ");
        integerStream1 = integerStream1.sorted(); // 정렬 : 중간연산 -> 연산결과도 Stream
        integerStream1.forEach(System.out::print); // forEach() : 최종연산 -> 재사용 불가능
        System.out.println('\n');


        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 가변인자 -> Stream

        String[] strs = new String[]{"a","b","c"}; // 객체 배열

        Stream<String> strStream1 = Stream.of("a","b","c"); // 가변인자 -> Stream
        Stream<String> strStream2 = Stream.of(strs); // 배열 -> Stream (Stream.of 활용)
        Stream<String> strStream3 = Arrays.stream(strs); // 배열 -> Stream (Arrays.stream 활용)
        Stream<String> strStream4 = Arrays.stream(strs, 1,3); // 배열 -> Stream (Arrays.stream 활용, 배열 부분 참조 start <= i < end)


        System.out.println("strStream 1,2,3,4 ↓");

        strStream1.forEach(System.out::print);
        System.out.println();

        strStream2.forEach(System.out::print);
        System.out.println();

        strStream3.forEach(System.out::print);
        System.out.println();

        strStream4.forEach(System.out::print);
        System.out.println('\n');

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 가변 기본형 인자 -> 기본형 Stream

        int[] intArr = new int[] {1,2,3,4,5}; // int 배열

        IntStream intStream1 = IntStream.of(1,2,3,4,5); // 기본형 가변인자 -> IntStream
        IntStream intStream2 = IntStream.of(intArr); // 기본형 배열 -> IntStream (IntStream.of 활용)
        IntStream intStream3 = Arrays.stream(intArr); // 기본형 배열 -> IntStream (Arrays.stream 활용)
        IntStream intStream4 = Arrays.stream(intArr,2,intArr.length); // 기본형 배열 -> IntStream (Arrays.stream 활용, 배열 부분 참조 start <= i < end)

        System.out.print("intStream1 : ");
        intStream1.forEach(System.out::print); // 전체 출력
        System.out.println();

        System.out.println("intStream2.sum() : "+intStream2.sum()); // 총합을 출력

        System.out.println("intStream3.average().getAsDouble() : "+intStream3.average().getAsDouble()); // 평균을 출력

        System.out.print("intStream4 : ");
        intStream4.forEach(System.out::print);
        System.out.println('\n');

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Integer 배열 -> Stream

        Integer[] integer_Arr = {6,7,8,9,0}; // 객체 배열
        Stream<Integer> integerStream2 = Stream.of(6,7,8,9,0);
        Stream<Integer> integerStream3 = Stream.of(integer_Arr);
        Stream<Integer> integerStream4 = Arrays.stream(integer_Arr);
        Stream<Integer> integerStream5 = Arrays.stream(integer_Arr,2,integer_Arr.length); // 2번 인덱스부터, 배열의 끝까지를 데이터소스로 한 Stream 생성

        System.out.print("integerStream2 : ");
        integerStream2.forEach(System.out::print);
        System.out.println();

        System.out.print("integerStream3.count() : "+integerStream3.count()); // 객체의 갯수를 반환
        System.out.println();

        System.out.print("integerStream4.sorted(Comparator.reverseOrder()) : ");
        integerStream4
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::print);
        System.out.println();

        System.out.print("integerStream5.sorted() : ");
        integerStream5.forEach(System.out::print);
        System.out.println();
    }
}
