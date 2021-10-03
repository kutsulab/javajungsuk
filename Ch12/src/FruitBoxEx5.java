
import java.util.*;

/* Java의 정석 3판 p.687 : 지네릭 타입의 형변환
 * 
 * [지네릭타입 <-> 원시타입]
 *  - 지네릭타입이 적용된 객체를 원시타입으로 형변환 가능.
 *   : 가능은 하지만, 경고 발생. 지네릭이 적용된 클래스는 지네릭 타입을 적용하자!
 *  - 원시타입이 적용된 객체를 지네릭 타입으로 형변환 가능.
 *   : 가능은 하지만, 경고 발생. 타입안정성이 보장되지 못 함.
 *   : 처음부터 지네릭 타입을 적용하자.
 *  
 * [매개변수화 타입이 다른 객체간의 형변환]
 *  : 불가능
 *  
 * [다형성에 의한 형변환]
 *  
 *  Box<? extends Object> strBox = new Box<String>();
 *  // 와일드카드가 적용된 변수로 형변환 가능
 *  
 *  Box<String> strBox2 = (Box<String>)strBox;
 *  // 와일드카드가 적용된 변수가 가리키는 객체를 역으로 형변환할 수 있지만, 타입안정성이 보장받지 못 하여 경고가 발생함
 *  
 */

public class FruitBoxEx5 {
	
	public static void main(String[] args) {
		Box5 box = null; //
		Box5<Object> objBox = null;
		
		box = (Box5)objBox; // 지네릭 타입을 원시타입으로 형변환. 가능은 하지만 경고 발생
		objBox = (Box5<Object>)box; // 원시 타입을 지네릭타입으로 형변환. 가능은 하지만 경고 발생
		
		objBox = null; // Box<Object>
		Box5<String> strBox = null;
		
		//objBox = (Box5<Object>)strBox; //Box<String>을 Box<Object>로 형변환 시도. 컴파일 에러 발생(형변환 불가능)
		//strBox = (Box5<String>)objBox; //Box<Object>을 Box<String>으로 형변환 시도. 컴파일 에러 발생(형변환 불가능)
		
		FruitBox5<? extends Fruit5> fruitBox = new FruitBox5<Fruit5>();
		// FruitBox5<? extends Fruit5> fruitBox = (FruitBox5<? extends Fruit5>) new FruitBox5<Fruit5>();
		// 형변환이 생략됨
		
		FruitBox5<? extends Fruit5> appleBox = new FruitBox5<Apple5>();
		// FruitBox5<? extends Fruit5> appleBox = (FruitBox5<? extends Fruit5>) new FruitBox5<apple5>();
		// 형변환이 생략됨.
		
		FruitBox5<Apple5> appleBox2 = (FruitBox5<Apple5>) appleBox;
		//FruitBox5<? extends Fruit5>을 FruitBox5<Apple5>로 형변환 가능
		//가능은 하지만 경고 발생. 와일드카드가 적용된 참조변수에 맞게 캐스팅했던 객체를 다시 형변환하는 것에서 타입 불안정성이 발생할 수 있기 때문
		
	}
}


class Fruit5 {
	String name; // 과일의 이름
	int weight; //과일의 무게
	
	Fruit5 (String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%dg)",name,weight); //이름(무게)로 형식화해서 반환
	}
}

class Apple5 extends Fruit5 {
	Apple5(String name, int weight) {
		super(name, weight);
	}
}

class Grape5 extends Fruit5 {
	Grape5(String name, int weight) {
		super(name, weight);
	}
}



class Box5<T> {
	ArrayList<T> list = new ArrayList<T>(); // T 타입 객체들을 저장할 ArrayList
	
	void add(T item) {
		list.add(item);
		return;
	}
	
	T get(int i) {
		return list.get(i);
	}
	
	ArrayList<T> getList() { //list를 반환
		return list;
	}
	
	int size() {
		return list.size();
	}
	
	public String toString() {
		return list.toString();
	}
}

class FruitBox5<T extends Fruit5> extends Box5<T> { // Fruit5와 그 자손만을 매개변수화 타입으로 지정
}


 