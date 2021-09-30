
import java.util.*;

public class GenericTest2 {

	/* Java의 정석 기초편 p.463 예제 12-1
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
	
	private static void printAll(ArrayList<Product> list) {
		// Product타입을 저장한 ArrayList만 메서드의 인수로 사용 가능
		
		for (Product p : list) { //list에 속한 각 객체들에 접근
			System.out.println(p);
		}
	}
	
	
	public static void main(String[] args) {
		ArrayList<Product> productList = new ArrayList<Product>();
		ArrayList<Tv> tvList = new ArrayList<Tv>();
		// ArrayList<Product> tvList = new ArrayList<Tv>(); //타입 매개변수 타입(대입된 타입) 이 일치해야함
		// List<Tv> = new ArrayList<Tv>(); // 다형성에 의해 OK
		
		productList.add(new Tv()); // Tv 객체를 Product로 형변환하여 저장
		
		/* public boolean add(E e) {}
		 *  -> 지네릭 타입이 Product이므로
		 *  -> public boolean add(Product e) {}
		 */
		
		productList.add(new Audio()); // Audio 객체를 Product로 형변환하여 저장
		
		tvList.add(new Tv()); // Tv 객체 저장
		
		/* public boolean add(E e) {}
		 *  -> 지네릭 타입이 Tv이므로
		 *  -> public boolean add(Tv e) {} 
		 */
		
		tvList.add(new Tv());
		
		printAll(productList);
		//printAll(tvList); printAll 메서드는 지네릭 타입이 Product인 ArrayList만을 매개변수로 가지므로 컴파일 에러
		
		Tv t0 = (Tv) productList.get(0); // productList에서 본래 객체 타입인 Tv로 꺼내올 때는 Product가 반환되므로 Tv로 다시 형변환해야한다.
		Product t1 = productList.get(1); // productList에서 Tv 객체를 꺼내올 때, Product 타입으로 꺼내올 때는 별도로 형변환할 필요가 없다.
		
		System.out.println(t0);
		System.out.println(t1);
	}
}

class Product {}
class Tv extends Product {}
class Audio extends Product {};