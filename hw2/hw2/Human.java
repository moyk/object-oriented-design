package hw2;

/*
 * User.java only extends Player
 */
import java.util.Scanner;
public class Human extends Player{
 
 public Human(String name) { // its constructor only aids in setting DecisionMaking object
  super(name);
  //DecisionMaking dm = new UserDM(name);
  //super.setDecisionMaking(dm);
 }
 public boolean decide(Player player, int chips, int succession) { // prompts the user for decision, not formula
   Scanner scan = new Scanner(System.in);
   Object[] options = { "Take the pot", "Keep rolling" };
  System.out.println("Make choice(1 for continue rolling, 2 for taking chips out): ");
  int response = scan.nextInt();
  if (response == 1)
   return true;
  else
   return false;
 } 
}
