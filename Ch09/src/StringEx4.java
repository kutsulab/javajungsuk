import java.util.StringJoiner;

public class StringEx4 {
	
	/* 자바의 정석 3판 p.472 예제 9-14
	 * String 클래스의 메서드 split(String regex)는 해당 인스턴스에 저장된 문자열을 지정된 분리자(regex)로 문자열을 나누어 배열에 담아 반환한다.
	 * String 클래스의 static 메서드 join(String regex, CharSequence elements, ...)는 지정된 구분자로 원하는 Charsequence 요소들을 결합해서 출력한다. (문자열 배열만 입력시 해당 요소들 전체)
	 * 
	 * java.util.StringJoiner 클래스
	 *  - 생성자 1 : StringJoiner(CharSequence) : 지정한 구분자로 문자열을 잇는 StringJoiner 객체 생성
	 *  - 생성자 2 : StringJoiner(CharSequence, CharSequence, CharSequence) : 구분자, 시작문자, 끝 문자 지정하여 StringJoiner 객체 생성
	 *  - 메서드 : StringJoiner.add(String s) : 지정한 문자열을 결합요소에 추가
	 *  - toString() : 결합 문자들을 지정한 생성자의 규칙에 맞게 결합해서 출력하도록 오버라이드 됨
	 */
	
	public static void main(String[] args) {
		
		String animals = "kyaru,dog,rabbit";
		String[] arr = animals.split(","); // 문자열 animals를 ","를 기준으로 나눠서 String 배열에 각각 저장
		System.out.println(String.join("-",arr)); // 문자열 배열 arr에 속한 모든 요소들을 "-"로 이어서 출력
		

		
		StringJoiner arr_join1 = new StringJoiner("/"); // 구분자 "/"로 연결
		for (String s : arr) arr_join1.add(s); // 배열 arr에 존재하는 모든 문자열들을 순서대로 더함
		/* JDK 1.5부터 배열, 컬렉션에 저장된 요소에 for문을 통해 접근할 때
		 * for (변수타입 변수명 : 배열 또는 컬렉션) {} 을 이용하여 접근할 수 있다. (읽어올 수만 있음)
		 * 배열 또는 컬렉션에 저장된 값이 매 반복마다 하나씩 순서대로 읽혀서 매개변수의 인수로 저장된다.
		 * {}안에서는 매개변수로 사용된 변수를 사용하여 코드를 작성한다.
		 */	
		System.out.println(arr_join1.toString()); //StringJoiner 클래스는 toString()이 오버라이드 되어 있다.
		
		StringJoiner arr_join2 = new StringJoiner("/","[","]"); // 구분자 "/"로 연결 + 시작과 끝에 "[","]"을 붙임
		for (String s : arr) arr_join2.add(s);
		System.out.println(arr_join2.toString()); 

	}

}
