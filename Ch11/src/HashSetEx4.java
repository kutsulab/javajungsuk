
import java.util.*;

public class HashSetEx4 {
	
	/* Java의 정석 3판 p.637 예제 11-25
	 * 
	 * [HashSet을 이용하여 집합 구현해보기]
	 * - 합집합 : 두 Set을 각각 addAll
	 * - 교집합 : 한 Set을 기준으로 retainAll(다른 Set)
	 * - 차집합 : 한 Set을 기준으로 removeAll(다른 Set)
	 * - 여집합 : 전체 집합에서 removeAll(지정 Set)
	 */
	
	public static void main(String[] args) {
		
		HashSet setA = new HashSet(); // 집합 A
		HashSet setB = new HashSet(); // 집합 B
		HashSet union = new HashSet(); // 합집합
		HashSet interSection = new HashSet(); // 교집합 
		HashSet differenceAB = new HashSet(); // 차집합 A-B
		HashSet differenceBA = new HashSet(); // 차집합 B-A
		
		setA.add("1"); setA.add("2"); setA.add("3");
		setA.add("4"); setA.add("5");
		System.out.println("A = "+setA);
		
		setB.add("4"); setB.add("5"); setB.add("6");
		setB.add("7"); setB.add("8");
		System.out.println("B = "+setB);
		System.out.println();
		
//=======합집합 : 두 Set의 모든 객체들을 저장한 Set==========================================================
		//union.addAll(setA);
		//union.addAll(setB);
		
		Iterator it = setA.iterator();
		
		while (it.hasNext()) {
			union.add(it.next());
		}
		
		it = setB.iterator();
		
		while (it.hasNext()) {
			union.add(it.next());
		}
		
		System.out.println("A∪B = "+union);
		
//=======교집합 : 두 Set의 공통인 객체들을 저장한 Set==========================================================
		//interSection.addAll(setA);
		//interSection.retainAll(setB);
		
		it = setA.iterator(); {
			
		while(it.hasNext()) {
			Object elementA = it.next();
			if (setB.contains(elementA)) {
				interSection.add(elementA);
			}
		} // while문 끝
		
		System.out.println("A∩B = "+interSection);
		
//=======차집합 A-B : setA에서 B의 객체들과 중복되는 객체들을 제외한 Set==========================================================
		//differenceAB.addAll(setA);
		//differenceAb.removeAll(setB);
		
		it = setA.iterator(); 
		while (it.hasNext()) {
			Object elementA = it.next();
			if(!setB.contains(elementA)) { //setB에 현재 객체가 없다면
				differenceAB.add(elementA); // A-B에 추가
			}
		}
		System.out.println("A-B = "+differenceAB);
		
//=======차집합 B-A : setB에서 A의 객체들과 중복되는 객체들을 제외한 Set==========================================================
		//differenceBA.addAll(setB);
		//differenceBA.removeAll(setA);
		
		it = setB.iterator(); 
		while (it.hasNext()) {
			Object elementB = it.next();
			if(!setA.contains(elementB)) { //SetA에 현재 객체가 없다면
				differenceBA.add(elementB); //B-A에 추가
			}
		}
		System.out.println("B-A = "+differenceBA);
		}

	}

}
