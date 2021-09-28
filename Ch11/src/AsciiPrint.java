
public class AsciiPrint {
	
	/* Java의 정석 3판 p.643 예제 11-28 : 문자열의 정렬기준은 char의 코드값의 크기가 기준이다.
	 * 
	 * [char]
	 *  - java의 char는 2byte 문자체계를 사용함.
	 *  - 2byte = 16bit, 즉 0 ~ 2^16-1 0~65535의 문자값을 저장할 수 있다.
	 *  - 문자의 종류가 많아지면 2byte로 저장할 수 없는 문자들도 있을 수 있기 마련인데,
	 *    이와 같은 추가 문자는 int로 코드를 저장할 수 있음.
	 *  
	 * [문자 정렬]
	 *  - Comparable 구현에 의한 기본 정렬은 char의 코드값을 기준으로 큰값이 다음에 정렬됨
	 *  - 공백, 숫자, 대문자, 소문자 순으로 정렬
	 */
	
	public static void main(String[] args) {
		char ch = ' '; //' '를 문자코드로 환산하면 32이다.
		
		for(; ch<127; ch++) {
			System.out.println("'"+ch+"'의 코드 : "+(int)ch);
			// 문자의 코드값을 1씩 증가시켜가면서 문자를 출력함. 이 출력된 순서가 문자의 오름차순 정렬 순서다.
		}
		
	}

}
