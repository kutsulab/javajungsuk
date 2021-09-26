
import java.util.*;

public class ArraysEx {
	
	/* Java의 정석 3판 p.626 예제 11-18 : Arrays 클래스
	 * 
	 * [Arrays 클래스]
	 * 배열을 다루는데 사용되는 여러가지 static 클래스가 존재함
	 * 
	 * [배열 출력]
	 * - toString(1차원 배열), deepToString(다차원 배열) : 2차원 이상의 배열을 출력
	 * 
	 * [배열의 비교]
	 * - Arrays.equals(arr1, arr2) : 1차원배열의 모든 요소를 비교하여 같으면 true, 하나라도 다르면 false
	 * - Arrays.deepEquals(arr2D1, arr2D2) : 다차원배열의 모든 요소를 비교하여 같으면 true, 하나라도 다르면 false
	 * 
	 * [배열 복사]
	 * 
	 * - copyOf(original, to) : 원본 original 배열에서 to 이전 인덱스까지의 데이터를 복사한 배열을 반환
	 * - copyOfRange(original, from, to) : 원본 arr에서 from <= i < to 인덱스를 복사한 배열을 반환
	 *   (cf : System.arrayCopy(original, originalStart, new, newStart, length)
	 *                           원본              원본 시작              사본배열   사본시작      복사인덱스수
	 * 
	 * [배열 채우기]
	 * - fill(arr, obj) : arr 배열의 모든 요소를 obj로 채움
	 * - setAll(arr, 람다식)
	 * 
	 * [배열의 정렬, 검색]
	 *  - Arrays.sort(arr) : arr 배열을 정렬
	 *  - Arrays.binarySearch(arr, number) : arr 배열에서 지정된 값이 저장된 인덱스를 반환.
	 *      (주의 : binarySearch는 이진검색 방식을 통해 검색하기 때문에 정렬이 선행되어야함)
	 *
	 * [배열을 List로 변환]
	 *  - Arrays.asList(Object... a) : 가변인수 -> 여러 저장할 요소들을 나열하여 list 생성
	 *  - 객체 배열을 인수로 하여, List로 변환 가능.
	 *  - List로 객체로 생성되면 추가, 삭제가 불가능함. 수정하고 싶다면 ArrayList 객체를 생성해서 다루면 됨
	 *  - 예) List list = new ArrayList(Arrays.asList(new Integer[] {1,2,3,4,5}));
	 *       List 객체를 생성 후, 이를 인수로 하여 ArrayList 객체를 생성 후 List 타입 참조변수로 다루기
	 *  
	 *  
	 * 
	 * [그 외 : 14장 람다, 스트림와 관련된 내용이므로 참고]
	 *  - parallelXXX() : 여러 쓰레드가 나눠서 작업
	 *  - spliterator() : 여러 쓰레드가 나눠서 처리할 수 있게 하나의 작업을 여러 작업으로 나누는 Spliterator 반환
	 *  - stream() : 컬렉션을 스트림으로 반환
	 *  
	 */
	public static void main(String[] args) {
		
		int[] arr = {0,1,2,3,4};
		int[][] arr2D = {{11,12,13}, {21,22,23}};
		
		System.out.println("======== 배열의 출력 : Arrays.toString, Arrays.deepToString ==========");
		System.out.println("arr = "+Arrays.toString(arr));
		System.out.println("arr2D = "+Arrays.deepToString(arr2D)); // 다차원배열은 Arrays.deepToString을 사용
		System.out.println();
		
		int[] arr2 = Arrays.copyOf(arr, arr.length); // arr을 arr.length-1 index까지 복사(끝까지 복사)
		int[] arr3 = Arrays.copyOf(arr, 3); //arr을 index 2까지 복사
		int[] arr4 = Arrays.copyOf(arr,7); //arr을 index 6까지 복사(arr.length -1을 벗어난 부분은 0으로 채움)
		int[] arr5 = Arrays.copyOfRange(arr,2,4); //arr을 2<=index < 4 부분 복사
		int[] arr6 = Arrays.copyOfRange(arr,0,7); //arr을 0<=index < 7 부분 복사 (벗어난 부분은 0으로 채움)
		
		
		System.out.println("========== 배열의 복사 : Arrays.copyOf, Arrays.copyOfRange ==========");
		System.out.println("arr2 = "+Arrays.toString(arr2));
		System.out.println("arr3 = "+Arrays.toString(arr3));
		System.out.println("arr4 = "+Arrays.toString(arr4));
		System.out.println("arr5 = "+Arrays.toString(arr5));
		System.out.println("arr6 = "+Arrays.toString(arr6));
		System.out.println();
		
		System.out.println("============ 배열 채우기 : Arrays.fill, Arrays.setAll ==============");
		int[] arr7 = new int[5];
		Arrays.fill(arr7, 9); // arr7의 모든 index의 요소를 9로 채운다.
		System.out.println("arr7 = "+Arrays.toString(arr7)); // 람다식
		
		Arrays.setAll(arr7, i-> (int)(Math.random()*6)+1);
		System.out.println("arr7 = "+Arrays.toString(arr7));
		
		for(int i : arr7) {//arr7의 모든 인덱스에 저장된 값을 순서대로 불러와 i에 저장 
			char[] graph = new char[i];
			Arrays.fill(graph, '*'); // 각 index의 숫자갯수만큼 *을 채움
			System.out.println(new String(graph)+i); // * 채운 것 + 값 출력
		}
		System.out.println();
		
		
		System.out.println("============ 배열의 비교 : Arrays.equals, Arrays.deepEquals =============");
		
		String[][] str2D = new String[][] {{"aaa","bbb"},{"AAA","BBB"}};
		String[][] str2D2 = new String[][] {{"aaa","bbb"},{"AAA","BBB"}};
		
		System.out.println("Arrays.equals(str2D, str2D2) = "+Arrays.equals(str2D, str2D2)); // 다차원 배열의 비교에 Arrays.equals는 적합하지 못하다.
		System.out.println("Arrays.deepEquals(str2D, str2D2) = "+Arrays.deepEquals(str2D, str2D2));
		System.out.println();

		System.out.println("=========== 배열의 정렬, 검색 : Arrays.sort, Arrays.binarySearch ==============");
		char[] chArr = {'A','D','C','B','E'};
		System.out.println("chArr = "+Arrays.toString(chArr));
		System.out.println("index of 'B' : "+Arrays.binarySearch(chArr, 'B')); // Arrays.binarySearch 메서드는 이진탐색을 하기에, 정렬되어있는 상황에서 사용해야 제대로 된 결과를 얻을 수 있다.
		
		Arrays.sort(chArr); // 정렬
		System.out.println("------------- After Sorting ------------");
		System.out.println("chArr = "+Arrays.toString(chArr));
		System.out.println("index of 'B' : "+Arrays.binarySearch(chArr, 'B'));
		System.out.println();
		
		System.out.println("============== 배열을 List로 : Arrays.asList ==============");
		Integer[] integerArr = new Integer[] {0,1,2,3,4};
		System.out.println("integerArr = "+Arrays.toString(integerArr));
		
		List list = new ArrayList(Arrays.asList(integerArr)); // 배열을 인수로 하여 List를 반환받고, 이를 인수로 하여 ArrayList 객체 생성
		list.add(5);
		list.add(6);
		list.add(7);
		
		System.out.println("list : "+Arrays.toString(list.toArray())); // toArray로 배열을 반환받고 Arrays.toString()으로 출력
	}

}
