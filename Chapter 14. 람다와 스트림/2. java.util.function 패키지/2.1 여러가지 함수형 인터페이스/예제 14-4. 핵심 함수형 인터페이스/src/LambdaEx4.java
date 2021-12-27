import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.*;

public class LambdaEx4 {

    public static void main(String[] args) {
        // size가 10인 list에 1~100까지 임의의 값들을 채운다.
        List<Integer> list = makeRandomIntegerList(10);
        System.out.println(list);

        // 짝수이면 출력한다
        printEvenNumber(list);

        // 각 값들에 대해 일의자리 숫자를 제거하여 출력하기
        Function<Integer, Integer> deleteOnesPlace = i-> i/10*10; // 정수를 입력받아 일의 자리 숫자를 제거
        changeAll(list, deleteOnesPlace); // List의 각 요소별로 일의자리 숫자를 제거
        System.out.println(list);
    }


    // 지정 Supplier에 정의된 return값들로 list를 채운다.
    private static List<Integer> makeRandomIntegerList(int size) {
        List<Integer> list = new ArrayList<>();
        Supplier<Integer> getRandomNumber = () -> (int)(Math.random()*100)+1; // 1~100 중 임의의 값을 반환하는 함수
        for (int i=0; i<size; i++) {
            list.add(getRandomNumber.get());
        }
        return list;
    }

    private static void printEvenNumber(List<Integer> numbers) {
        Consumer<Integer> printWithDelim = i -> System.out.print(i+", "); // 정수를 입력받아, ", "을 붙여 출력함
        Predicate<Integer> isEvenNumber = i -> i%2==0; // 정수를 입력받아 짝수이면 true, 홀수면 false를 반환

        System.out.print('[');
        for (Integer number : numbers) {
            if (isEvenNumber.test(number)) { // 짝수이면 구분자를 붙인다.
                printWithDelim.accept(number);
            }
        }
        System.out.println(']');
        return;
    }

    private static <T> void changeAll(List<T> list, Function<T,T> f) {
        ListIterator<T> listIterator = list.listIterator(); // ListIterator는 모든 요소에 대하여, 수정이 가능하다.
        while(listIterator.hasNext()) {
            T change = listIterator.next();
            listIterator.set(change);
        }
        return;
    }
}
