
import java.util.*;

public class HashSetEx2 {

	/* Java의 정석 3판 p.634 예제 11-23
	 * 
	 * [Set인터페이스를 구현한 컬렉션들은 무엇을 기준으로 중복을 따지는가?]
	 * - HashSet은 equals 메서드를 기준으로 그 객체가 중복되는 객체인지 아닌 객체인지를 판단한다.
	 * - 따라서 객체를 Set에 저장하기 전에 그 객체의 equals 메서드를 따로 오버라이드 해줄 필요가 있다.
	 * - hashSet의 검색 성능 향상을 위해 hashCode 메서드 역시 equals의 오버라이드에 맞게 오버라이드 해주는 것이 좋다.
	 */
	
	public static void main(String[] args) {
	
		// 같은 내용의 문자열 객체 생성
		String str1 = "abc";
		String str2 = new String("abc");
		
		// 인스턴스변수가 같은 두 객체 생성
		Person1 p1 = new Person1("캬루", 14); 
		Person1 p2 = new Person1("캬루", 14);
		
		//객체의 정보 출력
		System.out.println("==========객체들==============");
		System.out.println("str1 : \""+str1+"\"");
		System.out.println("str2 : \""+str2+"\"");
		System.out.println("p1 : "+p1);
		System.out.println("p2 : "+p2);
		System.out.println();
		
		//String 클래스는 자체적으로 equals, hashCode 메서드가 오버라이드 되어있음. 서로 다른 주소의 객체더라도 문자열을 기준으로 반환됨
		System.out.println("==========String 객체들의 equals, hashCode===========");
		System.out.println("str1.equals(str2) : "+str1.equals(str2));
		System.out.println("str1.hashCode() : "+str1.hashCode());
		System.out.println("str2.hashCode() : "+str2.hashCode());
		System.out.println();
		
		System.out.println("==========Person1 객체들의 equals, hashCode===========");
		System.out.println("p1.equals(p2) : "+p1.equals(p2));
		System.out.println("p1.hashCode() : "+p1.hashCode());
		System.out.println("p2.hashCode() : "+p2.hashCode());
		System.out.println();
		
		
		System.out.println("==============HashSet에 객체들을 추가=============");
		HashSet set = new HashSet();
		
		// equals가 true를 반환함 -> HashSet에서 중복으로 판단함
		System.out.println("str1을 추가 : "+set.add(str1));
		System.out.println("str2을 추가 : "+set.add(str2));
		System.out.println("p1을 추가 : "+set.add(p1));
		System.out.println("p2을 추가 : "+set.add(p2));
		System.out.println();
		
		
		// Person1 클래스는 equals, hashCode가 오버라이드 되어있지 않기 때문에 같은 멤버변수를 갖더라도 중복으로 취급되지 않는다.
		System.out.println("============실제 HashSet에 저장된 것=============");
		System.out.println(set);
	}

}

class Person1 {
	private String name;
	private int age;
	
	Person1 (String name, int age) {
		this.name = name;
		this.age = age;
	}
		
	public String toString() {
		return name+"("+age+"세)";
	}
}