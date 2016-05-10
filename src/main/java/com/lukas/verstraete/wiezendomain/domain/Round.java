package com.lukas.verstraete.wiezendomain.domain;

import com.lukas.verstraete.wiezendomain.domain.gametypes.GameType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Round implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;
    private GameType type;
    private int wins;
    private HashMap<Player, Integer> players;
    
    public Round()
    {
        
    }
    
    public Round(GameType type, List<Player> allPlayers, List<Player> players, List<Player> opponents)
    {
        setType(type);
        setPlayers((HashMap<Player,Integer>)createPlayerMap(allPlayers, players, opponents));
    }
    
    public long getId()
    {
        return id;
    }
    
    public void setId(long id)
    {
        this.id = id;
    }
    
    public GameType getType()
    {
        return type;
    }
    
    public void setType(GameType type)
    {
        this.type = type;
    }

    public HashMap<Player, Integer> getPlayers() {
        return players;
    }

    public void setPlayers(HashMap<Player, Integer> players) {
        this.players = players;
    }
    
    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
    
    private Map<Player,Integer> createPlayerMap(List<Player> allPlayers, List<Player> players, List<Player> opponents)
    {
        HashMap<Player, Integer> playerMap = new HashMap<>();
        
        for(Player p : allPlayers)
        {
            if(players.contains(p))
            {
                playerMap.put(p, 1);
            }
            else if(opponents.contains(p))
            {
                playerMap.put(p, 0);
            }
            else
            {
                playerMap.put(p, -1);
            }
        }
        
        return playerMap;
    }
    
    public Map<Player,Score> getScores(int wins)
    {   
        this.wins = wins;
        Map<Player,Score> allScores = new HashMap<>();
        Map<Player,Score> playerScores = type.getScores(getPlayersFromMap(), getOpponentsFromMap(), wins);
        for(Entry e : players.entrySet())
        {
            Score score = new Score(0);
            if((Integer)e.getValue() >= 0)
                score = playerScores.get((Player)e.getKey());
            allScores.put((Player)e.getKey(), score);
        }
        return allScores;
    }
    
    public Map<Player,Score> getScores()
    {
        return getScores(wins);
    }
    
    private List<Player> getOpponentsFromMap()
    {
        ArrayList<Player> opponents = new ArrayList<>();
        
        for(Entry e : players.entrySet())
        {
            if((Integer)e.getValue() == 0)
                opponents.add((Player)e.getKey());
        }
        
        return opponents;
    }
    
    private List<Player> getPlayersFromMap()
    {
        ArrayList<Player> opponents = new ArrayList<>();
        
        for(Entry e : players.entrySet())
        {
            if((Integer)e.getValue() == 1)
                opponents.add((Player)e.getKey());
        }
        
        return opponents;
    }
}

