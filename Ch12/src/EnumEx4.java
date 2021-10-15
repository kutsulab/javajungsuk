
	/* ========================================================================
	 *  Java의 정석 3판 p.700 예제 12-8
	 * 
	 * [열거형의 이해]
	 * 
	 *  1. 열거형의 상수
	 *   열거형의 각 상수들은 각각 그 열거형 클래스의 생성자에 의해 만들어진 열거형 객체들이다.
	 *   멤버변수가 없는 열거형 상수들은 name()과 ordinal() 만을 가진다.
	 *   
	 * ========================================================================  
	 */


abstract class MyEnum<E extends MyEnum<E>> implements Comparable<E> {
	
	// static 변수
	protected static int id = 0; // 접근 제한 : 다른 패키지의 자손들까지.

	// 열거형 상수의 기본 멤버변수(상수명, 생성자)
	private String name; // 상수의 이름
	private int ordinal; // 상수의 순서

	// 특별히 멤버변수를 기본적인 생성자
	MyEnum (String name) {
		this.name = name;
		ordinal = id++; // 상수 생성 시, id를 참조한 ordinal 반환. 참조 후 id를 증가시킴
	}
	
	@Override
	public int compareTo(E e) {
		return this.ordinal - e.ordinal();
	}
	
	public String name() {return name;}
	public int ordinal() {return ordinal;}
	
	@Override
	public String toString() {return name;}
}

abstract class MyTransportation extends MyEnum {
	
	// 열거형 상수
	static final MyTransportation BUS = new MyTransportation("BUS", 100) {
		int fare(int distance) {return BASIC_FARE * distance;}
	};
	static final MyTransportation TRAIN = new MyTransportation("TRAIN", 150) {
		int fare(int distance) {return BASIC_FARE * distance;}
	};
	static final MyTransportation SHIP = new MyTransportation("SHIP", 100) {
		int fare(int distance) {return BASIC_FARE * distance;}
	};
	static final MyTransportation AIRPLANE = new MyTransportation("AIRPLANE", 300) {
		int fare(int distance) {return BASIC_FARE * distance;}
	};
	
	// 열거형 상수의 멤버변수
	protected final int BASIC_FARE;
	
	// 열거형 상수의 추상 메서드
	abstract int fare(int distance);
	
	// 열거형 상수의 생성자
	private MyTransportation(String name, int basicFare) {
		super(name);
		this.BASIC_FARE = basicFare;
	}
	
}

public class EnumEx4 {

	public static void main(String[] args) {
		MyTransportation t1 = MyTransportation.BUS;
		MyTransportation t2 = MyTransportation.BUS;
		MyTransportation t3 = MyTransportation.TRAIN;
		MyTransportation t4 = MyTransportation.SHIP;
		MyTransportation t5 = MyTransportation.AIRPLANE;
		
		System.out.printf("t1=%s, %d%n", t1.name(), t1.ordinal());
		System.out.printf("t2=%s, %d%n", t2.name(), t2.ordinal());
		System.out.printf("t3=%s, %d%n", t3.name(), t3.ordinal());
		System.out.printf("t4=%s, %d%n", t4.name(), t4.ordinal());
		System.out.printf("t5=%s, %d%n", t5.name(), t5.ordinal());
		System.out.println("t1==t2 ? : "+(t1==t2));
		System.out.println("t1.compareTo(t3) : "+(t1.compareTo(t3)));
		
	}
	
}
