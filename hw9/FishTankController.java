
import java.awt.Dimension;
import java.util.*;

public class FishTankController implements FTModelObserver, FTViewObserver{
 private FishTankModel model;
 private FishFrame view;
 
 public FishTankController(FishTankModel model, FishFrame view) {
       this.model = model;
       this.view = view;
       model.addObserver(this);
       view.addObserver(this);
       
 }
 
 public void update(Collection<Fish> fishes) {
  view.update(fishes);
 }

 @Override
 public void isSuspended(boolean b){
  view.isSuspended(b);
 }

 @Override
 public void newFish(String ftype) {
  model.newFish(ftype);
 }

 @Override
 public void startStopPressed() {
  model.startStopPressed();

 }

 @Override
 public void setSize(Dimension d) {
  model.setSize(d);
  
 }

}
