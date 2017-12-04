import java.util.Arrays;
import java.util.Comparator;

public class DiningHall {
 private Comparator<CashRegister> comparator;
 private String cmp;
 private CashRegister[] registers = new CashRegister[2];
 private int total;
 private ItemDistribution distrirandom;

 public DiningHall(int normal, int fast, ItemDistribution distrirandom, String comparemethod) {
  this.distrirandom = distrirandom; 
  total = normal + fast; 
  registers = new CashRegister[total];
  this.cmp = cmp;
  
  for (int r=0; r<normal; r++)  // create normal speed
   registers[r] = new CashRegister(new NormalSpeed());
  for (int r=0; r<fast; r++)  // create high speed
   registers[r+normal] = new CashRegister(new Fast());
 }
 
  private boolean aCustomerArrives() {
  int n = (int) (Math.random() * 100);  // an integer between 0 and 99
  return n < 18;
 }
  
 
 public void print() {
  if (cmp.equals("w")){
    comparator = new CompareByWaitTime();
    Arrays.sort(registers, comparator);
   }
  if (cmp.equals( "s")){
    comparator = new CompareByCustsServed();
    Arrays.sort(registers, comparator);
  }
  for (int r=0; r<total; r++) {
   CashRegister reg = registers[r];
   System.out.println("Register " + r + " " + registers[r].cashier());
   System.out.println("\tNumber of arrivals = " + reg.customersServed());
   System.out.println("\tAverage wait time = " + reg.avgWaitTime());
  } 
 }

 public void elapseOneSecond(int t) { 
  if (aCustomerArrives()) {
   int chosenRegister = total-1;
   for (int r=0; r<total; r++) { 
    chosenRegister = (registers[chosenRegister].size() < registers[r].size()) ? chosenRegister : r; 
   }
   registers[chosenRegister].addCustomer(t, distrirandom); 
  }
  for (int r=0; r<total; r++)
   registers[r].elapseOneSecond(t);  
 }

}