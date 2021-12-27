import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i=0; i<10; i++) list.add(i); // 리스트의 각 index마다 index의 값을 추가

        list.forEach(i-> System.out.print(i+", ")); // list의 모든 요소를 출력한다. : Iterable의 forEach 메서드
        System.out.println();

        list.removeIf(i->i%2==0||i%3==0); // 2의 배수이거나 3의 배수이면 지운다. : Collection의 removeIf 메서드
        System.out.println(list);

        list.replaceAll(i->i*10); // 각 요소에 10을 곱한다. : List의 replaceAll 메서드
        System.out.println(list);

    }

}
