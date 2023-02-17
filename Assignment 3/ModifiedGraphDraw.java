import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class ModifiedGraphDraw extends JFrame
{
   private JPanel drawPanel = new JPanel();
   private final ArrayList<Point> points = new ArrayList<>();
   Random random = new Random();
   //private Arc2D arcs = new Arc2D();
   private Line2D.Double line = new Line2D.Double();
   Point start = null, end = null, holdpt = null, newpt = null;
   private JPopupMenu popupMenu;
   private JMenuItem add;
   private JMenuItem move;
   private JMenuItem delete;

   public ModifiedGraphDraw()
   {
      setTitle("test popup");
      //Container containPane = getContentPane();
      //popup menu items
      popupMenu = new JPopupMenu();
      add = new JMenuItem("Add");
      popupMenu.add(add);

      move = new JMenuItem("Move");
      popupMenu.add(move);

      delete = new JMenuItem("Delete");
      popupMenu.add(delete);

      drawPanel.add(popupMenu);
      this.add(drawPanel);

      //listener classes
      drawPanel.addMouseListener(new MouseAdapter()
      {
         @Override
         public void mouseReleased(MouseEvent e)
         {
            if (e.isPopupTrigger())
               popupMenu.show(e.getComponent(), e.getX(), e.getY());
         }
      });

      add.addMouseListener(new MouseAdapter()
      {
         @Override
         public void mouseClicked(MouseEvent e)
         {
            drawPanel.add(new JLabel("Click the mouse and drag to draw line"), BorderLayout.SOUTH);
            start = e.getPoint();
            points.add(start);
            //repaint();
         }

         @Override
         public void mouseDragged(MouseEvent e)
         {
            end = e.getPoint();
            points.add(end);
            repaint();
         }
      });

      move.addMouseListener(new MouseAdapter()
      {
         @Override
         public void mouseClicked(MouseEvent e)
         {
            holdpt = e.getPoint(); //point on the line where user clicked to start dragging
         }

         @Override
         public void mouseDragged(MouseEvent e)
         {
            drawPanel.add(new JLabel("Drag the mouse to move"), BorderLayout.SOUTH);
            newpt = e.getPoint();
            Component arc = e.getComponent();
            //location where the line will be dragged to
            arc.setLocation(newpt.x + holdpt.x, newpt.y + holdpt.y);
         }
      });

      delete.addMouseListener(new MouseAdapter()
      {
         @Override
         public void mouseClicked(MouseEvent e)
         {
            //drawPanel.add(new JLabel("Click the mouse to pick a starting point"), BorderLayout.SOUTH);
            Component arc = e.getComponent();
            arc.repaint();
         }
      });

      setBackground(Color.WHITE);
      setSize(450, 430);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public void paintComponent(Graphics g)
   {
      g.setColor(Color.BLACK);
      g.drawArc(start.x, start.y, 10, 10, 0, random.nextInt((360 -(-360)) + 1) -360);
      //g.drawLine(start.x, start.y, end.x, end.y);
   }

   public static void main(String[] args)
   {
      new ModifiedGraphDraw();
   }
}