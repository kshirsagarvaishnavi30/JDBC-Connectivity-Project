package com.tka.service;

import java.util.List;

import com.tka.dao.IPLDao;
import com.tka.entity.Player;

public class IPLService {

    IPLDao dao = new IPLDao();

    public List<Player> getAllPlayers() {
        return dao.getAllPlayer();
    }

    public List<Player> getPlayersByTeam(String teamName) {
        return dao.getPlayersByTeam(teamName);
    }

//    public String addPlayer(Player player) {
//        return dao.addPlayer(player);
//    }
    
    public String deletePlayer(int jn) {
        return dao.deletePlayer(jn);
    }
    
    public String updatePlayerRuns(int jn, int runs) {
        return dao.updatePlayerRuns(jn, runs);
    }
    
    public Player getHighRunScorer() {
        return dao.getHighRunScorer();
    }
}
