
public class NoHello {
	
	/* Java의 정석 p.8 예제 1-1
	 * 
	 * System.out.println() 메서드는 ()안의 문자열을 출력하고 줄바꿈을 행한다.
	 * 
	 * 기본형 데이터들은 자동으로 문자열로 변환해서 출력한다.
	 * 객체를 ()안에 매개변수로 넣을 경우 자동으로 toString() 메서드를 호출하여 결과값을 출력한다.
	 * '+'를 통해 여러 문자열들을 결합해서 새로운 문자열 인스턴스를 생성하고 그 문자열을 화면에 출력해준다.
	 */
	
	public static void main(String[] args) {
		System.out.println("NoHello"); // 문자열 "NoHello"를 출력하는 메서드
	}
}