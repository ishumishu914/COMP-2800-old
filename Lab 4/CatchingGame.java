import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;

//use jslider for changing speed
//use bufferedimage object for random popup photos

public class CatchingGame extends JFrame
{
   //private JDesktopPane desktopPane;
   private JSlider speedSlider;
   private JButton photoButton; //clickable image
   private JPanel panel = new JPanel();
   //private static final ImageIcon img;

   public CatchingGame() throws IOException, UnsupportedAudioFileException, LineUnavailableException
   {
      super("Catch the running photo!");
      /*desktopPane = new JDesktopPane();
      add(desktopPane);*/
      this.add(panel);

      //sound
      File soundFile = new File("sound.wav");
      AudioInputStream sound = AudioSystem.getAudioInputStream(soundFile);
      DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
      Clip clip = (Clip) AudioSystem.getLine(info);
      clip.open(sound);

      //image button
      SecureRandom generator = new SecureRandom();
      photoButton = new JButton("Image");
      photoButton.setBounds(generator.nextInt(), generator.nextInt(), this.getWidth(), this.getHeight());
      //desktopPane.add(photoButton);
      panel.add(photoButton);

      String[] images = {"img1.png", "img2.png", "img3.png", "img4.png", "img5.png"};
      Image img = ImageIO.read(getClass().getResource(images[generator.nextInt(images.length)]));

      photoButton.addActionListener(new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            //upon clicking image button, change image to random choice and put sound clip
            photoButton.setIcon(new ImageIcon(img));
            clip.start();
         }
      });

      //slider for speed
      speedSlider = new JSlider(SwingConstants.HORIZONTAL, 0,100,10);
      speedSlider.setMajorTickSpacing(10);
      speedSlider.setPaintTicks(true);

      speedSlider.addChangeListener(new ChangeListener()
      {
         @Override
         public void stateChanged(ChangeEvent e)
         {
            speedSlider.getValue();
         }
      });
      //desktopPane.add(speedSlider, BorderLayout.NORTH);
      add(speedSlider, BorderLayout.NORTH);
   }

   // return image dimensions
   public Dimension getPreferredSize()
   {
      return new Dimension(photoButton.getWidth(),
              photoButton.getHeight());
   }

   public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
      CatchingGame catchingGame = new CatchingGame();
      catchingGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      catchingGame.setSize(600, 480);
      catchingGame.setVisible(true);
   }
}