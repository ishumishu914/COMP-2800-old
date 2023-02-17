import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DrawingPanel extends JPanel
{
    private int x1,x2,y1,y2;
    private int selection;

    public DrawingPanel(int choice)
    {
        selection = choice;
        addMouseListener(new MouseAdapter()
            {
                public void mousePressed(MouseEvent event)
                {
                    x1 = event.getX();
                    y1 = event.getY();
                    repaint();
                }
                public void mouseReleased(MouseEvent event)
                {
                    x2 = event.getX();
                    y2 = event.getY();
                    repaint();
                }
            }
        );
        addMouseMotionListener(new MouseMotionAdapter()
        {
            public void mouseDragged(MouseEvent event)
            {
                x2 = event.getX();
                y2 = event.getY();
                repaint();
            }
        });
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        switch (selection)
        {
            case 1:
                g.drawOval(x1,y1,x2,y2);
                break;
            case 2:
                g.drawRect(x1,y1,x2,y2);
                break;
        }
    }
}
