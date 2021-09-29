
import java.util.*;

	/* Java의 정석 3판 p.650 예제 11-33 : 원본 배열로부터 Map을 만들고, 동일한 데이터의 갯수 그래프로 확인하기
	 * 
	 * - containsKey(Object key) : key가 존재하는가?
	 * - containsValue(Object value) : value가 존재하는가?
	 * - get(Object key) : key에 대응하는 value를 반환
	 * 
	 */

public class HashMapEx4 {

	public static void main(String[] args) {
		String[] src = { "A", "K", "A", "K", "D", "K", "A", "K", "K", "K", "Z", "D" };

		HashMap map = new HashMap(); // 문자열을 Key로 하고, 문자열의 빈도수를 value로 저장

		for (int i = 0; i < src.length; i++) {
			if (map.containsKey(src[i])) {//map이 문자열을 가지고 있으면
				int prequency = ((Integer) map.get(src[i])).intValue();
				map.put(src[i], new Integer(prequency + 1)); //기존 value 값에 1을 더함
			}

			else {//map이 문자열을 가지고 있지 않으면
				map.put(src[i], new Integer(1));
			}
		}

		Iterator it = map.entrySet().iterator();

		while (it.hasNext()) {//각 Entry에 순차적으로 접근 접근
			Map.Entry entry = (Map.Entry) it.next();

			String data = (String) entry.getKey(); // 데이터
			int prequency = ((Integer) entry.getValue()).intValue(); // 데이터의 빈도수

			System.out.printf("%s : %s %d%n", data, getBar('#', prequency), prequency);
		}

	}
	
	private static String getBar(char ch, int prequency) { //지정문자를 빈도수만큼 채운 문자열을 반환
		char[] bar = new char[prequency];
		Arrays.fill(bar,ch); // 배열을 ch로 채움

		return new String(bar);
	}
}
