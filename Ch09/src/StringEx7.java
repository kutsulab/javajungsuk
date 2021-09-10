
public class StringEx7 {

	/* 자바의 정석 3판 p.475 예제 9-17
	 * 
	 * [문자열에서 찾고자 하는 문자의 index 찾기]
	 * int indexOf(char ch) : 문자열에서 찾고자 하는 문자의 index를 맨 앞부터 반환한다.
	 * int lastIndexOf(char ch) : 문자열에서 찾고자 하는 문자의 index를 맨 뒤부터 찾아서 반환한다.
	 * [문자열에서 찾고자 하는 index에 위치한 문자 찾기]
	 * char charAt(int index) : 문자열에서 해당 index에 위치한 문자를 반환한다.
	 * 
	 * [문자열 추출]
	 * substring(start index, end index) : 시작 index 부터, (끝-1) index까지 문자열을 추출한다
	 * substring(start index) : 시작 index부터 문자열의 끝까지 문자열을 추출한다. (end index : s.length)
	 * 
	 */ 
	
	public static void main(String[] args) {
		String fullName = "Hello.java"; // 확장자를 포함한 파일명
		
		int dot_index = fullName.indexOf('.'); // 찾는 문자를 앞에서부터 찾는다.
		int dot_index2 = fullName.lastIndexOf('.'); //찾는 문자를 뒤에서부터 찾는다.
		
		//charAt(int index) : 문자열에서 찾고자하는 index에 위치한 문자를 찾는다.
		System.out.println(fullName+"에서 문자 '.'는 "+dot_index+"번 index에 위치해 있다.");
		System.out.println(fullName+"에서 "+dot_index+"번 index에 '"+fullName.charAt(dot_index)+"'가 있다.");
		System.out.println();
		
		String fileName = fullName.substring(0,dot_index); //확장자를 제외한 파일명
		String ext = fullName.substring(dot_index2+1); // 확장자 : File Name Extension -> ext
		
		System.out.println("fullName : "+fullName);
		System.out.println(fullName+"의 확장자를 제외한 이름은 "+fileName);
		System.out.println(fullName+"의 확장자는 "+ext);
	}

}
