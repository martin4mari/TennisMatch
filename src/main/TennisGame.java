/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Maria
 */
public class TennisGame {

    private static final Map<Integer, String> SCORE_MAP = new HashMap<>();

    static {
        SCORE_MAP.put(0, "Love");
        SCORE_MAP.put(1, "Fifteen");
        SCORE_MAP.put(2, "Thirty");
        SCORE_MAP.put(3, "Forty");
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
    
    
    
    public void game(Player p, Player p2){
        
             
        for (int i = 0; i < 6; i++) {
                        point(p,p2);

        }
            point(p,p2);
         

             
    }

    
    
    
    public void point(Player p, Player p2) {
        //    int diference = Math.abs(score - score2);                 p.getScore() <= 6 || p2.getScore() <= 6))
        int c = 0;
        int c2 = 0;

        while ((p.getScore() < 3 && p2.getScore() < 3)) {
            
            int random = (int) Math.round(Math.random() * 10);
            if (random < 5) {
                p.setScore(p.getScore() + 1);
                System.out.println(p.getName() + " anoto " + SCORE_MAP.get(p.getScore()));
                c++;
            } else if (random >= 5) {
                p2.setScore(p2.getScore() + 1);
                System.out.println(p2.getName() + " anoto " + SCORE_MAP.get(p2.getScore()));
                c2++;
            }
        }
        
        String win = c > c2 ? p.getName() : p2.getName();
        System.out.println("Game: " + SCORE_MAP.get(p.getScore()) + "-" + SCORE_MAP.get(p2.getScore()) + " " + win + " wins" + "\n");
        p.setScore(0);
        p2.setScore(0);
    }

}
