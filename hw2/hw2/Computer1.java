package hw2;

public class Computer1 extends Player {
 public Computer1(String name, int level) { // its constructor only aids in setting DecisionMaking object
  super(name);
 }
 public boolean decide(Player player, int chips, int succession) { // calculates its decision based on a constant factor
  if((chips + player.pot()) >= 30)
   return false;
  if(player.pot() >= 5)
   return true;
  if(succession >= 3)
   return false;
  return (Math.random()*10)>5;
 }

}
