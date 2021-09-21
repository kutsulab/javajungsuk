
import java.util.*;

public class VectorEx1 {

	/* Java의 정석 3판 p.588 예제 11-3 : Capacity
	 * 
	 * [List - Vector]
	 * 	Vector는 JDK 1.2 컬렉션 프레임웍스 등장 이전부터 존재하던 컬렉션
	 * 	Vector와 ArrayList는 대부분 구조적인 특징이 같다. 
	 * 
	 * [List의 Capacity]
	 * size가 capacity를 넘어가면 자동적으로 더 많은 capacity를 할당한 배열이 생성되어 복사되므로 메모리 낭비가 발생하게 됨
	 * 처음부터 List에 어느 정도의 데이터가 삽입될 지, capacity를 얼마만큼 쓸지 상정하여 Capacity의 변동이 없도록 해야함
	 */
	
	private static void printInfo(Vector v) {
		System.out.println(v);
		System.out.println("size : "+v.size());
		System.out.println("capacity : "+v.capacity());
		return;
	}
	
	public static void main(String[] args) {
		Vector v = new Vector(5); // 용량이 5인 Vector 생성
		v.add("1");
		v.add("2");
		v.add("3");
		printInfo(v);
		
		v.trimToSize(); // capacity를 Vector에 저장된 객체 개수에 맞게 조절 (v에 빈 공간이 없게 함.)
		System.out.println("===========after trimToSize()============");
		printInfo(v);

		
		v.ensureCapacity(6); // v의 capacity가 최소한 6이 되도록 함
		System.out.println("===========after ensureCapacity(6)============");
		printInfo(v);
		
		v.setSize(7); // v의 Size를 7로 조절. 비어있는 부분은 null을 채움
		System.out.println("===========after setSize(7)============");
		printInfo(v);
		
		v.clear();
		System.out.println("===========after clear()============");
		printInfo(v);
	}

}
