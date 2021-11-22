import java.awt.*;

public class FrameTest {
    public static void main(String[] args) {
        Frame frame = new Frame("냐옹"); // Title의 text가 "냐옹"인 Frame을 생성한다.
        frame.setSize(300, 200); // 컴포넌트의 size를 지정한다.
        frame.setVisible(true); // 컴포넌트가 화면에 보이게(true) 한다.

        System.out.println("==========================================");
        System.out.println("frame.getTitle() : "+frame.getTitle()); // frame의 Title의 text를 얻어온다.
    }
}
