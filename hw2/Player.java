import java.util.LinkedList;
import java.util.Random;


public abstract class Player {
  private int chipnum;
  private int potnum=0;
  private String name;
  private Random random = new Random();
  
  public Player(String Name){
  name = Name;
  chipnum = 0;
 }
  
  public String getName() { 
  return name;
 }
  
  public int getchipnum(){
     return chipnum;
  }
  
  public boolean win(){
     return chipnum>=30;
  }
  
  public LinkedList<Integer> roll(int dice) { // list of dice roll results
  LinkedList<Integer> rolls = new LinkedList<Integer>();
  for(int i=0; i<dice; i++){
   rolls.add(random.nextInt(4) + 1);
  }
  return rolls;
 }

  public void addchipnum(int num){
       chipnum += num;
  } 
  
 //public abstract boolean decide(Stat stat, int chips, int succession);
  
  
}
