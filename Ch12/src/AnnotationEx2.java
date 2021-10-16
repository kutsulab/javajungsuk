
	/* ========================================================================
	 *  Java의 정석 3판 p.705 예제 12-10
	 * 
	 * [애너테이션]
	 * 
	 *  1. 애너테이션
	 *   주석처럼, 프로그래밍에 영향을 미치지 않으면서 다른 특정 프로그램에 정보를 전달하기 위한 표식
	 *   (정보 제공, 설정 제공 등...)
	 *   
	 *  2. 표준 애너테이션 : JDK를 통해 기본으로 제공되는 애너테이션
	 *   - @Override : 컴파일러에게 이 다음에 오는 메서드는 오버라이딩 된 메서드라는 것을 알린다.
	 *   - @Deprecated : 앞으로 사용하지 않을 것을 권장하는 대상에 붙인다.
	 *   
	 * ========================================================================  
	 */

class NewClass {
	int newField;
	int getNewField() {return newField;}
	
	@Deprecated
	int oldField;
	
	@Deprecated
	int getOldField() {return oldField;}
}


public class AnnotationEx2 {

	public static void main(String[] args) {
		NewClass nc = new NewClass();
		nc.oldField = 10;
		// Eclipse 기준 취소선 발생 : javac.exe를 통해 컴파일 시 경고 메시지가 발생한다.
		// javac.exe 컴파일 시 -Xlint:deprecation 옵션을 붙여서 컴파일 시 자세한 내역을 볼 수 있다.
		// 에러는 아님.
		
		System.out.println(nc.getOldField());
		
	}

}
