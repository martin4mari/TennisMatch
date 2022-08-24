package main;

import java.util.Scanner;

/**
 *
 * @author Maria
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        TennisGame tg = new TennisGame();

        System.out.println("Tournaments name:");
        tg.setTournament(sc.next());
        System.out.println("***     Welcome to " + tg.getTournament() + " Tournament    ***");

        
        Player p = new Player();
        Player p2 = new Player();

        System.out.println("Player one name:");
        p.setName(sc.next());
        System.out.println("Player two name:");
        p2.setName(sc.next());

        System.out.println("Please enter number of sets. Enter 2 (2/3) or 3 (3/5)");
        int n = sc.nextInt();
        
        String ans = null;
        do {
            Player winner = tg.winnerPlayer(p, p2, n);
            System.out.println(winner.getName() +" won the tournament!");

            System.out.println("Do you want to play again? Y / N");
            ans = sc.next().toUpperCase();
            if (ans.equals("N")) {
                break;
            }
        } while (ans.equals("Y"));

        System.out.println("Goodbye!!");
    }
}
