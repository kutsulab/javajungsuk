
public class CloneEx1 {
	
	/* 자바의 정석 3판 p.456 예제 9-7
	 * 
	 * Object.clone() : 인스턴스를 복제하고 Object 타입으로 형변환해서 반환한다.
	 * 이렇게 형변환된 것을 참조변수에 저장하려면 다시 원래 클래스로 형변환해서 저장해야함.
	 * 
	 * <사용조건>
	 * 1. Cloneable 인터페이스를 구현해야 Object.clone() 메서드를 사용할 수 있다.
	 * 2. Object.clone()의 접근제어자는 protected이므로 별도의 패키지에서 호출해서 사용하려면
	 *    클래스 파일 내에서 접근제어자를 public으로 오버라이드 해야한다.
	 * 3. Object.clone()의 선언부에는 throws CloneNotSupportedException가 있다.
	 *    즉, CloneNotSupportedException에 대한 예외처리를 해야한다.
	 *    (cf) CloneNotSupportedException
	 *         Cloneable 인터페이스를 구현하지 않은 인스턴스가 clone() 메서드를 호출할 때 발생
	 */
	
	public static void main(String[] args) {
		Point original = new Point(3,5); // 원본 Point 인스턴스를 생성
		Point copy = original.clone(); // Object 클래스로 형변환 되어서 반환되었으므로 다시 원래 클래스로 형변환해야한다.
		// JDK 1.5부터는 공변반환타입 기능이 추가되어, 클래스 내에서 반환 타입을 자손타입(클래스 타입)으로 하여 반환할 수 있다.
		// 즉 호출부에서 형변환을 따로 할 필요가 없음 
		System.out.println("original"+original);
		System.out.println("copy"+copy);
	}
}

class Point  implements Cloneable {
	// Cloneable 인터페이스를 구현해야 object.clone() 메서드를 사용할 수 있다.
	
	double x, y;
	
	Point (double x, double y) {
		// 생성자 : 인스턴스 변수 x, y를 매개변수에 저장된 인수로 초기화
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "(x, y) = ("+x+", "+y+")"; // 인스턴스 변수 x,y를 출력하도록 오버라이드
	}
	
	@Override
	public Point clone() { // 다른 클래스에서 clone()을 호출하려면 public으로 접근제어자를 오버라이드 해야한다.
		// JDK 1.5부터 공변 반환타입 기능이 추가되어, 오버라이딩을 할 때 조상 메서드의 반환타입을 자손타입으로 변경 허용함

		Object obj = null; // Object obj을 선언 후 null로 초기화
		
		// Object.clone() 메서드는 throws CloneNotSupportedException이 선언부에 적혀있으므로 사용시 예외처리를 해야함(강제)
		// super.clone(); 그냥 이렇게만 못 씀.
		
		try {
			obj = super.clone(); // Object.clone()을 호출. 객체 자신을 복제하고 그것을 Object 타입으로 형변환해서 반환함
		} catch (CloneNotSupportedException e) { // object.clone()의 예외처리
			e.printStackTrace();
		} 
		
		return (Point)obj; // Object 클래스의 참조변수로 반환되므로 호출한 쪽에서 원래 클래스로 형변환해야한다.
		// 1.5부터 공변 반환타입 기능이 추가되어 class의 clone() 메서드 내에서 자손타입으로 형변환하여 반환 가능. 
	}
	
}