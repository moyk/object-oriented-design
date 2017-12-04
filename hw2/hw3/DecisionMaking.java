package hw2;

/*
 * DecisionMaking.java is an interface that has nothing but a method that varies  in the decision making algorithms
 */

public interface DecisionMaking {
 
 public boolean decide(Player player, int chips, int succession); // sub-classes implement this differently

}
