import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("key1", 10);
        map.put("key2", 20);
        map.put("key3", 30);
        map.put("key4", 40);
        System.out.println("map : \n"+map+'\n');

        //computeIfAbsent
        map.computeIfAbsent("key4", key-> 45); // 지정 key가 존재할 경우, 수행되지 않고 value가 그대로 반환된다.
        map.computeIfAbsent("key5", key-> 50);
        map.computeIfAbsent("key6", key-> 60);
        System.out.println("After computeIfAbsent : \n"+map+'\n');

        map.put("key7", null);
        System.out.println("After put(\"key7\", null) in map : \n"+map+'\n');

        map.computeIfAbsent("key7", key -> 100); // key가 존재하고 대응값이 null일 때도 compute 작업을 시행한다.
        System.out.println("After computeIfAbsent(\"key7\", key-> 100) in map : \n"+map+'\n');

        map.computeIfAbsent("key7", key->null);
        System.out.println("After computeIfAbsent(\"key7\", key-> null) in map : \n"+map+'\n'); // newValue가 null이면 아무 것도 수행하지 않는다.

        Map<String, Set<Integer>> map2 = new HashMap<>();

        map2.put("key1", new HashSet<>(Arrays.asList(1,2)));
        System.out.println("map2 : "+map2+"\n");

        map2.computeIfAbsent("key2", k-> new HashSet<>()).add(3);
        System.out.println("After computeIfAbsent(\"key2\", k -> new HashMap<>()).add(3)) in map2 : \n"+map2+'\n'); // set을 추가

        Map<Integer, Integer> map3 = new HashMap<>();
        map3.put(1,1);
        map3.put(2,2);
        System.out.println("map3 : \n"+map3+'\n');

        try {
            map3.computeIfAbsent(3, null); // mappingFunction이 null일 경우 NullPointerException 발생
        } catch (NullPointerException e) {
            System.out.println("after map3.computeIfAbsent(3, null) in map3 :\nException - "+e);
        }
        System.out.println();

        map3.computeIfAbsent(null, key->100);
        System.out.println("after map3.computeIfAbsent(null, key->100) in map3 :\n"+map3+'\n'); // (null,value)가 가능하네?;


        //ComputeIfPresent
        Map<String, Integer> map4 = new HashMap<>();
        map4.put("국어", 10);
        map4.put("수학", 20);
        map4.put("영어", 30);
        System.out.println("map4 :\n" + map4+'\n');

        map4.computeIfPresent("영어", (k,v) -> k.length()+v+10);
        System.out.println("map4 after 'computeIfPresent(\"영어\",(k,v) -> k.length+v+10)' :\n" + map4+'\n'); // key에 맵핑된 값이 존재하지 않을 경우(null) 아무것도 하지 않음.
        map4.computeIfPresent("과학", (k,v) -> 50);
        System.out.println("map4 after 'computeIfPresent(\"과학\",(k,v) -> 50)' :\n" + map4+'\n'); // key에 맵핑된 값이 존재하지 않을 경우(null) 아무것도 하지 않음.

        map4.computeIfPresent("수학", (k,v) -> null); // key에 맵핑된 값이 존재하지만, remappingFunction의 함숫값이 null인 경우 map에서 이 (key, oldValue)가 제거됨
        System.out.println("map4 after 'computeIfPresent(\"수학\", (k,v)-> null)' :\n"+ map4+'\n');
    }
}
