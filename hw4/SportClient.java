public class SportClient implements Client{
   private string sport;
   private string home;
   private strinng away;
   private string homeScore;
   private strinng awayScore;
   
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
         message = away + "defeats" + home + "," + awayScore + "to" + homeScore;    
     }
     if(Integer.parseInt(homeScore) > Integer.parseInt(awayScoere)){
         message = home + "defeats " + away + "," + homeScore + "to" + awayScore;    
     }
     if(Integer.parseInt(homeScore) = Integer.parseInt(awayScoere)){
         message = home + "ties with" + away + "," + homeScore + "to" + awayScore;    
     }
     JOptionPane.showMessageDialog(Null, message); 
}