
public class HashCodeEx1 {
	/* 자바의 정석 3판 p.453 예제 9-3
	 * 
	 * String 클래스는 문자열의 내용이 같으면 동일한 해시코드를 반환하도록 hashCode()에서 오버라이딩 되어있다.
	 * 하지만 System.identityHashCode(Object obj) 메서드는 메모리 주소를 기준으로 한 HashCode를 반환하므로
	 * 모든 서로 다른 인스턴스에 대하여 그 값이 다름이 보장되어 있다.*/
	
	public static void main(String[] args) {
		String str1 = "abc"; // 문자열 리터럴을 저장
		String str2 = "abc"; // 문자열 리터럴을 저장
		String str3 = "def"; // 문자열 리터럴을 저장
		
		/* 소스파일에 포함된 모든 문자열 리터럴은 컴파일 시에 클래스 파일의 리터럴 목록에 저장됨.
		 * 같은 내용의 문자열 리터럴은 한번만 저장
		 * 클래스 파일이 실행 될 때, 리터럴 목록은  JVM의 상수저장소 (constant pool)에 저장
		 * 이후 새로 변수를 선언하고 문자열 리터럴을 저장하도록 하면, 별도로 인스턴스를 생성하지 않고
		 * 상수저장소에 위치한 리터럴 인스턴스를 가리키게 함.
		 * 즉 같은 문자열 리터럴을 저장한 변수들은 서로 가리키는 String 객체의 주소가 같다.
		 */
		
		String str4 = new String("abc"); // 새로운 문자열 인스턴스 "abc"를 생성하고 저장
		String str5 = new String("abc"); // 새로운 문자열 인스턴스 "abc"를 생성하고 저장
		String str6 = new String("def"); // 새로운 문자열 인스턴스 "def"를 생성하고 저장
		
		String[] strs = {str1, str2, str3, str4, str5, str6};
		
		System.out.printf("%3s	%3s	%8s	%16s%n","변수명","문자열","hashCode","identityHashCode");
		
		for (int i = 0; i<strs.length ; i++) {
			System.out.printf("%3s	%3s	%8s	%16s%n","str"+(i+1),strs[i],strs[i].hashCode(),System.identityHashCode(strs[i]));
		}
		
		//	출력 결과
		//		변수명	문자열	hashCode	identityHashCode
		//		str1	abc	   96354	      1252169911		
		//		str2	abc	   96354	      1252169911			
		//		str3	def	   99333	      2101973421		
		//		str4	abc	   96354	       685325104		
		//		str5	abc	   96354	       460141958			
		//		str6	def	   99333	      1163157884		
		
		// 1. str1과 str2는 같은 문자열 리터럴을 저장했기 때문에
		//    hashCode값, identityHashCode값이 같다.
		// 2. str3은 str1,str2과 다른 문자열 리터럴을 저장했기기 때문에 str1,str2와 hashCode값이 다르다.
		// 3. str4,str5는 새로 메모리를 할당하여 새로운 인스턴스를 생성했기 때문에
		//    identityHashCode가 다르다. 메모리 주소도 str1과 str2와 다르다.
		// 4. 하지만 str1, str2와 같은 문자열의 인스턴스이기 때문에 hashCode() 값은 같다.
		// 5. str6 역시 str3과 메모리 주소 자체도 다른 새로운 인스턴스. identityHashcode가 다르다.
		
		System.out.println("str1==str2 : "+(str1==str2)); // 같은 문자열 리터럴 인스턴스를 가리키므로 주소가 같다
		System.out.println("str1==str3 : "+(str1==str3)); // 다른 문자열 리터럴 인스턴스를 가리키므로 주소가 다르다
		System.out.println("str1==str4 : "+(str1==str4)); // str4는 새로운 인스턴스이므로 같은 문자열이더라도 str1과 주소가 다르다
		System.out.println("str4==str5 : "+(str4==str5)); // str5도 새로운 인스턴스이므로 str1, str4와 주소가 다르다.
		System.out.println("str3==str6 : "+(str3==str6)); // str6 역시 새로운 인스턴스이므로 str3과 주소가 다르다.
		
		System.out.println("str1.equals(str2) : "+str1.equals(str2)); // 같은 문자열이므로 ture (equals 오버라이딩에 의함)
		System.out.println("str1.equals(str3) : "+str1.equals(str3)); // 다른 문자열이므로 false (equals 오버라이딩에 의함)
		System.out.println("str1.equals(str4) : "+str1.equals(str4)); // 주소가 달라도 같은 문자열이므로 true (equals 오버라이딩에 의함)
		System.out.println("str4.equals(str5) : "+str4.equals(str5)); // 주소가 달라도 같은 문자열이므로 true (equals 오버라이딩에 의함)
		System.out.println("str3.equals(str6) : "+str3.equals(str6)); // 주소가 달라도 같은 문자열이므로 true (equals 오버라이딩에 의함)
	}

}
