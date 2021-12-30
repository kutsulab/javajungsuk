public class Student implements Comparable<Student> {

    private String name;
    private int ban;
    private int totalScore;

    public Student(String name, int ban, int  totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }


    public String getName() {
        return this.name;
    }

    public int getBan() {
        return this.ban;
    }

    public int getTotalScore() {
        return this.totalScore;
    }

    @Override
    public String toString() {
        return String.format("[%s, %d, %d]", this.name, this.ban, this.totalScore);
    }

    @Override
    // 기본정렬 기준은 총점 기준 내림차순
    public int compareTo(Student o) {
        return o.totalScore-this.totalScore;
    }
}
