//package hw.hw8;

public class UnquotedField implements State {

 private CSVMachine machine;
 
 public UnquotedField(CSVMachine machine) {
  this.machine = machine;
 }

 public void processChar(char c) {
  if(c == '"')
   machine.setState(machine.getErrorState());
  else if(c == ',')
   machine.setState(machine.getBeginState());
  else
   machine.concat(String.valueOf(c));
 }
}
