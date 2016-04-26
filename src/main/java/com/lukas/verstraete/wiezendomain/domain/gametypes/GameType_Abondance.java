package com.lukas.verstraete.wiezendomain.domain.gametypes;

import com.lukas.verstraete.wiezendomain.domain.Player;
import com.lukas.verstraete.wiezendomain.domain.Score;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameType_Abondance extends GameType {
    
    protected int goal;
    protected int points;
    protected int points_opponent;
    
    public GameType_Abondance(List<Player> players, List<Player> opponents, int goal, int points, int pointsOpponent) {
        super(players, opponents);
        this.goal = goal;
        this.points = points;
        this.points_opponent = pointsOpponent;
    }

    @Override
    public Map<Player, Score> getScores(int wins) {
        Score playersScore = new Score();
        Score opponentsScore = new Score();
        wins = wins < 0 ? 0 : wins;
        if(goal <= wins)
        {
            playersScore.add(points);
            opponentsScore.setPoints(0);
        }
        else
        {
            playersScore.subtract(points);
            opponentsScore.add(points_opponent);
        }
        HashMap<Player,Score> scores = new HashMap<>();
        for(Player p : players) scores.put(p, playersScore);
        for(Player p : opponents) scores.put(p, opponentsScore);
        return scores;
    }
    
}
