
import java.util.*;

	/* Java의 정석 3판 p.680 예제 12-3
	 * 
	 * [와일드 카드]
	 * 하나의 지네릭 참조변수로 매개변수화된 타입이 다른 객체들을 가리킬 수 있게 함
	 * 
	 * <? extends T> : 지네릭 참조변수가 다룰 수 있는 지네릭 클래스 객체의 타입변수 상한을 T로 지정. T와 그 자손
	 * <? super T> : 지네릭 참조변수가 다룰 수 있는  지네릭 클랙스 객체의 타입변수 하한을 T로 지정. T와 그 조상
	 * <?> : 지네릭 클래스 객체의 상하한 없음. <? extends Object>와 동일
	 * 
	 * [예시]
	 * - ArrayList<Tv> list = new ArrayList<Tv>(); // Ok
	 *  : 참조변수 list를 선언할 때, 이 참조변수는 ArrayList<Tv>를 참조한다고 선언함.
	 *  
	 * - ArrayList<Product> list = new ArrayList<Tv>(); // No
	 *  : 참조변수 list를 선언할 때 이 참조변수는 ArrayList<Product>를 참조한다고 선언함.
	 *  : ArrayList<Tv> 타입은 참조할 수 없음.
	 * 
	 * - ArrayList<? extends Product> list = new ArrayList<Tv>(); OK 
	 *   : 참조변수를 선언할 때, 이 참조변수는 Product 또는 그 자손을 매개변수화 타입으로 한 ArrayList를 참조한다고 선언함.
	 * 
	 * - static Juice makeJuice(FruitBox3<? extends Fruit3> box)
	 *  : 이 메서드는 매개변수화 타입이 Fruit3 또는 그 자손인 FruitBox3 타입의 객체만을 참조한다.
	 * 
	 * 
	 * [헷갈리는 부분]
	 *  - <T extends ~Class> 는 클래스 선언부에서 사용하여 매개변수화 타입을 제한한다.
	 *  - 와일드 카드는 (예 : <? extends T>) 는 참조변수 선언시 참조할 수 있는 지네릭 객체의 매개변수화 타입의 범위를 정한다.
	 *  
	 *  - Class FruitBox <T extends Fruit> extends Box<T>
	 *   : 이 클래스는 Fruit 또는 그 자손을 매개변수화 타입으로 할 수 있고, Box<T>를 상속받았다.
	 *      : new FruitBox<Fruit>(); (O), new FruitBox<Apple>() (O), new FruitBox<Toy>() (X)
 	 *  
	 */

class Fruit3 {
	@Override
	public String toString() { // 객체를 toString 호출 시 클래스명 반환
		return this.getClass().getName();
	}
}

class Apple3 extends Fruit3 {}
class Grape3 extends Fruit3 {}

class Toy3 {
	@Override
	public String toString() {
		return this.getClass().getName();
	}
}

class Box3<T> { // 지네릭 클래스
	List<T> list = new ArrayList<T>();
	void add(T item) { // 객체 추가
		list.add(item);
		return;
	}
	
	List<T> getList() { //List<T>로 list 반환
		return list;
	}
	
	T get(int i) { // i 인덱스에 위치한 객체 반환 
		return list.get(i);
	}
	int size() { // 저장한 객체 반환
		return list.size();
	}
	public String toString() { // toString 호출 시 list.toString()을 반환 
		return list.toString();
	}
}

class FruitBox3<T extends Fruit3> extends Box3<T> {}
	//Fruit3 및 Fruit3을 상속받은 객체들만을 매개변수화 할 수 있음

class Juice {
	String name; // 생성자로 받은 이름 + "juice"
	
	Juice (String name) { // 생성자로 받은 과일의 이름 뒤에 juice를 붙여서 저장
		this.name = name+"juice";
	}
	
	@Override
	public String toString() {
		return name;
	}
}

class Juicer {
	static Juice makeJuice(FruitBox3<? extends Fruit3> box) {
		// 와일드카드 사용 -> 참조하는 지네릭 클래스 객체의 매개변수화 타입 범위 설정
		// FruitBox3<Fruit3> (O) , FruitBox3<Apple3> (O), FruitBox3<Grape3> (O)
		
		StringBuffer tmp = new StringBuffer("");
		
		for (Fruit3 f : box.getList() ) {
			// 향상된 for문 : for( 타입변수명 : 배열 또는 컬렉션) -> 지정 배열, 컬렉션의 요소에 하나씩 접근 (읽기만 가능)
			tmp.append(f).append(" "); // 문자열+" "을 tmp에 덧붙여라.
		}
		
		return new Juice(tmp.toString());
	}
	
		
}

public class FruitBoxEx3 {

	public static void main(String[] args) {
		
		//FruitBox3<Toy3> toyBox = new FruitBox3<Toy3>();
		//FruitBox3은 Fruit3 및 Fruit3을 상속받은 객체들만 저장할 수 있도록 제한됨
		
		FruitBox3<Fruit3> fruitBox = new FruitBox3<Fruit3>();
		FruitBox3<Apple3> appleBox = new FruitBox3<Apple3>(); // Apple3 타입으로만 저장할 수 있는 FruitBox3
		FruitBox3<Grape3> grapeBox = new FruitBox3<Grape3>();
		
		fruitBox.add(new Apple3());
		fruitBox.add(new Grape3());
		appleBox.add(new Apple3());
		grapeBox.add(new Grape3());
		
		System.out.println(Juicer.makeJuice(fruitBox));
		System.out.println(Juicer.makeJuice(appleBox));
		System.out.println(Juicer.makeJuice(grapeBox));
		
	}

}
