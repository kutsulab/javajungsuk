import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {

    // 생성자
    public MyFrame(String title) {
        super(title);
        addWindowListener(new WindowAdapter() { // 창을 닫았을 때 프로그램이 종료되는 이벤트 리스너를 추가
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        }
        );
        setBounds(100,100, 400,300);
        // setSize(400, 300);
        // setLocation(100, 100);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.setFont(new Font("SansSerif", Font.PLAIN, 15));
        g.drawString("This picture has been painted with Graphics.", 10, 50);

        g.drawOval(50, 100, 50, 50);
        g.setColor(Color.pink);
        g.fillOval(100,100, 50,50);

        g.setColor(Color.blue);
        g.drawLine(100,100, 150, 150);
        g.drawLine(150,100,100,150);

        g.setColor(Color.CYAN);
        g.fillRoundRect(200,100,120,80,30,30);

        g.setColor(Color.orange);
        g.fillPolygon(new int[]{50,100,150,200}, new int[]{250,200,200,250},4);

        g.setColor(Color.black);
        g.fillArc(250, 200, 100, 100, 0, 120);
    }
}
