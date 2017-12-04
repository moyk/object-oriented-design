
import java.awt.Dimension;
import java.util.*;

public class FishTankModel {
 private Collection<Fish> fishes = new ArrayList<Fish>();
 private Collection<FTModelObserver> observers = new ArrayList<FTModelObserver>();
 private Boolean suspended = false;
 private Dimension size;
 
 public void newFish(String ftype){
    FishFactory ff = FishFactory.getFactory(ftype);
    Fish f = ff.create();
    fishes.add(f);
    notifyObservers(fishes);
 }
 
 public void addObserver(FTModelObserver x) {
       observers.add(x);
    }
 
 public void startStopPressed(){
  suspended = !suspended;
  for (FTModelObserver ft : observers)
          ft.isSuspended(suspended);
 }
 
 public void setSize(Dimension d){
  this.size = d;
 }
 
 private void notifyObservers(Collection<Fish> fishes) {
       for (FTModelObserver ft : observers)
          ft.update(fishes);
  }
}
