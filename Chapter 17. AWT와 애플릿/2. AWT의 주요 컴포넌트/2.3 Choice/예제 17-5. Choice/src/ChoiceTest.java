import java.awt.*;

public class ChoiceTest {
    public static void main(String[] args) {
        Frame frame = new Frame("Choice - Select");

        final int FRAME_WIDTH = 300;
        final int FRAME_HEIGHT = 200;

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLayout(null); // LayoutManager을 설정하지 않음.

        Choice day = new Choice(); // choice 생성
        day.add("SUN"); // Choice에 item들 추가
        day.add("MON");
        day.add("TUE");
        day.add("WED");
        day.add("THU");
        day.add("FRI");
        day.add("SAT");

        final int CHOICE_WIDTH = 100;
        final int CHOICE_HEIGHT = 50;

        day.setSize(CHOICE_WIDTH, CHOICE_HEIGHT); // Choice의 크기 지정

        final int CHOICE_X = FRAME_WIDTH/2 - CHOICE_WIDTH/2;
        final int CHOICE_Y = FRAME_HEIGHT/2 - CHOICE_HEIGHT/2;

        day.setLocation(CHOICE_X, CHOICE_Y); // Choice의 좌표 지정

        frame.add(day); // Frame에 Choice 추가
        frame.setVisible(true); // Frame을 화면에 보이게 함
    }
}
