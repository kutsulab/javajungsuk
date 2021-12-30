import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("캬루", 3, 300));
        students.add(new Student("아루", 1, 200));
        students.add(new Student("몰루", 2, 100));
        students.add(new Student("각루", 2, 150));
        students.add(new Student("냐루", 1, 200));
        students.add(new Student("란란루", 3, 290));
        students.add(new Student("수캬루", 3, 180));

        // 학생 이름만 뽑아서 List<String>에 저장
        List<String> names = students.stream()
                .map(Student::getName)
                .sorted() // String 기본정렬
                .collect(toList()); // List로 수집
        System.out.println(names);
        System.out.println();

        //Stream을 배열로 변환
        Student[] studentArr = students.stream()
                .sorted(Comparator.comparing(Student::getBan) // 반 기준으로 오름차순
                        .thenComparing(Comparator.naturalOrder())) // 총점 기준 내림차순
                .toArray(Student[]::new); // Student 배열로 반환

        for(Student student : studentArr) System.out.println(student);
        System.out.println();

        // Stream을 Map<String, Student>에 변환. 학생 이름이 key
        Map<String, Student> studentRepository = students.stream()
                .collect(toMap(Student::getName, Function.identity())); // Map으로 반환

        for (String name : studentRepository.keySet()) {
            System.out.println(name +" - "+studentRepository.get(name)); // 각 name별로 Map에서 대응되는 Student 찾아서 출력
        }
        System.out.println();

        // 학생수, 총점
        long count = students.stream()
                .collect(counting()); // 학생수 수집
        long totalScore = students.stream()
                .collect(summingInt(Student::getTotalScore)); // 총점을 수집하여 총점의 합을 반환

        System.out.println("학생수(count) = "+count);
        System.out.println("전체 총점(totalScore) = "+totalScore);

        totalScore = students.stream()
                .collect(reducing(0,Student::getTotalScore,Integer::sum)); // 초깃값 0, 누적 대상은 총점, 누적방식은 총점의 합.

        System.out.println("전체 총점(totalScore) = "+totalScore);
        System.out.println();

        students.stream()
                .collect(maxBy(Comparator.comparing(Student::getTotalScore))) // 총점이 제일 높은 학생을 Optional로 반환
                .ifPresent(student -> System.out.println("topStudent= "+student+'\n')); // 값이 존재하면 출력

        IntSummaryStatistics stats = students.stream()
                .collect(summarizingInt(Student::getTotalScore)); // 학생의 총점에 대한 SummaryStatistics를 반환

        System.out.println(stats);
        System.out.println();

        String names2 = students.stream()
                .map(Student::getName) // 학생의 이름들
                .collect(joining(", ", "[", "]")); // 지정 결합자로 결합한 문자열 반환

        System.out.println(names2);
    }

}
