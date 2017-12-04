import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

// GUI4: Similar to GUI3 except with two buttons

public class GUI4 {
   public static void main(String[] args) {
      GUIFrame4 frame = new GUIFrame4();
      frame.pack();
   }
}

@SuppressWarnings("serial")
class GUIFrame4 extends JFrame {
   private GUIPanel4 panel;
   
   public GUIFrame4() {
      setTitle("GUI3a Demo");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLocation(200,200);
      panel = new GUIPanel4();
      setContentPane(panel);
      setVisible(true);
   }
}

@SuppressWarnings("serial")
class GUIPanel4 extends JPanel implements ActionListener {
   private JLabel lbl     = new JLabel("value is 50");
   private JTextField txt = new JTextField("50", 4);
   private JSlider sld    = new JSlider(0, 100, 50);
   private JSpinner spn   = new JSpinner();
   private JCheckBox chk  = new JCheckBox("value is even", true);
   private JList<String> lst;
   private JTextArea area = new JTextArea(5,10);
   private JButton btn1 = new JButton("SYNCH WITH SLIDER");
   private JButton btn2 = new JButton("SYNCH WITH TEXT FIELD");
   
   public GUIPanel4() {
      spn.setValue(50);
      String[] listitems = new String[] {"zero", "one", "two", "three", "four"};
      lst = new JList<String>(listitems);
      lst.setVisibleRowCount(3);
      JScrollPane lstsp = new JScrollPane(lst);
      JScrollPane areasp = new JScrollPane(area);
      
      JPanel p1 = new JPanel();
      p1.add(lbl); p1.add(txt); p1.add(sld); p1.add(spn);
      p1.setBorder(new LineBorder(Color.red));
      JPanel p2 = new JPanel();
      p2.add(chk); p2.add(lstsp);
      p2.setBorder(new LineBorder(Color.blue));
      areasp.setBorder(new LineBorder(Color.green));
      
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      add(p1); add(p2); add(areasp);
      
      // new for version 4
      add(btn1); add(btn2);
      btn1.addActionListener(this);  
      btn2.addActionListener(this); 
      
      txt.add(lbl);
   }
   
   // new for version 4
   public void actionPerformed(ActionEvent evt) {
     if (evt.getSource() == btn1)
      synch(sld.getValue());
     else {
      int val;
      try {
       val = Integer.parseInt(txt.getText());
      }
      catch(NumberFormatException e) { val = 0;}
      synch(val);
     }
   }
   
   public void synch(int val) {
     sld.setValue(val);
      lbl.setText("value is " + val);
      txt.setText("" + val);
      spn.setValue(val);
      if (val % 2 == 0)
         chk.setSelected(true);
      else
         chk.setSelected(false);
      area.append("\nnew value is " + val);
      lst.setSelectedIndex(val % 5);
   }
}

