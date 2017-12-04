import java.util.*;

public class CashRegister { 
  private int customerServed;
  
  public CashRegister(){
    customerServed = 0;
  }
  
 // public void servecustomer(Customer c, int time){
   //  servetime.add =  2*c.howmanyitem() + 10;
    // addcustomerServed();
 // }

  public int getcustomerServed(){
     return customerServed;
  }
  
   public void addcustomerServed(){
      customerServed++;
  }
  
}
