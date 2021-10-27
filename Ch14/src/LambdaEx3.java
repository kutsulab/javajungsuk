
	/* ========================================================================
	 *  Java의 정석 3판 p.801 예제 14-3 : 외부변수를 참조하는 람다식
	 * ========================================================================
	 *
	 *     1. 외부 변수를 참조하는 람다식
	 *     
	 *      - 외부 멤버변수 : 변경 가능하다.
	 *      - 외부 지역변수 : 상수여야함. 이 변수는 변경 불가능하다. final이 붙지 않아도 상수 취급
	 *                    또, 람다식 매개변수는 외부 지역변수와 같은 이름의 변수를 허용하지 않는다.
	 *      
	 * ========================================================================
	 */

@FunctionalInterface
interface MyFunctionEx3_1 {
	void myMethod();
}

@FunctionalInterface
interface MyFunctionEx3_2 {
	void myMethod(int i);
}

class Outer {
	int val = 10; // Inner 입장에서 : Outer.this.val
	
	class Inner {
		int val = 20; // Inner 입장에서 : this.val
		void method (int i) {
			int val = 30;
			// val = 20; // 람다식 내에서 참조하는 지역변수는 final이 붙지 않아도 상수취급되기 떄문에 값을 변경할 수 없다.
			// i = 10;
			
			MyFunctionEx3_1 f = () -> {
				System.out.printf("%22s : %d%n","i",i);
				System.out.printf("%22s : %d%n","val",val);
				System.out.printf("%22s : %d%n","this.val",++this.val); // 람다식 내에서 참조하는 인스턴스 변수는 변경이 가능하다.
				System.out.printf("%22s : %d%n","Outer.this.val",++Outer.this.val);
			};
			
			f.myMethod();
			return;
		}
		
		void method2 (int i) {
			int val = 40;
			
			//MyFunctionEx3 f = (i) -> { // 외부 지역변수와 같은 이름의 람다식 매개변수는 허용되지 않는다.
			MyFunctionEx3_2 f = (k) -> {
				System.out.printf("%16s(k=%d) : %d%n","k+i",k,k+i);
				System.out.printf("%16s(k=%d) : %d%n","k+val",k,k+val);
				System.out.printf("%16s(k=%d) : %d%n","k+this.val",k,k+(++this.val)); // 람다식 내에서 참조하는 인스턴스 변수는 변경이 가능하다.
				System.out.printf("%16s(k=%d) : %d%n","k+Outer.this.val",k,k+(++Outer.this.val));
			};
			
			f.myMethod((int)(Math.random()*100));
			return;
		}
	}
	
}


public class LambdaEx3 {

	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		// Inner 인스턴스의 생성은 외부 Outer 인스턴스의 생성이 선행되어야하고, outer을 통해 생성해야한다.
		
		inner.method(100);
		System.out.println();
		inner.method2(100);
	}
}
