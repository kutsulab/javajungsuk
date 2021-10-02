
import java.util.*;

/* Java의 정석 3판 p.681 예제 12-4
 * 
 * [와일드 카드 : <? super T>]
 *  사용하는 지네릭 참조변수의 매개변수화 타입을 T 또는 그 조상으로 제한함.
 * 
 * [예시]
 * - Collections.sort() 메서드는
 *   public static <T> void sort(List<T> list, Comparator<? super T> comp) {...} 으로 정의 됨
 * 
 * - HashSet, HashMap 의 생성자 HashSet/HashMap(Comparator<? super T>)
 * 
 */


class Fruit4 {
	String name; // 과일의 이름
	int weight; //과일의 무게
	
	Fruit4 (String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%dg)",name,weight); //이름(무게)로 형식화해서 반환
	}
}

class Apple4 extends Fruit4 {
	Apple4(String name, int weight) {
		super(name, weight);
	}
}

class Grape4 extends Fruit4 {
	Grape4(String name, int weight) {
		super(name, weight);
	}
}

class FruitComp4 implements Comparator<Fruit4> {
	@Override
	public int compare(Fruit4 f1, Fruit4 f2) {
		return f1.weight - f2.weight; // 무게를 오름차순으로 정렬
	}
}

class AppleComp4 implements Comparator<Apple4> {
	
	@Override
	public int compare(Apple4 a1, Apple4 a2) {
		return a2.weight - a1.weight; // 무게를 내림차순으로 정렬
	}
}

class GrapeComp4 implements Comparator<Grape4> {
	
	@Override
	public int compare(Grape4 g1, Grape4 g2) {
		return g2.weight - g1.weight; //무게를 내림차순으로 정렬
	}
}

class Box4<T> {
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

class FruitBox4<T extends Fruit4> extends Box4<T> { // Fruit4와 그 자손만을 매개변수화 타입으로 지정
}

public class FruitBoxEx4 {
	
	public static void main(String[] args) {
		FruitBox4<Apple4> appleBox = new FruitBox4<Apple4>();
		FruitBox4<Grape4> grapeBox = new FruitBox4<Grape4>();
		
		appleBox.add(new Apple4("RedApple",300));
		appleBox.add(new Apple4("GreenApple",100));
		appleBox.add(new Apple4("badApple",200));
		
		grapeBox.add(new Grape4("purpleGrape", 400));
		grapeBox.add(new Grape4("GreenGrape", 300));
		grapeBox.add(new Grape4("GoodGrape", 200));
		
		
		System.out.println("===== 내림차순 정렬 =====");
		Collections.sort(appleBox.getList(), new AppleComp4());// list를 가져와서 내림차순 정렬
		Collections.sort(grapeBox.getList(), new GrapeComp4()); 
		
		System.out.println("appleBox : "+appleBox);
		System.out.println("grapeBox : "+grapeBox);
		
		System.out.println();

		/*
		 *   public static <T> void sort(List<T> list, Comparator<? super T> c) {
        		list.sort(c);
    		 }
    		 
    	 	- 만약 sort메서드가 Comparator<T>를 매개변수로 했을 경우, Comparator<T>를 구현한 객체만을 매개변수로 사용해야함
    		- 예를 들어 위에서는 비교를 하기 위해 AppleComp4는 Comparator<Apple4>를 구현했고, GrapeComp4는 Comparator<Grape4>를 구현함.
    		- 이와 같은 방식으로 작성하면 과일 클래스의 종류가 늘어날 때마다 Comparator<T> 구현 클래스를 매번 새로 작성해야하는 문제점이 발생함
		 */
		System.out.println("===== 오름차순 정렬 =====");
		Collections.sort(appleBox.getList(), new FruitComp4()); // 오름차순 정렬
		Collections.sort(grapeBox.getList(), new FruitComp4());
		
		/*
		 * 다행히 Collections.sort메서드는 Comparator<? super T>를 구현한 객체를 매개변수로 삼음
		 * 따라서, appleBox.getList()의 매개변수화 타입 Apple4를 기준으로 생각하면
		 * 비교 Comparator 구현체의 매개변수화 타입을 Apple4 또는 Apple4의 조상으로 지정할 수 있게 됨
		 * 
		 * Comparator<Apple4>, Comparator<Fruit4>, Comparator<Object>를 매개변수로 삼을 수 있게됨.
		 * 매번 과일 클래스 각각의 정렬기준이 되는 Comparator 구현체를 새로 만들 필요 없이,
		 * Comparator<Fruit4>의 구현체를 한 두개 만들어서, 이것만을 이용해 모든 과일클래스에 대해 정렬할 수 있게 됨.
		 * 
		 */
		
		System.out.println("appleBox : "+appleBox);
		System.out.println("grapeBox : "+grapeBox);
	}
}
