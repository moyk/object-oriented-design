package hw4;

import javax.swing.JOptionPane;

public class CollegeClient implements Client{
	private String sport;
	private String hometeam;
	private String awayteam;
	private int homescore;
	private int awayscore;
	private String collegename;
	private ScoreService scoreservice;
	
	public CollegeClient(String collegename, ScoreService ss){
		this.collegename = collegename;
		scoreservice = ss;
		scoreservice.registerObserver(this);
	}
	
	public void update(ScoreService ss){
		this.sport = ss.getSport();
		this.hometeam = ss.getHometeam();
		this.awayteam = ss.getAwayteam();
		this.homescore = ss.getHomescore();
		this.awayscore = ss.getAwayscore();
		display();
	}
	
    public void display(){
    	if (hometeam.equals(collegename)){
    		JOptionPane.showMessageDialog(null, hometeam + " News: " + "The " + sport +" team: " + hometeam + " : " + awayteam + " is " + homescore + ":" + awayscore);
    	}
    	else if (awayteam.equals(collegename)){
    		JOptionPane.showMessageDialog(null, awayteam + " News: " + "The " + sport +" team: "  +": " + hometeam + " : " + awayteam + " is " + homescore + ":" + awayscore);
    	}
    }
}

  


