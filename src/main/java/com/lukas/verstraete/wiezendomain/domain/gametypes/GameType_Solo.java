/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lukas.verstraete.wiezendomain.domain.gametypes;

import com.lukas.verstraete.wiezendomain.domain.Player;
import com.lukas.verstraete.wiezendomain.domain.Score;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameType_Solo extends GameType {
    
    protected int base_points = 12;
    protected int max_points = 21;
    protected int base_points_lose = 15;
    protected int increment = 3;
    protected int base_points_opponents = 10;
    protected int increment_opponents = 2;
    protected int baseWins = 6;
    protected int maxWins = 8;
    protected int goal;
    
    public GameType_Solo(List<Player> players, List<Player> opponents, int goal) {
        super(players, opponents);
        setGoal(goal);
    }
    
    public void setGoal(int goal)
    {
        if(goal < baseWins)
            goal = baseWins;
        this.goal = goal;
    }
    
    @Override
    public Map<Player, Score> getScores(int wins) {
        Score playersScore = new Score();
        Score opponentsScore = new Score();
        wins = wins < 0 ? 0 : wins;
        if(goal <= wins)
        {
            playersScore.setPoints(baseWins + (wins - goal) * increment);
            if(wins >= maxWins && goal < maxWins) playersScore.setPoints(baseWins + (maxWins - goal) * increment);
            if(wins >= maxWins && goal == maxWins) playersScore.setPoints(max_points);
            opponentsScore.setPoints(0);
        }
        else
        {
            playersScore.subtract(base_points_lose + (goal - wins) * increment);
            opponentsScore.add(base_points_opponents + (goal - wins) * increment_opponents);
        }
        HashMap<Player,Score> scores = new HashMap<>();
        for(Player p : players) scores.put(p, playersScore);
        for(Player p : opponents) scores.put(p, opponentsScore);
        return scores;
    }
    
}
