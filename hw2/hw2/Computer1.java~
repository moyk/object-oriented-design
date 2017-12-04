package hw2;

/*
 * RiskTakerDM.java only implements DecisionMaking
 */

public class Computer1 implements DecisionMaking {
 
 private final int riskFactor = 30;

 public boolean decide(Player player, int chips, int succession) { // calculates its decision based on a constant factor
  if((chips + player.pot()) >= 30)
   return false;
  if(player.pot() >= 3)
   return (Math.random()*100) <= (riskFactor - (player.pot()*succession));
  if(succession >= 3)
   return false;
  
  return (Math.random()*100) <= (3*riskFactor);
 }

}
