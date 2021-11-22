import java.awt.*;

public class FrameTest2 {
    public static void main(String[] args) {
        Frame frame = new Frame("멍멍");

        final int FRAME_WIDTH = 300;
        final int FRAME_HEIGHT = 200;
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT); // frame의 크기 지정

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize(); // Screen의 크기에 관한 인스턴스

        final int SCREEN_WIDTH = screenSize.width;
        final int SCREEN_HEIGHT = screenSize.height;

        final int FRAME_X = SCREEN_WIDTH/2 - FRAME_WIDTH/2; // Screen의 가운데에 frame을 두기 위함
        final int FRAME_Y = SCREEN_HEIGHT/2 - FRAME_HEIGHT/2;

        frame.setLocation(FRAME_X, FRAME_Y); // frame의 위치 지정
        frame.setVisible(true);
    }
}

