import java.awt.*;

public class ButtonTest {
    public static void main(String[] args) {
        Frame frame = new Frame("클릭 시 200억이 입금됨");
        frame.setSize(300, 200); // frame의 사이즈를 지정

        Button button = new Button("Click");
        button.setSize(100,50); // button의 사이즈를 지정

        frame.add(button); // frame에 button을 추가
        frame.setVisible(true); // frame을 화면에 표시
    }
}
