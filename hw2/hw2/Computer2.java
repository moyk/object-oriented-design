package hw2;

import java.util.Random;
public class Computer2 extends Player {
  public Computer2(String name, int level) {
  super(name);
  }
 private Random random = new Random();
 public boolean decide(Player player, int chips, int succession) { // half chance of taking the pot, totally random
  if((chips + player.pot()) >= 30)
   return false;
  return random.nextInt(2) == 1;
 }

}