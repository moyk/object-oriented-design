package hw2;

/*
 * ConservativeDM.java only implements DecisionMaking
 */
import java.util.Random;
public class Computer2 implements DecisionMaking {
 
 private Random random = new Random();

 public boolean decide(Player player, int chips, int succession) { // 50% chance of taking the pot
  if((chips + player.pot()) >= 30)
   return false;
  return random.nextInt(2) == 1;
 }

}