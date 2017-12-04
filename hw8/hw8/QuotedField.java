//package hw.hw8;

public class QuotedField implements State {
 
 private CSVMachine machine;
 
 public QuotedField(CSVMachine machine) {
  this.machine = machine;
 }

 public void processChar(char c) {
  if(c == '"')
   machine.setState(machine.getSeenAQuote());
  else
   machine.concat(String.valueOf(c));
 }
}
