
	/* ========================================================================
	 *  Java의 정석 3판 p.807 예제 14-6 : 기본형을 사용하는 함수형 인터페이스
	 * ========================================================================
	 *
	 *     1. 기본형을 사용하는 기본형 인터페이스
	 *     
	 *       (여기서 기본형은 A,B,...로 표기하고 참조형은 T,U,V,... 로 표기함)
	 *       
	 *      1) ASupplier : 반환타입이 A(기본형)인 Supplier
	 *         메서드 : getAsA
	 *      
	 *       예) IntSupplier : 반환 타입이 int인 Supplier <메서드 : int getAsInt()>
	 *              
	 *      2) AConsumer : 입력이 A 타입이고 반환값이 없는 Consumer
	 *         메서드 : void accept(A a)
	 *      
	 *      3) ObjectAConsumer<T> : 입력이 T, A 타입이고 반환값이 없는 Consumer
	 *         메서드 : void accept(T t, A a)
	 *        
	 *        예) ObjectIntConsumer<String> : 입력이 String 타입과 int 타입이고, 반환값이 없는 Consumer <메서드 : void accept (String str, int i)>
	 *      
	 *      4) AToBFunction : 입력이 A타입, 반환타입이 B타입인 Function
	 *         메서드 : B applyAsB(A a)
	 *        
	 *        예) DoubleToIntFunction : 입력이 double, 출력이 int인 Function <메서드 : int applyAsInt(double d)>
	 *      
	 *      5) ToBFunction<T> : 입력이 T타입, 반환타입이 B타입인 Function
	 *         메서드 : B applyAsB(T t)
	 *         
	 *      6) APredicate : 입력이 A타입, 반환타입이 boolean인 Predicate
	 *         메서드 : boolean test(A a)
	 *         
	 *      7) AUnaryOperator : 입력이 A타입, 반환타입 또한 A 타입인 UnaryOperator
	 *         메서드 : A applyAsA(A a)
	 *      
	 *      8) ABinaryOperator : 입력이 A, A 타입 반환 타입 또한 A 타입인 BinaryOperator
	 *         메서드 : A applyAsA(A a1, A a2)
	 *         
	 * ========================================================================
	 */


import java.util.function.*;
import java.util.*;

public class LambdaEx6 {

	public static void main(String[] args) {
		IntSupplier getRandomInt = ()->(int)(Math.random()*100) + 1; // 1~100 사이의 임의의 값을 반환한다.
		IntConsumer printInt = i -> System.out.print(i+", ");
		IntPredicate isEvenNumber = i -> i%2==0;
		IntUnaryOperator deleteOnesPlace = i-> i/10*10;
		
		int[] intArr = new int[10];
		fillArr(intArr, getRandomInt);
		System.out.println(Arrays.toString(intArr));
		printEvenNumber(intArr, isEvenNumber, printInt);
		
		int[] newIntArr = doSomething(intArr, deleteOnesPlace);
		System.out.println(Arrays.toString(newIntArr));
	}
	
	static void fillArr(int[] intArr, IntSupplier s) {
		for (int i=0; i<intArr.length; i++) {
			intArr[i] = s.getAsInt();
		}
		return;
	}
	
	static void printEvenNumber(int[] intArr, IntPredicate ip, IntConsumer ic) {
		System.out.print('[');
		for(int i : intArr) {
			if(ip.test(i)) ic.accept(i);
		}
		System.out.println(']');
		return;
	}
	
	static int[] doSomething(int[] intArr, IntUnaryOperator iop) {
		int[] newIntArr = new int[intArr.length];
		for (int i=0; i< newIntArr.length; i++) {
			newIntArr[i] = iop.applyAsInt(intArr[i]);
		}
		return newIntArr;
	}
}
