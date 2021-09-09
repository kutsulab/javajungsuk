
public class StringEx1 {
	
	/* 자바의 정석 3판 p.466 예제 9-11
	 * 
	 * String 클래스는 char[] value라는 인스턴스 변수를 가지고 있다.
	 * 기본적으로 클래스에 포함된 모든 문자열 리터럴들은 클래스가 메모리에 올라갈 때, JVM의 상수저장소(constant pool)에 저장된다.
	 * 같은 문자열 리터럴은 유일하므로,
	 * String str1 ="abc"; 과 같은 방식의 변수 초기화는, 문자열이 새로 생겨나는게 아니라 상수저장소에서 불러오는 것이다.
	 * 
	 * 문자열의 비교 : .equals(String s)
	 *  - String 클래스에서 equals 메서드가 오버라이드 되어있어서, 해당 인스턴스의 value를 기준으로 하여 true,false를 반환한다.
	 *  - hashCode() 역시, 오버라이드 되어있어서 같은 문자열이 저장되어 있을 경우 true를 반환한다.
	 *  - 문자열의 결합은 새로운 인스턴스를 만들어내므로 메모리 낭비. String 객체로 가급적 쓰지 말 것!
	 *  
	 * 같은 문자열을 저장한 String 인스턴스들은 hashCode() 값이 서로 같다.
	 * new String(String s)방식으로 생성된 String 인스턴스는 새로운 인스턴스라서 identityhashCode() 값이 다르다.
	 */
	
	public static void main(String[] args) {
		String str1 = "abc"; // 문자열 리터럴 "abc"의 주소를 반환
		String str2 = "abc";
		
		System.out.println("String str1 = \""+str1+"\";");
		System.out.println("String str2 = \""+str2+"\";");
		
		System.out.println("str1 == str2 ? : "+(str1==str2));
		System.out.println("str1.equals(str2) ? : "+(str1.equals(str2))); // String 클래스에서 value를 기준으로 equals()의 값을 반환하도록 오버라이드 되어있음
		System.out.println();
		
		String str3 = new String("\"abc\""); // 새로운 문자열 인스턴스를 생성. -> 서로 다른 인스턴스
		String str4 = new String("\"abc\"");
		
		System.out.println("String str3 = new String("+str3+")");
		System.out.println("String str4 = new String("+str4+")");
		
		System.out.println("str3 == str4 ? : "+(str3==str4));
		System.out.println("str3.equals(str4) ? : "+(str3.equals(str4)));
		System.out.println();
		
		String str5 = "a";
		String str6 = "b";
		String str7 = str5+str6; // 문자열 결합은 결합된 문자열 리터럴을 불러오는 것이 아닌, 새로운 인스턴스를 생성한다. -> 메모리 낭비!
		String str8 = "ab";
		
		System.out.println("str7 == str8 ? : "+(str7==str8)); // 이것도 결국은 문자열 결합 방식(새로운 객체 생성) -> 메모리 낭비...
		System.out.println("System.identityHashCode(str7) : "+System.identityHashCode(str7)); // value는 같지만 두 객체의 identityHashCode()값이 다르다.
		System.out.println("System.identityHashCode(str8) : "+System.identityHashCode(str8));
	}

}
