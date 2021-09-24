
public class VarEx1 {
	
	/* Java의 정석 3판 p.21 예제 2-1
	 * 
	 * [변수의 선언과 초기화]
	 * 
	 * 변수타입 변수명; (선언)
	 * 변수명 = 값; (저장)
	 * 변수타입 변수명 = 값; (선언 + 저장)
	 * 
	 */
	public static void main(String[] args) {
		
		String name; // String 타입의 참조변수 name을 선언
		int kor; // int 타입의 기본형 변수 kor 선언 -> 국어 점수 저장
		int mat; // int 타입의 기본형 변수 mat 선언 -> 수학 점수 저장
		int eng; // int 타입의 기본형 변수 eng 선언 -> 영어 점수 저장
		int total; // int 타입의 기본형 변수 total 선언 -> 총점 저장
		double avarage; // double 타입의 기본형 변수 avarage 선언 -> 평균 저장
		
//=========================== 컴파일 에러 : 변수의 초기화가 되지 않음==================================		
//		System.out.println(name+"의 성적은 다음과 같습니다."); 
//		System.out.println("국어 : "+kor);
//		System.out.println("영어 : "+eng);
//		System.out.println("수학 : "+mat);
//		System.out.println("총점 : "+total);
//		System.out.println("평균 : "+avarage);
//==========================================================================================		
		
		name = "캬루"; // String타입 참조변수 String에 "캬루"를 저장
		kor = 22; // int타입 참조변수 kor에 22 저장
		eng = 30; // int타입 참조변수 eng에 30 저장
		mat = 56; // mat타입 참조변수 mat에 56 저장

		total = kor + eng + mat; // 변수 kor eng mat에 저장된 값들을 참조하여 이들의 합을 total에 저장
		avarage = total / 3.0; // 변수 total에 저장된 값을 참조하여 이를 3.0으로 나눈 값을 avarage에 저장
		
		System.out.println(name+"의 성적은 다음과 같습니다.");
		System.out.println("국어 : "+kor); // 출력
		System.out.println("영어 : "+eng);
		System.out.println("수학 : "+mat);
		System.out.println("총점 : "+total);
		System.out.println("평균 : "+avarage);
		System.out.println();
		
		name = "콧코로"; // 변수에 저장된 값(data) 대신 다른 값을 입력
		kor = 100;
		eng = 100;
		mat = 100;
		
//		System.out.println(name+"의 성적은 다음과 같습니다.");
//		System.out.println("국어 : "+kor);
//		System.out.println("영어 : "+eng);
//		System.out.println("수학 : "+mat);
//		System.out.println("총점 : "+total); // total, avarage는 새로 값을 저장해주지 않았기 때문에 그대로.
//		System.out.println("평균 : "+avarage);
//		System.out.println();
		
		total = kor + eng + mat; // total과 avarage의 값도 새로 저장 해야한다.
		avarage = total/3.0;
		
		System.out.println(name+"의 성적은 다음과 같습니다.");
		System.out.println("국어 : "+kor);
		System.out.println("영어 : "+eng);
		System.out.println("수학 : "+mat);
		System.out.println("총점 : "+total);
		System.out.println("평균 : "+avarage);
		System.out.println();
		
		System.out.println("캬루가 선생님에게 콧코로의 수학문제가 하나 틀렸다고 추궁합니다.");
		System.out.println("선생이 이를 인정하고 콧코로의 수학 점수를 4점 차감합니다.");
		
		mat = mat - 4; // mat에 저장되어 있는 '값'을 호출 후 4를 차감 후 mat에 저장
		total = kor + eng + mat; // 다시 total, avarage에 변경된 결과를 저장
		avarage = total/3.0;
		
		System.out.println(name+"의 성적 정정 결과는 다음과 같습니다.");
		System.out.println("국어 : "+kor);
		System.out.println("영어 : "+eng);
		System.out.println("수학 : "+mat);
		System.out.println("총점 : "+total);
		System.out.println("평균 : "+avarage);
		System.out.println();
		
	}

}
