package main;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Maria
 */
public class TennisGame {

    private static final Map<Integer, String> SCORE_MAP = new HashMap<>();

    
    // defino las constantes, cada punto corresponde a un numero especifico
    static {
        SCORE_MAP.put(0, "Love");
        SCORE_MAP.put(1, "15");
        SCORE_MAP.put(2, "30");
        SCORE_MAP.put(3, "40");
    }

    private String tournament;
    private Player player;

    public TennisGame() {

    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    
    //punto por punto, cada jugador gana aleatoriamente
    public Player point(Player p, Player p2) {

        int c = 0;
        int c2 = 0;

        while (Math.max(p.getScore(), p2.getScore()) < 3) {
 
 
            int random = (int) Math.round(Math.random() * 100);  //cada jugador tiene el 50% de probabilidades de ganar

            if (random < 50) {
                p.setScore(p.getScore() + 1);
                System.out.println(p.getName() + " scored " + SCORE_MAP.get(p.getScore()));
                c++;
            } else if (random >= 50) {
                p2.setScore(p2.getScore() + 1);
                System.out.println(p2.getName() + " scored " + SCORE_MAP.get(p2.getScore()));
                c2++;
            }
        }
        if (c > c2) {
            System.out.println(p.getName() + " won the game---");
        } else {
            System.out.println(p2.getName() + " won the game---");
        }
        System.out.println("Game: " + SCORE_MAP.get(p.getScore()) + "-" + SCORE_MAP.get(p2.getScore()) + "\n");

        //reinicio el score de cada jugador para el comienzo de cada juego
        p.setScore(0);
        p2.setScore(0);

        return c > c2 ? p : p2;
    }

    
    //cuento cantidad de juegos ganados para saber quien gana el set
    public Player winSets(Player p, Player p2) {

        int c = 0;
        int c2 = 0;

        System.out.println("\n" + "******** NUEVO SET ********");

        do {
            Player win = point(p, p2);
            if (win == p) {
                c++;
            } else if (win == p2) {
                c2++;
            }
        } while (Math.max(c, c2) < 6 || Math.abs(c - c2) <= 2 || c == c2);  //bucle funciona mientras el punto maximo de cualquier jugador permanezca menor a 6,
                                                                                                           //mientras  la diferencia entre ellos sea menor a dos, y si empatan

        if (c > c2) {
            System.out.println(p.getName() + " won the set---");
        } else {
            System.out.println(p2.getName() + " won the set---" + "\n");
        }

        return c > c2 ? p : p2;
    }

    public Player winnerPlayer(Player p, Player p2, int numSets) {
        int c = 0;
        int c2 = 0;

        do {
            Player win = winSets(p, p2);

            if (win == p) {
                c++;
            } else if (win == p2) {
                c2++;
            }
        } while (Math.max(c, c2) < numSets || Math.abs(c - c2) <= 2 || c == c2); //utilizo el numero de sets elegido saber que jugador gana

        return c > c2 ? p : p2;
    }

}
