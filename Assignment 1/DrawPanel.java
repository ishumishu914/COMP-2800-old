import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class DrawPanel extends JPanel {
    private int x, y;
    public DrawPanel() {
        addMouseListener(
                new MouseAdapter() {
                    public void mouseClicked( MouseEvent event ) {
                        x = event.getX();
                        y = event.getY();
                        repaint();
                    }
                }
        );
    }
    public void paintComponent( Graphics g ) {
        super.paintComponent( g );
        g.drawOval( x, y, 10, 10);
    }
}
