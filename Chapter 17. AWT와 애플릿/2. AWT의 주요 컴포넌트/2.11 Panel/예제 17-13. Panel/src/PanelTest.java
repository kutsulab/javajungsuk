import java.awt.*;

public class PanelTest {
    public static void main(String[] args) {

        // 프레임 생성
        Frame frame = new Frame("Panel");
        frame.setSize(300, 200);
        frame.setLayout(null); // 프레임의 레이아웃 매니저를 지정하지 않음.
        
        //패널 생성, 크기 및 위치 지정
        Panel panel = new Panel();
        panel.setBackground(new Color(138, 43, 226));
        panel.setSize(100,100);
        panel.setLocation(50, 50);

        //OK 버튼 생성
        Button button_OK = new Button("OK");

        //패널에 버튼을 추가하고, frame에 패널을 추가한다.
        panel.add(button_OK);
        frame.add(panel);
        frame.setVisible(true);
    }
}
