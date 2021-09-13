
import java.util.*;

public class RandomEx4 {
	
	/* Java의 정석 3판 p.504 예제 9-30 내용 확인 및 연습
	 * 
	 * [java.util.Random의 활용 - 불연속적인 값들 중 하나를 임의로 얻어와야할 때]
	 * 
	 *  불연속적인 값들 중 임의로 값을 얻어와야할 때,
	 *  불연속적인 값들을 배열에 저장 후 배열의 index를 임의로 얻어서 배열에 저장된 값을 임의로 읽어오는 식으로 처리 가능
	 *  
	 *  1. Random.nextInt(int n) : 1 이상 n 미만의 임의의 값을 반환함
	 *  
	 *  2. static int getRandomInt(int from, int to)
	 *  	from 이상 to 이하의 임의의 정수 반환
	 *  
	 *  3. static int fillRandomInt (int[] arr, from, to)
	 *  	from 이상 to 이하의 임의의 정수를 getRandomInt를 통해 구해서, arr의 각 요소에 채워넣음
	 *  
	 *  4. static int fillRandomInt (int[] arr, int[] source) 
	 *		source 배열의 임의의 인덱스에 위치한 값을 arr의 각 요소에 채워넣음
	 *
	 *  5. static String getRdmString (String[] source)
	 *  	source 배열의 임의의 인덱스에 위치한 문자열을 가져옴.
	 *
	 */
	
	// 데이터베이스의 TEST_TABLE에 임의의 포켓몬 10마리를 임의로 추가하는 상황
	
	private final static int KINDS = 898; // 포켓몬의 종류
	
	private final static String TABLE_NAME = "TEST_TABLE";
	
	private final static String[] GENDER = {"수컷", "암컷", "무성"}; // 포켓몬의 성별
	
	private final static String[] TYPE1 = {"노말","불꽃","물","풀","전기",
											"얼음","격투","독","땅","비행",
											"에스퍼","벌레","바위","고스트",
											"드래곤","악","강철","페어리"}; // 포켓몬의 타입 1
	private final static String[] TYPE2 = Arrays.copyOf(TYPE1, TYPE1.length); // 포켓몬의 타입2
	
	private final static String[] NATURE = {"노력","대담","조심","차분","겁쟁이",
											"외로움","온순","의젓","얌전","성급",
											"고집","장난꾸러기","수줍음","신중","명랑",
											"개구쟁이","촐랑","덜렁","변덕","천진난만",
											"용감","무사태평","냉정","건방","성실"}; // 포켓몬의 성격
	
	// from 이상 to 이하의 임의의 정수를 반환
	private static int getRdmInt(int from, int to) {
		Random rdm = new Random();
		return rdm.nextInt(Math.abs(to-from)+1) + Math.min(from,to);
	}
	
	// 1이상 n 이하의 임의의 정수를 반환
	private static int getRdmInt (int n) {return getRdmInt(1,n);}
	
	// 포켓몬을 임의 생성해서 데이터 베이스의 테스트테이블에 삽입
	public static void insertPokemon() {
		System.out.println(" INSERT INTO "+TABLE_NAME
								+ " VALUES ("
								+ " '" + getRdmString(GENDER) + "'"
								+ ", '" + getRdmString(TYPE1) + "'"
								+ ", '" + getRdmString(TYPE2) + "'"
								+ ", '" + getRdmString(NATURE) + "'"
								+ ", " + getRdmInt(1,KINDS)
								+ "); ");
		return;
	}
	
	// 포켓몬 number마리를 임의 생성해서 테스트 테이블에 넣음
	public static void insertPokemon(int number) {
		for (int i =0; i < number ; i++) insertPokemon();
		return;
	}
	
	// 매개변수로 넣은 배열의 임의의 인덱스에 위치한 문자열 하나를 반환함.  
	private static String getRdmString(String[] source) {
		return source[getRdmInt(0, source.length-1)];
	}
		
	public static void main(String[] args) {
		
		// 테스트
		System.out.println("test - getRdmString(GENDER) : "+getRdmString(GENDER));
		System.out.println("test - getRdmString(TYPE1) : "+getRdmString(TYPE1));
		System.out.println("test - getRdmString(TYPE2) : "+getRdmString(TYPE2));
		System.out.println("test - getRdmString(NATURE) : "+getRdmString(NATURE));
		System.out.println("test - getRdmInt(KINDS) : "+ getRdmInt(KINDS));
		System.out.println("test - getRdmInt(150,200) : "+getRdmInt(150,200));
		System.out.println();
		
		insertPokemon(10); // 포켓몬 10마리를 데이터베이스(테스트 테이블)에 추가함
	}
}
