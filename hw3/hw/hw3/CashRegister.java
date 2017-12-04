import java.util.*;

public class CashRegister {
   private List<Customer> custlist = new LinkedList<Customer>();
   private int cusServed = 0;
   private int totalWaitTime = 0;
   private Customer currentCust = null;
   private Cashier cashier; 
   
   public CashRegister(Cashier cashier){ 
    this.cashier = cashier;
   }
   
   public void addCustomer(int t, ItemDistribution distrirandom) { 
    Customer a = new Customer(t, distrirandom); 
    custlist.add(a);
    if (currentCust == null)
     currentCust = a;
   }
  public int size() { 
      return custlist.size(); 
   }
   
   public int customersServed() { 
      return cusServed; 
   }
   
   public void elapseOneSecond(int currentTime) {
    if(cashier.elapseOneSecond(currentCust)){ 
     cusServed++;       
     totalWaitTime += currentTime - currentCust.arrivalTime();
     custlist.remove(0);
     currentCust = custlist.size() > 0 ? custlist.get(0) : null;
    }
   }
   
   public int avgWaitTime() { 
      return totalWaitTime / cusServed; 
   }
   public String cashier(){ 
    return cashier.toString();
   }
}
