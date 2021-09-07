
public class ExceptionEx1 {
	public static void main(String[] args) {

		try {
			// 예외가 발생할 가능성이 있는 문장을 적는다.
			throw new Ex1_Exception2("예외 발생!");
		} catch (Ex1_Exception1 e1) {
			// Ex1_Exception1이 발생했을 때 수행할 문장들을 적는다.
			e1.printStackTrace(); // Exception e1이 발생하지 않았으므로 해당 catch 문은 수행되지 않는다.
		} catch (Ex1_Exception2 e2) {
			// Ex1_Exception2가 발생했을 때 수행할 문장들을 적는다.
			e2.printStackTrace(); // 예외 메시지 + 예외 객체 생성 당시 호출스택(callstack)에 있었던 메서드 정보 출력
		} catch (Exception e) {
			// 위에서 어떤 예외도 처리되지 않았을 경우를 가정하여 마지막 catch문에 Exception을 매개변수로 두고 예외를 처리하는게 좋다.
			e.printStackTrace();
		} // try-catch의 끝
		
		
		try { 
			try {} catch (Exception e) {} // try, catch 문 안에 또 try catch 문을 넣을 수 있다. 물론 너무 많이 넣으면 코드가 더러워지니 적절히 정리가 필요함
		} catch(Exception e) {
//			try {} catch (Exception e) {} : 에러 발생. 바깥의 catch문에 이미 인수 e가 선언되어 있어서 e를 또 다시 사용하지 못 함  
		} // try- catch의 끝
	}// main 메서드 끝
}

class Ex1_Exception1 extends RuntimeException {
	Ex1_Exception1(String msg) {
		super(msg);
	}
}

class Ex1_Exception2 extends RuntimeException {
	Ex1_Exception2(String msg) {
		super(msg);
	}
}