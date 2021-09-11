
import static java.lang.Math.*;
import static java.lang.System.*; // import static문 : static 멤버를 호출할 때, 클래스 이름을 생략할 수 있다.

public class MathEx1 {
	
	/* 자바의 정석 3판 p.483 예제 9-20
	 * 
	 * <java.lang.Math 클래스의 메서드들>
	 * abs : 절댓값을 같은 타입으로 반환
	 * ceil : 올림 후 double로 반환
	 * floor : 버림 후 double로 반환
	 * round : 소숫점 첫째자리에서 반올림 후 long으로 반환
	 * rint : 소숫점 첫째자리에서 짝수반올림 후 long으로 반환
	 * max, min : 둘 중 큰 값, 작은 값을 같은 타입으로 반환
	 * random : 0이상 1미만의 임의의 double을 반환
	 */
	
	
	public static void main(String[] args) {
		double val = 90.7552;
		out.println("round("+ val + ")=" + round(val)); // 90.7 -> 91 반올림
		
		val *= 100; // val = 9075.52
		out.println("round("+ val + ")=" + round(val)); // 9075.5 -> 9076 반올림
		
		out.println("round("+ val + ")/100 =" + round(val)/100); // 90.76 -> 90 (버려짐)
		out.println("round("+ val + ")/100.0 =" + round(val)/100.0); // 9076/100.0 = 90.76
		
		out.println();
		out.printf("random()=%f%n", random()); // 0이상 1미만의 임의의 double
		out.printf("abs(%3.1f)=%3.1f%n", -1.1, abs(-1.1)); // 절댓값
		out.printf("max(%3.1f, %3.1f)=%3.1f%n", -0.9, 1.8, max(-0.9, 1.8)); // 둘 중 큰 값
		out.printf("min(%3.1f, %3.1f)=%3.1f%n", -0.9, 1.8, min(-0.9, 1.8)); // 둘 중 작은 값
		out.println();
		out.printf("ceil(%3.1f)=%3.1f%n", 1.1, ceil(1.1)); // 올림
			//printf의 %3.1f : 소숫점의 '.' 포함 전체 3자리, 소숫점 아래 1자리표시.
			//그 아랫자리가 있을 경우 반올림
		out.printf("floor(%3.1f)=%3.1f%n", 1.5, floor(1.5)); // 버림
		out.printf("round(%3.1f)=%d%n", 1.1, round(1.1)); // 반올림
		out.printf("round(%3.1f)=%d%n", 1.5, round(1.5)); // 반올림
		out.printf("rint(%3.1f)=%f%n", 1.5, rint(1.5)); // 짝수로 반올림
		out.printf("round(%3.1f)=%d%n", -1.5, round(-1.5)); // 반올림
		out.printf("rint(%3.1f)=%f%n", -1.5, rint(-1.5)); // 짝수로 반올림
		out.printf("ceil(%3.1f)=%3.1f%n", -1.5, ceil(-1.5)); // 올림
		out.printf("floor(%3.1f)=%3.1f%n", -1.5, floor(-1.5)); // 버림
	}

}
