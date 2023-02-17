import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ColorSlider extends JFrame
{
    private final JSlider redSlider, greenSlider, blueSlider;
    private final JLabel redlabel, redvalLabel, greenlabel, greenvalLabel, bluelabel, bluevalLabel;
    private final JPanel colorPanel, infoPanel, sliders, labels1, labels2;

    public ColorSlider()
    {
        super();

        // initialize sliders
        redSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        greenSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        blueSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);

        //labels
        redlabel = new JLabel("Red");
        greenlabel = new JLabel("Green");
        bluelabel = new JLabel("Blue");

        redvalLabel = new JLabel("0");
        greenvalLabel = new JLabel("0");
        bluevalLabel = new JLabel("0");

        //panel
        colorPanel = new JPanel();
        infoPanel = new JPanel();
        colorPanel.setBackground(Color.WHITE);
        labels1 = new JPanel();
        sliders = new JPanel();
        labels2 = new JPanel();

        labels1.setLayout(new GridLayout(3,3,5,1));
        sliders.setLayout(new GridLayout(3,3,5,1));
        labels2.setLayout(new GridLayout(3,3,5,1));

        //listner classes
        redSlider.addChangeListener(new event());
        blueSlider.addChangeListener(new event());
        greenSlider.addChangeListener(new event());

        Container pane = this.getContentPane();
        pane.setLayout(new GridLayout(2,1,1,1));

        // add panel, sliders & labels
        this.add(colorPanel, BorderLayout.NORTH);
        this.add(infoPanel, BorderLayout.SOUTH);

        //add sliders & labels in infoPnael
        infoPanel.add(labels1, BorderLayout.SOUTH);
        infoPanel.add(sliders, BorderLayout.SOUTH);
        infoPanel.add(labels2, BorderLayout.SOUTH);

        labels1.add(redlabel);
        labels1.add(bluelabel);
        labels1.add(greenlabel);

        sliders.add(redSlider);
        sliders.add(blueSlider);
        sliders.add(greenSlider);

        labels2.add(redvalLabel);
        labels2.add(bluevalLabel);
        labels2.add(greenvalLabel);
    }

    public class event implements ChangeListener
    {
        public void stateChanged(ChangeEvent event)
        {
            int r = redSlider.getValue();
            int b = blueSlider.getValue();
            int g = greenSlider.getValue();

            redvalLabel.setText("" + r);
            bluevalLabel.setText("" + b);
            greenvalLabel.setText("" + g);

            colorPanel.setBackground(new Color(r,g,b));
        }
    }

    public static void main(String[] args)
    {
        ColorSlider colorSlider = new ColorSlider();
        colorSlider.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        colorSlider.setVisible(true);
        colorSlider.setTitle("Slider for Colors");
        colorSlider.setSize(400, 300);
    }
}
