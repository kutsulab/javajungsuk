
import java.lang.annotation.*;

	/* ========================================================================
	 *  Java의 정석 3판 p.718 예제 12-13
	 * 
	/* ========================================================================
	 *
	 * [메타 에너테이션]
	 *  
	 *  1. 메타 애너테이션 : 애너테이션을 정의할 때 사용하는 애너테이션
	 *   - @Target : 이 애너테이션으로 적용가능한 대상
	 *       (주요 필드) 
	 *           ElementType.ANNOTATION_TYPE : 애너테이션 타입 선언시
	 *           ElementType.CONSTRUCTOR : 생성자에 적용 가능
	 *           ElementType.FIELD : 기본형 멤버변수, enum 상수
	 *           ElementType.LOCAL_VARIABLE : 지역변수 선언시
	 *           ElementType.METHOD : 메서드 선언시
	 *           ElementType.PACKAGE : 패키지 선언시
	 *           ElementType.PARAMETER : 매개변수 선언시
	 *           ElementType.TYPE : 타입 선언시 (클래스, 인터페이스, enum)
	 *           ElementType.TYPE_PARAMETER : 타입 매개변수(실행시 지네릭 클래스의 인자에 전달하는 타입. T) 선언시
	 *           ElementType.TYPE_USE : 타입 매개변수를 포함하여, 타입이 타입이 사용되는 모든 곳
	 *           
	 *    - @Retention : 이 애너테이션이 유지되는 기간.
	 *                   애너테이션을 정의할 때 디폴트가 거의 잘 사용되지 않는 Retention.CLASS로 잡혀있기 때문에 거의 매번 수동으로 지정할 필요가 있다.
	 *                   주로 RetentionPolicy.SOURCE, RetentionPolicy.RUNTIME 중 하나를 지정함.
	 *        (주요 필드)
	 *           RetentionPolicy.SOURCE : 소스파일에서만 유효함. 컴파일 후 .class 파일에는 존재하지 않음
	 *           RetentionPolicy.CLASS
	 *            : .class파일까지 유효. 클래스 로더를 통해 JVM에 올려진 시점에는 존재하지 않음.
	 *            : 별도로 지정하지 않을 경우, 디폴트가 RetentionPolicy.CLASS으로 되어있음
	 *            : .class에 저장은 되지만, JVM에 올라간 시점에는 애너테이션에 대한 정보가 소멸되어 그닥잘 사용되지 않는다.
	 *           RetentionPolicy.RUNTITME : .class 파일에도 존재하고, 실행시에도 사용 가능하다.
	 *    
	 *    - @Documented : 이 애너테이션에 대한 정보가 javadoc으로 작성된 문서에 포함되도록 함.
	 *    - @Inherited : 이 메타 애너테이션이 적용된 애너테이션은 적용된 클래스의 자손 클래스들에게도 애너테이션이 상속되어 적용된다.
	 *    - @Repeatable : 하나의 대상에 이 메타 애너테이션이 적용된 애너테이션을 여러번 붙일 수 있게 함.
	 *       : Repeatable을 정의할 때는,
	 *         Repeatable이 적용된 애너테이션이 클래스에 중복 사용됐을 때 이 애너테이션들을 한번에 모아둘 컨테이너가 필요하다.
	 *         
	 *         예를 들어 Repeatable 애너테이션이 적용된 애너테이션 ToDo를 정의하는 경우
	 *         ToDo를 묶어둘 ToDos 애너테이션도 정의해야함. Repeatable 애너테이션을 적용할 때
	 *         Repeatable(Todos.class) 와 같이 달아서 적용함.
	 *         
	 *         @interface Todos {
	 *          Todo[] values();
	 *         }
	 *         
	 *         @Repeatable (Todos.class)
	 *         @interface Todo {
	 *          String value();
	 *         }
	 *     
	 * ========================================================================
	 * 
	 *   2. 애너테이션 타입 정의하기
	 *    
	 *    @interface 애너테이션명 {
	 *       타입 요소이름(); // 애너테이션의 요소 선언
	 *    }
	 *    
	 * ========================================================================
	 *    
	 *   3. 애너테이션의 요소 : 애너테이션에 선언된 메서드
	 *     - return값이 있고, 매개변수가 없는 추상 메서드의 형태 (하지만, 상속을 통해 구현을 할 필요는 없음)
	 *     - 애너테이션을 적용할 때 각 요소들을 지정해야함
	 *     - default를 통해 기본값을 지정할 수 있음. 기본값이 존재할 경우 반드시 요소를 새로 지정할 필요는 없음
	 *     
	 *     1) 기본형 변수
	 *     - 요소가 오직 하나뿐이고, 이름이 value일 경우 요소의 이름을 생략하고 값만 적어도 됨
	 *     2) 배열
	 *       - 애너테이션을 적용 할 때 괄호 {...}을 사용해서 여러 개의 값을 지정할 수 있음.
	 *       - 지정할 때 요소가 1개일 경우 괄호 '{', '}'을 생략 가능
	 *       - 기본값이 존재할 경우 {}을 사용해저 지정할 수도 있음.
	 *       - 요소가 오직 한 개뿐이고, 이름이 value인 배열의 경우에도 요소의 이름을 생략할 수 있음.
	 *     3) 다른 애너테이션
	 *     4) 열거형 상수   
	 *       
	 * ========================================================================
	 * 
	 *    4. java.lang.annotation.Annotation
	 *      모든 애너테이션의 조상인 일반 인터페이스.
	 *      각 애너테이션 객체들에 대하여 다음을 호출할 수 있다.
	 *      
	 *      boolean equals(Object obj);
	 *      int hashCode();
	 *      String toString();
	 *      
	 *      Class<? extends Annotation> annotationType() : 애너테이션 객체의 타입을 반환함
	 *          
	 * ========================================================================
	 * 
	 *    5. 마커 애너테이션
	 *      요소가 정의되지 않은 애너테이션. 값을 별도로 지정할 필요가 없다. 
	 *      Overried 등...
	 *      
	 * ========================================================================
	 * 
	 *    6. 애너테이션 요소의 규칙
	 *      - 요소의 타입은 기본형, String, enum, 애너테이션, Class(클래스 객체)만 허용된다.
	 *      - ()안에 매개변수를 선언할 수 없다.
	 *      - 예외를 선언할 수 없다.
	 *      - 요소를 타입 매개변수로 정의할 수 없다. 
	 *    
	 * ========================================================================
	 * 
	 *    7. Class 클래스의 메서드
	 *      - getAnnotation(애너테이션의 Class객체) : 현재 클래스에 적용된 애너테이션을 가져온다.
	 *      - getAnnotations() : 현재 클래스에 적용된 애너테이션들의 배열을 가져온다.
	 *      
	 * ========================================================================
	 */



@Deprecated // 이 클래스는 사용이 권장되지 않는다. (표준 애너테이션, JDK에서 제공)
@SuppressWarnings ("ㅁㄴㅇㄹ") // 일부러 삽입한 유효하지 않은 애너테이션 -> main메서드 내에서 애너테이션들을 호출할 때 호출되지 않는다.
@TestInfo (testedBy="kutsulab", testDate=@DateTime(yymmdd="211020", hhmmss="165731"))
class AnnotationEx5 {
	
	public static void main(String[] args) {
		
		// Class 객체를 얻어옴.
		Class<AnnotationEx5> cls = AnnotationEx5.class; 
		
		// Class 객체를 통해 해당 클래스에 적용된 TestInfo 애너테이션을 반환함
		TestInfo anno = (TestInfo) cls.getAnnotation(TestInfo.class); 
		
		System.out.println("anno.testedBy() = "+anno.testedBy());
		System.out.println("anno.testDate().yymmdd() = "+anno.testDate().yymmdd());
		System.out.println("anno.testDate().hhmmss() = "+anno.testDate().hhmmss());
		
		for(String str : anno.testTools()) { // 이 클래스 애너테이션의 testTools() 요소에 대하여, 각 요소에 접근 
			System.out.println("testTools="+str);
		}
		System.out.println();
		
		// Class 객체를 통해 해당 객체의 모든 애너테이션들을 배열로 반환함
		Annotation[] annoArr = cls.getAnnotations();
		
		for (Annotation a : annoArr) { // 배열의 모든 요소에 접근하여 출력
			System.out.println(a);
			// Annotation들은 모든 애너테이션의 조상인 java.lang.annotation.Annotation의 toString()을 상속받음.
			// 애너테이션들의 값들을, 기본값들을 포함하여 모두 출력한다.
		}
	}
}

@Retention(RetentionPolicy.RUNTIME) // 이 애너테이션의 유지 정책 : 실행시에 사용 가능
@interface TestInfo { // 애너테이션 선언
	
	String testedBy(); // 요소 선언, 디폴트 값을 설정하지 않았으므로 반드시 구현해야함
	DateTime testDate(); // 다른 애너테이션을 요소로 선언함. 디폴트 값을 설정하지 않았으므로 반드시 구현해야함. 
	
	int count() default 1; // 요소 선언, 디폴트값을 설정했으므로 반드시 구현할 필요는 없다.
	String[] testTools() default "JUnit"; // 배열 요소 선언, 디폴트 값을 설정했으므로 반드시 구현할 필요는 없음. 배열의 요소가 한 개일 때는 {}을 사용하지 않아도 됨
	TestType testType() default TestType.FIRST; // 열거형 요소 선언. 디폴트 값을 설정했으므로 반드시 구현할 필요는 없다.
}

@Retention(RetentionPolicy.RUNTIME) // 이 애너테이션의 유지 정책 : 실행시에 사용 가능
@interface DateTime {
	String yymmdd(); // 반드시 구현해야함.
	String hhmmss(); // 반드시 구현해야함.
}

enum TestType { FIRST, FINAL} // 열거형