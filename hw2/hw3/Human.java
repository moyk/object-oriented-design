package hw2;

/*
 * User.java only extends Player
 */

public class Human extends Player{
 
 public Human(String name) { // its constructor only aids in setting DecisionMaking object
  super(name);
  DecisionMaking dm = new UserDM(name);
  super.setDecisionMaking(dm);
 }
}
