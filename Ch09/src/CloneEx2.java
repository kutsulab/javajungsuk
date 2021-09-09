import java.util.*;

public class CloneEx2 {
	
	/* 자바의 정석 3판 p.458 예제 9-8
	 * 배열 클래스들은 Cloneable, Serializable 인터페이스가 구현되어 있음
	 * 접근제어자가 public으로 오버라이드 되어 있음
	 * 즉 clone() 메서드를 호출 가능하다.
	 * 
	 * System.arraycopy (original, original_startnmb , copy, copy_starynmb, copylength) 메서드를 응용해서
	 * 원본 길이만큼의 배열을 새로 생성 후 내용을 복사할 수 있다.
	 */
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int[] arrClone = arr.clone();
		// 배열 클래스들은 Cloneable, Serializable 인터페이스가 구현되어 있음
		// 접근제어자가 public으로 오버라이드 되어 있음
		// 원본과 같은 타입을 반환하므로 별도의 형변환이 필요 없음.
		// 즉 clone() 메서드를 호출 가능하다.
		
		arrClone[0] = 6;
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arrClone));
		
		int[] arrCopy = new int[arr.length]; // arr과 length가 같은 배열을 생성함
		System.arraycopy(arr, 0, arrCopy, 0, arr.length); // arrCopy에 arr의 요소들을 복사(clone()과 구조적 동일)
		
		arrCopy[0] = 7;
		
		System.out.println("arr : "+Arrays.toString(arr));
		System.out.println("arrClone : "+Arrays.toString(arrClone));
		System.out.println("arrCopy : "+Arrays.toString(arrCopy));
		
	}

}
