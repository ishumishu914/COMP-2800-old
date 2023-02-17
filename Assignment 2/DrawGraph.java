import java.awt.*;
//import java.awt.Graphics;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
//import java.awt.event.ItemListener;
//import java.awt.event.ItemEvent;
//import javax.swing.JRadioButton;
//import javax.swing.ButtonGroup;
import javax.swing.*;

public class DrawGraph extends JPanel
{
   private JRadioButton addButton;
   private JRadioButton moveButton;
   private JRadioButton deleteButton;
   private ButtonGroup radioGroup = new ButtonGroup();
   private JPanel buttonPanel = new JPanel();
   private final ArrayList<Point> points = new ArrayList<>();
   private final ArrayList<Line2D.Double> linesList = new ArrayList<Line2D.Double>();
   private Line2D.Double line = new Line2D.Double();
   Point start = null, end = null;
   Point newLocation = null;
   MouseEvent press;

   public DrawGraph()
   {
      //create radio buttons
      addButton = new JRadioButton("Add", true);
      moveButton = new JRadioButton("Move", false);
      deleteButton = new JRadioButton("Delete", false);

      //add button panel to current panel
      this.add(buttonPanel, BorderLayout.SOUTH);
      buttonPanel.add(addButton);
      buttonPanel.add(moveButton);
      buttonPanel.add(deleteButton);

      radioGroup.add(addButton);
      radioGroup.add(moveButton);
      radioGroup.add(deleteButton);

      // radio button events
      ItemListener itemListener = new ItemListener()
      {
         @Override
         public void itemStateChanged(ItemEvent event)
         {
            int state = event.getStateChange();
            Line2D.Double line = new Line2D.Double();

            if (state == ItemEvent.SELECTED)
            {
               if (event.getItem() == "Add")
               {
                  // handle frame mouse motion event
                  addMouseListener(
                       new MouseAdapter()
                       {
                          // store beginning & final coordinates and repaint
                          @Override
                          public void mousePressed(MouseEvent event)
                          {
                             start = event.getPoint();
                             points.add(start);
                          }
                          public void mouseReleased(MouseEvent event)
                          {
                             end = event.getPoint();
                             points.add(end);
                             repaint();
                          }
                         line = Line2D.Double(start.x, start.y, end.x, end.y);
                          //linesList.add(line);
                          //repaint();
                       }
                  );
                  // do i really need this?
                  /*addMouseMotionListener(
                       new MouseMotionAdapter()
                       {
                          // store drag coordinates
                          @Override
                          public void mouseDragged(MouseEvent event)
                          {
                             end = event.getPoint();
                             points.add(end);
                          }
                       }
                  );*/

               }

               else if (event.getItem() == "Move")
               {
                  addMouseListener(
                       new MouseAdapter()
                       {
                          // store beginning & final coordinates and repaint
                          @Override
                          public void mousePressed(MouseEvent event)
                          {
                             press = event;
                          }
                       }
                  );
                  //drag line & record new coordinates
                  addMouseMotionListener(
                       new MouseMotionAdapter() {
                          //Point newLocation = null;
                          @Override
                          public void mouseDragged(MouseEvent e)
                          {
                             Component component = e.getComponent();
                             newLocation = component.getLocation(newLocation);
                             int x = newLocation.x - press.getX() + e.getX();
                             int y = newLocation.y - press.getY() + e.getY();
                             component.setLocation(x, y);
                          }
                       }
                  );
               }

               else if (event.getItem() == "Delete")
               {
                  addMouseListener(
                       new MouseAdapter()
                       {
                          // store beginning & final coordinates and repaint
                          @Override
                          public void mousePressed(MouseEvent event)
                          {
                             press = event;
                          }
                       }
                  );
               }
            }
         }
      };
      addButton.addItemListener(itemListener);
      moveButton.addItemListener(itemListener);
      deleteButton.addItemListener(itemListener);


   }

   //@Override
   public void paintComponent(Graphics g)
   {
      // draw all
      if (start != null)
      {
         g.setColor(Color.BLACK);
         g.drawLine(start.x, start.y, end.x, end.y);
      }
   }

   public static void main(String[] args)
   {
      JFrame drawFrame = new JFrame("Drawing Lines");
      DrawGraph drawPanel = new DrawGraph();
      drawFrame.add(drawPanel, BorderLayout.CENTER);

      drawFrame.add(new JLabel("Drag the mouse to draw"), BorderLayout.SOUTH);
      drawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      drawFrame.setSize(600, 500);
      drawFrame.setVisible(true);
   }
}
