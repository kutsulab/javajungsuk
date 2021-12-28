import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("캬루", 3, 300));
        students.add(new Student("아루", 1, 200));
        students.add(new Student("몰루", 2, 100));
        students.add(new Student("각루", 2, 150));
        students.add(new Student("냐루", 3, 200));
        students.add(new Student("란란루", 3, 290));
        students.add(new Student("수캬루", 3, 180));

        Stream<Student> studentStream = students.stream();

        studentStream.sorted(Comparator.comparing(Student::getBan) // 반 기준으로 오름차순
                .thenComparing(Comparator.naturalOrder())) // 기본정렬 기준 : 총점 내림차순
                .forEach(System.out::println); // 출력

        studentStream = students.stream(); // 다시 Stream 생성
        IntStream scoreStream = studentStream.mapToInt(Student::getTotalScore); // 총점 IntStream 생성

        IntSummaryStatistics stat = scoreStream.summaryStatistics(); // 총점 IntStream으로부터 Statistics 생성
        System.out.println("count : "+stat.getCount()); // 갯수
        System.out.println("sum : "+stat.getSum()); // 합
        System.out.printf("average : %.2f%n",stat.getAverage()); // 평균
        System.out.println("min : "+stat.getMin()); // 최솟값
        System.out.println("max : "+stat.getMax()); // 최댓값

    }
}
