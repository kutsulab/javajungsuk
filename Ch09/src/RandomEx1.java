
import java.util.*;

public class RandomEx1 {
	
	/* Java의 정석 3판 p.501 예제 9-27 내용 확인 및 연습
	 * 
	 * [java.util.Random 클래스]
	 * 
	 * 1. 생성자
	 *  Random(long seed) : 지정된 값을 시드로 하는 Random 인스턴스 생성
	 * 	Random() :현재 시각(System.currentTimeMillis() : 1/1000초 단위)을 시드(Seed, 종자값)로 하는 Random 인스턴스 생성
	 *  
	 *  
	 *  같은 값을 시드로 하는 Random 인스턴스는 같은 메서드를 통해 같은 값을 같은 순서대로 얻는다.
	 *  
	 * 2. 메서드
	 *  boolean nextBoolean() : boolean 타입의 난수 반환
	 *  
	 *  void nextBytes(byte[] bytes) : 매개변수로 입력한 byte타입 배열 객체의 모든 요소에 byte 타입 난수를 채워줌
	 *  double nextDouble() : 0.0<=x<1.0 의 double 타입 난수 반환
	 *  float nextFloat() : 0.0<=x<1.0의 float 타입 난수 반환
	 *  double nextGaussian() : 평균 0, 표준편차가 1.0인 Gaussian 분포에 따른 double형 난수 반환
	 *  int nextInt() : int타입의 임의의 난수 반환
	 *  int nextInt(int n) : 0<= x < n 범위에 있는 임의의 int 값 반환
	 *  long nextLong() : long 타입의 임의의 난수 반환 
	 *  void setSeed(long seed) : 시드를 주어진 값으로 변경
	 */

	public static void main(String[] args) {
		Random rand1 = new Random(1); // 1을 시드로 한 Random 객체 생성
		Random rand2 = new Random(1); // 1을 시드로 한 Random 객체 생성
		
		// 두 Random 객체는 같은 시드를 사용하기 때문에 같은 값들을 같은 순서로 얻는다.

		System.out.println("===rand1===");
		for (int i = 0; i < 5; i++) {
			System.out.println(i+" : "+rand1.nextInt()); // 임의의 값을 5회 출력
		}
		
		System.out.println();
		
		System.out.println("===rand2===");
		for (int i = 0; i < 5; i++) {
			System.out.println(i+" : "+rand2.nextInt()); // 임의의 값을 5회 출력
		}
		
		
	}

}
