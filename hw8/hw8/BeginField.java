public class BeginField implements State {
 
 private CSVMachine machine;

 public BeginField(CSVMachine machine) {
  this.machine = machine;
 }

 public void processChar(char c) {
  if(c == '"')
   machine.setState(machine.getQuotedState(""));
  else
   machine.setState(machine.getUnquotedState(String.valueOf(c)));
 }

}
