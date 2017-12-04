
import javax.swing.Timer;

public class hw9 {
 public static void main(String[] args) {
       FishTankModel model = new FishTankModel();
       FishFrame frame = new FishFrame();
       frame.setVisible(true);
    FishTankController controller = new FishTankController(model, frame);
    Timer t = new Timer(100, frame);
       t.start();
     }
  }
