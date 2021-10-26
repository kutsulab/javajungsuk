
	/* ========================================================================
	 *  Java의 정석 3판 p.738 예제 13-9 : 쓰레드 그룹
	 * ========================================================================
	 *
	 *     1. 쓰레드 그룹
	 *      서로 관련된 쓰레드를 그룹으로 취급함
	 *      
	 *      1) 생성자
	 *       - ThreadGroup(String name) : 지정 이름의 새로운 쓰레드그룹 생성
	 *       - ThreadGroup(ThreadGroup parent, String name)
	 *        : 지정 Thread 그룹에 속한 하위 ThreadGroup 생성
	 *      
	 *      2) 상,하위 쓰레드 그룹에 관한 정보
	 *       - int activeCount() : 쓰레드 그룹의 현재 활성 중인 Thread의 갯수
	 *       - int activeGroupCount() : 쓰레드 그룹의 현재 활성 중인 ThreadGroup의 갯수
	 *       
	 *       - ThreadGroup getParent() : 쓰레드 그룹의 상위 쓰레드그룹을 반환
	 *       - boolean parentOf(ThreadGroup g) : 지정된 쓰레드 그룹의 상위 쓰레드 그룹인지 확인
     *
	 *       - void list() : 쓰레드 그룹에 속한 쓰레드와 하위 쓰레드 그룹에 대한 정보를 출력
	 *       - int enumerate(Thread[] list, boolean recurse)
	 *        : 쓰레드 그룹에 속한 쓰레드의 목록을 지정 배열에 담고 그 개수를 반환.
	 *          true로 하면 하위 쓰레드 그룹에 속한 쓰레드까지 배열에 담음
	 *       - int enumerate(ThreadGroup[] list, boolean recurse)
	 *        : 쓰레드 그룹에 속한 쓰레드 그룹의 목록을 지정 배열에 담고 그 개수를 반환.
	 *          true로 하면 하위 쓰레드 그룹에 속한 쓰레드그룹까지 배열에 담음
	 *        
	 *      3) 그 외 정보 확인
	 *       - int getMaxPriority() : 쓰레드 그룹의 우선순위를 반환
	 *       - String Name() : 쓰레드 그룹의 이름 반환 
	 *       - void checkAccess()
	 *        : 현재 실행 중인 쓰레드가 쓰레드 그룹을 변경할 권한이 있는지 체크, 없다면 Security Exception을 발생
	 *        
	 *       - boolean isDaemon : 쓰레드 그룹이 데몬 쓰레드 그룹인지 확인
	 *       
	 *       - boolean isDestroyed() : 쓰레드 그룹이 삭제 되었는지 확인
	 *       
	 *      4) 정보 변경
	 *       - void setMaxPriority(int pri) : 쓰레드 그룹의 최대 우선순위를 지정
	 *       - void setDaemon(boolean daemon) : 쓰레드 그룹을 데몬 쓰레드 그룹으로 설정/해제
	 *       - void destroy() : 쓰레드 그룹 및 하위 쓰레드 그룹을 삭제, 단 쓰레드 그룹이나 하위 쓰레드 그룹이 비어있어야함.
	 *       
	 * ========================================================================
	 *     
	 *     2. Thread의 쓰레드 그룹에 관한 메서드
	 *     
	 *      1) 쓰레드의 생성
	 *      
	 *      - Thread(Runnable target) : 쓰레드 그룹을 지정하지 않을 경우 자신을 호출한 쓰레드 그룹에 포함시킴
	 *      - Thread(Thread group, Runnable target) : 지정 쓰레드 그룹에 생성
	 *      - Thread(Thread group, Runnable target, String name)
	 *      - Thread(Thread group, Runnable target, String name, long stackSize)
	 * 
	 *      2) 쓰레드 그룹과 관련된 메서드
	 *      
	 *      - ThreadGroup getThreadGroup() : 쓰레드 자신이 속한 쓰레드 그룹을 반환
	 *      - void uncaughtException(Thread t, Throwable e)
	 *      : 쓰레드 그룹의 쓰레드가 처리되지 않은 예외에 의해 실행이 종료되었을 때, JVM에 의해 이 메서드가 자동 호출됨.
	 *       
	 * ========================================================================
	 */

public class ThreadEx9 {

	public static void main(String[] args) {
		ThreadGroup main = Thread.currentThread().getThreadGroup(); // 현재 쓰레드가 속한 쓰레드 그룹을 반환한다.
		ThreadGroup thg1 = new ThreadGroup("Group1");
		ThreadGroup thg2 = new ThreadGroup("Group2");
		
		ThreadGroup subThg1 = new ThreadGroup(thg1, "SubGroup1"); // thg1에 속한 "SubGroup1" 쓰레드그룹을 생성
		
		thg1.setMaxPriority(3); // thg1 쓰레드 그룹의 최대 우선순위를 3으로 설정함
		
		Runnable r = new Runnable() { // 1회용 익명 클래스
			@Override
			public void run() {
				try {
					Thread.sleep(1000); // 활성화 집계의 편의를 위해 1초 지연 역할을 하게 함
					} catch (InterruptedException e) {}
			}
		};
		
		new Thread(thg1, r, "th1").start(); // thg1에 속하게 되므로 최대 우선순위는 3이다.
		new Thread(subThg1, r, "th2").start(); // thg1의 하위 쓰레드그룹 subThg1에 속하게 되므로 최대 우선순위는 5다.
		new Thread(thg2, r, "th3").start(); // thg2는 별도로 최대 우선순위를 지정하지 않았으므로, 최대 우선순위는 10이다.
		
		System.out.printf(">> List of ThreadGroup : %s\n",main.getName()); // 메인 쓰레드
		System.out.printf(">> Active ThreadGroup : %s\n",main.activeGroupCount()); // 현재 활성화 중인 쓰레드 그룹의 갯수 
		System.out.printf(">> Active Thread : %s\n",main.activeCount()); // 현재 활성화 중인 쓰레드의 갯수
		
		main.list(); // 이 ThreadGroup 및 하위 ThreadGroup에 관한 정보를 출력 
		
	}

}
