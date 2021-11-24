import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame implements MouseMotionListener {

    private int x = 0;
    private int y = 0;

    public MyFrame(String title) {
        super(title);
        addMouseMotionListener(this);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        setBounds(100,100, 500, 500);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("Move mouse Cursor.", 10, 50);
        g.drawString("*", this.x, this.y);
    }

    @Override
    public void mouseDragged(MouseEvent me) {

    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        // 마우스 이동이 감지되면, 이동한 x,y 좌표를 멤버변수에 반영시킨 뒤 repain()를 호출한다.
        this.x = me.getX();
        this.y = me.getY();
        repaint();
    }
}
