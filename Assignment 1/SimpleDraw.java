import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JComboBox;

public class SimpleDraw extends JFrame
{
    public static void main( String args[] )
    {
        SimpleDraw f = new SimpleDraw();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DrawPanel p = new DrawPanel();
        f.add(p);
        f.setSize(300, 200);
        f.setVisible(true);
    }
}
