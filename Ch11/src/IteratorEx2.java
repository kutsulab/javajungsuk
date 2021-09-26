import java.util.*;

public class IteratorEx2 {
	
	/* Java의 정석 3판 p.619 예제 11-15
	 * Iterator의 remove()메서드 : 접근한 객체를 제거한다.
	 */
	
	public static void main(String[] args) {
		ArrayList original = new ArrayList(10); // 원본 데이터
		ArrayList copyList = new ArrayList(10); // 데이터 복사
		ArrayList moveList = new ArrayList(10); // 데이터 이동
		
		for (int i=0; i<10; i++) {
			original.add(String.valueOf(i));
		}
		
		Iterator it = original.iterator();
		
		while(it.hasNext()) {
			copyList.add(it.next());
		}
		
		System.out.println("========= original -> copyList (복사) ===========");
		System.out.println("original : "+original); // original을 출력
		System.out.println("copyList : "+copyList); // copyList를 출력
		System.out.println();
		
		it = original.iterator();
		
		while (it.hasNext()) {
			moveList.add(it.next());
			it.remove(); // 컬렉션에서 해당 객체를 제거
		}
		
		System.out.println("========== original -> moveList (이동) =============");
		System.out.println("original : "+original); // original을 출력
		System.out.println("moveList : "+moveList); // moveList를 출력
	}

}
