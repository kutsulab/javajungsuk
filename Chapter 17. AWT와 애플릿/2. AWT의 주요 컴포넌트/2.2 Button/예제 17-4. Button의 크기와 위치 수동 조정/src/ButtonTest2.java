import java.awt.*;

public class ButtonTest2 {
    public static void main(String[] args) {
        Frame frame = new Frame("클릭시 10억 입금");
        final int FRAME_WIDTH = 300;
        final int FRAME_HEIGHT = 200;
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setLayout(null); // LayoutManager를 null로 설정해준다.

        Button button = new Button("Click");
        final int BUTTON_WIDTH = 100;
        final int BUTTON_HEIGHT = 50;
        button.setSize(BUTTON_WIDTH,BUTTON_HEIGHT); // button의 사이즈를 지정

        final int BUTTON_X = FRAME_WIDTH/2 - BUTTON_WIDTH/2;
        final int BUTTON_Y = FRAME_HEIGHT/2 - BUTTON_HEIGHT/2;
        button.setLocation(BUTTON_X,BUTTON_Y); // button의 위치를 지정

        frame.add(button);
        frame.setVisible(true);

    }
}

