package hw5;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.border.*;

public class BorderTest {
   public static void main(String[] args) {
      GUIFrame8 frame = new GUIFrame8();
      frame.pack();
   }
}

@SuppressWarnings("serial")
class GUIFrame8 extends JFrame {
   private GUIPanel8 panel;
   
   public GUIFrame8() {
      setTitle("BorderTest");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLocation(200,200);
      panel = new GUIPanel8();
      setContentPane(panel);
      setVisible(true);
   }
}

@SuppressWarnings("serial")
class GUIPanel8 extends JPanel {
   private JTextField tf1 = new JTextField("Hello!",40);
   private JTextField tf2 = new JTextField("Hello!",40);
   private JTextField tf3 = new JTextField("Hello!",40);
   private JTextField tf4 = new JTextField("Hello!",40);
   private JTextField tf5 = new JTextField("Hello!",40);
   
   private JTextArea area; 
   private JTextArea area2;
   
   public GUIPanel8() {
	   area = new JTextArea("Hello!\na\nab\nabc\n ", 5,10);
	   area2 = new JTextArea("Hello!\na\nab\nabc\n ", 5,10);
	   JScrollPane lstsp = new JScrollPane(area);
	   JScrollPane lstsp2 = new JScrollPane(area2);
	   lstsp.setPreferredSize(new Dimension(200,110));
	   lstsp2.setPreferredSize(new Dimension(200,110));
	   
      JPanel p1 = new JPanel();
      p1.add(tf1);
      tf1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new LineBorder(Color.red, 5),new LineBorder(Color.green, 5)));  
      //p1.setBorder(BorderFactory.createBevelBorder( BevelBorder.LOWERED));
      
      JPanel p2 = new JPanel();
      p2.add(tf2);
      tf2.setBorder(javax.swing.BorderFactory.createCompoundBorder(new LineBorder(Color.red, 5),new CompoundBorder(new LineBorder(Color.green, 5),new LineBorder(Color.blue, 5))));
      
      JPanel p3 = new JPanel();
      p3.add(tf3);
      tf3.setBorder(javax.swing.BorderFactory.createCompoundBorder(new TitledBorder(new LineBorder(Color.green, 5),"A Green Border"),new LineBorder(Color.red, 5)));
      
      JPanel p4 = new JPanel();
      p4.add(tf4);
      tf4.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(Color.red, 5),new LineBorder(Color.green, 5)),"A Red-Green Border"));
      
      JPanel p5 = new JPanel();
      p5.add(tf5);
      tf5.setBorder(BorderFactory.createCompoundBorder(new TitledBorder(new LineBorder(Color.green, 5),"A Green Border"), new TitledBorder(new LineBorder(Color.red, 5),"A Red Border")));
      JPanel p6 = new JPanel();
      p6.add(lstsp);
      lstsp.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(Color.red, 5),new LineBorder(Color.green, 5)),"A bordered scrollpane"));
      JPanel p7 = new JPanel();
      p7.add(lstsp2);
      area2.setBorder(new LineBorder(Color.blue, 5));
      lstsp2.setBorder(new TitledBorder(new LineBorder(Color.red, 5),"A Red Border"));
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      add(p1); add(p2); add(p3);add(p4);add(p5);add(p6);add(p7);

  
   }
}
