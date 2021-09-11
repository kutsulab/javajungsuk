
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
	 * 
	 * pow(a,b) : a^b;
	 */
	
	/* myCeil, myFloor, myRound, myRint
	 *  소숫점 자리수에 해당하는 만큼 10의 거듭제곱꼴을 곱하여 ceil, floor, round, rint를 계산 후 다시 원래값으로 환산함
	 *  원하는 자리수에서 반올림하도록 함.
	 *  예를 들어 소숫점 첫째자리는 10^-1 자리이므로 -1
	 *  정수부분 첫째자리는 10^0자리이므로 0
	 *  정수부분 둘째자리는 10^1자리이므로 1
	 */

	private static double myCeil(double val, int place) {
		double adjust = pow (10.0, -place-1);
		return ceil(val * adjust)/adjust;
	}
	
	private static double myFloor(double val, int place) {
		double adjust = pow (10.0, -place-1);
		return floor(val * adjust)/adjust;
	}
	
	private static double myRound(double val, int place) {
		double adjust = pow (10.0, -place-1);
		return round(val * adjust)/adjust;
	}
	
	private static double myRint(double val, int place) {
		double adjust = pow (10.0, -place-1);
		return rint(val * adjust)/adjust;
	}
	
	private static void printMyCeil(double val, int place) {
		out.println("myCeil("+val+", "+place+") = "+myCeil(val,place));
		return;
	}
	
	private static void printMyFloor(double val, int place) {
		out.println("myFloor("+val+", "+place+") = "+myFloor(val,place));
		return;
	}
	
	private static void printMyRound(double val, int place) {
		out.println("myRound("+val+", "+place+") = "+myRound(val,place));
		return;
	}
	
	private static void printMyRint(double val, int place) {
		out.println("myRint("+val+", "+place+") = "+myRint(val,place));
		return;
	}
	
	
	public static void main(String[] args) {
		double val = 90.7552;
		printMyRound(val, -1); // 90.7552를 10^-1 자리에서 반올림
		printMyRound(val, -3);
		
		out.println();
		out.printf("random()=%f%n", random()); // 0이상 1미만의 임의의 double
		out.printf("abs(%3.1f)=%3.1f%n", -1.1, abs(-1.1)); // 절댓값
		out.printf("max(%3.1f, %3.1f)=%3.1f%n", -0.9, 1.8, max(-0.9, 1.8)); // 둘 중 큰 값
		out.printf("min(%3.1f, %3.1f)=%3.1f%n", -0.9, 1.8, min(-0.9, 1.8)); // 둘 중 작은 값
		out.println();

		printMyCeil(1.1,-1); // 소숫점 첫째자리에서 올림
		printMyFloor(1.5,-1); // 버림
		printMyRound(1.1,-1); // 반올림
		printMyRound(1.5,-1); // 반올림
		printMyRint(1.5,-1); // 짝수 반올림
		printMyRound(-1.5,-1); // 반올림
		printMyRint(-1.5,-1); // 짝수 반올림
		printMyCeil(-1.5,-1); // 올림
		printMyFloor(-1.5,-1); // 버림
	}

}
