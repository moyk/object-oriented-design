
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.*;

@SuppressWarnings("serial")
public class FishMenuBar extends JMenuBar {
   private Collection<FTViewObserver> observers = new ArrayList<FTViewObserver>();
   private Collection<Fish> fishes = new ArrayList<Fish>();
   
   public FishMenuBar(FishPanel fp) {  // set up the menu bar
      JMenu animation = new JMenu("Animation");
      add(animation);
     JMenuItem startstop = new JMenuItem("Stop");
      animation.add(startstop);
      startstop.addActionListener(e->{
     startStopPressed();
        String label = startstop.getText();
        String newlabel = label.equals("Start") ? "Stop" : "Start";
        startstop.setText(newlabel);
      });
      
      JMenu newmenu = new JMenu("New Fish");
      add(newmenu);
      JMenuItem angelfish = new JMenuItem("Angel Fish");
      newmenu.add(angelfish);
      angelfish.addActionListener(e->newFish(angelfish.getText()));
      JMenuItem meanie = new JMenuItem("Mean Fish");
      newmenu.add(meanie);
      meanie.addActionListener(e->newFish(meanie.getText()));
      JMenuItem octopus = new JMenuItem("Octopus");
      newmenu.add(octopus);
      octopus.addActionListener(e->newFish(octopus.getText()));    
   }
 
 public void addObserver(FTViewObserver x) {
  observers.add(x);
}

 private void newFish( String fishtype) {
  for (FTViewObserver ft : observers)
         ft.newFish(fishtype);
  }
 
 public void startStopPressed(){
  for (FTViewObserver ft : observers)
         ft.startStopPressed();
}
 public void resize(Dimension d){
  for (FTViewObserver ft : observers)
         ft.setSize(d);
  
 }
 }

