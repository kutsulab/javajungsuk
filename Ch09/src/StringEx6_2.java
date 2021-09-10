
public class StringEx6_2 {
	 
	/* 자바의 정석 3판 p.475 예제 9-16
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
	 * 
	 * [문자열 결합이 잦으면 성능향상을 위해 String.join 메서드를 사용하는 것을 고려해보자.]
	 */
	
	public static void main(String[] args) {
		int iVal = 100;
		String strVal1 = String.valueOf(iVal); // int타입 데이터 100을 문자열 "100"으로 변환
		
		double dVal = 200.0;
		String strVal2 = dVal+""; // double타입 데이터 200.0을 문자열 "200.0"으로 변환
		
		// 래퍼클래스.parse래퍼클래스 메서드를 이용한 기본형 데이터화
		double sum1 = Integer.parseInt("+"+strVal1) + Double.parseDouble(strVal2); //"+"를 포함한 문자열이 parseInt로 변환 가능하게 된 것은 JDK 1.7부터라고 한다.
		
		// 래퍼클래스.valueOf(String s) 메서드를 이용한 기본형 데이터화
		double sum2 = Integer.valueOf(strVal1) + Double.valueOf(strVal2);
		
		System.out.println(String.join("",strVal1,"+",strVal2,"=")+sum1); // String.join메서드를 이용한 문자열 결합 : StringBuffer를 통하다보니 성능이 향상된다고 함
		System.out.println(strVal1+"+"+strVal2+"="+sum2); // 객체를 새로 만들다보니 성능 저하
		
	}

}
