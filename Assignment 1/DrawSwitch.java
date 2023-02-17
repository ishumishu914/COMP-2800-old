import java.awt.*;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JComboBox;

public class DrawSwitch extends JFrame
{
    private final JComboBox<String> switchComboBox;
    private static final String[] names = {"oval", "rectangle"};
    private int choice;

    public DrawSwitch()
    {
        super();
        setLayout(new FlowLayout());

        switchComboBox = new JComboBox<String>(names);
        switchComboBox.setMaximumRowCount(2);
        switchComboBox.setBounds(5,5,10,10);
        switchComboBox.addItemListener(
            new ItemListener()
            {
                @Override
                public void itemStateChanged(ItemEvent event)
                {
                    if (event.getStateChange() == ItemEvent.SELECTED) 
                    {
                        if (event.getItem() == "oval")
                        {
                            choice = 1;
                            add(new DrawingPanel(choice));

                        }
                        else if (event.getItem() == "rectangle")
                        {
                            choice = 2;
                            add(new DrawingPanel(2));
                        }
                    }
                }
            }
        );

        this.add(switchComboBox);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //DrawingPanel p = new DrawingPanel(choice);
        //add(p);
        this.setSize(600, 600);
        this.setVisible(true);
    }

    public static void main(String[] args) 
    {
        /*DrawSwitch d = new DrawSwitch();
        d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DrawingPanel p = new DrawingPanel();
        d.add(p);
        d.setSize(600, 600);
        d.setVisible(true);*/
        new DrawSwitch();
    }
}