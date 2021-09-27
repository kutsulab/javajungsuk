
import java.util.*;

public class HashSetEx3 {

	/* Java의 정석 3판 p.634 예제 11-24
	 * 
	 * [Set인터페이스를 구현한 컬렉션들은 무엇을 기준으로 중복을 따지는가?]
	 * - HashSet은 equals 메서드를 기준으로 그 객체가 중복되는 객체인지 아닌 객체인지를 판단한다.
	 * - 따라서 객체를 Set에 저장하기 전에 그 객체의 equals 메서드를 따로 오버라이드 해줄 필요가 있다.
	 * - hashSet의 검색 성능 향상을 위해 hashCode 메서드 역시 equals의 오버라이드에 맞게 오버라이드 해주는 것이 좋다.
	 * 
	 * [어떻게 오버라이드 하는가?]
	 * - equals(Object obj)
	 *  1. 타입이 다르다 -> false 반환하도록 함
	 *  2. 타입이 같을 때 -> 인스턴스 변수가 같은지의 여부를 기준으로 true, false를 반환하도록 함
	 *  
	 * - hashCode()
	 *  1. Objects 클래스의 int hash (Object ... values) 활용 오버라이드
	 *   : Objects.hash(Object... values(가변인자)) 는 인스턴스 변수 값들을 인수로 하여 hash값을 반환한다.
	 *   
	 *  2. JDK 1.8 이전에는, 멤버변수들을 하나의 문자열로 합친뒤 이 문자열의 hashCode를 반환하도록 하여 했었음.
	 *    예) (name+age).hashCode()
	 *   
	 */
	
	public static void main(String[] args) {
	
		// 같은 내용의 문자열 객체 생성
		String str1 = "abc";
		String str2 = new String("abc");
		
		// 인스턴스변수가 같은 두 객체 생성
		Person2 p1 = new Person2("캬루", 14); 
		Person2 p2 = new Person2("캬루", 14);
		
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
		
		
		//Person2 클래스 역시 equals, hashCode 메서드가 멤버변수의 동일성 여부를 기준으로 오버라이드 되어있음. 서로 다른 주소의 객체더라도, 멤버변수 값이 같다면 true가 반환됨
		System.out.println("==========Person2 객체들의 equals, hashCode===========");
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
		
		
		// Person2 클래스는 equals, hashCode의 return이 멤버변수를 기준으로 반환되도록 오버라이드 됨 -> 같은 멤버변수를 가지면 중복으로 취급됨
		System.out.println("============실제 HashSet에 저장된 것=============");
		System.out.println(set);
	}

}

class Person2 {
	private String name;
	private int age;
	
	Person2 (String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return name+"("+age+"세)";
	}
	
	@Override
	//멤버변수들을 기준으로 hashCode 값을 반환하도록 오버라이드
	public int hashCode() {
		return Objects.hash(name, age);
	}
	
	@Override
	//멤버변수들을 기준으로 equals 값을 반환하도록 오버라이드
	public boolean equals(Object obj) {
		if (!(obj instanceof Person2)) {
			return false;
		}
		Person2 p = (Person2) obj;
		return (this.name.equals(p.getName()))&&(this.age == p.getAge());
	}
	
}