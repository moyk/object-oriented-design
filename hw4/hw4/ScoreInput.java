package hw4;
import java.util.*;

import hw4.GUIFrame8;
import hw4.GUIPanel8;

import javax.swing.*;

public class ScoreInput {
	 private Collection<ScoreService> observers = new ArrayList<ScoreService>();
	 private String sport;
	 private String hometeam;
	 private String awayteam;
	 private int homescore;
	 private int awayscore;
	 
	 public ScoreInput(){
		 GUIFrame8 frame = new GUIFrame8(this);
	     frame.pack();
	 }
	 
	 public void registerObserver(ScoreService ss){
		 observers.add(ss);
	 }
	 
	 public void removeObserver(ScoreService ss){
		 observers.remove(ss);
	 }
	 
	 public void notifyObservers(){
		 for (ScoreService ss:observers){
			 ss.update(sport, hometeam, awayteam, homescore, awayscore);
		 }
	 }
	   
	 public void measurementsChanged() {
	      notifyObservers();
	   }
	   
	   public void setMeasurements(String sport, String hometeam, String awayteam, int homescore, int awayscore) {
		   this.sport = sport;
	   	   this.hometeam = hometeam;
	   	   this.awayteam = awayteam;
	   	   this.homescore = homescore;
	   	   this.awayscore = awayscore;
	       measurementsChanged();
	   }
}

@SuppressWarnings("serial")
class GUIFrame8 extends JFrame {
   private GUIPanel8 panel;
   private ScoreInput si2;
   
public GUIFrame8(ScoreInput si) {
	  si2 = si;
      setTitle("Score Input");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLocation(200,200);
      panel = new GUIPanel8(si2); 
      setContentPane(panel);
      setVisible(true);
    
   }
}

@SuppressWarnings("serial")
class GUIPanel8 extends JPanel {
   
   private ScoreInput si3;

private JLabel lbl1     = new JLabel("Sport:");
   private JTextField txt1 = new JTextField("50", 4);
   private JLabel lbl2     = new JLabel("Home team:");
   private JTextField txt2 = new JTextField("50", 4);
   private JLabel lbl3     = new JLabel("Away team:");
   private JTextField txt3 = new JTextField("50", 4);
   private JLabel lbl4    = new JLabel("Home Score:");
   private JTextField txt4 = new JTextField("50", 4);
   private JLabel lbl5    = new JLabel("Away Score:");
   private JTextField txt5 = new JTextField("50", 4);
   private JButton btn1 = new JButton("NEW SCORE");
   
   
   public GUIPanel8(ScoreInput si) {
      JPanel p1 = new JPanel();
      p1.add(lbl1); p1.add(txt1); 
      p1.add(lbl2); p1.add(txt2);
      p1.add(lbl3); p1.add(txt3);
      p1.add(lbl4); p1.add(txt4);
      p1.add(lbl5); p1.add(txt5);
      add(p1); 
      add(btn1); 
      si3 = si;
      
      btn1.addActionListener( evt -> si3.setMeasurements(txt1.getText(),txt2.getText(),txt3.getText(),Integer.parseInt(txt4.getText()), Integer.parseInt(txt5.getText())));    
   } 
}  

