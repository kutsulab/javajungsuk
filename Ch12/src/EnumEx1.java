
	/* ========================================================================
	 *  Java의 정석 3판 p.694 예제 12-5
	 * 
	 * [열거형의 정의와 사용]
	 *  
	 *  1. 열거형
	 *   - 서로 관련된 상수를 편리하게 선언하기 위한 것.
	 *   - C에서는 타입이 달라도 값이 같으면 동일하게 취급하는 등, 타입에 안전하지 않았지만
	 *     Java에서는 타입과 값을 모두 체크하는 점에서'타입에 안전한 열거형'이다.
	 * 
	 *  2. 열거형 정의하기 
	 *   - enum 열거형이름 {상수명1, 상수명2, 상수명3, ...}
	 *  
	 *  3. 열거형 상수의 비교
	 *   - == 을 통해 비교 가능. (상수이므로, 메모리 주소를 통한 비교가 가능함)
	 *   - equals를 통해 비교가 가능하지만, ==을 통한 비교가 더 빠름.
	 *      -> equals를 통한 비교가 가능하다 : 열거형 상수는 객체다.
	 *   - compareTo()를 통한 비교가 가능. (ordinal의 대소로 비교)
	 *   - > < >= <=를 통한 비교 불가능.
	 *  
	 *  4. switch문에서
	 *   case문에 열거형의 이름을 적지 않고 상수의 이름만 적어야함.
	 *   
	 *  5. java.lang.Enum : 모든 열거형의 조상
	 *   - static E values() : 열거형 상수가 보유한 모든 상수를 배열로 반환함
	 *   - static E valueOf(String name) : 문자열로 열거형 상수를 반환함
	 *   - Class<E> getDeclaringClass() : 열거형의 class 객체 반환
	 *   - String name : 열거형 상수의 이름을 문자열로 반환
	 *   - int ordinal : 열거형 상수가 정의된 순서를 반환 (0부터 시작)
	 *   
	 * ========================================================================  
	 */


enum Direction { EAST, SOUTH, WEST, NORTH } // 0, 1, 2, 3

public class EnumEx1 {
	
	public static void main(String[] args) {
		Direction d1 = Direction.EAST; // 열거형 타입.상수이름 
		Direction d2 = Direction.valueOf("WEST"); // 열거형타입.valueOf("상수이름") <- 문자열로 상수를 가져옴
		Direction d3 = Enum.valueOf(Direction.class, "EAST"); // Enum.valueOf(열거형 클래스, "상수이름")
		
		System.out.println("d1 = "+d1); // toString 호출 시 name이 반환됨
		System.out.println("d2 = "+d2);
		System.out.println("d3 = "+d3);
		
		System.out.println("d1==d2 ? "+ (d1==d2)); // 상등을 == 으로 판단 가능
		System.out.println("d1==d3 ? "+ (d1==d3));
		System.out.println("d1.equals(d3) ? "+ (d1==d3)); // 각각이 객체라서 equals로 비교 가능
		
		// System.out.println("d2 > d3 ? "+(d2>d3)); // 객체는 > 으로 비교 불가능
		System.out.println("d1.compareTo(d3)?"+(d1.compareTo(d3)));
		System.out.println("d1.compareTo(d2)?"+(d1.compareTo(d2)));
		
		switch(d1) { // switch-case 문에서, Dircetion.EAST와 같이 쓸 수 없음.
		case EAST :
			System.out.println("The direction is EAST.");
			break;
		case SOUTH :
			System.out.println("The direction is SOUTH.");
			break;
		case WEST :
			System.out.println("The direction is WEST.");
			break;
		case NORTH :
			System.out.println("The direction is NORTH.");
			break;
		default :
			System.out.println("Invalid direction.");
			break;
		}
		
		Direction[] dArr = Direction.values(); // 열거형의 모든 상수를 배열로 반환
		
		for (Direction dir : dArr) { // 배열의 각 열거형 상수에 접근
			System.out.printf("%s = %d%n",dir.name(),dir.ordinal());
			//ordinal : 값 x 순서 o
		}
		
	}
}
