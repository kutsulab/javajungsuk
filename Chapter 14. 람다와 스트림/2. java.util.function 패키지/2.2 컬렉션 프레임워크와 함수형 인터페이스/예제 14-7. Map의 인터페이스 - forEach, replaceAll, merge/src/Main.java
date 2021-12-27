import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Apple",1);
        map1.put("Banana",3);
        map1.put("Orange",5);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("Banana",5);
        map2.put("Apple",2);
        map2.put("Orange",9);

        System.out.println("map1 : "+map1);
        System.out.println("map2 : "+map2);
        System.out.println();

        // map2의 각 (key, value)에 대하여
        // map1에서 key에 대응되는 oldValue가 있으면 map1에 합산, 그렇지 않다면 map2의 value를 put
        map2.forEach((key,value) ->
                map1.merge(key, value, (v1, v2) -> v1+v2));

        //map1의 각 entry에 대하여, 지정 작업을 수행
        System.out.println("After merge to map1 :");
        map1.forEach((key,value)-> System.out.print("{\""+key+"\", "+value+"}, "));
        System.out.println('\n');

        //map의 각 value에 대하여 1000을 곱함.
        map1.replaceAll((key, value) -> value * 1000);
        System.out.println("After replaceAll :");
        map1.forEach((key,value)-> System.out.print("{\""+key+"\", "+value+"}, "));
        System.out.println();
    }
}
