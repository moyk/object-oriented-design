import java.util.Scanner;

public class HW3Simulation {
 private static final int SIMULATION_TIME = 50000;  
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in); 
  int normal, fast, distriSize; 
  String distritype,cmp;
  ItemDistribution distrirandom;
  while(true){
   System.out.println("How many normal speed registers?");
   scan = new Scanner(System.in);
   try{
    normal = scan.nextInt(); 
   }catch(Exception e){
    System.out.println("Invalid input. Please enter a number.");
    continue;
   }
   if(normal<=0){
    System.out.println("Invalid input. Please enter either u or b.");
    continue;
   }
   break;
  }
   while(true){
   System.out.println("How many fast registers?"); 
   scan = new Scanner(System.in);
   try{
    fast = scan.nextInt(); 
   }catch(Exception e){
    System.out.println("Invalid input. Please enter a number.");
    continue;
   }
   if(fast<=0){
    System.out.println("Invalid input. Please enter either u or b.");
    continue;
   }
   break;
   }
  while(true){
   System.out.println("Identify item distribution type: ( u=Uniform, b=Bimodal )"); 
   scan = new Scanner(System.in);
   try{
    distritype = scan.nextLine(); 
   }catch(Exception e){
    System.out.println("Invalid input. Please enter a number.");
    continue;
   }
   if(!distritype.equals("u") && !distritype.equals("b")){
    System.out.println("Invalid input. Please enter either u or b.");
    continue;
   }
   break;
  }
  while(true){ 
   System.out.println("Identify item distribution size."); 
   scan = new Scanner(System.in);
   try{
    distriSize = scan.nextInt(); 
   }catch(Exception e){
    System.out.println("Invalid input. Please enter a number.");
    continue;
   }
   if(distriSize<=0){
    System.out.println("Invalid input. Please enter a positive number.");
    continue;
   }
    break;
  }
  while(true){ 
   System.out.println("Select sorting method: (x = no sort, w= sort by wait time, s= sort by number served)"); //user prompt
   scan = new Scanner(System.in);
   try{
    cmp = scan.nextLine(); 
   }catch(Exception e){
    System.out.println("Invalid input. Please enter a string among 'x', 'w', 's'.");
    continue;
   }
   break;
  }
  scan.close();
  
  if (distritype.equals("u")){
    distrirandom = new Uniform(distriSize);}
  else{
    distrirandom = new Bimodal(distriSize);}    
  
  DiningHall hall = new DiningHall(normal, fast, distrirandom, cmp);
  
  for (int t=0; t<SIMULATION_TIME; t++) {
   hall.elapseOneSecond(t);
  }
  hall.print();
 }
}
