
	/* 자바의 정석 3판 p.460 예제 9-9
	 * 
	 * <<얕은 복사(shallow copy : 불완전한 복사)>>
	 * 참조변수를 인스턴스 변수로 가지는 객체는 clone()을 통해 복사하더라도, 해당 참조변수가 가리키는 객체가 같다.
	 * 이 상태에서 인스턴스 변수의 변화가 생길 경우 원본, 복사본 양쪽에 영향이 가게 되는 문제가 발생한다.
	 * 
	 * <<깊은 복사(deep copy : 완전한 복사)>>
	 * 원본이 참조하고 있는 객체까지 따로 복사해서 복사 인스턴스에 참조변수에 새로 저장하면 얕은 복사의 문제점이 해결된다.
	 * 인스턴스 변수의 변화가 생기더라도 각각의 참조변수가 완전히 다른 객체를 가리키게 되므로 서로 영향을 주지 않는다.
	 */


class Circle implements Cloneable {
	Point2 p; // 참조변수를 인스턴스 변수로 가지고 있음.
	double r; // 반지름
	
	Circle (Point2 p, double r) {
		this.p = p;
		this.r = r;
	}
	
	public String toString() {
		return "[중심이 "+p+"이고, 반지름이 "+r+"인 원]";
	}
	
	// 얕은 복사 : Circle 객체가 복제되어도 Circle의 참조변수 Point2가 가리키는 객체는 그대로인 문제가 있음.
	public Circle shallowCopy() {
		Object obj = null;
		
		try {
			obj = super.clone(); //
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return (Circle) obj;
	}
	
	public Circle deepCopy() {
		Object obj = null;
		
		try {
			obj = super.clone(); //
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		Circle c = (Circle) obj;
		
		// 진정한 의미의 깊은 복사를 하려면 원본 객체의 참조변수가 가리키는 객체도 새로 복제하여, 저장해줘야한다.
		c.p = new Point2(this.p.x, this.p.y); // point2 객체를 복사하여 참조변수가 이를 가리키게 함 
		
		return c;
	}
}

class Point2 {
	double x, y;
	Point2(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "("+x+", "+y+")";
	}
}


public class ShallowDeepCopy {

	public static void main(String[] args) {
		Circle c1 = new Circle(new Point2(1,1), 2.0); // 중심이 (1,1)이고 반지름이 2인 원
		Circle c2 = c1.shallowCopy();
		Circle c3 = c1.deepCopy();
		
		System.out.println("c1 : "+c1);
		System.out.println("c2 : "+c2);
		System.out.println("c3 : "+c3);
		System.out.println();

		System.out.println("c1의 p 변경!");
		c1.p.x = 9;
		c1.p.y = 9;
		System.out.println();
		
		System.out.println("===c1의 p 변경 후===");
		System.out.println("c1 : "+c1);
		System.out.println("c2 : "+c2); // c2의 참조변수 p가 가리키는 Point2 객체가 c1과 같으므로, c1의 p의 변경이 반영됨
		System.out.println("c3 : "+c3);
	}

}
