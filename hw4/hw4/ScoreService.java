package hw4;

import java.util.ArrayList;
import java.util.Collection;

public class ScoreService {
	   private Collection<Client> observers = new ArrayList<Client>();
	   private String sport;
	   private String hometeam;
	   private String awayteam;
	   private int homescore;
	   private int awayscore; 
	   
       public ScoreService(ScoreInput si){
    	  si.registerObserver(this);
       }
       
       public void update(String sport,String hometeam, String awayteam, int homescore, int awayscore){
   		this.sport = sport;
   		this.hometeam = hometeam;
   		this.awayteam = awayteam;
   		this.homescore = homescore;
   		this.awayscore = awayscore;
   		measurementsChanged();
   	} 
       
       public void registerObserver(Client ct){
    		 observers.add(ct);
       }
    	 
       public void removeObserver(Client ct){
    		 observers.remove(ct);
       }
       
       public void notifyObservers() {
    	   for (Client ct : observers)
    	      ct.update(this);
    	}
       
       public String getSport(){
  		 return sport; 
  	 }
  	 
  	 public String getHometeam(){
  		 return hometeam; 
  	 }
  	 
  	 public String getAwayteam(){
  		 return awayteam;
  	 }
  	 
  	 public int getHomescore(){
  		 return homescore;
  	 }
  	 
  	 public int getAwayscore(){
  		 return awayscore;
  	 }
  	public void measurementsChanged() {
  	   notifyObservers();
  	}
}
