public class Fast implements Cashier {
 public boolean elapseOneSecond(Customer currentCust) { 
  if (currentCust == null)
   return false;
  currentCust.elapseOneSecond(); 
  currentCust.elapseOneSecond();
  if(currentCust.isFinished()) 
   return true;
  return false;
 }

 public String toString(){
  return "Fast";
 }
}
