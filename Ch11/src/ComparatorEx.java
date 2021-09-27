
import java.util.*;

public class ComparatorEx {
	
	/* Java의 정석 3판 p.629 예제 11-19 : 정렬
	 * 
	 * [인터페이스 Comparable]
	 *  기본 정렬 기준을 구현하는데 사용
	 *  java.lang에 있음 (별도로 import 필요 없음)
	 *  
	 *  int compareTo(Object o)
	 *  
	 * [인터페이스 Comparator]
	 *  기본 정렬 기준 외에 다른 기준으로 정렬하고자 할 때 사용
	 *  java.util에 있음
	 *  
	 *  int compare(Object o1, Object o2)
	 *  boolean equals(Object obj)
	 * 
	 * [정렬]
	 * - 정렬을 위해서는 정렬 대상이 필요하고 정렬 기준이 필요하다.
	 * - sort(Object[] arr) : 기본 정렬 기준 Comparable의 구현에 의한 정렬. 비교대상들이 Comparable 인터페이스를 구현해야한다.
	 * - sort(Object[] arr, Comparator cp) : 별도의 정렬 기준 Comparator의 구현에 의한 정렬. 비교대상들이 Comparator 인터페이스를 구현해야한다.
	 * - 각각의 정렬 기준에 존재하는 compareTo, compare을 기준으로 하여 두 객체끼리 비교하여  1,0,-1을 반환받고 이를 통한 자리바꿈
	 *  
	 *  
	 */

	public static void main(String[] args) {
		String[] strArr = {"cat", "Dog", "lion", "tiger"};
		
		Arrays.sort(strArr); //String 클래스의 comparable 구현(compareTo 메서드 오버라이드)에 의한 정렬
		System.out.println("strArr : "+Arrays.toString(strArr)); // 대소문자가 구분됨

		
	    /* public static final Comparator<String> CASE_INSENSITIVE_ORDER
	     * = new CaseInsensitiveComparator();
         * 
         * String.CASE_INSENSITIVE_ORDER는 비교기준 CaseInsensitiveComparator() 객체를 생성한 것을 상수화 한 것이다.
         *
         */
		
		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); // 대소문자를 구분 안 하는 Comparator
		System.out.println("strArr : "+Arrays.toString(strArr)); // 대소문자 구분없이 정렬됨
 
		
		Arrays.sort(strArr, new Descending()); // 기본정렬의 역순
		System.out.println("strArr : "+Arrays.toString(strArr));
		
		Arrays.sort(strArr, new MyDescending()); // 대소문자 구분 없이 역순으로 정렬
		System.out.println("strArr : "+Arrays.toString(strArr));
	}

}

class Descending implements Comparator {
	
	/*
	 * String 클래스는 기본적으로 Comparable 인터페이스가 구현되어 있음.
	 * 이 클래스의 int compareTo(String str)은 문자열을 비교하여 대소문자를 구분하여 사전순으로 배열하도록 되어있다.
	 * 
	 */
	
	@Override
	public int compare (Object o1, Object o2) {
		if (o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable) o1; // 기본 정렬 기준
			Comparable c2 = (Comparable) o2;
			return c1.compareTo(c2) * -1; // String 클래스의 기본정렬 기준 compareTo 값에 -1을 곱함(기본정렬의 역순)
		}
		return -1;
	}
}

class MyDescending implements Comparator<String> {
	
	@Override 
	public int compare (String s1, String s2) {
		return String.CASE_INSENSITIVE_ORDER.compare(s1, s2) * -1; //대소문자 구분 없이 역순 정렬
	}
}
