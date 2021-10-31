
	/* ========================================================================
	 *  Java의 정석 3판 p.822 : Stream의 생성 (5), (6), (7)
	 * ========================================================================
	 *
	 *     1. Stream의 생성 (5) 파일 기반
	 *     
	 *      java.nio.files.Files : 파일을 다루는데 필요한 유용한 메서드들을 제공
	 *      
	 *      
	 *      1) Stream<Path> Files.list(Path dir)
	 *       - 지정된 디렉토리에 있는 파일의 목록을 소스로 하는 스트림을 생성해서 반환한다.
	 *       - Path는 하나의 파일 또는 경로를 다루는 클래스
	 *      
	 *      2) Stream<String> Files.lines(Path path)
	 *         Stream<String> Files.lines(Path path, Charset cs)
	 *         
	 *        - 파일의 한 행의 문자열을 요소로 하는 String타입의 Stream
	 *         
	 *         (cf) Stream<String> lines() // BuffereReader의 메서드
	 *            - 파일 뿐 아니라, 다른 입력대상으로부터 데이터를 행단위로 읽어올 수 있음
	 *   
	 * ========================================================================
	 * 
	 *      2. Stream의 생성 (6) 빈 스트림
	 *        
	 *        Stream emptyStream = Stream.empty(); // 빈 스트림을 반환함
	 *        long count = emptyStream.count();; // count의 값은 0
	 *        
	 * ========================================================================
	 * 
	 *      3. Stream의 생성 (7) 두 스트림의 연결
	 *      
	 *       Stream<T> concatStream = Stream.concat(Stream<T> stream1, Stream<T? stream2)
	 *       
	 *       두 스트림을 하나로 연결함.
	 *       연결된 기존 Stream들은 더 이상 사용할 수 없다.
	 *      
	 * ========================================================================
	 */

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx3 {

	public static void main(String[] args) throws IOException {
	
		@SuppressWarnings("resource")
		Stream<String> lineStream = 
				Files.lines(Paths.get("text_StreamEx3.txt"),
						    Charset.forName("UTF-8"));
		System.out.println("=== lineStream ===");
		lineStream.forEach(System.out::println);
		System.out.println("==================");
		
		Stream<?> emptyStream = Stream.empty(); // 빈 Stream
		System.out.println("emptyStream.count() : "+emptyStream.count());
		
		String[] strArr1 = {"a","b","c"};
		String[] strArr2 = {"d","e","f"};
		
		Stream<String> strs1 = Arrays.stream(strArr1);
		Stream<String> strs2 = Arrays.stream(strArr2);
		Stream<String> strs3 = Stream.concat(strs1, strs2);
		strs3.forEach(System.out::print);
		System.out.println();
		
		strs3 = Stream.concat(Arrays.stream(strArr2), Arrays.stream(strArr1));
		strs3.forEach(System.out::print); // 순서상으로 뒤의 요소가 뒤에 병합됨
		System.out.println();
		
		int[] intArr1 = {1,2,3};
		int[] intArr2 = {4,5,6};
		
		IntStream ints1 = IntStream.of(intArr1);
		IntStream ints2 = IntStream.of(intArr2);
		IntStream ints3 = IntStream.concat(ints1, ints2);
		// System.out.println(ints1.sum()); // 에러 : ints1, ints2는 이미 소모되었다
		
		System.out.println("sum of ints3 : "+ints3.sum());
	}

}
