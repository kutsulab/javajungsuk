
import java.util.*;

public class HashMapEx2 {
	
	/* Java의 정석 3판 p.647 예제 11-31
	 * 
	 * [HashMap 분리]
	 *  - entrySet() : Map.Entry(Key, Value 가짐) 객체들로 구성된 Set
	 *  - keySet() : key 객체들로 구성된 Set
	 *  - Values() : value 객체들로 구성된 Colleciton
	 *  
	 * [Map.Entry 객체]
	 *  - key, Value 가짐
	 *  - 추출 시 getKey(), getValue()로 추출 -> Object 객체로 반환
	 * 
	 * [Collections.max(Collection), Collections.min(Collection)]
	 *  - Comparable 기준으로 하여 객체들 비교
	 *  - Collection.max(Collection c, Comparator cp) 을 이용하면 Comparator 기준으로 정렬할 수 있음
	 */
	
	public static void main(String[] args) {
		
		HashMap studentMap = new HashMap();
		
		studentMap.put("캬루", new Integer(2));
		studentMap.put("콧코로", new Integer(100));
		studentMap.put("페코린느", new Integer(90));
		studentMap.put("유이", new Integer(80));
		studentMap.put("네네카", new Integer(95));

		// Map 출력
		System.out.println("studentMap = "+studentMap);
		System.out.println();
		
		// entrySet, keySet, values 생성
		Set entrySet = studentMap.entrySet();
		Set nameSet = studentMap.keySet();
		Collection scoreCollection = studentMap.values();

		
		// Iterator를 통하여 entrySet에 있는 개개인의 Entry 접근 후 출력
		Iterator it = entrySet.iterator();
		
		while (it.hasNext()) {
			Map.Entry personalEntry = (Map.Entry) it.next();
			String name = (String) personalEntry.getKey();
			int score = (int) personalEntry.getValue();
			System.out.printf("이름 : %s , 점수 : %d%n", name, score);
		}
		System.out.println();
		
		// nameSet(map의 keySet) 출력
		System.out.println("학생 명단 : "+nameSet);
		
		// scoreCollection (map의 values) 에 접근하여, 총점, 평균, 최고점수, 최저점수 반환
		
		it = scoreCollection.iterator();
		int total = 0;
		
		while(it.hasNext()) {
			int i = (int) it.next(); //Object 객체로 받은 것을 int로 형변환 (원래 Object 객체로 받는데 이를 컴파일러가 알아서 Integer로 형변환 후, int로 autoUnboxing 해줌)
			total += i;
		}
		
		double avarage = (double)total/scoreCollection.size();
		int maxScore = (int) Collections.max(scoreCollection); //Comparable 기준으로 정렬
		int minScore = (int) Collections.min(scoreCollection);
		
		System.out.println("총점 : "+total);
		System.out.println("평균 : "+avarage);
		System.out.println("최고 점수 : "+maxScore);
		System.out.println("최저 점수 : "+minScore);
	}
}
