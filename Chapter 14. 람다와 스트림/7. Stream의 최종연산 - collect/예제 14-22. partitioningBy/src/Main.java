import java.util.*;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class Main {

    public static void main(String[] args) {
        List<Student> students = initStudents();

        System.out.printf("1. 단순분할(성별로 분할)%n");
        Map<Boolean, List<Student>> stuByGender =
                students.stream()
                        .collect(partitioningBy(Student::isMale)); // 남자니? -> 기준으로 분할

        List<Student> maleStudents = stuByGender.get(true);
        List<Student> femaleStudents = stuByGender.get(false);

        maleStudents.stream().forEach(System.out::println);
        femaleStudents.stream().forEach(System.out::println);

        System.out.printf("%n2. 단순분할 + 통계(각 성별의 학생수)%n");
        Map<Boolean, Long> stuNumByGender =
                students.stream()
                        .collect(partitioningBy(Student::isMale, counting())); // 남자니? ->  기준으로 그룹별 총 인구수를 반환.
        System.out.println("남학생 수 : "+stuNumByGender.get(true));
        System.out.println("여학생 수 : "+stuNumByGender.get(false));

        System.out.printf("%n3. 단순분할 + 통계(성별 1등)%n");
        Map<Boolean, Optional<Student>> topScoreByGender = students.stream()
                .collect(partitioningBy(Student::isMale, maxBy(comparingInt(Student::getScore))));
        System.out.println("남학생 1등 : "+topScoreByGender.get(true).get());
        System.out.println("남학생 1등 : "+topScoreByGender.get(false).get());

        System.out.printf("%n4. 다중분할 (각 성별별 불합격자, 100점 이하)%n");
        Map<Boolean, Map<Boolean, List<Student>>> stuByGender2 = students.stream()
                .collect(partitioningBy(Student::isMale, partitioningBy(s -> s.getScore() <= 100)));
        List<Student> failedMales = stuByGender2.get(true).get(true); // 남자를 성적 조건상으로 그룹핑했을 때 true
        List<Student> failedFemales = stuByGender2.get(false).get(true); // 여자를 성적 조건상으로 그룹핑했을 때 true
        failedMales.stream().forEach(System.out::println);
        failedFemales.stream().forEach(System.out::println);
    }


    // 학생 초기화
    private static List<Student> initStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("종려", true, 1,1, 300));
        students.add(new Student("캬루", false, 1,1, 250));
        students.add(new Student("아야토", true, 1,1, 200));
        students.add(new Student("아야카", false, 1,2, 150));
        students.add(new Student("벤티", true, 1,2, 100));
        students.add(new Student("각청", false, 1,2, 50));
        students.add(new Student("감우", false, 1,3, 100));
        students.add(new Student("에이", false, 1,3, 150));
        students.add(new Student("토마", true, 1,3, 200));

        students.add(new Student("타르탈리아", true, 2,1, 300));
        students.add(new Student("신학", false, 2,1, 250));
        students.add(new Student("다이루크", true, 2,1, 200));
        students.add(new Student("야에", false, 2,2, 150));
        students.add(new Student("카즈하", true, 2,2, 100));
        students.add(new Student("모나", false, 2,2, 50));
        students.add(new Student("코코미", false, 2,3, 100));
        students.add(new Student("바바라", false, 2,3, 150));
        students.add(new Student("중운", true, 2,3, 200));

        return students;
    }
}
