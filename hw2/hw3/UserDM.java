package hw2;

/*
 * UserDM.java only implements DecisionMaking.java.
 */
import javax.swing.JOptionPane;
import java.util.Scanner;

public class UserDM implements DecisionMaking {
 
 private String name;
 
 public UserDM(String name){ // it takes a string value to remember the name of the player
  this.name = name;
 }

 public boolean decide(Player player, int chips, int succession) { // prompts the user for decision, not formula
   Scanner scan = new Scanner(System.in);
   Object[] options = { "Take the pot", "Keep rolling" };
  System.out.println("You have " + chips + " chips.\n" + 
    player.pot() + " chips are in the pot.\nMake a wise decision...\n(Next: " + (succession+1) + " dice)");
  System.out.println("Make choice: ");
  int response = scan.nextInt();
  if (response == 1)
   return true;
  else
   return false;
 } 
}
