public class Uniform implements ItemDistribution{

 private int distriSize; 

 public Uniform(int distriSize) {
  this.distriSize = distriSize;
 }

 public int HowManyItems() { 
  int n =  1 + (int)(Math.random() * 10);
  return n;
 }

}
