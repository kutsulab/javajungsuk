import java.util.Objects;

class Person {
	long id; // 인스턴스 변수
	
	Person(long id) {
		this.id = id;
	}
	
	@Override // Object 클래스의 equals를 오버라이딩
	public boolean equals(Object obj) {
		if (!(obj instanceof Person)) return false;
		Person p = (Person) obj;
		return this.id == p.id; // 두 Person 인스턴스의 인스턴스 변수 id를 비교하여 일치하면 참을 반환하도록 오버라이딩 
	}
	
	@Override
	// equals(object obj) 메서드가 인스턴스 변수를 기준으로 boolean 값을 반환하도록 오버라이딩했다면, hashCode()도 오버라이딩 해야한다.
	public int hashCode() {
		return Objects.hash(id); //주소가 아닌 id 기준으로 hashCode()를 반환하도록 오버라이딩
	}

}

public class EqualsEx2 {

	public static void main(String[] args) {	
		Person p1 = new Person(1234567890123L); // p1과 p2는 다른 객체
		Person p2 = new Person(1234567890123L);
		
		// 다른 객체는 메모리 주소가 서로 다르기 때문에 메시지가 출력될 것이다.
		if (p1==p2)
			System.out.println("p1과 p2는 같은 사람입니다.");
		else
			System.out.println("p1과 p2는 다른 사람입니다."); 
		
		// 두 객체는 서로 다르지만 인스턴스 변수 id가 같아서 equals()의 오버라이딩 된 정의에 의해 equals()는 true를 반환한다
		if (p1.equals(p2))
			System.out.println("p1과 p2는 같은 사람입니다.");
		else
			System.out.println("p1과 p2는 다른 사람입니다."); 
	}
}
