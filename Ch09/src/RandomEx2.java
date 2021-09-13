
import java.util.*;

public class RandomEx2 {
	
	/* Java의 정석 3판 p.502 예제 9-28 내용 확인 및 연습
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
	
	private static String printGraph(char ch, int value) {
		char[] bar = new char[value]; // 배열 char를 생성
		
		for (int i = 0; i < bar.length; i++) // value 값만큼 ch를 채워넣음
			bar[i] = ch;
		return new String(bar); // char[]를 매개변수로한 String 인스턴스 생성 후 반환
	}
	
	public static void main(String[] args) {
	
		Random rand = new Random(); // 현재 시각을 시드로 한 Random 객체 생성
		
		int[] number = new int[100]; // 모든 값이 0으로 초기화 되어 있음
		int[] counter = new int[10]; // 모든 값이 0으로 초기화 되어 있음
		
		for (int i=0; i < number.length; i++) {
			System.out.print(number[i] = rand.nextInt(10));
			// 0~9 범위의 정수를 연속해서 출력
			//System.out.print(number[i] = (int) (Math.random() * 10)) 과 구조적 동일
			
			if (i%10 == 9) System.out.println();
			// index의 값이 9로 끝나는 부분마다 줄바꿈. (10개단위로 끊어서 출력)
		}
		System.out.println();
		
		for (int i=0; i < number.length; i++) {
			counter[number[i]] ++;
			// number[i]에 해당하는 counter의 index에 저장된 값을 1 증가 -> 각 인덱스에 저장된 값은 각각 number에 포함된 숫자들의 개수를 계산해서 넣어줌 
		}
		
		for (int i=0; i < counter.length; i++) {
			System.out.println(i+"의 갯수 : "+printGraph('#',counter[i])+"   "+counter[i]+"개");
		}
	}

}
