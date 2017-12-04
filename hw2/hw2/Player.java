package hw2;

import java.util.LinkedList;
import java.util.Random;

public abstract class Player {
 
 protected Random random = new Random();
 private String name;
 private int chips;
 private int pot;
 
 public Player(String name){
  this.name = name;
  this.chips = 0;
 }
 
 public int chipPot(int amt){
  pot += amt;
  return pot;
 }
 
 public int takeChips(){
  int chips = pot;
  pot = 0;
  return chips;
 }
 
 public int pot(){
  return pot;
 }
 
 public String toString(){
  return "The pot contains " + pot + " chips.";
 }
 
 public LinkedList<Integer> roll(int dice) { // list of dice roll results
  LinkedList<Integer> rolls = new LinkedList<Integer>();
  for(int i=0; i<dice; i++){
   rolls.add(random.nextInt(4) + 1);
  }
  return rolls;
 }
 
 public String getName() { 
  return name;
 }
 
 public int getChips(){
  return chips;
 }
 
 public void giveChips(int chips){ // add number of chips
  this.chips += chips;
 }

 public boolean decide(Player player, int succession){ 
  return decide(player, chips, succession);
 }

 public void info() { 
  System.out.print(name + ": " + chips + " ");
 }
 
 public abstract boolean decide(Player player, int chips, int succession);
}
