import javax.swing.JOptionPane;

public class CollegeClient implements Client{
   private string sport;
   private string home;
   private strinng away;
   private string homeScore;
   private strinng awayScore;
   private strring message;
   
   public CurrentConditionsDisplay(ScoreService ss) {
      ss.registerObserver(this);
   }
   
   public void update(ScoreService ss) {
      this.sport = input.getSport();
      this.home = input.getHome();
      this.away = input.getAway();
      this.homeScore = input.getHomeScore();
      this.awayScore = input.getAwayScore();
      display();
   }
   
   public void display() {
     if(Integer.parseInt(homeScore) < Integer.parseInt(awayScoere)){
         message = "the"+ sport + "team was defeated by" + away + "," + homeScore + "to" + awayScore;    
     }
     if(Integer.parseInt(homeScore) > Integer.parseInt(awayScoere)){
         message = "the"+ sport + "team defeated " + away + "," + homeScore + "to" + awayScore;    
     }
     if(Integer.parseInt(homeScore) = Integer.parseInt(awayScoere)){
         message = "the"+ sport + "team tied with" + away + "," + homeScore + "to" + awayScore;    
     }

      JOptionPane.showMessageDialog(Null, message);     
}