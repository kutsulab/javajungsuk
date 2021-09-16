
import java.util.*;

	/* Java의 정석 3판 p.516 예제 9-41 내용 확인 및 연습
	 * 
	 * StringTokenizer 클래스의 활용 - 큰 규모로 쪼개고, 작은 규모로 쪼개기
	 * 
	 * [StringTokenizer]
	 * 
	 * 문자열을 구분자를 기준으로 여러 개의 Token으로 잘라내여 활용하는 클래스
	 * 다른 방법과 달리 정규식을 사용하지 않고 사용하는 차별점이 있음
	 * 
	 * 다만, 구분자를 하나씩 인식한다는 점이 한계.
	 * 두 글자 이상의 복잡한 구분자로 나누거나 복잡한 형식에 맞춰 쪼갤 때는 정규식을 사용할 필요가 있다.
	 * (예를 들어 ",.#+"을 구분자로 지정하면 "," "." "#" "+" 각각의 문자들이 구분자로 취급됨.)
	 * 
	 *  1. 생성자
	 *  	StringTokenizer (String str, String delim) : 문자열 지정, 구분자 지정
	 *      StringTokenizer (String str, String delim, boolean returnDelims) : true일 때 구분자도 토큰으로 간주 
	 *      
	 *  2. 메서드
	 *  	int countTokens() : 전체 토큰의 수 반환
	 *  	boolean hasMoreTokens() : 토큰이 남아있는지를 boolean으로 반환 
	 * 		String nextToken() : 다음 토큰을 반환
	 * 
	 * [구분자로 문자열을 쪼개는 다른 방법]
	 * 
	 * String 객체.split(String regex) : 문자열을 regex로 쪼개서 배열로 반환
	 * Scanner 객체.useDelimiter(String pattern) : Scanner 객체의 내용을 pattern을 구분자로 한 Scanner 객체 반환
	 * 
	 */


class HangulNumber {
	
	// 상수
	private final static String HANGUL_NUMBER = "영일이삼사오육칠팔구"; // 각 자리 숫자
	private final static String HANGUL_UNIT = "십백천만억조"; // 구분자(단위)
	private final static long[] VALUE_UNIT = {10,100,1000,10000,(long)1e8, (long)1e12}; // 단위의 숫자 환산
	
	// 인스턴스 변수
	private String source; //원본
	private long value; //변환 결과

	// 생성자
	HangulNumber(String source) {
		this.source = source;
		setValue();
	}
	
	// 한글을 숫자로
	private void setValue() {
		
		long largeNumber = 0; // 만,억,조,경 이상으로 값을 다룰 때
		long middleNumber = 0; // 십백천 단위로 값을 다룸
		long smallNumber = 0; // 자리의 수
		
		StringTokenizer tokenList = new StringTokenizer(source,HANGUL_UNIT,true); 
		
		class Token { // 토큰을 객체로 취급
			private long value;
			boolean isNumber, isLargeUnit, isSmallUnit;
			
			Token(String token) {
				int numberIndex = HANGUL_NUMBER.indexOf(token);
				int unitIndex = HANGUL_UNIT.indexOf(token);
				
				setType(numberIndex, unitIndex);				
				setValue(numberIndex, unitIndex);
			}
			
			private void setType(int numberIndex, int unitIndex) {
				isNumber = (numberIndex!=-1);
				isLargeUnit = (!isNumber)&&(unitIndex>=3);
				isSmallUnit = (!isNumber)&&(0<=unitIndex&&unitIndex<3);
			}
			
			private void setValue(int numberIndex, int unitIndex) {
				if (isNumber) value = numberIndex;		
				else if (!isNumber) value = VALUE_UNIT[unitIndex];
				return;
			}
			
			
		}
		
		while(tokenList.hasMoreTokens()) {
			Token token = new Token(tokenList.nextToken()); // 다음 토큰을 가져온다.
				
			if (token.isLargeUnit) { // 단위가 만,조,억,경,... 일 때
				middleNumber += smallNumber; // smallNumber(0,1,2,...9)가 남아 있는 경우 middleNumber(10,...)에 합침
				largeNumber += (middleNumber!=0 ? middleNumber : 1) * token.value; // middleNumber를 큰 단위에 합쳐버림
				middleNumber = 0; // middleNumber는 큰 단위에 합쳐졌으므로 초기화
				smallNumber = 0; // smallNumber는 큰 단위에 합쳐졌으니 초기화
			}
			
			else if (token.isSmallUnit) { // 단위가 십,백,천, ... 일 때
				middleNumber += (smallNumber !=0 ? smallNumber : 1) * token.value; //smallNumber를 더 큰 단위에 합쳐버림
				smallNumber = 0; // smallNumber는 큰 단위에 합쳐졌으니 초기화
				}

			
			else if (token.isNumber) { // 숫자일 때
				smallNumber = token.value; // smallNumber : 자리의 숫자
			}
			
		}
		
		value = largeNumber + middleNumber + smallNumber; // 모두 처리 완료했으면 합산하여 value에 저장
		return;
	}
	
	//value 반환
	public long getValue() {
		return value;
	}

	public void printValue() {
		System.out.println(source + " -> " + value);
	}
	
}//클래스 끝

public class StringTokenizerEx4 {
	
	public static void main(String[] args) {
		String source = "사천육백이십구억칠천삼백팔십이만오천칠백이십일";
		HangulNumber nmb = new HangulNumber(source); // 문자열을 원본으로 한 HangulNumber 객체 생성
		nmb.printValue(); // HangulNumber에서 자체적으로 변환된 값을 출력함
	}
	
}