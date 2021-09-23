
import java.util.*;

	/* Java의 정석 3판 p.600 예제 11-5 : ArrayList와 LinkedList의 방식차이 및 그에 따른 성능차
	 * 
	 * [자료 저장방식 1. 순차적 저장방식 - ArrayList]
	 * - 배열을 기반으로 한 List
	 * - 배열은 크기를 도중에 변경할 수 없으므로, 크기를 늘리려면 새로운 배열을 생성하고, 데이터를 복사한 뒤, 참조를 변경해야한다.
	 * - 중간에서 데이터를 추가 또는 삭제하는데 시간이 많이 걸린다.
	 *   (도중에 데이터를 추가하려면 데이터를 뒤에 복사하는 과정을 거쳐야함. 심지어 capacity가 모자라면 배열을 새로 만들어야한다.)
	 * - 대신 순차적으로 데이터를 앞에서부터 추가하고, 뒤에서부터 삭제하는 성능은 빠르다.
	 * - 개별 데이터에 대한 접근성이 좋다.
	 *   (ArrayList 주소와, 찾고자하는 객체의 index 주소를 알면 해당 객체의 주소로 바로, 빠르게 이동 가능하다.)
	 * 
	 * [자료 저장방식 2-1. linkedList]
	 * - 불연속적인 메모리 주소를 가진 참조변수들의 순차적 연결을 기반으로한 List
	 * - 각 리스트의 요소들을 Node로 나누고, 각 Node에는 객체와 다음 Node의 참조변수(메모리주소)가 저장된다.
	 * - 데이터를 추가할 때는 다음 Node를 생성하고, 이전 Node로부터 다음 Node를 참조하면 된다.
	 * - 중간에서 데이터를 추가 또는 삭제할 때는 참조하는 다음 Node의 주소를 변경해주기만 하면 되므로 ArrayList보다 빠르다.
	 * - 하지만 순차적으로 데이터를 앞에서 추가하고 뒤에서부터 삭제하는 과정은 Node의 연결관계를 계속적으로 변경해야하므로 시간이 오래 걸린다.
	 * - 개별 데이터에 대한 접근성이 나쁘다.
	 *   (LinkedList 주소와, 찾고자하는 객체의 index 주소를 알더라도, 첫번째 Node부터 순차적으로 해당 index까지 이동해야한다.)
	 * 
	 * [자료 저장방식 2-2. double linked List]
	 * - linkedList의 단점을 보완
	 * - 각 Node가 이전 node의 주소도 참조하도록 함
	 * - 각 요소에 대한 접근과 이동이 linkedlist보다 더 좋아짐
	 * - Java의 LinkedList는 이 방식을 채용했다.
	 * 
	 * [자료 저장방식 2-3. double circular linked list]
	 * - double linked list에서 접근성을 좀 더 보완
	 * - 첫번째 node와 마지막 node를 연결하여, 끝의 요소에서 앞의 요소로 접근하기 더 편하게 함.
	 * 
	 */

public class ArrayListLinkedListTest {

	public static void main(String[] args) {
		ArrayList al = new ArrayList(2000000);
		LinkedList ll = new LinkedList();
		
		System.out.println("=========순차적으로(앞에서부터) 데이터 추가하기==========");
		System.out.println("addInOrder(al) : "+addInOrder(al)+"ms"); // 순차적으로 데이터를 삽입하는 성능은 ArrayList가 더 빠르다
		System.out.println("addInOrder(ll) : "+addInOrder(ll)+"ms");
		System.out.println("앞에서부터 데이터 100만개 추가 완료!");
		System.out.println();
		
		System.out.println("=========중간에서 추가하기===============");
		System.out.println("addInMiddle(al) : "+addInMiddle(al)+"ms"); // 중간에 데이터를 삽입하는 성능은 linkedList가 더 빠르다
		System.out.println("addInMiddle(ll) : "+addInMiddle(ll)+"ms");
		System.out.println("500번 index에 \"X\" 10000회 추가 완료!");
		System.out.println();
		
		System.out.println("=========중간에서 삭제하기===============");
		System.out.println("RemoveInMiddle(al) : "+removeInMiddle(al)+"ms"); // 중간에서 데이터를 삭제하는 성능은 linkedList가 더 빠르다
		System.out.println("RemoveInMiddle(ll) : "+removeInMiddle(ll)+"ms");
		System.out.println("앞에서부터 데이터 10000개 삭제 완료!");
		System.out.println();
		
		System.out.println("=========순차적으로(끝에서부터) 삭제하기===============");
		System.out.println("RemoveInOrder(al) : "+removeInOrder(al)+"ms"); // 뒤에서부터 순차적으로 데이터를 삭제하는 성능은 ArrayList가 더 빠르다
		System.out.println("RemoveInOrder(ll) : "+removeInOrder(ll)+"ms");
		System.out.println("뒤에서부터 데이터 일괄 삭제 완료!");
		System.out.println();
		
	}
	
	
	private static long addInOrder(List list) {
		long start = System.currentTimeMillis(); // 시작시점 시각을 millisecond 단위로 저장
		
		for (int i=0; i<1000000; i++) { //0부터 999999까지 숫자를 String 타입으로 리스트에 순차적으로 저장
			list.add(String.valueOf(i));
		}
		
		long end = System.currentTimeMillis(); // 완료 시점 시간을 millisecond 단위로 저장
		
		return end-start; // 시작시점, 완료시점간의 차를 반환
	}
	
	private static long addInMiddle(List list) {
		long start = System.currentTimeMillis(); // 시작시점 시각을 millisecond 단위로 저장
		
		for (int i=0; i<10000; i++) {
			list.add(500, "X"); // 500번째 인덱스에 "X"를 삽입하기를 10000번 반복
		}
		
		long end = System.currentTimeMillis(); // 완료 시점 시간을 millisecond 단위로 저장
		
		return end-start; // 시작시점, 완료시점간의 차를 반환
	}
	
	private static long removeInOrder(List list) {
		long start = System.currentTimeMillis(); // 시작 시점 시간을 millisecond 단위로 저장
		for (int i=list.size()-1; i>=0; i--) {
			list.remove(i);
		}
		long end = System.currentTimeMillis(); // 완료 시점 시간을 millisecond 단위로 저장

		return end - start; // 시작시점, 완료시점간의 차를 반환
	}
	
	private static long removeInMiddle(List list) {
		long start = System.currentTimeMillis(); // 시작 시점 시간을 millisecond 단위로 저장
		
		for (int i=0; i<10000; i++) { // 맨 앞부터 데이터를 10000개 삭제
			list.remove(i);
		}		
		
		long end = System.currentTimeMillis(); // 완료 시점 시간을 millisecond 단위로 저장
		return end - start; // 시작시점, 완료시점간의 차를 반환
	}
	
	
	
}
