
	/* ========================================================================
	 *  Java의 정석 3판 p.696 예제 12-6
	 * 
	 * [열거형에 멤버 추가하기]
	 * 
	 *  1. 열거형 상수의 멤버변수 선언
	 *   private final 타입a 변수명1;
	 *   private final 타입b 변수명2; ...
	 *   
	 *  2. 열거형 상수의 생성자
	 *   (private) 열거형이름 (멤버변수타입 매개변수) {this.멤버변수타입 = 매개변수; ...}
	 *  
	 *  3. 열거형 상수의 멤버변수 반환
	 *   public 타입 get변수() ...
	 *   
	 * ========================================================================  
	 */


enum Direction2 {
	EAST(1, "→"), SOUTH(2, "↓"), WEST(3, "←"), NORTH(4, "↑"); 
	
	private static final Direction2[] DIR2_ARR = Direction2.values(); // 열거형 상수 객체들의 배열
	
	private final int value; // 열거형 상수의 멤버변수 1 : value
	private final String symbol; // 열거형 상수의 멤버변수 2 : symbol
	
	Direction2(int value, String symbol) { // 열거형 상수의 생성자
		this.value = value;
		this.symbol = symbol;
	}
	
	public int getValue() { return value; }
	public String getSymbol() { return symbol; }
	
	public static Direction2 of(int value) { // value로 Direction2 객체 반환
		if (value<1||value>4) { // 범위를 벗어나는 값을 입력받았을 경우
			throw new IllegalArgumentException("Invalid value : "+value);
		}
		return DIR2_ARR[value-1];
	}
	
	public Direction2 turnClockwise90Degree (int count) { // 시계방향 90도 회전
		count = count%4;
		if (count<0) count += 4; // 시계 반대방향으로 count번 회전한 것은 음수일 경우 시계방향으로 4-count번 회전한 것과 구조적 동일
		
		return DIR2_ARR[(value+count-1)%4];
	}
	
	@Override
	public String toString() { // 호출 시 현재 상수명과 Symbol을 반환
		return name()+"("+getSymbol()+")";
	}
	
}

public class EnumEx2 {

	public static void main(String[] args) {
		for (Direction2 d : Direction2.values()) {
			System.out.printf("%s = %d%n",d.name(),d.getValue());
		}
		
		Direction2 d1 = Direction2.EAST; // Direction2 상수 직접 호출
		Direction2 d2 = Direction2.of(1); // value로 Direction2 객체 반환
		
		System.out.printf("d1 = %s, %d%n",d1.name(), d1.getValue());
		System.out.printf("d2 = %s, %d%n",d2.name(), d2.getValue());
		
		System.out.println(Direction2.EAST.turnClockwise90Degree(1));
		System.out.println(Direction2.EAST.turnClockwise90Degree(2));
		System.out.println(Direction2.EAST.turnClockwise90Degree(-1));
		System.out.println(Direction2.EAST.turnClockwise90Degree(-2));
	}

}
