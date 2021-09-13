
import java.util.*;

public class RandomEx3 {
	
	/* Java의 정석 3판 p.503 예제 9-29 내용 확인 및 연습
	 * 
	 * [java.util.Random의 활용]
	 *  
	 *  1. Random.nextInt(int n) : 0 이상 n 미만의 임의의 값을 반환함
	 *  
	 *  2. static int getRandomInt(int from, int to)
	 *  	from 이상 to 이하의 임의의 정수 반환
	 *  
	 *  3. static int fillRandomInt (int[] arr, from, to)
	 *  	from 이상 to 이하의 임의의 정수를 getRandomInt를 통해 구해서, arr의 각 요소에 채워넣음
	 *  
	 *  4. static int fillRandomInt (int[] arr, int[] source) 
	 *		source 배열의 임의의 인덱스에 위치한 값을 arr의 각 요소에 채워넣음
	 */
	
	
	
	// from 이상 to 이하의 임의의 정수를 반환
	private static int getRandomInt(int from, int to) {
		Random rdm = new Random(); // Random 객체 생성
	
		int rdmInt = 
				rdm.nextInt(Math.abs(to-from)+1) + Math.min(from,to);
		// rdm.nextInt(Math.abs(to-from)+1) : 범위의 양끝 값의 차
		// Math.min(from,to) : 범위의 시작값
		
		return rdmInt;
	}
	
	// 정해진 범위 내의 임의의 정수를 int 배열에 채워서 반환함
	private static int[] fillRandomInt(int[] arr, int from, int to) {
		for (int i=0; i < arr.length ; i++)
			arr[i] = getRandomInt(from,to);
		return arr;
	}
	
	// 정해진 배열이 있을 때 그 배열의 임의의 인덱스에 존재하는 값을 int 배열에 채워넣어서 반환함
	private static int[] fillRandomInt(int[] arr, int[] source) {
		for (int i=0; i < arr.length ; i++)
			arr[i] = source[getRandomInt(0,source.length-1)]; // 정해진 배열의 임의의 index에 위치한 값
		return arr;
	}
	
	public static void main(String[] args) {
		
		int[] rdm1 = fillRandomInt(new int[10], 1, 20);
		System.out.println(Arrays.toString(rdm1));
		
		int[] rdm2 = fillRandomInt(new int[10], new int[] {1,2,3,4,5});
		System.out.println(Arrays.toString(rdm2));
	}

}
