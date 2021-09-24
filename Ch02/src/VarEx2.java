
public class VarEx2 {
	
	/* Java의 정석 3판 p.24 예제 2-2
	 * 
	 * [두 변수에 저장된 값을 교환하기]
	 * - 두 가지 변수의 값(예 : x, y)을 교체하려면 두 값중 하나를 임시로 저장할 변수가 하나 더 필요함
	 *  1. 임시 저장소에 한 값을 저장 (예 : tmp = x;)
	 *  2. 두 변수 중 한가지 변수의 값을 교체 (예 : x = y;)
	 *  3. 임시저장소에 저장되어 있던 값을 다시 반대쪽에 저장 (y=tmp;)
	 *  
	 */
	public static void main(String[] args) {
		int x = 10, y = 20; // 두 변수에 저장된 값을 변경하려는 상황
		
		System.out.println("x : "+x);
		System.out.println("y : "+y);
		System.out.println();
		
		int backupX = x; // 값을 옮기는 과정에서 필요한 임시 저장소(변수)에 x를 저장
		
		x=y; // x에 y에 저장되어 있던 값을 옮김 -> x에 저장되어있던 값은 사라짐
		y=backupX; // backupX에 저장되어 있던 본래 x값을 y에 저장
		
		System.out.println("x, y 교환 완료!");
		System.out.println("x : "+x);
		System.out.println("y : "+y);
	}

}
