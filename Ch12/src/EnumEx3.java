
	/* ========================================================================
	 *  Java의 정석 3판 p.698 예제 12-7
	 * 
	 * [열거형에 추상메서드 추가하기]
	 * 
	 *  1. 추상메서드 선언
	 *   열거형에 추상메서드를 선언하면, 각 열거형 상수들은 이를 구현해야한다. 
	 *   
	 *  2. 멤버변수  참조하기
	 *   protected를 접근제어자로 설정해야 상수들에서 접근 가능함.
	 *   캡슐화를 위해서 상수는 private로 두고, getter를 통해 접근하는 방법도 있을 듯하다.
	 *   
	 * ========================================================================  
	 */


enum Transportation {
	
	// 열거형 상수
	BUS(100) { int fare(int distance) { return BASIC_FARE * distance;}},
	TRAIN(150) { int fare(int distance) { return BASIC_FARE * distance;}},
	SHIP(100) { int fare(int distance) { return BASIC_FARE * distance;}},
	AIRPLANE(300) { int fare(int distance) { return BASIC_FARE * distance;}};
	
	// 열거형 상수의 멤버 변수
	protected final int BASIC_FARE; // <- protected로 접근제어자를 지정해야 상수내의 메서드에서 접근 가능하다.
	
	// 추상 메서드
	abstract int fare(int distatnce); // 열거형에 정의한 추상 메서드
	
	// 생성자
	Transportation (int basicFare) {BASIC_FARE = basicFare;} // 열거형 상수의 생성자
	
	// 멤버변수 반환
	public int getBasicFare() {return BASIC_FARE;} // 열거형 상수의 멤버변수, BASIC_FARE를 반환
	
}


public class EnumEx3 {

	public static void main(String[] args) {
		System.out.println("BUS fare = " + Transportation.BUS.fare(100));
		System.out.println("TRAIN fare = " + Transportation.TRAIN.fare(100));
		System.out.println("SHIP fare = " + Transportation.SHIP.fare(100));
		System.out.println("AIRPLANE fare = " + Transportation.AIRPLANE.fare(100));
	}

}
