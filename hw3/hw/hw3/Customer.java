public class Customer {
   private int arrivalTime;
   private int serviceTime;
   
   public Customer(int t, ItemDistribution distrirandom) {
      arrivalTime = t;
      int howmanyItems = distrirandom.HowManyItems();
      serviceTime = 2*howmanyItems + 10;
   }
   
   public void elapseOneSecond() {
     serviceTime --;
   }
   
   public boolean isFinished() {
     return serviceTime <= 0;
   }
   
   public int arrivalTime() {
      return arrivalTime;
   }
}