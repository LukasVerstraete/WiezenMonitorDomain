package com.lukas.verstraete.wiezendomain.domain;

import com.lukas.verstraete.wiezendomain.domain.gametypes.GameType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private List<Player> players;
    
    public Round() 
    {
        this(null, null);
    }
    
    public Round(GameType type, List<Player> players)
    {
        setType(type);
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
    
    public List<Player> getPlayers()
    {
        return players;
    }
    
    public void setPlayers(List<Player> players)
    {
        this.players = players;
    }
    
    public Map<Player,Score> getScores(int wins)
    {   
        this.wins = wins;
        Map<Player,Score> allScores = new HashMap<>();
        Map<Player,Score> playerScores = type.getScores(wins);
        for(Player p : this.players)
        {
            Score endScore = new Score(0);
            if(playerScores.get(p) != null)
                endScore.add(playerScores.get(p));
            allScores.put(p, endScore);
        }
        return allScores;
    }
}

