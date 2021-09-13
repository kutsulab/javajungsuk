
import static java.lang.Math.*;
import static java.lang.System.*;

public class MathEx3 {
	
	/* 자바의 정석 3판 p.486 예제 9-22
	 * 
	 * <java.lang.Math 클래스의 메서드들>
	 * sqrt(a) : a의 제곱근
	 * pow (a,b) : 수학에서의 a^b
	 * sin (theta) : theta(rad) 기준의 sin값
	 * cos (theta) : theta(rad) 기준의 cos값
	 * tan (theta) : theta(rad) 기준의 tan값

	 * atan (value) : value의 역 tan 값
	 * atan2 (b, a) : b/a 의 역 tan 값
	 *   예) tan (theta) = b/a 일 때
	 *       atan (b/a) = theta
	 *       atan2 (b,a) = theta // 두 점을 기준으로 역탄젠트 값을 구할 때 편리 
	 *       
	 * Loga(b) : 밑이 a 이고 진수가 b인 로그
	 *  예) log2(3) : 밑이 2이고 진수가 3인 로그
	 *       수학에서 2^x = 3 -> x = Log2(3)
	 */
	
	
	public static void main(String[] args) {
	
		int x1 = 1, y1 = 1; // 점 (x1, x2) = (1,1)
		int x2 = 2, y2 = 2; // 점 (y1, y2) = (2,2)
		
		double a = x2-x1; // 두 점의 x 좌표 차
		double b = y2-y1; // 두 점의 y 좌표 차	
		double c = sqrt ( pow(a, 2) + pow(b, 2) ); // 두 점 사이의 거리
		
		double angle_rad = atan2 (b,a); // 두 점 사이의 각을 rad로 반환
		double angle_degree = angle_rad * (180/PI); // 두 점 사이의 각을 degree로 환산

		double a2 = c * cos (angle_rad); // 두 점 사이의 거리에 cos값을 곱하여 x 좌표 차를 구함
		double b2 = c * sin (angle_rad); // 두 점 사이의 거리에 sin값을 곱하여 y 좌표 차를 구함
		
		out.printf("a = %f%n", a);
		out.printf("b = %f%n", b);
		out.printf("a2 = %f%n", a2);
		out.printf("b2 = %f%n", b2);
		out.printf("c = %f%n", c); // root2
		out.printf("angle_rad = %f(rad)%n", angle_rad);
		out.printf("angle_degree = %f(degree)%n", angle_degree);
		
		// 수학에서 2^24 = 10^x -> x = log10(2^24) = 7.224720...
		// 수학에서 2^53 = 10^x -> x = log10(2^53) = 15.954590...
		
		// 2진법으로 24자리 2진수는 십진법으로 7자리의 값을 표현할 수 있다. (float)
		// 2진법으로 53자리 2진수는 십진법으로 15자리 값을 표현할 수 있다. (double)
		out.printf("24 * log10(2) = %f%n", 24 * log10(2)); // log의 밑은 log 옆의 숫자, 진수는 매개변수로 사용하여 표현
		out.printf("53 * log10(2) = %f%n", 53 * log10(2));
	}

}
