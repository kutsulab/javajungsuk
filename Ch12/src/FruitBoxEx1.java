
import java.util.*;

	/* Java의 정석 3판 p.675 예제 12-1 : 지네릭 타입과 다형성
	 * 
	 * [지네릭 타입과 다형성]
	 *  - 참조변수와 생성자의 대입된 타입은 일치해야한다.
	 *   예) ArrayList<Tv> tvList = new ArrayList<Tv>();
	 *   예) ArrayList<Product> productList = new ArrayList<Product>();
	 *   예) Box<Apple> appleBox = new Box<Apple>();
	 *   
	 *  - 지네릭 클래스 간의 다형성은 성립(여전히 대입된 타입은 일치해야한다.)
	 *   예) List<Tv> tvList = new ArrayList<Tv>();
	 *   예) List<Product> productList = new LinkedList<Product>();
	 *   예) Box<Apple> appleBox = new FruitBox<Apple>(); (여기서 FruitBox는 Box를 상속받았다 가정)
	 *   
	 *  - 매개변수의 다형성도 성립. 가리키는 객체는 불변!
	 *   예) ArrayList<Product> productList = new ArrayList<Product>(); 
	 *       list.add(new Tv()); // Tv는 Product를 상속받음 -> Product로 형변환되어 저장됨
	 *       list.add(new Audio()); // Audio는 Product를 상속받음 -> Product로 형변환되어 저장됨
	 *       
	 */

class Fruit {
	
	@Override
	public String toString() {
		return this.getClass().getName(); // 클래스명을 반환. 자손 클래스들도 자동으로 자신의 클래스명을 반환하도록 함
	}
	
}

class Apple extends Fruit {}
class Grape extends Fruit {}

class Toy {
	@Override
	public String toString() {
		return this.getClass().getName();
	}
} 

class Box<T> {
	ArrayList<T> list = new ArrayList<T>(); // 인스턴스 변수로 사용된 ArrayList
	
	void add(T item) {list.add(item);} // list에 T 타입으로 객체를 저장
	T get(int index) {return list.get(index);} // list의 지정 index에 저장된 객체를 반환
	
	int size() {return list.size();} // list 저장 객체 수 반환
	public String toString() {return list.toString();} // list에 저장된 객체들을 나열해서 반환
}

public class FruitBoxEx1 {

	public static void main(String[] args) {
		
		Box<Fruit> fruitBox = new Box<Fruit>();
		Box<Apple> appleBox = new Box<Apple>();
		Box<Toy> toyBox = new Box<Toy>();
		Box<Grape> grapeBox = new Box<Grape>();
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple()); // OK. Apple 객체가 Fruit로 형변환되서 저장.
		System.out.println(fruitBox);
		
		appleBox.add(new Apple());
		appleBox.add(new Apple());
		//appleBox.add(new Toy()); // 컴파일 에러. appleBox의 지네릭타입은 Apple. Apple만 담을 수 있다.
		System.out.println(appleBox);
		
		toyBox.add(new Toy());
		//toyBox.add(new Apple()); // 컴파일 에러. toyBox의 지네릭타입은 Toy. Toy만 담을 수 있다.
		System.out.println(toyBox);
		
	}

}
