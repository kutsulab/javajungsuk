
public class StringBufferEx2 {
		
	/* 자바의 정석 3판 p.482 예제 9-19
	 * 
	 * <StringBuffer의 여러가지 메서드>
	 * 
	 * 1. StringBuffer append(데이터타입)
	 * 버퍼의 뒤에 문자열 추가
	 * 추가 작업을 진행하고 반환함. 반환 타입이 StringBuffer.
	 * StringBuffer append(기본형데이터) : 입력한 값을 문자열로 변환하여 인스턴스가 저장하고 있는 문자열의 뒤에 덧붙임
	 * StringBuffer append(인스턴스) : 입력한 인스턴스의 toString()메서드를 호출하여 문자열의 뒤에 덧붙임
	 * 
	 * 2. StringBuffer deleteCharAt(int index)
	 * 지정한 index에 위치한 문자를 지운다. 그리고 뒤에 문자가 있으면 앞으로 당김. 그 후 결과를 반환
	 * 
	 * 3. StringBuffer delete(int start, int end)
	 * start <= index < end 에 위치한 index의 문자들을 전부 지우고 뒤의 문자를 앞당겨온다. 그리고 결과를 반환함
	 * 
	 * 4. StringBuffer insert (int index, 데이터타입)
	 * 버퍼의 해당 인덱스에 문자열을 삽입 후 뒤의 내용을 뒤로 밀어버림. 그리고 반환
	 * 
	 * 5. StringBuffer replace (int start, int end, String str)
	 * start <= index < end 에 위치한 index의 문자들을 지정한 문자열로 싹 바꾼다. 뒷부분은 뒤로 밀어버림. 그리고 결과를 반환함
	 * 
	 * 6. int capacity() : 버퍼의 크기를 반환한다.
	 * 7. int length() : 저장된 문자열의 길이를 반환한다.
	 */
		
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("01"); // 버퍼의 크기가 2+16인 StringBuffer 생성
		StringBuffer sb2 = sb.append("23"); // 0123
		sb.append("4").append(56); // 0123456 매개변수로 입력된 값을 문자열로 변환하여 인스턴스가 저장하고 있는 문자열의 뒤에 덧붙임
		
		StringBuffer sb3 = sb.append(78); // 012345678
		sb3.append(9.0); //0123456789.0
		
		System.out.println("sb = "+sb); //0123456789.0
		System.out.println("sb2 = "+sb2);
		System.out.println("sb3 = "+sb3);
		
		System.out.println("sb = "+sb.deleteCharAt(10)); // 01234567890
		System.out.println("sb = "+sb.delete(3, 6)); // 01267890
		System.out.println("sb = "+sb.insert(3,"abc")); // 012abc67890
		System.out.println("sb = "+sb.replace(6, sb.length(), "END")); // 012abcEND
		
		System.out.println("capacity = "+sb.capacity()); //버퍼의 크기 18
		System.out.println("length = "+sb.length()); // 문자열의 길이 9
		
	}

}
