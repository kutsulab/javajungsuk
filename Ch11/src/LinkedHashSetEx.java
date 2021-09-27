
import java.util.*;

public class LinkedHashSetEx {
	
	/* Java의 정석 3판 p.633 예제 11-22 : 저장순서가 보장되는 LinkedHashSet
	 *  
	 *  - HashSet은 저장순서를 보장하지 않음. Iterator 접근 시 자체적인 방식에 따라 접근 순서가 결정됨
	 *  - LinkedHashSet은 저장 순서를 보장하기 때문에  무작위로 값을 뽑아 저장 후 접근하는 상황에서 HashSet보다 적합하다.
	 */
	
	public static void main(String[] args) {
	
		//Set set = new HashSet(); HashSet()은 저장된 순서를 보장하지 않고 자체적인 방식에 따라 순서가 저장되기 때문에 반복시행했을 시 추출 결과가 비슷하게 나온다.
		Set set = new LinkedHashSet(); // 저장순서를 보장하기 때문에 HashSet이 좀 더 적합하다.
		
		int[][] bingoBoard = new int[5][5]; // 빙고판(임의의 1~50의 정숫값이 저장되는 25칸)
		
		for (int x=0; set.size() <25; x++) {	
			
			// auto-boxing에 의해 Integer 객체가 저장된다.
			set.add((int)(Math.random()*50) + 1);
		}
		
		Iterator it = set.iterator();
		
		for (int i=0; i<bingoBoard.length; i++) {
			
			for (int j=0; j<bingoBoard[i].length; j++) {
				bingoBoard[i][j] = (Integer)it.next();
				// Iterator는 반환타입이 Object
				// Integer로 형변환 후 auto-unboxing에 의해 int값이 저장된다. 
				
				System.out.printf("%2d ",bingoBoard[i][j]); 
			} // 내부 for문 끝
			
			System.out.println();
			
		}//외부 for문 끝
		
	}//main 메서드

}
