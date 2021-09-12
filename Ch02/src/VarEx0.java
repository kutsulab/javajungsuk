
public class VarEx0 {
	/* Java의 정석 3판 p.20 내용 정리 : 변수의 선언과 초기화
	 * https://kutsulab.tistory.com/9
	 * 
	 * [변수]
	 * 단 하나의 데이터를 저장할 수 있는 메모리 공간
	 * 
	 * [변수의 선언]
	 * 저장하는 데이터에 맞는 변수를 설정해야하고, 그 변수를 어떤 이름으로 사용할 것인지 설정해야함.
	 * 변수타입 변수 이름;
	 * 예) int age; (int 타입의 변수 age 선언)
	 * 
	 * [변수의 초기화]
	 * 메모리는 여러 프로그램이 공유하는 자원이므로 다른 프로그램에 읭해 저장된 알 수 없는 값이 남아있을 수 있다.
	 * 변수를 사용하기 전에 변수에 적절한 값을 처음으로 저장해주는 작업을 해줘야 변수를 사용할 수 있다.
	 * 변수를 사용하기 전에 처음으로 값을 저장하는 것을 '변수의 초기화'라고 한다.
	 * 
	 *  - 사용 방법
	 * 		1) 변수 선언 -> 변수 초기화
	 *         (예) int age;
	 *             age = 14;
	 *             
	 *        * 대입연산자 '=' : 우변의 데이터를 좌변의 변수에 저장
	 *             
	 * 	    2) 변수 선언과 초기화를 동시에 하기
	 *         (예) int age = 14;
	 *         
	 *      3) 같은 타입의 변수 여러개 선언 및 초기화
	 *         (예) int x = 7, y = 8; (int 타입의 변수 x에 7 저장, y에 8 저장)
	 *         
	 * [선언 위치에 따른 변수의 종류]
	 *  1. 클래스 변수 : 클래스 영역(메서드 바깥)에 선언된 변수
	 *       - static 변수 (객체를 생성하지 않고 사용할 수 있음.) : 클래스가 메모리에 올라갈 때 자동으로 초기화
	 *       - 인스턴스 변수 (객체를 생성해야 사용할 수 있음.) : 객체가 생성될 때 자동 초기화
	 *       
	 *  2. 지역 변수 : 메서드 영역(메서드 안)에 선언된 변수.
	 *              자동으로 초기화되지 않기 때문에 수동으로 초기화 코드를 작성해야 호출해서 사용할 수 있다.
	 * 
	 */
	
	// 출력하는 메서드를 분리
	private static void printKorAge(String name, int birthYear, int thisYear) {
		System.out.println("=======================================");
		System.out.println(name+"의 출생년도는 "+birthYear+"년이고 올 해는 "+thisYear+"년이다.");
		System.out.println("한국식 나이는 (올해의 연도 - 출생년도 + 1)로 계산된다.");
		System.out.print("이를 토대로 한국식 나이를 계산해보면, ");
		System.out.println(name+"의 한국식 나이는 "+getKorAge(birthYear,thisYear)+"세이다.");
		System.out.println("=======================================");
		return;
	}
	
	// 나이를 구하는 메서드를 따로 분리
	private static int getKorAge(int birthYear, int thisYear) { 
		int korAge = thisYear - birthYear + 1;
		return korAge;
	}
	

	public static void main(String[] args) {
		
		printKorAge("철수",1996,2021); // 이름, 출생년도, 올해 연도를 매개변수로 하여 한국식 나이를 계산, 출력해줌.
		printKorAge("영희",1991,2022);
		
	}

}
