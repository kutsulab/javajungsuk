import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 난수

        // IntStream intStream = new Random().ints(); // 무한 Stream
        // IntStream intStream = new Random().ints(5,10); // 무한 Stream (5~10범위)
        // IntStream intStream = new Random().ints().limit(5); // 유한 Stream (5개)
        // IntStream intStream = new Random().ints(5); // 유한 Stream (5개)
        IntStream intStream = new Random().ints(10,0,10); // 0이상 10미만의 임의의 수 10개
        intStream.forEach(System.out::print);
        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 연속한 정수

        IntStream intStream2 = IntStream.range(0,9); // 0이상 9미만의 연속된 정수 Stream
        IntStream intStream3 = IntStream.rangeClosed(0,9); // 0이상 9이하의 연속된 정수 Stream

        intStream2.forEach(System.out::print);
        System.out.println();
        intStream3.forEach(System.out::print);
        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 람다식

        Stream<Integer> integerStream = Stream.iterate(1, n-> n+2).limit(10);
        integerStream.forEach(System.out::print);;
        System.out.println();

        Stream<Integer> rdmStream = Stream.generate(()->(int)(Math.random()*10)).limit(5);
        // IntStream rdmStream = new Random().ints(5,0,10);
        rdmStream.forEach(System.out::print);
    }

}