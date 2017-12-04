package hw2;

/*
 * Computer.java only extends Player
 */

public class Computer extends Player{

 public Computer(String name, int level) { // its constructor only aids in setting DecisionMaking object
  super(name);
  
  if (level == 1){
     DecisionMaking dm=new Computer1();
     super.setDecisionMaking(dm);
  }
  else{
    DecisionMaking dm=new Computer2();
    super.setDecisionMaking(dm);
  }
 }
}
