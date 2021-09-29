
import java.util.*;

	/* Java의 정석 3판 p.648 예제 11-33
	 * [HashMap안에 HashMap들을 저장하기 (그룹핑)]
	 * 
	 * 1. 상위 HashMap(그룹 전체) : key로 그룹명, value로 그룹HashMap을 저장
	 * 2. 하위 HashMap(각 그룹) : 개별 객체들을 하위 HashMap에 저장
	 * 
	 */

public class HashMapEx3 {
	
	// phoneBook : group HashMap들을 저장하는 HashMap (key : groupName, value : HashMap());
	// group HashMap : 개별 이름, 연락처를 저장하는 HashMap (key : phoneNmb, value : phoneNmb); 
	static HashMap phoneBook = new HashMap(); // 클래스 호출 시 자동으로 생성, 저장되는 static HashMap

	//group HashMap을 전체 HashMap에 추가
	private static void addGroup(String groupName) {
		if(!phoneBook.containsKey(groupName)) {
			phoneBook.put(groupName, new HashMap());
			//phoneBook에 지정 groupName이 존재하지 않을 경우, groupName을 key로 하는 HashMap을 저장
		}
		return;
	}
	
	//group HashMap에 개별 연락처를 저장
	private static void addPhoneNmb (String groupName, String name, String phoneNmb) {
		addGroup(groupName);
		HashMap group = (HashMap) phoneBook.get(groupName); // 지정 groupName에 해당하는 HashMap을 반환
		group.put(phoneNmb, name); // phoneNmb를 Key로 하고, name을 value로 하여 group HashMap에 저장
		return;
	}
	
	//group명을 지정하지 않을 경우 기타 그룹에 저장
	private static void addPhoneNmb(String name, String phoneNmb) {
		// groupName을 지정하지 않을 경우 기타 그룹에 해당하는 HashMap에 저장
		addPhoneNmb("기타", name, phoneNmb);
		return;
	}
	
	//연락처 출력
	private static void printList() {
		Set groupEntrySet = phoneBook.entrySet(); // group들의 EntrySet (key : groupName, value : HashMap()) 
		Iterator it = groupEntrySet.iterator();
		
		while(it.hasNext()) { // 그룹별 Entry에 접근
			Map.Entry groupEntry = (Map.Entry) it.next(); // groupName, HashMap()
			
			String groupName = (String)groupEntry.getKey(); // 그룹명
			Set personalEntrySet = ((HashMap)groupEntry.getValue()).entrySet(); // 그룹에 속한 개인들의 EntrySet (key : phoneNmb, value : name)
			System.out.printf(" * %s [%s명]%n", groupName, personalEntrySet.size());
			
			Iterator subIter = personalEntrySet.iterator();
			while (subIter.hasNext()) {// 그룹에 속한 개별 Entry에 접근
				Map.Entry personalEntry = (Map.Entry) subIter.next(); // phoneNmb, name
				
				String phoneNmb = (String) personalEntry.getKey();
				String name = (String) personalEntry.getValue();
				
				System.out.printf("%s %s%n",name,phoneNmb);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		addPhoneNmb("몬드", "벤티", "010-0000-0000");
		addPhoneNmb("몬드", "모나", "010-1111-1111");
		addPhoneNmb("몬드", "바바라", "010-2222-2222");
		addPhoneNmb("리월", "종려", "010-3333-4444");
		addPhoneNmb("리월", "감우", "010-5555-6666");
		addPhoneNmb("리월", "호두", "010-7777-7777");
		addPhoneNmb("리월", "각청", "010-8888-8888");
		addPhoneNmb("이나즈마", "라이덴", "010-9999-9999");
		addPhoneNmb("이나즈마", "야에", "010-1234-1234");
		addPhoneNmb("이나즈마", "코코미", "010-4321-4321");
		addPhoneNmb("이나즈마", "사라", "010-1212-1212");
		addPhoneNmb("이나즈마", "아야카", "010-2121-2121");
		addPhoneNmb("캬루", "010-2727-2727");
		
		printList();
		
	}

}
