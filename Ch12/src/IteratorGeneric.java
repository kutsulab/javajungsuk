
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
	
	// 학년, 반, 번호를 기반으로 학번을 생성 (예 : 2학년 7반 5번 -> 20705)
	public int getStudentID() {
		String strGrade = String.valueOf(studentGrade); // 학년을 문자열로 변경 
		String strClass = new DecimalFormat("00").format(studentClass); // 반을 00 형식화
		String strNumber = new DecimalFormat("00").format(studentNumber); // 숫자를 00 형식화
		return Integer.parseInt(strGrade+strClass+strNumber);
	}
	
	Student(String studentName, int studentGrade, int studentClass, int studentNumber) throws Exception {
		setStudentName(studentName);
		setStudentGrade(studentGrade);
		setStudentClass(studentClass);
		setStudentNumber(studentNumber);
		return;
	}
	
	//Setter : 학생명
	private void setStudentName(String studentName) {
		this.studentName = studentName;
		return;
	}
	
	//Setter : 학년
	private void setStudentGrade(int studentGrade) throws Exception {
		if (studentGrade<1||studentGrade>3) { // 학번이 1,2,3 이면 예외
			throw new Exception("학년 잘 못 입력함");
		}
		
		this.studentGrade = studentGrade;
		return;
	}
	
	//Setter : 반
	private void setStudentClass(int studentClass) throws Exception {
		if (studentClass<1||studentClass>99) { //반이 1~99에서 벗어나면 예외
			throw new Exception("반을 잘 못 입력함");
		}
		this.studentClass = studentClass;
		return;
	}
	
	//Setter : 번호
	private void setStudentNumber(int studentNumber) throws Exception {
		if (studentNumber<1||studentNumber>99) { //번호가 1~99에서 벗어나면 예외
			throw new Exception("번호를 잘 못 입력함");
		}
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
	public int hashCode() { // 학번에 따라 hashCode 부여
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
