
public class PrintEx {

	/* Java의 정석 기초편 p.46~p.47 학습 내용 정리 및 연습
	 * https://kutsulab.tistory.com/8
	 * 
	 * [화면에 원하는 내용 출력하기 - print(), println()]
	 * 1. System.out.println() 메서드는 ()안의 내용을 출력하고 줄바꿈을 행한다.
	 * 2. System.out.print() 메서드는 ()안의 내용을 출력하고  줄바꿈을 행하지 않는다.
	 * 
	 * [print()메서드들을 통한 숫자 및 사칙연산의 출력]
	 * 1. print() 메서드들은 숫자 데이터들을 출력해주기도 한다.
	 * 2. print() 메서드들은 숫자들의 간단한 사칙연산을 수행한 뒤 출력해준다.
	 * 3. ""로 감싸진 숫자, 수식 등은 문자열로 인식된다.
	 */
	
	public static void main(String[] args) {

		System.out.print("캬루 : (사장실의 문을 열면서 난동을 부린다.) 네놈들 회사는 이제 망했어! ");
		// System.out.print() : 문자열을 출력하고 줄바꿈을 행하지 않는다.
		System.out.println("여긴 이제 캬루가 지배한다!");
		// System.out.println() : 문자열을 출력하고 줄바꿈을 행한다.
		
		System.out.print("사장 : (캬루를 두들겨 때리면서) ");
		System.out.println("캬루 또 너야?");
		
		System.out.println(65535); // 숫자를 입력하면 숫자가 그대로 출력된다.
		
		System.out.println(3+3); // 숫자들의 간단한 사칙연산의 결과를 출력해준다.
		System.out.println(5-2);
		System.out.println(2*9);
		System.out.println(10/2);
		
		System.out.println("3+3"); // 큰 따옴표 "" 안에 들어간 것들은 문자열로 인식한다.
		System.out.println("5-2");
		System.out.println("2*9");		
		System.out.println("10/2");
	}

}