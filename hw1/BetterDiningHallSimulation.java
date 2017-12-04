import java.util.*;

public class BetterDiningHallSimulation {
 private static final int SIMULATION_TIME = 50000;  // A simulation is for 50,000 seconds.
 private static final int CUST_ARRIVAL_PCT = 18;    // There is a 18% chance a customer arrives each second.
 private static final int NUM_REGISTERS = 4;        // There are 4 cash registers.

 // info about customers waiting at the cash registers
 private static List<Customer>[] arrivalTimes = (List<Customer>[]) new List[NUM_REGISTERS];
 private static List<Customer>[] serviceTimes = (List<Customer>[]) new List[NUM_REGISTERS];  
 private static LinkedList<CashRegister> register =(LinkedList<CashRegister>) new LinkedList<CashRegister>();
 // statistics about the cash registers
 private static int[] totalWaitTimes = new int[NUM_REGISTERS];

 public static void main(String[] args) {
  // First, initialize the cash register arrays.
  for (int r=0; r<NUM_REGISTERS; r++) {
   arrivalTimes[r] = new LinkedList<Customer>();
   serviceTimes[r] = new LinkedList<Customer>();
   totalWaitTimes[r]  = 0;
   CashRegister c = new CashRegister();
   register.add(c);
   //System.out.println(register.get(r).);
  }

  // Then perform the simulation for the specified number of seconds.
  for (int t=0; t<SIMULATION_TIME; t++) {
   if (aCustomerArrives()) {
    // The new customer goes into the smaller line.
    int chosenRegister = smallestRegister(); 
    Customer newcustomer = new Customer(t);
    arrivalTimes[chosenRegister].add(newcustomer);
    serviceTimes[chosenRegister].add(newcustomer);
   }

   for (int r=0; r<NUM_REGISTERS; r++)
    elapseOneSecond(r, t);  // Simulate each register for one second.
  }

  // Print out the statistics.
  for (int r=0; r<NUM_REGISTERS; r++) {
   System.out.println("Register " + r);
   System.out.println("\tNumber of arrivals = " + register.get(r).getcustomerServed());
   System.out.println("\tAverage wait time = " + (totalWaitTimes[r] / register.get(r).getcustomerServed()));
  }
 }

 private static boolean aCustomerArrives() {
  int n = (int) (Math.random() * 100);  // an integer between 0 and 99
  return n < CUST_ARRIVAL_PCT;
 }

 
 // The lists "arrivalTimes" and "serviceTimes" are associated with each register.
 // These lists have the same size, which is the number of people in line for that register.
 // We can use either list to determine the register having the smallest line.
 private static int smallestRegister() {
  int currentSmallest = 0;
  for (int r=1; r<NUM_REGISTERS; r++)
   if (arrivalTimes[r].size() < arrivalTimes[currentSmallest].size())
    currentSmallest = r;
  return currentSmallest;
 }
 
 private static void elapseOneSecond(int reg, int currentTime) {
  // If the list is empty, there are no customers to process.
  if (arrivalTimes[reg].size() == 0)
   return;

 // Otherwise, the first customer in line gets processed.
  int timeLeft = serviceTimes[reg].get(0).getServiceTime() - 1;
  if (timeLeft > 0) { 
   serviceTimes[reg].get(0).setServiceTime(timeLeft);
  }
  else { // We are done with this customer.
   // First update the register's statistics.
   register.get(reg).addcustomerServed();
   totalWaitTimes[reg] += arrivalTimes[reg].get(0).getWaitTime(currentTime);
   
   // Then remove the customer.
   arrivalTimes[reg].remove(0);
   serviceTimes[reg].remove(0);
  
  }
 }
}

