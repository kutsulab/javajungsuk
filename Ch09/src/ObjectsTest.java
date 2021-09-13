import java.util.*;
import static java.util.Objects.*;

public class ObjectsTest {
	
	/* Java의 정석 3판 p.498 내용 확인 및 연습
	 * 예제 9-26
	 * java.util.Objects 클래스
	 * 
	 * [java.util.Objects] 클래스
	 * 	모든 메서드가 static 메서드. 객체의 비교, null check 등에 이용
	 * 
	 *		1. boolean isNull(Object obj) : 객체가 null 이면 true
	 *
	 *		2. boolean nonNull(Object obj) : 객체가 null 아닐 경우 true
	 * 
	 * 		3. requireNonNull(Object obj, String Message)
	 * 			객체가 null이 아니어야 하는 경우 사용
	 * 			obj가 null 일 경우 obj를 반환하고 obj가 null이면 예외 메시지를 발생시킴
	 *
	 *		4. int compare (Object a, Object b, Comaprator c)
	 *			객체의 어떤 값을 기준 Comparator c를 이용해 비교
	 *
	 *		5. boolean equals(Object a, Object b)
	 *			매개변수의 값이 null인지 아닌지 여부를 같이 판단한다.
	 *
	 *			equals 내부에서
	 *			return (a==b) || (a != null && a.equals(b)) 이 작성되어 있는데
	 *
	 *			a와 b의 주소가 같거나, 객체가 null이 아니고 서로 주솟값이 같은 경우 true를 반환함.
	 *			a,b가 모두 null인 경우 참을 반환하는 차이가 있음
	 *			null 검사를 따로 하지 않아도 된다.
	 *
	 *		6. boolean deepEquals(Object a, Object b)
	 *			두 배열을 비교했을 때 배열의 요소들이 전부 같을 때 true를 return
	 *			둘 중 어느 하나라도 null이면 false
	 *
	 *		7. String toString(Object obj, String nullDefault)
	 *			내부적으로 null 검사를 하고 null일 경우 nullDefault에 해당하는 문자열을 호출함
	 *
	 *		8. int hashCode(Object o) : 내부적으로 null검사를 하고 Object 클래스의 hashCode를 호출
	 *		9. int hash(Object... values) : 매개변수의 타입이 가변인자. 매개변수들의 값에 따라 hash값을 반환함
	 */
	
	public static void main(String[] args) {
		String[][] str2D_1 = {{"aaa","bbb"}, {"AAA","BBB"}};
		String[][] str2D_2 = {{"aaa","bbb"}, {"AAA","BBB"}};
		
		System.out.print("str2D_1 = {"); // str2D_1을 출력
		for (String[] tmp : str2D_1)
			System.out.print(Arrays.toString(tmp));
		System.out.println("}");
		
		System.out.print("str2D_2 = {"); // str2D_2을 출력
		for (String[] tmp : str2D_2)
			System.out.print(Arrays.toString(tmp));
		System.out.println("}");
		
		System.out.println("equals(str2D_1, str2D_2) = "
											+Objects.equals(str2D_1, str2D_2));
		// Objects.equals() : 기본적으로 주솟값 비교, 두 객체가 null이면 false가 반환됨
		
		System.out.println("deepEquals(str2D_1, str2D_2) = "
											+Objects.deepEquals(str2D_1, str2D_2));
		// Objects.deepEquals() : null이면 false 반환, 두 배열의 각 요소를 모두 비교하여 같으면 true 반환
		
		System.out.println("isNull(null) = "+isNull(null));
		// 매개변수로 사용된 객체가 null이면 true를 반환
		
		System.out.println("nonNull(null) = "+nonNull(null));
		// 매개변수로 사용된 객체가 null이면 false를 반환
		
		System.out.println("hashCode(null) = "+Objects.hashCode(null));
		// Object.hashCode(null)은 예외를 발생시키지만, Objects.hashCode(null)은 0을 반환함
		
		System.out.println("toString(null) = "+Objects.toString(null));
		// Object.toString(null)은 예외를 발생시키지만, Objects.toString(null)은 문자열 "null"를 반환함
		
		System.out.println("toString(null, \"\") = "+Objects.toString(null, ""));
		// null일 때 무슨 문자열을 출력할 지 지정할 수 있음
		
		Comparator c = String.CASE_INSENSITIVE_ORDER; // 대소문자 구분 안 하는 비교 기준
		
		System.out.println("compare(\"aa\",\"bb\") = "+compare("aa","bb",c));
		// 앞의 문자가 앞섬 : -1
		
		System.out.println("compare(\"bb\",\"aa\") = "+compare("bb","aa",c));
		// 앞의 문자가 뒤 : 1
		
		System.out.println("compare(\"ab\",\"AB\") = "+compare("ab","AB",c));
		// 앞의 문자와 뒤의 문자가 같다 : 0
		
	}

}
