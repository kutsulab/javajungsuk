public class CardToString {
	/* 자바의 정석 3판 p.454 예제 9-4
	 * 
	 * toString() 메서드는 인스턴스의 클래스명, 16진수화 된 해시코드를 반환한다.
	 */

	public static void main(String[] args) {
		Card c1 = new Card(); // Card 인스턴스 생성
		Card c2 = new Card(); // Card 인스턴스 생성

		System.out.println(c1); //Card@15db9742 : 클래스명 + @ + 인스턴스 고유의 16진수 해시코드
		System.out.println(c2); //Card@6d06d69c

	}

}

class Card {

	 String kind; // 인스턴스 변수
	 int number;

	 // 기본 생성자 : SPADE, 1로 초기화
	 Card() {
		 this ("SPADE", 1);
	 }

	 // 매개변수가 있는 생성자 : 카드 종류, 숫자를 초기화
	 Card (String kind, int number) {
		 this.kind = kind;
		 this.number = number;
	 }
}