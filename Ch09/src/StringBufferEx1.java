
public class StringBufferEx1 {
	/* 자바의 정석 3판 p.479 예제 9-18
	 * 
	 * StringBuffer 클래스는 문자열 편집을 위한 Buffer를 가지고 있다.
	 * StringBuffer 클래스의 value에 저장된 char[]는 생성할 때 길이가 정해져 있어 더 이상 길이를 변경할 수 없다.
	 * 배열의 길이를 늘려주려면 배열을 복사한 새로운 배열을 만들고 참조변수 value가 가리키게 변경해야한다.
	 * 
	 * <StringBuffer 생성자>
	 * StringBuffer()는 버퍼의 크기를 16으로 초기화하여 생성한다.
	 * StringBuffer(int length)는 버퍼의 크기를 length+16으로 초기화하여 생성한다.
	 * StringBuffer(String s)는 버퍼의 크기를 s.length+16으로 초기화하여 생성한다.
	 * 
	 * <StringBuffer의 변경 : 추가(append)>
	 * append(String s)는 해당하는 문자열을 뒤에 추가해주고, 그 결과를 반환한다.
	 * 반환타입이 void가 아닌, StringBuffer 라서, 반환 없이 사용할 수도 있고, StringBuffer 객체 그 자체를 반환할 수 있다.
	 * 
	 * <StringBuffer의 비교>
	 * StringBuffer 클래스는 equals 메서드가 오버라이드 되어있지 않아서 주소값을 비교한 후 서로 같은지의 여부를 반환한다.
	 * 문자열을 비교하려면 toString()을 통해 문자열로 변환한 뒤, 변환한 것들끼리 비교해야한다.
	 */ 
	
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("abc"); //sb의 value가 가리키는 char[]은 3+16의 길이를 가진다.
		StringBuffer sb2 = new StringBuffer("abc");
		System.out.println("sb==sb2 ? : "+(sb==sb2));
		
		//StringBuffer 클래스는 equals메서드가 오버라이드 되어있지 않아서, equals 메서드가 주소값이 동일한 지의 여부를 반환한다.
		System.out.println("sb.equals(sb2) ? : "+sb.equals(sb2));
		
		// 문자열의 내용을 비교하려면 String Buffer의 내용을 String으로 변환하고 비교해야한다.
		String s = sb.toString();
		String s2 = sb2.toString();
		
		System.out.println("s.equals(s2) ? : "+s.contentEquals(s2));
	}

}
