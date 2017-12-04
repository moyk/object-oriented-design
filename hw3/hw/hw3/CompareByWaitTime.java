import java.util.Comparator;

public class CompareByWaitTime implements Comparator<CashRegister>{
  public int compare(CashRegister a, CashRegister b){
    int c = a.avgWaitTime();
    int d= b.avgWaitTime();
    if (c > d)
      return 1;
    else if (c < d)
      return -1;
    else 
      return 0;
  }  
}