import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.Timer;
import javax.imageio.*;
import javax.swing.*;

public class Race extends JFrame
{
   public static void main(String[] args) throws IOException
   {
      Hare hare = new Hare();
      Turtle turtle = new Turtle();
      hare.setPosition(1);
      turtle.setPosition(1);
      start(hare, turtle);

      JFrame frame = new JFrame("Hare vs Turtle race");
      frame.setSize(200, 500);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new BorderLayout());
      frame.setVisible(true);
   }
   public static void start(Hare hare, Turtle turtle)
   {
      BufferedImage image = null;
      try
      {
         image = ImageIO.read(new File("harerun.png"));
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      ImageIcon add = new ImageIcon(image);
      boolean winner = false;

      final Timer timer = new Timer();
      ActionListener listener = new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent e)
         {

         }
      };

   }
}
