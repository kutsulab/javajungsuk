
public class Student {

    private String name; // 성별
    private boolean isMale; // 남자니? 여자니?
    private int hak; // 학년
    private int ban; // 반
    private int score; // 점수

    public Student(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public int getHak() {
        return hak;
    }

    public int getBan() {
        return ban;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점]",
                name,
                (isMale) ? "남" : "여",
                hak,
                ban,
                score);
    }
}
