import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Playdice {
    private List<Player> players = new ArrayList<Player>(); // list of players
    private int numPlayers; // number of players
    private int humanPlayers;
    private int computerPlayers;
    Player player;
    String name;
    
    
    public void main(String[] args) { 
    System.out.println("Game Start!");
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter number of players: ");
    numPlayers= scan.nextInt();
    System.out.println("Enter number of humanplayers: ");
    humanPlayers= scan.nextInt();
    computerPlayers = numPlayers-humanPlayers;
    for(int i=1; i<=humanPlayers; i++){
    player = new Human("human");
    players.add(player);
    }
    for(int i=1; i<=computerPlayers; i++){
    player = new Computer("computer");
    players.add(player);
    }
  
    }
}
