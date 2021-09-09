
	/* 자바의 정석 3판 p.463 예제 9-10
	 * 
	 * 1. Class 클래스 : 클래스명이 Class!
	 * - public final class Class 
	 * - 클래스의 모든 정보를 담고 있고, 해당 정보들을 얻을 수 있는 많은 수의 메서드가 정의되어 있다.
	 * - 각 클래스마다 Class 객체는 하나 존재!
	 * - 파일 형태로 저장되어있는 .class 파일을 읽어서 classLoader에 의해 메모리에 올라갈 때 자동으로 Class 객체가 생성됨
	 * 
	 * 2. Class 객체 호출
	 * getClass() 메서드를 이용하면 해당 인스턴스의 클래스에 해당하는 Class 객체를 가져올 수 있다.
	 * 참조변수.class를 이용하거나, Class.forName(클래스명)을 통해 클래스 객체를 호출 가능함
	 * 
	 * 3. Class 인스턴스를 통해 객체 생성
	 *  - 보통 객체를 생성할 때는 new + 생성자 를 통하여 객체를 생성함
	 *  - Class 인스턴스를 통해 객체를 생성할 수도 있다.
	 *   클래스명.class.newInstance(); 와 같이,
	 *   클래스 인스턴스를 통해 newInstance() 메서드를 사용해 새 객체를 만들 수 있음.
	 *   단, 이 방식은 InstantiationException 이 발생하므로 별도로 예외처리를 해야함
	 * 
	 * 4. Class 인스턴스로부터 정보 얻기
	 *  - 클래스인스턴스.getName() : 클래스명 얻기
	 *  - 클래스인스턴스.gettoGenericString() : 제어자, 반환타입(class), 클래스명을 반환
	 *  - 클래스인스턴스.toString() : 반환타입(class), 클래스명을 반환
	 */

public class ClassEx1 {

	public static void main(String[] args) {
		Card3 c = new Card3("HEART",3); // new 연산자를 통한 객체 생성
		Card3 c2 = null;
		
		try {
			c2 = Card3.class.newInstance(); // class.newInstance()를 통하여 객체 생성.
			//Instantiation Exception, IllegalAccessException에 대한 예외처리가 필요함
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		
		// Class 클래스 : 클래스의 정보를 인스턴스변수로 가짐. 클래스의 정보를 얻을 수 있는 여러 메서드가 정의됨.
		Class cObj = c.getClass(); // c가 가리키는 인스턴스의 Class 객체를 생성
		
		System.out.println(c);
		System.out.println(c2);
		System.out.println(cObj.getName()); // 클래스 이름을 문자열로 반환함
		System.out.println(cObj.toGenericString()); // 제어자와 매개변수 타입을 포함하여 클래스 이름을 문자열로 반환함
		
		/* toGenericString()은 뭐지?
		 * 
		 *  : 해당 클래스의 제어자, 매개변수 타입(여기서는 class인 듯?)을 포함한 정보를 문자열로 반환한다
		 *  (cf) 잘 몰라서 구글링했음. 영어 못 해서 좀 틀릴 수 있으니 영잘알 컴잘알 고수 여러분 여러분 제보 부탁드림;;
		 *  
		 * public String toGenericString() : 인스턴스 메서드고, 반환타입은 String이군!
		 * 
		 * The toGenericString() method of java.lang.Class class 
		 *  역 ) toGenericString() 메서드 (어떤 메서드냐면 java.lang.Class 클래스의)는
		 *  
		 *  is used to convert the instance of this Class
		 *  역 ) 사용된다 / 바꾸는데 / 이 클래스의 인스턴스를
		 *  
		 *   to a string representation
		 *  역) string 표현으로
		 *  
		 *  along with the information about the modifiers and type parameters.
		 *  역) 정보를 덧붙인 / modifier(제어자)와 매개변수 타입에 관한
		 *  
		 * This method returns the formed string representation.
		 * 역) 이 메서드는 반환한다 / 형성된 String 표현을
		 * 
		 */
		
		System.out.println(cObj.toString()); // 매개변수 타입(class)과 클래스명을 문자열로 반환함 
	}

}

final class Card3 {
	 final String[] KINDLIST = {"SPADE", "CLOVER", "DIAMOND", "HEART"};
	 String kind; // 인스턴스 변수
	 int number;
	 
	 @Override // kind와 number를 출력하도록 오버라이드
	 public String toString() {
		 return "kind : "+ kind +", number : "+number;
	 }
	 
	 // 기본 생성자 : 임의의 카드 종류, 임의의 숫자로 초기화
	 Card3() {
		 this.kind = KINDLIST[(int)(Math.random()*KINDLIST.length)];
		 this.number = (int)(Math.random() * 10) + 1;
	 }
	 
	 // 매개변수가 있는 생성자 : 카드 종류, 숫자를 초기화
	 Card3 (String kind, int number) {
		 this();
		 if (!(isValid(kind,number))) return;
		 
		 this.kind = kind;
		 this.number = number;
		 return;
	 }
	 
	 private boolean isValid(String kind, int number) {
		 boolean valid = true;
		 
		 if (!(isValidKind(kind))) {
			 System.out.println("종류 에러!");
			 valid = false; 
		 }
		 
		 if (!(isValidNumber(number))) {
			 System.out.println("숫자 에러!");
			 valid = false;
		 }
		 
		 if (!valid)
			 System.out.println
			 ("매개변수로 입력한 종류와 숫자가 정해진 범위를 벗어났으므로, 무작위로 카드를 뽑습니다.");
		
		 return valid;
	 }
	 
	 private boolean isValidNumber(int number) {
		 boolean isValid = false;
		 if (1<=number&&number<=10) isValid = true;
		 return isValid;
	 }
	 
	 private boolean isValidKind(String kind) {
		 boolean isValid = false;
		 for (int i=0; i < KINDLIST.length; i++ ) {
			 if (kind.equals(KINDLIST[i])) isValid = true; 
		 }
		 return isValid;
	 }
	 
} 