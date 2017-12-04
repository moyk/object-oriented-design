import java.util.Comparator;

public class CompareByCustsServed implements Comparator<CashRegister>{
  public int compare(CashRegister a, CashRegister b){
    int c = a.customersServed();
    int d = b.customersServed(); 
    if (c > d)
      return -1;
    else if (c < d)
      return 1;
    else
      return 0;
  }  
}