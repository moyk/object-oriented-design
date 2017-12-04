public class Error implements State {
 
 private CSVMachine machine;

 public Error(CSVMachine machine) {
  this.machine = machine;
 }

 @Override
 public void processChar(char c) {
  if(c == ',')
   machine.setState(machine.getBeginState());
 }
}
