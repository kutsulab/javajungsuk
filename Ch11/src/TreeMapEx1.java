
import java.util.*;

public class TreeMapEx1 {

	/* Java의 정석 3판 p.656 예제 11-34 : TreeMap
	 * 
	 * [TreeMap]
	 *  - 이진검색트리
	 *  - 별도로 생성자에서 지정해주지 않으면 Key의 Comparable 구현에 의한 정렬 기준으로 정렬됨
	 */
	
	public static void main(String[] args) {
		String[] src = { "A","K","A","K","D","K","A","K","K","K","Z","D"};
		
		TreeMap map = new TreeMap(); // key의 기본 정렬 기준 Comparable에 의한 정렬
		
		for (int i=0; i< src.length; i++) {//배열의 모든 요소들을 추가. 같은 값을 추가할 경우 value 1 증가
			if (map.containsKey(src[i])) {
				int prequency = (int) map.get(src[i]);
				map.put(src[i], prequency + 1);
			} else {
				map.put(src[i],1);
			}
		}
		
		Iterator it = map.entrySet().iterator();
		
		System.out.println("====== 기본 정렬 ======");
		while(it.hasNext()) { // 각 Entry 접근 후 값 출력
			Map.Entry entry = (Map.Entry) it.next();
			
			String data = (String)entry.getKey();
			int prequency = (int)entry.getValue();
			System.out.printf("%s : %s %d%n",data,getBar('#', prequency), prequency);
		}
		System.out.println();
		
		Set entryTreeSet = new TreeSet(new ValueComparator()); //ValueComparator에 의해 정렬되는 TreeSet
		entryTreeSet.addAll(map.entrySet()); //map의 entrySet을 entryTreeSet에 저장
		
		it = entryTreeSet.iterator();
		
		System.out.println("====== 빈도 기준으로 정렬 ======");
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			
			String data = (String)entry.getKey();
			int prequency = (int)entry.getValue();
			System.out.printf("%s : %s %d%n",data,getBar('#', prequency), prequency);
		}
		System.out.println();
		
		
	}	
	
	private static String getBar(char ch, int prequency) {
		char[] bar = new char[prequency];
		Arrays.fill(bar,ch);
		return new String(bar);
	}
	
}

class ValueComparator implements Comparator { //내부 클래스
	
	public int compare (Object o1, Object o2) {
		if (o1 instanceof Map.Entry && o2 instanceof Map.Entry) { //타입이 Map.Entry일때만 (이후 지네릭스를 배우면 이런 짓을 안 해도 될듯?)
			Map.Entry e1 = (Map.Entry) o1;
			Map.Entry e2 = (Map.Entry) o2;
			
			int e1Value = (int) e1.getValue();
			int e2Value = (int) e2.getValue();
			
			if (e1Value > e2Value) {//value값이 클 때 앞에 두도록 함
				return -1;
			} else if (e1Value < e2Value) {
				return 1;
			} else {
				return 0;
			}
		}
		return -1;
	}
}
