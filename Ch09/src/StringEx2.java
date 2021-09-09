
public class StringEx2 {
	
	/* 자바의 정석 3판 p.466 예제 9-12
	 * 클래스 내의 문자열 리터럴은 컴파일 시 class파일의 리터럴 목록에 따로 저장되고,
	 * 해당 클래스가 클래스로더에 의해서 메모리에 올라갈 때 JVM의 상수 저장소(constant pool)에 저장된다.
	 */
	public static void main(String[] args) {
		String s1 = "AAA"; //문자열리터럴 AAA, BBB가 컴파일 시 class파일에 저장된다.
		String s2 = "AAA";
		String s3 = "AAA";
		String s4 = "BBB";
		// 16진수 코드에디터로 해당 클래스 파일을 열었을 경우 문자열 AAA, BBB가 보임
		// 41 41 41, 42 42 42 이렇게.
	}

}
