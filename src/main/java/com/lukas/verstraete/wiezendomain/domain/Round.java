package com.lukas.verstraete.wiezendomain.domain;

import com.lukas.verstraete.wiezendomain.domain.gametypes.GameType;
import java.io.Serializable;
import java.util.Map;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Round implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;
    private GameType type;
    
    public Round() 
    {
        this(null);
    }
    
    public Round(GameType type)
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
    
    public Map<Player,Score> getScores(int wins)
    {
        return type.getScores(wins);
    }
}

