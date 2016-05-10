package com.lukas.verstraete.wiezendomain.domain.gametypes;

import com.lukas.verstraete.wiezendomain.domain.Player;
import com.lukas.verstraete.wiezendomain.domain.Score;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameType_Samen implements GameType, Serializable {
    
    protected int base_points = 7;
    protected int max_points = 30;
    protected int base_points_lose = 10;
    protected int increment = 3;
    protected int baseWins = 8;
    protected int maxWins = 13;
    protected int goal;
    
    
    public GameType_Samen(int goal)
    {
        setGoal(goal);
    }
    
    public void setGoal(int goal)
    {
        if(goal < baseWins)
            goal = baseWins;
        this.goal = goal;
    }
    
    @Override
    public Map<Player, Score> getScores(List<Player> players, List<Player> opponents, int wins) {
        Score playersScore = new Score();
        Score opponentsScore = new Score();
        wins = wins < 0 ? 0 : wins;
        if(goal <= wins)
        {
            playersScore.setPoints(baseWins + (wins - goal) * increment);
            if(wins >= maxWins) playersScore.setPoints(max_points);
            opponentsScore.setPoints(0);
        }
        else
        {
            playersScore.subtract(base_points_lose + (goal - wins) * increment);
            opponentsScore.add(base_points_lose + (goal - wins) * increment);
        }
        HashMap<Player,Score> scores = new HashMap<>();
        for(Player p : players) scores.put(p, playersScore);
        for(Player p : opponents) scores.put(p, opponentsScore);
        return scores;
    }  
}
