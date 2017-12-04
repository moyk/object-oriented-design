package hw2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class HW2DiceGame {
 private List<Player> players = new ArrayList<Player>(); // list of players
 private int numPlayers; // total number of  players
 
 public HW2DiceGame(){
  initialize(); // initializes the game
  try {
   game(); // plays the game
  } catch (InterruptedException e) {}
  System.out.println("\n");
 }
 
 private void game() throws InterruptedException { 
  int turn=0;
  int playerTurn = 0,
  succession = 0;
  Player currentPlayer; 
  LinkedList<Integer> rolls; //  list of dice roll result
  String name; 
  
  while(true){
   currentPlayer = players.get(playerTurn); // get the Player of the turn
   name = currentPlayer.getName();
   for(Player p : players){ // prints chip counts for all players
    p.info(); 
   }   
 
   System.out.println("\n\n" + name + "'s turn :");
   do{ // repeat this as long as player decides to keep going or aces out.
    succession++; 
    currentPlayer.chipPot(succession); // add chips to pot of corresponding amt.
    System.out.println(currentPlayer.toString()); // print statistical info
    rolls = currentPlayer.roll(succession); // tells currentPlayer to roll dice
    System.out.println(name + " rolls " + rolls);
    if(rolls.contains(1)){ // test for ace outs
     System.out.println(name + " has aced out after " + rolls.size() + " rolls.");
     break;
    }
    
    boolean keepGoing = currentPlayer.decide(currentPlayer,succession); // continue rolling?
    
    if(!keepGoing){ // take the pot and finish turn
     System.out.println(name + " decided to take " + currentPlayer.pot() + " chips from the pot.");
     System.out.println(name + " stopped after " + rolls.size() + " rolls and won " + currentPlayer.pot() + " chips.");
     currentPlayer.giveChips(currentPlayer.takeChips());
     break;
    }
    System.out.println(name + " decided to roll again");
   }while(true);
   
   succession = 0; 
   turn++; // update for next turn 
   playerTurn = turn % numPlayers; // get the next turn
   if(currentPlayer.getChips() >= 30){ // game finishes if player gets more than 30 chips
    System.out.println("\n");
    System.out.println(name + " wins with " + currentPlayer.getChips() + " chips!");
    break;
   }
  }
 }

 private boolean initialize(){ // initializing the game.
  Player player;
  String name;
  Scanner scan = new Scanner(System.in);
  System.out.println("\tGame Start!\n");
  
  while(true){ 
    System.out.println("Enter number of players: ");  
   try{
      numPlayers= scan.nextInt();
   }catch(Exception e){
    System.out.println("Invalid input. Please enter a number.");
    continue;
   }
   if(numPlayers <= 1){
    System.out.println("Invalid input. Two or more players are required.");
    continue;
   }
   break;
  } 
 
  for(int i=1; i<=numPlayers; i++){ // create either user or computer players
   int choice = 0;
   Object[] options = { "User", "Computer" };
   System.out.println("Enter a number for player" +i+" (0 for User, 1 for Computer): "); 
   choice= scan.nextInt();
   if(choice == 0){
    player = new Human("Player " + i);
    players.add(player);
   } else{
    System.out.println("Enter difficulty (1 or 2): ");
    int level = scan.nextInt();
    if (level ==1) {
    player = new Computer1("Player " + i, level);
    players.add(player);
    }
    if (level == 2) {
    player = new Computer2("Player " + i, level);
    players.add(player);
    }
   }   
  }
  return true;
 }

 public static void main(String[] args) { 
  new HW2DiceGame(); // starts game
 }
}
