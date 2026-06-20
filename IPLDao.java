package com.tka.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tka.entity.Player;

public class IPLDao {

    String path = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/advjava_433_db";
    String un = "root";
    String pwd = "root";

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    //Get all players
    public List<Player> getAllPlayer() {

        List<Player> ipl_db = new ArrayList<>();

        try {

            Class.forName(path);

            conn = DriverManager.getConnection(url, un, pwd);

            String query = "SELECT * FROM player";

            pst = conn.prepareStatement(query);

            rs = pst.executeQuery();

            while (rs.next()) {

                int jn = rs.getInt(1);
                String pname = rs.getString(2);
                int runs = rs.getInt(3);
                int wickets = rs.getInt(4);
                String tname = rs.getString(5);

                Player p = new Player(pname, jn, runs, wickets, tname);

                ipl_db.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ipl_db;
    }
    
    
   //Get Players by team
    public List<Player> getPlayersByTeam(String teamName) {

        List<Player> list = new ArrayList<>();

        try {

            Class.forName(path);

            conn = DriverManager.getConnection(url, un, pwd);

            String query = "SELECT * FROM player WHERE tname=?";

            pst = conn.prepareStatement(query);

            pst.setString(1, teamName);

            rs = pst.executeQuery();

            while (rs.next()) {

                int jn = rs.getInt(1);
                String pname = rs.getString(2);
                int runs = rs.getInt(3);
                int wickets = rs.getInt(4);
                String tname = rs.getString(5);

                Player p = new Player(pname, jn, runs, wickets, tname);

                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    
    //add new player
    public String addPlayer(Player player) {

        String query = "INSERT INTO player VALUES(?,?,?,?,?)";

        try {

            Class.forName(path);

            conn = DriverManager.getConnection(url, un, pwd);

            pst = conn.prepareStatement(query);

            pst.setInt(1, player.getJn());
            pst.setString(2, player.getPname());
            pst.setInt(3, player.getRuns());
            pst.setInt(4, player.getWickets());
            pst.setString(5, player.getTname());

            int count = pst.executeUpdate();

            if (count > 0) {
                return "Player Added Successfully";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Player Not Added";
    }
    
   //delete player 
    public String deletePlayer(int jn) {

        String query = "DELETE FROM player WHERE jn = ?";

        try {

            Class.forName(path);

            conn = DriverManager.getConnection(url, un, pwd);

            pst = conn.prepareStatement(query);

            pst.setInt(1, jn);

            int count = pst.executeUpdate();

            if(count > 0) {
                return "Player Deleted Successfully";
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return "Player Not Found";
    }
    
    //update runs 
    public String updatePlayerRuns(int jn, int runs) {

        String query = "UPDATE player SET runs = ? WHERE jn = ?";

        try {

            Class.forName(path);

            conn = DriverManager.getConnection(url, un, pwd);

            pst = conn.prepareStatement(query);

            pst.setInt(1, runs);
            pst.setInt(2, jn);

            int count = pst.executeUpdate();

            if(count > 0) {
                return "Runs Updated Successfully";
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return "Player Not Found";
    }
    
    //more runs
    public Player getHighRunScorer() {

        Player player = null;

        String query = "SELECT * FROM player ORDER BY runs DESC LIMIT 1";

        try {

            Class.forName(path);

            conn = DriverManager.getConnection(url, un, pwd);

            pst = conn.prepareStatement(query);

            rs = pst.executeQuery();

            if (rs.next()) {

                int jn = rs.getInt(1);
                String pname = rs.getString(2);
                int runs = rs.getInt(3);
                int wickets = rs.getInt(4);
                String tname = rs.getString(5);

                player = new Player(pname, jn, runs, wickets, tname);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return player;
    }
}