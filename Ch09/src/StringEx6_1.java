
public class StringEx6_1 {
		
	/* 자바의 정석 3판 p.474 내용 확인 및 연습
	 * [기본형 값을 String으로 변환]
	 *  - 방법 1 : static 클래스 String.valueOf(기본형 데이터)
	 *  	예 ) "4".equals(String.valueOf(4)) : true
	 *  - 방법 2 : 래퍼클래스.toString(기본형 데이터)
	 *  	예 ) "4".equals(Integer.toString(4)) : true
	 *  
	 * [String을 기본형 값으로 변환]
	 *  - 방법 1 : 래퍼클래스.parse래퍼클래스(문자열로 표시된 기본형데이터) - 반환타입이 int
	 *  	예) 4 == Integer.parseInt("4") : true
	 *  - 방법 2 : 래퍼클래스.valueOf(문자열로 표시된 기본형데이터) - 반환타입이 Integer
	 * 		예) 4 == Integer.valueOf("4") : true
	 */

	public static void main(String[] args) {
		
		// 정수를 문자열로 바꾸기
		
		int i1 = 100;

		
		String str1 = "100"; 
		String str2 = 100 + ""; // Integer 리터럴에 ""을 붙여서 생성하면 문자열 리터럴을 불러온다.
		String str3 = i1 + ""; // 정수 타입 변수에 ""을 붙여서 생성하면 새로운 String 객체를 생성한다?
		String str4 = String.valueOf(i1);
		String str5 = Integer.toString(i1);

		System.out.println("각 String 객체별 identityHashCode");
		System.out.println("identityHashCode(str1) : "+System.identityHashCode(str1)); // 366712642
		System.out.println("identityHashCode(str2) : "+System.identityHashCode(str2)); // 366712642
		System.out.println("identityHashCode(str3) : "+System.identityHashCode(str3)); // 1829164700
		System.out.println("identityHashCode(str4) : "+System.identityHashCode(str4)); // 2018699554
		System.out.println("identityHashCode(str5) : "+System.identityHashCode(str5)); // 1311053135
		System.out.println();

		// 기본형 데이터로 변환
		
		int i2 = Integer.parseInt(str1);
		int i3 = Integer.valueOf(str1);
		
		System.out.println("i1 : "+i1);
		System.out.println("i2 : "+i2);
		System.out.println("i3 : "+i3);
		
	}

}
