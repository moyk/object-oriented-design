package hw4;

import javax.swing.JOptionPane;

public class SportClient implements Client{
	private String sport;
	private String hometeam;
	private String awayteam;
	private int homescore;
	private int awayscore;
	private String ctsport;
	private ScoreService scoreservice;
	
	public SportClient(String sportname, ScoreService ss){
		ctsport = sportname;
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
    	if (ctsport.equals(sport)){
    		JOptionPane.showMessageDialog(null, sport + " News: "+ hometeam + " : " + awayteam + " is " + homescore + " : " + awayscore);
    	}
    }
}
