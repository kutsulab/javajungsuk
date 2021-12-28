public class Student implements Comparable<Student> {

    private String name; // 학생
    private int ban; //반
    private int totalScore; // 총점

    public Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    public int getBan() {
        return this.ban;
    }

    public int getTotalScore() {
        return this.totalScore;
    }

    @Override
    public String toString() {
        return String.format("[%s, %d반, %d점]",name, ban, totalScore);
    }

    @Override
    // 총점 내림차순
    public int compareTo(Student s) {
        return s.getTotalScore() - this.getTotalScore();
    }
}
