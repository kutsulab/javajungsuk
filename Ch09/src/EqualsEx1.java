
public class EqualsEx1 {

	public static void main(String[] args) {
		Value v1 = new Value(10);
		Value v2 = new Value(10); // v1과 v2는 인스턴스 변수가 같지만, 서로 메모리 주소가 달라서 다른 인스턴스
		
		v1.printEquals(v2); // 결과 : 두 객체는 서로 다르다.
		
		v2 = v1; // 하지만 v2가 가리키는 객체를 v1이 가리키는 객체로 같게 하면
		
		v1.printEquals(v2); // 결과 : 두 객체는 서로 같다.
	}
}



class Value {
	int value; // 인스턴스 변수
		
	//생성자
	Value (int value) {
		this.value = value;
	}
	
	void printEquals(Object obj) {
		if (!(obj instanceof Value)) {
			// 객체를 비교했을 때 Value로 형변환 불가능할 경우 다르다고 메시지를 출력하고 반환함 
			System.out.println("두 객체는 서로 다르다.");
			return;
		}
		
		//형변환 가능할 경우 형변환
		Value v2 = (Value) obj;
		
		//Object 클래스의 equals(Object obj) 메서드는 기본적으로 두 인스턴스의 주소값을 비교한뒤 출력
		if (this.equals(v2)) 
			System.out.println("두 객체는 서로 같다.");
		else
			System.out.println("두 객체는 서로 다르다.");
	}
}
