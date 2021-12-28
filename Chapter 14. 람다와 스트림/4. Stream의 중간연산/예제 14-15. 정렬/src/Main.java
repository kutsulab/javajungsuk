import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("캬루", 3, 300));
        students.add(new Student("아루", 1, 200));
        students.add(new Student("몰루", 2, 100));
        students.add(new Student("각루", 2, 100));
        students.add(new Student("냐루", 3, 300));
        students.add(new Student("란란루", 3, 290));
        students.add(new Student("수캬루", 3, 180));

        Stream<Student> studentStream = students.stream();

        studentStream.sorted(Comparator.comparing(Student::getBan) // 학생의 '반'의 기본 정렬기준을 최우선 정렬기준으로 함
                .thenComparing(Comparator.naturalOrder())) // 그 다음 정렬 기준은 기본정렬기준(총점)
                .forEach(System.out::println);
    }
}
