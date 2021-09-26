
import java.util.*;

	/* Java의 정석 3판 p.591 예제 11-4
	 * Vector 클래스의 몇 가지 기능을 직접 구현해보는 경험을 통해 List의 작동 원리 이해
	 */


public class MyVector {

	Object[] data = null; // 저장된 배열
	int capacity = 0; // 용량 (실제 저장할 수 있는 인덱스 수)
	int size = 0; // 크기 (값이 저장되어있는 인덱스 수를 기록)
	
	// 생성자
	public MyVector() {this(10);}
	public MyVector(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException ("유효하지 않은 값입니다. : "+capacity);
			}
		this.capacity = capacity;
		data = new Object[capacity]; // capacity : data.length
	}
	
	public void setCapacity(int capacity) {
		
		if (this.capacity == capacity) {
			return; // 지정하고자 하는 capacity와 현재 capacity가 같으면 capacity가 변경하지 않음
		}
		
		Object[] tmp = new Object[capacity]; // 새로 옮겨 쓸 배열을 생성
		System.arraycopy(data, 0, tmp, 0, size); // 배열 복사
		data = tmp; //복사한 배열로 참조 변경
		this.capacity = capacity; // capacity값 최신화
	}
	
	public void ensureCapacity(int mincapacity) { // 최소 저장공간을 확보
		if (mincapacity - data.length > 0) setCapacity(size+1);
	}
	
	public void trimToSize() {
		setCapacity(size); // capacity를 size에 맞춤
	}
	
	public boolean add(Object obj) {
		ensureCapacity (size+1);
		// 새로 객체 1개를 추가한다 = size 1 증가
		// size가 증가된 결과가 capacity보다 작을 경우 문제가 생길 수 있으므로 ensureCapacity 메서드가 필요하다.
		data[size++] = obj; //현재 size의 index에 객체를 추가하고, size의 값을 1 증가
		return true;
	}
	
	public Object get(int index) {
		if (index<0||index>=size) { // 인덱스가 size를 벗어나면
			throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
		}
		return data[index];
	}
	
	
	public Object remove(int index) {
		Object oldObj = null;
		
		if (index<0||index>=size) {
			throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
		}
		
		oldObj = data[index]; //oldObj가 기존의 index에 있던 객체를 참조하도록 함
		
		if(index!= size-1) { // 삭제하려는 인덱스가 마지막이 아닐 경우 뒤의 데이터를 앞당겨야함
			System.arraycopy(data, index+1, data, index, size-1-index);
			// 원본의 index+1 인덱스부터 size-1-index(나머지 인덱스들)만큼 원본의 index의 위치에 복사
		}
		
		data[size-1] = null; // 마지막 index의 객체를 비워야함
		size--; // 객체가 하나 줄었으므로 size 1 감소
		
		return oldObj;
	}
	
	public boolean remove(Object obj) {
		for (int i=0; i<size; i++) {
			if (obj.equals(data[i])) {
				remove(i); // 같은 객체를 찾아내면 제거
				return true;
			}
		}
		
		return false;
	}
	
	public void clear() { // 모든 객체 비우기
		for (int i=0; i < size; i ++) {
			data[i] = null;
		}
		size = 0;
		return;
	}
	
	public Object[] toArray() { // 리스트의 data를 size만큼 복사한 객체배열을 반환
		Object[] result = new Object[size]; 
		System.arraycopy(data, 0, result, 0, size);
		return result;
	}
	
	public boolean isEmpty() {return size==0;}
	public int capacity() {return this.capacity;}
	public int size() {return this.size;}
	
	/************************************************************************************/
	/*                             List로부터 상속받은 메서드들                                                               */
	/************************************************************************************/
	//public int size()
	//public boolean isEmpty();
	// 등
	
	public boolean contains(Object o) { // 객체를 list에서 찾기
		for (int i=0; i<size; i++) {
			if (data[i].equals(o)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean equals(Object o) { // list가 서로 같은지 확인
		if (!(o instanceof MyVector)) return false;
		
		MyVector mo = (MyVector) o;
		
		if (!(mo.size==this.size)) return false;
		
		for (int i=0; i < mo.size; i++) {
			if (!(mo.data[i].equals(this.data[i]))) return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(size,data);
	}
	
	
	public Object set(int index, Object element) { // 배열의 특정 인덱스에 위치한 객체 수정
		if (index<0||index>=size) {
			throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
		}
		
		data[index] = element;
		return data[index];
	}
	
	public int indexOf(Object o) { // 특정 객체를 앞에서부터 찾아서 인덱스 반환
		int index = -1;
		
		for (int i=0; i<size; i++) {
			if (o.equals(data[i])) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public int lastIndexOf(Object o) { // 특정 객체를 뒤에서부터 찾아서 인덱스 반환
		int index = -1;
		
		for (int i=size-1; i>=0; i--) {
			if(o.equals(data[i])) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	@Override
	public String toString() {
		String tmp = "[";
		for (int i=0; i<size; i++) {
			if (i!=0) tmp += ", ";
			tmp += data[i].toString();
			if (i==size-1) tmp +="]";
		}
		
		return tmp;
	}
	
}