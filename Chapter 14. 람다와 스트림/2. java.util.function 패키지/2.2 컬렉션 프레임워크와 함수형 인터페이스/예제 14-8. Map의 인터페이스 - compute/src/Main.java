import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, String> rabbitProfile = new HashMap<>();
        rabbitProfile.put("종류", "토끼");
        rabbitProfile.put("이름", "토실이");
        System.out.println("rabbitProfile : " + rabbitProfile);

        // compute : 지정 key의 value를 람다식을 통해 변경 후 반환
        rabbitProfile.compute("종류", (key, value) -> value.concat("고기"));
        rabbitProfile.compute("이름", (key, value) -> value.concat("였던 것"));
        System.out.println("rabbitProfile : " + rabbitProfile);

        // compute : oldValue가 null이 아니거나 key가 존재하는데 newValue가 null일 경우 map에서 제거된다.
        rabbitProfile.put("친구", null); // key는 존재하지만 value가 null임
        System.out.println("rabbitProfile : " + rabbitProfile);

        rabbitProfile.compute("이름", (key, value) -> null); // oldValue가 null이 아닌 것을, null로 변경했더니 entry가 map에서 제거된다.
        rabbitProfile.compute("친구", (key, value) -> null); // oldValue가 null인 것을 null로 덮어씌웠음에도 entry가 map에서 제거된다.
        System.out.println("rabbitProfile : " + rabbitProfile);
        System.out.println();

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("key1", 10);
        map2.put("key2", 20);
        map2.put("key3", null);
        System.out.println("map2 : " + map2);

        map2.compute("key1", (key, value) -> (value == null) ? 1 : value + 1);
        map2.compute("key2", (key, value) -> (value == null) ? 1 : value + 2);
        map2.compute("key3", (key, value) -> (value == null) ? 1 : value + 3);
        System.out.println("map2 : " + map2);

        try {
            map2.compute(null, (key, value) -> value + 4); // 지정 key값이 null일 경우 NullPointerException을 throw
        } catch (NullPointerException e) {
            System.out.println("Exception : " + e);
        }

        try {
            map2.compute("key1", null); // remappingFunction이 null일 경우 NullPointerException을 throw
        } catch (NullPointerException e) {
            System.out.println("Exception : " + e);
        }
    }

}
