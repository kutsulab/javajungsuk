
public class CardToString {
	/* 자바의 정석 3판 p.454 예제 9-4
	 * 
	 * toString() 메서드는 인스턴스의 클래스명, 16진수화 된 해시코드를 반환한다.
	 */
	
	public static void main(String[] args) {
		
		System.out.println("c1을 뽑습니다.");
		Card c1 = new Card(); // Card 인스턴스 생성
		System.out.println(c1+"\n");
		System.out.println("c2를 뽑습니다.");
		Card c2 = new Card(); // Card 인스턴스 생성
		System.out.println(c2+"\n");

		System.out.println("c3를 뽑습니다.");
		Card c3 = new Card("CLOVER", 7); // 매개변수 생성자를 통하여 Card 인스턴스 생성
		System.out.println(c3+"\n");
		
		System.out.println("c4를 뽑습니다.");
		Card c4 = new Card("FLOWER", 200); // 범위에서 벗어난 값을 생성자의 매개변수로 입력
		System.out.println(c4+"\n");

	}

}

class Card {
	 final String[] KINDLIST = {"SPADE", "CLOVER", "DIAMOND", "HEART"};
	 String kind; // 인스턴스 변수
	 int number;
	 
	 @Override // kind와 number를 출력하도록 오버라이드
	 public String toString() {
		 return "kind : "+ kind +", number : "+number;
	 }
	 
	 // 기본 생성자 : 임의의 카드 종류, 임의의 숫자로 초기화
	 Card() {
		 this.kind = KINDLIST[(int)(Math.random()*KINDLIST.length)];
		 this.number = (int)(Math.random() * 10) + 1;
	 }
	 
	 // 매개변수가 있는 생성자 : 카드 종류, 숫자를 초기화
	 Card (String kind, int number) {
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