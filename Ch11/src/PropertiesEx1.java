
import java.util.*;

public class PropertiesEx1 {

	/* Java의 정석 3판 p.658 예제 11-35
	 * 
	 * [Properties]
	 *  - 구버전 Hashtable을 상속받아 구현, Key, value를 String, String으로 저장
	 *  - 데이터를 파일로부터 읽고 쓰는 기능을 제공
	 *  - 간단한 입출력은 Properties를 활용하면 편리 
	 * 
	 * [Properties의 메서드]
	 * 
	 *  1. 생성자
	 *   - Properties()
	 *   - Properties(Properties defaults) : 지정된 Properties에 저장된 목록을 가진 Properties 객체 생성
	 *   
	 *  2. key를 인수로 하여 value 반환
	 *   - String getProperty(String key) : 지정된 key에 대응하는 value 반환
	 *   - String getProperty(String key, String defaultValue) : 지정된 key에 대응하는 value 반환, key가 없으면 defaultValue 반환
	 *  
	 *  3. 모든 key를 Set에 담아서 반환
	 *   - Set stringPropertyNames() : Properties에 저장된  모든 Key를 Set에 담아 반환
	 *   
	 *  4. 접근
	 *   - Enumeration propertyNames() : 목록의 key값에 접근하는 Enumeration 반환
	 *  
	 *  5. 추가
	 *   - Object setProperty(String key, String value) : 지정 key와 value를 추가. 이미 존재하는 key면 value를 덮어씀
	 *   - void load(InputStream inStream) : 지정 InputStream으로부터 목록을 읽어서 저장
	 *   - void load(Reader reader) : 지정 Reader으로부터 목록을 읽어서 저장
	 *   - void loadFromXML(InputStream in) : 지정 InputStream으로부터 XML 문서를 읽어서 XML문서에 저장된 목록을 읽어다 담음(load, store)
	 *
	 *  6. 저장된 목록을 출력
	 *   - void list (PrintStream out) : 지정 printStream에 저장된 목록을 출력
	 *   - void list (PrintWriter out) : 지정 printStream에 저장된 목록을 출력
	 *   (cf) System.out은 화면과 연결된 표준 출력 -> System 클래스에 정의된 PrintStream타입의 static 변수
	 *   
	 *  7. 저장된 목록을 출력, Stream에 저장
	 *   - void save (OutputStream out, String header) : deprecated됨(사용하지 않길 권장)
	 *   - void store(OutputStream out, String comments) : 저장된 목록을 지정된 OutputStream에 출력(저장), comments는 주석
	 *   - void store(Writer writer, String comments) : 저장된 목록을 지정된 writer에 출력(저장). comments는 주석
	 *   - void storeToXML(OutputStream os, String comment) : 저장된 목록을 지정된 출력 스트림에 XML문서로 출력(저장). comment는 주석
	 *   - void storeToXML(OutputStream os, String comment, String encoding) : 저장된 목록을 지정된 출력 스트림에 지정 인코딩의 XML문서로 출력(저장). comment는 주석
	 *   
	 */
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		
		//prop에 key, value 저장
		prop.setProperty("timeout","30");
		prop.setProperty("language","kr");
		prop.setProperty("size","10");
		prop.setProperty("capacity","10");
		
		Enumeration e = prop.propertyNames(); // key값들에 접근하는 Enumeration 구현체
		
		while(e.hasMoreElements()) {//다음 key가 있는가? 있으면,
			String element = (String) e.nextElement(); // Key값 호출
			System.out.printf("%s = %s%n",element, prop.getProperty(element)); //key(설정명), value(설정값)
		}
		System.out.println();
		
		prop.setProperty("size","20"); // 이미 등록된 key의 value는 값을 변경한다.
		System.out.println("size = "+prop.getProperty("size"));
		System.out.println("capacity = "+prop.getProperty("capacity","30")); // key "capacity"가 있으면 value, 없으면 "30"반환 -> key가 있으므로 value "10" 반환 
		System.out.println("loadfactor = "+prop.getProperty("loadfactor","0.75")); // key "loadfactor"가 있으면 value, 없으면 "0.75"반환 -> key가 없으므로 defaultValue "0.75" 반환
		System.out.println();
		
		System.out.println("prop = "+prop); // prop에 저장된 요소 반환
		System.out.println();
		
		prop.list(System.out); // prop에 저장된 요소를 화면(System.out)에 출력
	}

}
