package main;

import java.util.Scanner;

/**
 *
 * @author Maria
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        
        Player p1 = new Player();
        Player p2 = new Player();
        
        System.out.println("Player one name:");
        p1.setName(sc.next());
        System.out.println("Player two name:");
        p2.setName(sc.next());
        
        TennisGame tg = new TennisGame();
        
         System.out.println("Tournaments name:");
                 tg.setTournament(sc.next());

         System.out.println("***     Welcome to "+tg.getTournament()+" Tournament    ***");
        
    tg.game(p1, p2);       
        
   //     System.out.println(p1);
      //  System.out.println(p2);
        
    }
}
