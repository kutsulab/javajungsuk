
import java.util.*;

	/* Java의 정석 3판 p.606 예제 11-8
	 * 
	 * [Stack을 구현해보는 경험]
	 *  - Stack은 마지막에 저장(push)된 객체가 처음 추출(pop)된다.
	 *  - pop : 추출 + 삭제
	 *  - peek : 추출만
	 *  - Stack의 인덱스는 마지막에 저장된 객체 기준으로 1이다.
	 *  - Stack의 인덱스 + 배열의 인덱스 = size()로 일정함을 이용 -> 배열의 인덱스를 Stack의 인덱스로 환산할 수 있다. 
	 */

public class MyStack extends Vector {

	private Object push(Object item) {//저장
		addElement(item); // 객체 추가
		return item;
	}
	
	private Object pop() {//추출 + 삭제
		Object obj = peek(); // 추출
		removeElementAt(size()-1); // 삭제
		return obj;
	}
	
	public Object peek() {//추출만 함
		if (size() == 0) {
			throw new EmptyStackException();
		}
		
		return elementAt(size()-1); //마지막 인덱스에 저장된 객체를 반환
	}
	
	public boolean empty() {
		return size()==0;
	}
	
	public int search(Object o) {
		int arrayIndex = lastIndexOf(o); // 배열에서, 마지막 입력된 것부터 객체를 찾아서 인덱스를 반환
		int stackIndex = -1; // 못 찾았을 경우 -1
		
		if(arrayIndex >=0) { //객체가 존재할 경우
			stackIndex = size()-arrayIndex;
			//stack의 인덱스는 마지막에 저장된 객체의 인덱스를 1로 함
			//어떤 stack의 객체에 대하여 그 객체의 stackIndex + arrayIndex의 합은 size()로 일정함
		}
		
		return stackIndex;
	}
	
}
