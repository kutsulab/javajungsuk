
import java.util.*;

public class HashMapGeneric {
	
	/* Java의 정석 기초편 p.465 : HashMap<K,V>
	 * 
	 * [HashMap<K, V> : 지네릭 타입을 두개 지정해야함]
	 *  - K : Key로 사용할 지네릭 타입
	 *  - V : Value로 사용할 지네릭 타입
	 * 
	 *  - 지네릭 타입을 지정 -> Key, Value를 불러왔을 때 별도로 형변환을 하지 않아도 됨
	 * 
	 */
	
	static HashMap<Integer, Student> map = new HashMap<>();
	
	static void putMapStudent (String studentName, int studentGrade, int studentClass, int studentNumber) {
		
		if (!Student.isValidStudent(studentGrade, studentClass, studentNumber)) {
			System.out.print(studentName+"학생 등록 실패 : 유효하지 않은 학번");
			return;
		}
		
		Student student = new Student(studentName, studentGrade, studentClass, studentNumber);
		Integer studentID = student.getStudentID();
		map.put(studentID, student); // key : studentID , value : Student로 하여 map에 추가
		return;
	}
	
	
	//학년,반,번호를 인수로 하여 studentID를 반환받고, 이 Key값으로 Student 객체 조회
	static Student getMapStudent (int studentGrade, int studentClass, int studentNumber) throws Exception {
		Integer studentID = Student.getStudentID(studentGrade, studentClass, studentNumber);
		return map.get(studentID); // 지네릭 타입으로 Value 타입을 지정했으므로 별도로 형변환을 할 필요가 없음
	}
	
	public static void main(String[] args) throws Exception {
		putMapStudent("캬루", 2,2,2); // map에 학생 추가
		Student s = getMapStudent(2,2,2); // map에서 학년, 반, 번호로 학생 조회
		System.out.println(s);
	}
}