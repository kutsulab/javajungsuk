import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        final Path FILES_PATH = Paths.get("resources");

        Stream<Path> fileStream = Files.list(FILES_PATH);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //파일 풀네임 추출
        Stream<String> fileNameStream =
                fileStream.map(Path::getFileName)
                        .map(Path::toString); // 파일명 추출

        fileNameStream.forEach(System.out::println);
        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 확장자만 출력하기
        fileStream = Files.list(FILES_PATH); // Stream을 다시 생성

        fileStream.map(Path::getFileName)
                .map(Path::toString) // 파일명 추출
                .filter(s -> s.indexOf('.') != -1) // 확장자가 없으면 거름
                .map(s-> s.substring(s.indexOf('.')+1)) // 확장자만 필터링
                //.peek(...) // 중간 중간 peek 메서드를 호출하여, Stream의 요소를 소모하지 않고 특정 행동을 할 수 있음(디버깅 용도)
                .distinct() // 중복 제거
                .map(String::toUpperCase) // 대문자화
                .map(s-> s.concat(" ")) // 뒤에 공백을 붙임
                .forEach(System.out::print); // 출력

    }
}
