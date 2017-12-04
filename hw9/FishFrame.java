
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.*;

@SuppressWarnings("serial")
public class FishFrame extends JFrame implements ActionListener {
   private FishPanel panel;
   private FishMenuBar menu;
   private Collection<Fish> fishes = new ArrayList<Fish>();
   private Collection<FTViewObserver> observers = new ArrayList<FTViewObserver>();
   private boolean suspended = false;
   private boolean visible;
   private JTextField text;
   
   public FishFrame() {
      setTitle("Fish Tank");
      setSize(650, 400);
      setLocation(20,20);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      panel = new FishPanel();
      menu= new FishMenuBar(panel);
      setJMenuBar(menu);
      getContentPane().add(panel);
      JFrame frame = new JFrame("Fish Counter");
      JPanel panel = new JPanel();
      frame.setSize(300,80);
      frame.setLocation(800,20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JLabel label1 = new JLabel("The aquariam has");
      text = new JTextField("",2);
      text.setForeground(Color.RED);
      String size = Integer.toString(fishes.size());
      text.setText(size);  
      this.addComponentListener(new ComponentAdapter(){
    public void componentResized(ComponentEvent e){
              resize(getSize());
    }
   });
      JLabel label2 = new JLabel("fishes");
      panel.add(label1);
      panel.add(text);
      panel.add(label2);
      frame.add(panel);
      frame.setVisible(true);
   }

   public void actionPerformed(ActionEvent e) { // called by the timer
      panel.tick();
      String size = Integer.toString(fishes.size());
      text.setText(size);  
      visible = !visible;
      text.setVisible(visible);
   }
   
   public void update(Collection<Fish> fishes){
     this.fishes = fishes;
     panel.update(fishes);
   }

   public void isSuspended(boolean b){
  suspended = b;
  panel.toggleSuspend();
 }
   
   public void addObserver(FTViewObserver x) {
     menu.addObserver(x);
}
   public void resize(Dimension d){
     menu.resize(d);
   }
   
   
}
