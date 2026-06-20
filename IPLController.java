package com.tka.controller;

import java.util.List;

import com.tka.entity.Player;
import com.tka.service.IPLService;

public class IPLController {

    public static void main(String[] args) {

        IPLService service = new IPLService();

        System.out.println("===== List of all Players =====");
        List<Player> allPlayers = service.getAllPlayers();
        for (Player p : allPlayers) {
        	System.out.println(p.getPname() + " =====> " + p.getTname());
        }
        
        
        System.out.println("\n===== RCB PLAYERS =====");
        List<Player> rcbPlayers = service.getPlayersByTeam("RCB");
        for (Player p : rcbPlayers) {
            System.out.println(p);
        }
        
        System.out.println();
//      Player player = new Player("Ram",101,7000,15,"MI");
//      String add = service.addPlayer(player);
//      System.out.println(add);
        
        System.out.println();
        String dlt = service.deletePlayer(101);
        System.out.println(dlt);
        
        System.out.println();
        String updateruns = service.updatePlayerRuns(32, 3000);
        System.out.println(updateruns);
        
        System.out.println();
        Player highScorer = service.getHighRunScorer();
        System.out.println("High Run Scorer"+highScorer);

    }
}