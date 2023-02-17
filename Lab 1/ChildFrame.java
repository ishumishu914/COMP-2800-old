import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class ChildFrame extends JFrame
{
    private JFrame frame = new JFrame("A Child Frame");
    private JButton button = new JButton("Change a parent color");

    public ChildFrame(JFrame parent)
    {
        frame.setLayout(null);

        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(275, 110);
        frame.setVisible(true);
        button.setBounds(80,45,110,45);
        frame.add(button);

        event e = new event();
        frame.addMouseListener(e);
    }

    public Color randomColor()
    {
        int r = (int)(Math.random() * 255);
        int g = (int)(Math.random() * 255);
        int b = (int)(Math.random() * 255);
        return (new Color(r, g, b));
    }

    public class event implements MouseListener
    {
        public void mouseClicked(MouseEvent e) 
        {
            parent.getContentPane().setBackground(randomColor());
        }

        public void mousePressed(MouseEvent e) {}

        public void mouseReleased(MouseEvent e){}

        public void mouseEntered(MouseEvent e) {}

        public void mouseExited(MouseEvent e) {}
    }

    /*public static void main(String[] args)
    {
        new ChildFrame();
    }*/
}
