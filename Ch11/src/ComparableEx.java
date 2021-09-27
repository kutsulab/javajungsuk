
import java.util.*;

public class ComparableEx {
	
	/* Java의 정석 기초편 p.423 예제 11-8
	 * 
	 * [Integer의 정렬]
	 * 
	 * - Integer 클래스는 기본 정렬 기준인 Comparable을 구현했다. (오름차순 정렬)
	 * - 역순 정렬 : Comparator 구현 (compareTo * -1 값을 compare이 반환하도록 함)
	 */

	public static void main(String[] args) {
		Integer[] arr = {30,50,10,40,20};
		System.out.println("arr 원본 : "+Arrays.toString(arr));
		System.out.println();
		
		Arrays.sort(arr); // Integer 클래스는 기본정렬기준 Comparable(오름차순)을 구현함
		System.out.println("arr 오름차순 정렬 : "+Arrays.toString(arr));
		System.out.println();
		
		Arrays.sort(arr, new DescComp()); // 별도의 정렬기준 Comparator을 구현함 -> 내림차순
		System.out.println("arr 내림차순 정렬 : "+Arrays.toString(arr)); 
		System.out.println();
	}
}

class DescComp implements Comparator {
	
	@Override
	public int compare (Object o1, Object o2) {
		if(!(o1 instanceof Integer && o2 instanceof Integer)) {
			return -1; // o1, o2가 Integer이 아니면 -1 반환
		}
		
		Integer i1 = (Integer) o1;
		Integer i2 = (Integer) o2;
		
		return i1.compareTo(i2) * -1; // Integer 클래스의 기본 정렬 기준인 compareTo 값에 -1을 곱해 역순
	}
}
