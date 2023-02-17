import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class ParentFrame extends JFrame
{
    public JFrame frame = new JFrame("The Parent frame");
    private final JButton button;

    public ParentFrame() 
    {
        super("Testing Buttons");
        frame.setLayout(null);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button = new JButton("Show A New Frame"); // button with text
        button.setBounds(50,40, 100, 50);
        frame.add(button); // add plainJButton to JFrame
        
        // create new ButtonHandler for button event handling 
        ButtonHandler handler = new ButtonHandler();
        button.addActionListener(handler);

        frame.setSize(275, 110);
        frame.setVisible(true);
   }

   // inner class for button event handling
   public class ButtonHandler implements ActionListener
   {
        // handle button event
        @Override
        public void actionPerformed(ActionEvent event)
        {
            new ChildFrame(frame);
        }
   }

    public static void main(String[] args) 
    {
        new ParentFrame();
    }
}