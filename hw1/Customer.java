
public class Customer {
  private int itemNum, arrivaltime, servicetime;
 
  public Customer(int time) {
       arrivaltime=time;
       itemNum= (int) (Math.random() * 10);
       servicetime = itemNum * 2 + 10;
       }
  public int getArrivalTime(){
       return arrivaltime;
  }
  public int howManyItems(){
       return itemNum;
  }
  public int getServiceTime(){
       return servicetime;
  }
  public void setServiceTime(int time){
       servicetime=time;
  }
  public int getWaitTime(int time){
       return time-arrivaltime;
  }
}
