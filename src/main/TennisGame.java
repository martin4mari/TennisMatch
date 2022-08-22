/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Maria
 */
public class TennisGame {

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

    public void point(Player p, Player p2) {
        
        int score = p.getScore();
       int score2 = p2.getScore();
       
       while (p.getScore()<=6 || p2.getScore()<=6){
           
            int random = (int) Math.round(Math.random() * 10);
            if (random < 5) {
                p.setScore(score++);
            } else {
                p2.setScore(score2++);
            }
       }

        
    }
}
