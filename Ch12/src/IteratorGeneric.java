
import java.util.*;
import java.text.DecimalFormat;

	/* Java의 정석 기초편 p.464 예제 12-2
	 * 
	 *  Iterator<E> : 지네릭스가 적용되어 있음.
	 *   -> 지네릭 타입을 지정해주면, 접근 후 각 객체를 반환할 때 지네릭 타입으로 반환받을 수 있다.
	 *   
	 *  Comparable<E> : 지네릭스가 적용되어 있음.
	 *   -> 지네릭 타입을 지정해주면, compareTo를 오버라이드 할 때 매개변수 타입을 E로 해서 비교하면 됨
	 *  
	 */

class Student implements Comparable<Student> { 
	private String studentName; // 이름
	private int studentGrade; // 학년
	private int studentClass; // 반
	private int studentNumber; // 번호
	
	// 이 학생 객체의 학번을 반환
	public int getStudentID() {
		return getStudentID(studentGrade, studentClass, studentNumber);
	}
	
	//학년, 반, 번호를 인수로 하여 학번을 반환// (예 : 2학년 7반 5번 -> 20705)
	static int getStudentID(int studentGrade, int studentClass, int studentNumber) {
		if (!isValidStudent(studentGrade, studentClass, studentNumber)) {
			return 0; // 유효하지 않은 학년, 반, 이름이면 0을 반환함
		}
		
		String strGrade = String.valueOf(studentGrade); // 학년을 문자열로 변경 
		String strClass = new DecimalFormat("00").format(studentClass); // 반을 00 형식화
		String strNumber = new DecimalFormat("00").format(studentNumber); // 숫자를 00 형식화
		return Integer.parseInt(strGrade+strClass+strNumber);
	}
	
	Student(String studentName, int studentGrade, int studentClass, int studentNumber) {
		
		if (!isValidStudent(studentGrade, studentClass, studentNumber)) {
			return; // 유효하지 않은 학년, 반, 이름이면 객체를 생성하지 않음
		}
		
		setStudentName(studentName);
		setStudentGrade(studentGrade);
		setStudentClass(studentClass);
		setStudentNumber(studentNumber);
		return;
	}
	
	
	//학년, 반, 번호의 유효성 검사
	static boolean isValidStudent(int studentGrade, int studentClass, int studentNumber) {
		return (isValidStudnetGrade(studentGrade)&&isValidStudentClass(studentClass)&&isValidStudentNumber(studentNumber));
	}
	
	private static boolean isValidStudnetGrade(int studentGrade) {
		return 1<=studentGrade&&studentGrade<=3;
	}
	
	private static boolean isValidStudentClass(int studentClass) {
		return 1<=studentClass&&studentClass<=99;
	}
	private static boolean isValidStudentNumber(int studentNumber) {
		return 1<=studentNumber&&studentNumber<=99;
	}
	
	//Setter : 학생명
	private void setStudentName(String studentName) {
		this.studentName = studentName;
		return;
	}
	
	//Setter : 학년
	private void setStudentGrade(int studentGrade) {
		this.studentGrade = studentGrade;
		return;
	}

	//Setter : 반
	private void setStudentClass(int studentClass) {
		this.studentClass = studentClass;
		return;
	}

	//Setter : 번호
	private void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
		return;
	}

	//getter
	public String getStudentName() {return studentName;}
	public int getStudnetGrade() {return studentGrade;}
	public  int getStudentClass() {return studentClass;}
	public int getStudentNumber() {return studentNumber;}
	
	@Override
	public boolean equals (Object o) {
		if (!(o instanceof Student)) { // Student 객체가 아니면 false 반환
			return false;
		}
		
		Student s = (Student) o;
		return (this.getStudentID() == s.getStudentID()); // 학번으로 객체를 구분
	}
	
	@Override
	public int hashCode() { // 학생 객체의 학번에 따라 hashCode 부여
		return Objects.hash(getStudentID());
	}
	
	@Override
	public int compareTo(Student s) { // Comparable 구현 : 학번값이 클 수록 뒤에 정렬되도록 함
		if (this.getStudentID() < s.getStudentID()) return -1; 
		else if (this.getStudentID() > s.getStudentID()) return 1; 
		else return 0; 
	}
	
	@Override
	public String toString() { // 학번 이름 출력
		return getStudentID()+" : "+studentName;
	}
}

public class IteratorGeneric {
	
	private static void printStudent(Collection<Student> c) {
		// 지네릭 타입이 Student인 컬렉션에 접근해서 요소를 한 줄씩 출력
		
		Iterator<Student> it = c.iterator(); // 지네릭 타입을 Student로 지정
		while(it.hasNext()) {
			Student s = it.next(); // 지네릭 타입이 Student라서 별도로 형변환을 할 필요가 없다.
			System.out.println(s.toString());
		}
		System.out.println();
		return;
	}
	
	public static void main(String[] args) throws Exception {
		
		List<Student> studentList = new ArrayList<Student>();
		// 본래 중복되지 않는 서로 다른 데이터를 저장할 때는 Set 인터페이스의 구현체가 적합하지만, 본 파일에서 HashSet에 저장시 정렬이 자동으로 학번순으로 됨.
		// 등록 순서에 따라 Student 객체에 접근하는 목적으로 ArrayList를 한번 사용해봤다.

		//studentList.add(new Student("사렌",10,9,1)); //학년 오류
		//studentList.add(new Student("네네카",2,100,10)); //반 오류
		//studentList.add(new Student("미쿠",3,9,100)); //번호 오류
		studentList.add(new Student("캬루",2,2,2));
		studentList.add(new Student("콧코로",1,1,1));
		studentList.add(new Student("페코린느",3,3,16));

		System.out.println("====== studentList======");
		printStudent(studentList);

		System.out.println("====== studentSet======");
		Set<Student> studentSet = new TreeSet<Student>(); // Student의 Comparable 구현에 의한 기본 정렬
		studentSet.addAll(studentList);
		printStudent(studentSet);
	}

}
