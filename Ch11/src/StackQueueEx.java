
import java.util.*;

public class StackQueueEx {
	
	/* Java의 정석 3판 p.605 예제 11-7 : Stack과 Queue
	 * 
	 * [Stack]
	 *  - LIFO (Last In First Out) : 나중에 저장된 것이 처음으로 추출됨
	 *  - push로 저장, pop으로 추출
	 *  - 
	 * 
	 * [Queue]
	 *  - FIFO (First In First Out) : 처음 저장된 것이 처음으로 추출됨.
	 *  - offer로 저장, poll로 추출
	 *  - 인터페이스로만 정의되어 있어서, Queue 인터페이스를 구현한 클래스들을 통해 생성해야함.
	 *     예) Queue q = new LinkedList();
	 */
	
	
	public static void main(String[] args) {
		Stack st = new Stack();
		Queue q = new LinkedList(); // Queue는 인터페이스 -> 인터페이스를 구현한 LinkedList를 사용
		
		st.push("0"); // 스택에 데이터 추가
		st.push("1");
		st.push("2");
		
		q.offer("0");
		q.offer("1");
		q.offer("2");
		
		System.out.println("====Stack====");
		while(!st.empty()) {
			System.out.println(st.pop()); // 마지막 저장된 것부터 하나씩 꺼낸다. (Stack)
		}
		
		System.out.println("====Queue====");
		while(!q.isEmpty()) {
			System.out.println(q.poll()); // 처음 저장된 것부터 하나씩 꺼낸다. (Queue)
		}
		
	}

}
