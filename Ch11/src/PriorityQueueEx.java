
import java.util.*;

public class PriorityQueueEx {
	
	/* Java의 정석 3판 p.612 예제 11-12
	 * 
	 * [PriorityQueue]
	 * 우선순위가 높은 것부터 꺼내는 Queue
	 * 
	 * - null은 저장할 수 없다. NullPointerException 발생
	 * - 저장공간으로 배열을 사용. 각 요소를 힙(heap)의 형태로 저장
	 * - heap : 이진 트리의 한 종류. 가장 큰 값이나 가장 작은 값을 빠르게 찾을 수 있다.
	 */
	public static void main(String[] args) {
		Queue pq = new PriorityQueue(); // Queue인터페이스를 구현한 PriorityQueue() 객체 생성
		
		
		pq.offer(3); // pq.offer(new Integer(3)); 을 오토박싱함
		pq.offer(1);
		pq.offer(5);
		//pq.offer(null); //nullPointerException 발생
		pq.offer(2);
		pq.offer(4);
		System.out.println(pq);
		
		Object obj = null; //pq에서 poll한 객체들을 임시 저장할 객체
		
		while ((obj = pq.poll())!=null) {//pq에서 poll한 것이 null이 아닐 때
			System.out.println(obj); // 입력 순서와 다르게 pq 객체에 정의되어 있는 어떤 우선순위에 의해 출력됨.
		}
		
	}

}
