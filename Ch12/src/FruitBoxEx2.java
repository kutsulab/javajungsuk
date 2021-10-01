
import java.util.*;

	/* Java의 정석 3판 p.677 예제 12-2
	 * 
	 * [지네릭클래스의 매개변수화 타입(parameterized type) 제한]
	 * 
	 *  - 지네릭 클래스를 작성할 때
	 *      <T extends Asdf>와 같이, 작성하면 Asdf 클래스와, 그 자손들만 매개변수화 할 수 있게 제한 가능
	 *  - 어떤 인터페이스를 구현한다는 제한이 필요할 때도 extends로 작성
	 *  - 여러 인터페이스, 클래스를  상속한 객체로 제한하고 싶을 때
	 * 
	 *  (예) 
	 *   - class FruitBox <T> => 모든 타입의 객체를 매개변수화 할 수 있는 지네릭 클래스
	 *   - class FruitBox <T extends Fruit> => Fruit 또는 그 자손만을 매개변수화 할 수 있는 지네릭 클래스
	 */

interface Eatable {}

class Fruit2 implements Eatable {
	@Override
	public String toString() { // 객체 호출 시 클래스 타입을 문자열로 반환
		return this.getClass().getName();
	}
}

class Apple2 extends Fruit2 {}
class Grape2 extends Fruit2 {}

class Toy2 {
	@Override
	public String toString() {
		return this.getClass().getName();
	}
}

class Box2 <T> {
	ArrayList<T> list = new ArrayList<>();
	
	void add(T item) { // list에 객체 추가
		list.add(item);
		return;
		}
	
	T get(int index) {return list.get(index);} // list의 index에 저장된 객체 반환
	
	int size() {// list의 size 반환
		return list.size();
	}
	
	@Override
	public String toString() { //list의 모든 요소들에 접근하여 [ , , ... ] 으로 반환
		return list.toString();
	}
}

class FruitBox2 <T extends Fruit2> extends Box2<T> {
	// Fruit2 및 그 자손만을 매개변수화 할 수 있는 지네릭클래스
}

public class FruitBoxEx2 {

	public static void main(String[] args) {
		
		FruitBox2<Fruit2> fruitBox = new FruitBox2<Fruit2>();
		FruitBox2<Apple2> appleBox = new FruitBox2<Apple2>(); 
		FruitBox2<Grape2> grapeBox = new FruitBox2<Grape2>(); 
		
		// FruitBox2<Grape2> fruitBox = new FruitBox2<Apple2>(); // 매개변수화된 타입이 일치하지 않음
		
		// FruitBox2<Toy2> box1 = new FruitBox2<>();
		// -> 컴파일 에러
		// -> FruitBox2 클래스에서, 매개변수화할 수 있는 타입의 종류를 Fruit2와 그 자손으로 제한을 둠
		// -> Toy2를 매개변수화 할 수 없다.
		
		fruitBox.add(new Apple2()); // Apple2 객체를 Fruit2 타입으로 저장
		fruitBox.add(new Grape2()); // Grape2 객체를 Fruit2 타입으로 저장
		
		appleBox.add(new Apple2()); // Apple2 객체를 Apple2 타입으로 저장
		// appleBox.add(new Grape2()); // 매개변수화 된 타입이 Apple2임. -> 다른 타입을 저장할 수 없음
		
		grapeBox.add(new Grape2()); // Grape2 객체를 Grape2 타입으로 저장
		
		System.out.println("fruitBox = "+fruitBox);
		System.out.println("appleBox = "+appleBox);
		System.out.println("grapeBox = "+grapeBox);
	}

}
