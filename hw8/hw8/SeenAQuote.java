//package hw.hw8;

public class SeenAQuote implements State {
 
 private CSVMachine machine;
 
 public SeenAQuote(CSVMachine machine) {
  this.machine = machine;
 }

 public void processChar(char c) {
  if(c == '"')
   machine.setState(machine.getQuotedState("\""));
  else if(c == ',')
   machine.setState(machine.getBeginState());
  else
   machine.setState(machine.getErrorState());
 }
}
