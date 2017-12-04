public class Bimodal implements ItemDistribution{
 
 private int distriSize; 

 public Bimodal(int distriSize) {
  this.distriSize = distriSize;
 }

 public int HowManyItems() { 
  int n = distriSize;
  while(n > distriSize/4 && n < (3 * distriSize / 4))
   n = (int) (Math.random() * distriSize);
  return n;
 } 
}