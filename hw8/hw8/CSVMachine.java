import java.util.*;

public class CSVMachine {
 
 private List<String> output;
 private String currentString;
 private State currentState;
 private State begin;
 private State unquoted;
 private State seenAQuote;
 private State quoted;
 private State error;
 
 public CSVMachine(){
  output = new ArrayList<String>();
  begin = new BeginField(this);
  quoted = new QuotedField(this);
  seenAQuote = new SeenAQuote(this);
  error = new Error(this);
  unquoted = new UnquotedField(this);
  currentState = begin;
  currentString = "";
 }

 public void processChar(char c) {
  currentState.processChar(c);
 }
 
 public void setState(State s){
  currentState = s;
 }
 
  public List<String> getRow() {
  if(!currentString.isEmpty())
   output.add(currentString);
  return output;
 }
 
 public void concat(String s){
  currentString += s;
 }
 
 
 public State getBeginState(){
  output.add(currentString);
  currentString = "";
  return begin;
 }
 
 public State getUnquotedState(String s){
  concat(s);
  return unquoted;
 }
 
 public State getSeenAQuote(){
  return seenAQuote;
 }
 
 public State getQuotedState(String s){
  concat(s);
  return quoted;
 }
 
 public State getErrorState(){
  currentString = "ERROR";
  return error;
 }
}
