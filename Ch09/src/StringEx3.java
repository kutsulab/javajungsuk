
public class StringEx3 {
	
	/* 자바의 정석 3판 p.468 예제 9-13
	 * String의 인스턴스 변수 value는 char[]을 저장함. char[]의 length가 곧 String 인스턴스의 length()
	 * 문자열 ""은 길이가 0인 char[]이다. 배열의 길이가 0, 그리고 문자열의 길이가 0
	 * null은 값 자체가 존재하지 않는 것이고 ""은 길이가 0인 문자열이 존재하는 차이가 있다.
	 */
	
	public static void main(String[] args) {
		// 길이가 0인 배열 생성
		char[] cArr = new char[0]; // char[] cArr = {}; 와 같은 표현
		String s = new String(cArr); // String s = new String(""); 와 같은 표현
		
		System.out.println("cArr.length : "+cArr.length);
		System.out.println("s.length() : "+s.length());
		System.out.println("@@@"+s+"@@@"); // 빈 문자열은 길이가 없는 문자열. 양 옆의 @@@가 붙어서 출력됨.
	}

}
