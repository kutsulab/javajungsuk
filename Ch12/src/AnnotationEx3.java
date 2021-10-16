
import java.util.ArrayList;

	/* ========================================================================
	 *  Java의 정석 3판 p.707 예제 12-11
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
	 *   - @FunctionalInterface : 함수형 인터페이스를 선언할 때 사용. 뒤에 오는 인터페이스는 한개의 추상메서드만을 허용한다.
	 *   - @SuppressWarnings : 컴파일러의 특정 경고메시지를 억제
	 *   
	 * ========================================================================  
	 */


class NewClass3 {
	int newField;
	int getNewField() {
		return newField;
	}
	
	@Deprecated
	int oldField;
	
	@Deprecated
	int getOldField() {
		return oldField;
	}
}

public class AnnotationEx3 {
	
	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" }) // 컴파일러 경고를 억제함. 이렇게 쓰기보다 발생 위치에 직접 사용하는 것이 좋다.
	public static void main(String[] args) {
		
		NewClass3 nc3 = new NewClass3();
		nc3.oldField = 10; // Deprecated 필드, 메서드를 호출함
		System.out.println(nc3.getOldField());
		
		ArrayList<NewClass3> list = new ArrayList(); // 지네릭 타입을 지정하지 않은 객체를 생성함
		list.add(nc3);
	}

}
