import java.util.*;

public class ScoreServices{

private Collection<Client> observers = new ArrayList<Client>();
private string sport;
private string home;
private strinng away;
private string homeScore;
private strinng awayScore;

ScoreServices(ScoreInput input){
  this.sport = input.getSport();
  this.home = input.getHome();
  this.away = input.getAway();
  this.homeScore = input.getHomeScore();
  this.awayScore = input.getAwayScore();
}

public void registerObserver(Client client) {
   observers.add(client);
}

public void removeObserver(Client client) {
   observers.remove(client);
}

public void notifyObservers() {
   for (Client cl : observers)
      cl.update(this);
}

public float getSport() {
   return sport;
}

public float getHome() {
   return home;
}

public float getAway() {
   return away;
}

public float getAwayScore() {
   return awayScore;
}

public float getHomeScore() {
   return homeScore;
}

public void scoreChanged() {
   notifyObservers();
}

}